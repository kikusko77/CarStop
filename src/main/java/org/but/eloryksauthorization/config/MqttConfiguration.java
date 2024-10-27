//package org.but.eloryksauthorization.config;
//
//import org.eclipse.paho.client.mqttv3.IMqttClient;
//import org.eclipse.paho.client.mqttv3.MqttClient;
//import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
//import org.eclipse.paho.client.mqttv3.MqttException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MqttConfiguration {
//
//    @Value("${mqtt.client.id}")
//    private String mqttClientId;
//    @Value("${mqtt.ipaddress}")
//    private String mqttIpAddress;
//    @Value("${mqtt.username}")
//    private String mqttUsername;
//    @Value("${mqtt.password}")
//    private String mqttPassword;
//
//    @Bean
//    public IMqttClient mqttAsyncClient() throws MqttException {
//        IMqttClient instance = new MqttClient(mqttIpAddress, String.valueOf(mqttClientId + Math.random()));
//        MqttConnectOptions connOpts = new MqttConnectOptions();
//        connOpts.setUserName(mqttUsername);
//        connOpts.setPassword(mqttPassword.toCharArray());
//        connOpts.setCleanSession(true);
//        connOpts.setKeepAliveInterval(15);
//        connOpts.setConnectionTimeout(30);
//        connOpts.setAutomaticReconnect(true);
//        connOpts.setCleanSession(true);
//        connOpts.setConnectionTimeout(10);
//        if (!instance.isConnected()) {
//            instance.connect(connOpts);
//        }
//        System.out.println("MQTT connected: " + instance.isConnected());
//        return instance;
//    }
//}
