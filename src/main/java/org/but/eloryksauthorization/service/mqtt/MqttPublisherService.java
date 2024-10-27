//package org.but.eloryksauthorization.service.mqtt;
//
//import org.eclipse.paho.client.mqttv3.IMqttClient;
//import org.eclipse.paho.client.mqttv3.MqttException;
//import org.eclipse.paho.client.mqttv3.MqttMessage;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MqttPublisherService {
//
//    private IMqttClient iMqttClient;
//
//    public MqttPublisherService(IMqttClient iMqttClient) {
//        this.iMqttClient = iMqttClient;
//    }
//
//    public void sendMessage(String mqttTopic, MqttMessage mqttMessage) {
//        try {
//            iMqttClient.publish(mqttTopic, mqttMessage);
//        } catch (MqttException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
