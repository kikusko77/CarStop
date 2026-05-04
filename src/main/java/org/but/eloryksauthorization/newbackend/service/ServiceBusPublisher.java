package org.but.eloryksauthorization.newbackend.service;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceBusPublisher {

    private static final Logger log = LoggerFactory.getLogger(ServiceBusPublisher.class);

    @Value("${servicebus.namespace:}")
    private String namespace;

    @Value("${servicebus.connection-string:}")
    private String connectionString;

    @Value("${servicebus.queue:telemetry-queue}")
    private String queueName;

    private ServiceBusSenderClient sender;
    private final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    @PostConstruct
    void init() {
        ServiceBusClientBuilder builder = new ServiceBusClientBuilder();
        if (connectionString != null && !connectionString.isBlank()) {
            builder = builder.connectionString(connectionString);
        } else if (namespace != null && !namespace.isBlank()) {
            builder = builder.fullyQualifiedNamespace(namespace)
                    .credential(new DefaultAzureCredentialBuilder()
                            .managedIdentityClientId(System.getenv("AZURE_CLIENT_ID"))
                            .build());
        } else {
            log.warn("ServiceBusPublisher not configured: set SERVICEBUS_CONNECTION_STRING or SERVICEBUS_NAMESPACE");
            return;
        }
        this.sender = builder.sender().queueName(queueName).buildClient();
        log.info("ServiceBusPublisher ready (queue={})", queueName);
    }

    public void publish(Object payload, String messageId) {
        if (sender == null) {
            throw new IllegalStateException("Service Bus is not configured");
        }
        try {
            String json = mapper.writeValueAsString(payload);
            ServiceBusMessage msg = new ServiceBusMessage(json)
                    .setContentType("application/json");
            if (messageId != null) {
                msg.setMessageId(messageId);
            }
            sender.sendMessage(msg);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Failed to serialize Service Bus payload", e);
        }
    }

    @PreDestroy
    void close() {
        if (sender != null) {
            sender.close();
        }
    }
}
