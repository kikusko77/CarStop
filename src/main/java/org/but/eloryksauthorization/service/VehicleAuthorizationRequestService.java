//package org.but.eloryksauthorization.service;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.querydsl.core.types.Predicate;
//import org.but.eloryksauthorization.api.*;
//import org.but.eloryksauthorization.data.entity.VehicleAuthorizationRequest;
//import org.but.eloryksauthorization.data.entity.enums.AuthorizedToSpeedLimitTargetVehicle;
//import org.but.eloryksauthorization.data.repository.VehicleAuthorizationRequestRepository;
//import org.but.eloryksauthorization.exceptions.ResourceNotFoundException;
//import org.but.eloryksauthorization.mappers.VehicleAuthorizationRequestMapper;
//import org.but.eloryksauthorization.service.mqtt.MqttPublisherService;
//import org.eclipse.paho.client.mqttv3.MqttMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.Clock;
//import java.time.LocalDateTime;
//
//@Service
//@Transactional
//public class VehicleAuthorizationRequestService {
//
//    @Value("${mqtt.topic.out}")
//    private String mqttTopic;
//
//    private VehicleAuthorizationRequestRepository vehicleRepository;
//    private VehicleAuthorizationRequestMapper vehicleMapper;
//    private MqttPublisherService mqttPublisherService;
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    public VehicleAuthorizationRequestService(VehicleAuthorizationRequestRepository vehicleRepository, VehicleAuthorizationRequestMapper vehicleMapper, MqttPublisherService mqttPublisherService, ObjectMapper objectMapper) {
//        this.vehicleRepository = vehicleRepository;
//        this.vehicleMapper = vehicleMapper;
//        this.mqttPublisherService = mqttPublisherService;
//        this.objectMapper = objectMapper;
//    }
//
//    @Transactional(readOnly = true)
//    public VehicleAuthorizationRequestDetailViewDto findById(Long id) {
//        return vehicleMapper.mapToVehicleDetail(vehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The request with: " + id + " is not available.")));
//    }
//
//    @Transactional(readOnly = true)
//    public Page<VehicleAuthorizationRequestBasicViewDto> findAll(Predicate predicate, Pageable pageable) {
//        return vehicleMapper.mapToPageDto(vehicleRepository.findAll(predicate, pageable));
//    }
//
//    @Transactional
//    public VehicleAuthorizationRequestIdDto updateVehicleRequestState(Long vehicleRequestId, VehicleAuthorizationRequestStatusUpdateDto vehicleAuthorizationRequestStatusUpdateDto) {
//        VehicleAuthorizationRequest vehicleAuthorizationRequest = vehicleRepository.getById(vehicleRequestId);
//        vehicleAuthorizationRequest.setAuthorizedToSpeedLimitTargetVehicle(vehicleAuthorizationRequestStatusUpdateDto.getAuthorizedToSpeedLimitTargetVehicle());
//        VehicleAuthorizationRequest vehicle = vehicleRepository.saveAndFlush(vehicleAuthorizationRequest);
//        // publish new authorizationRequest update (e.g., approve/decline)
//        VehicleAuthorizationRequestBasicViewDto vehicleAuthorizationRequestBasicViewDto = vehicleMapper.mapToVehicleBasicView(vehicle);
//        this.publishRequestStatusUpdate(vehicleAuthorizationRequestBasicViewDto);
//
//        VehicleAuthorizationRequestIdDto vehicleAuthorizationRequestIdDto = new VehicleAuthorizationRequestIdDto();
//        vehicleAuthorizationRequestIdDto.setVehicleAuthorizationRequestId(vehicle.getId());
//        return vehicleAuthorizationRequestIdDto;
//    }
//
//    public void publishRequestStatusUpdate(VehicleAuthorizationRequestBasicViewDto vehicleAuthorizationRequestBasicViewDto) {
//        MqttMessage mqttMessagePayloadToPublish = new MqttMessage();
//        try {
//            mqttMessagePayloadToPublish.setPayload(objectMapper.writeValueAsString(vehicleAuthorizationRequestBasicViewDto).getBytes());
//            mqttPublisherService.sendMessage(mqttTopic, mqttMessagePayloadToPublish);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public VehicleAuthorizationRequestIdDto insertAuthorizationRequest(VehicleAuthorizationRequestCreateDto vehicleAuthorizationRequestCreateDto) {
//        vehicleAuthorizationRequestCreateDto.setAuthorizedToSpeedLimitTargetVehicle(AuthorizedToSpeedLimitTargetVehicle.NOT_DECIDED_YET);
//        vehicleAuthorizationRequestCreateDto.setActionTimestamp(LocalDateTime.now(Clock.systemUTC()));
//        VehicleAuthorizationRequest vehicle = vehicleRepository.saveAndFlush(vehicleMapper.mapToVehicleEntity(vehicleAuthorizationRequestCreateDto));
//
//        VehicleAuthorizationRequestIdDto vehicleAuthorizationRequestIdDto = new VehicleAuthorizationRequestIdDto();
//        vehicleAuthorizationRequestIdDto.setVehicleAuthorizationRequestId(vehicle.getId());
//        return vehicleAuthorizationRequestIdDto;
//    }
//
//}
