//package org.but.eloryksauthorization.service.mqtt;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.annotation.PostConstruct;
//import org.but.eloryksauthorization.data.entity.VehicleAuthorizationRequest;
//import org.but.eloryksauthorization.data.entity.enums.AuthorizedToSpeedLimitTargetVehicle;
//import org.but.eloryksauthorization.data.repository.VehicleAuthorizationRequestRepository;
//import org.eclipse.paho.client.mqttv3.IMqttClient;
//import org.eclipse.paho.client.mqttv3.MqttException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.time.Clock;
//import java.time.LocalDateTime;
//
//@Service
//public class MqttSubscriberService {
//
//    @Value("${mqtt.topic.in}")
//    private String mqttTopic;
//
//    private IMqttClient iMqttClient;
//    private VehicleAuthorizationRequestRepository vehicleAuthorizationRequestRepository;
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    public MqttSubscriberService(IMqttClient iMqttClient, VehicleAuthorizationRequestRepository vehicleAuthorizationRequestRepository, ObjectMapper objectMapper) {
//        this.iMqttClient = iMqttClient;
//        this.vehicleAuthorizationRequestRepository = vehicleAuthorizationRequestRepository;
//        this.objectMapper = objectMapper;
//    }
//
//    @PostConstruct
//    public void subscribeMqttMessages() {
//        try {
//            iMqttClient.subscribe(mqttTopic, (actualTopicValue, mqttMessage) -> {
//                try {
//                    VehicleAuthorizationRequest vehicleAuthorizationRequest = objectMapper.readValue(mqttMessage.getPayload(), VehicleAuthorizationRequest.class);
//                    vehicleAuthorizationRequest.setAuthorizedToSpeedLimitTargetVehicle(AuthorizedToSpeedLimitTargetVehicle.NOT_DECIDED_YET);
//                    vehicleAuthorizationRequest.setActionTimestamp(LocalDateTime.now(Clock.systemUTC()));
//                    vehicleAuthorizationRequestRepository.save(vehicleAuthorizationRequest);
//                } catch (Exception e) {
//                    System.out.println("Wrong data were sent: " + e);
//                }
//            });
//        } catch (MqttException e) {
//            e.printStackTrace();
//        }
//    }
//}
