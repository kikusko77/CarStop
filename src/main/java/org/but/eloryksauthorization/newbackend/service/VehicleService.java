package org.but.eloryksauthorization.newbackend.service;

import jakarta.transaction.Transactional;
import org.but.eloryksauthorization.newbackend.api.*;
import org.but.eloryksauthorization.newbackend.data.entity.Vehicle;
import org.but.eloryksauthorization.newbackend.data.repository.VehicleRepository;
import org.but.eloryksauthorization.newbackend.exceptions.VehicleAlreadyExistsException;
import org.but.eloryksauthorization.newbackend.exceptions.VehicleNotFoundException;
import org.but.eloryksauthorization.newbackend.exceptions.VehicleNotFoundPutException;
import org.but.eloryksauthorization.newbackend.mappers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;
    private final PositionService positionService;
    private final EncryptionKeyService encryptionKeyService;
    private final SignKeyService signKeyService;
    private final SpeedLimitService speedLimitService;
    private final PositionMapper positionMapper;
    private final EncryptionKeyMapper encryptionKeyMapper;
    private final SignKeyMapper signKeyMapper;
    private final SpeedLimitMapper speedLimitMapper;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository,
                          VehicleMapper vehicleMapper,
                          PositionService positionService,
                          EncryptionKeyService encryptionKeyService,
                          SignKeyService signKeyService,
                          SpeedLimitService speedLimitService,
                          PositionMapper positionMapper,
                          EncryptionKeyMapper encryptionKeyMapper,
                          SignKeyMapper signKeyMapper,
                          SpeedLimitMapper speedLimitMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
        this.positionService = positionService;
        this.encryptionKeyService = encryptionKeyService;
        this.signKeyService = signKeyService;
        this.speedLimitService = speedLimitService;
        this.positionMapper = positionMapper;
        this.encryptionKeyMapper = encryptionKeyMapper;
        this.signKeyMapper = signKeyMapper;
        this.speedLimitMapper = speedLimitMapper;
    }

    @Transactional
    public List<VehicleDTO> findAll() {
        List<Vehicle> vehicles = vehicleRepository.findAll(Sort.by(Sort.Direction.DESC, "stationId"));
        return vehicleMapper.toDTOList(vehicles);
    }

    @Transactional
    public VehicleDTO findById(Long id) {
        return vehicleRepository.findById(id)
                .map(vehicleMapper::toDTO)
                .orElseThrow(() -> new VehicleNotFoundPutException("Vehicle with ID " + id + " not found."));
    }

    @Transactional
    public List<VehicleDTO> save(VehicleRequestDTO vehicleRequestDTO, String responsible, LocalDateTime timestamp) {
        if (vehicleRequestDTO.getVehicle() == null || vehicleRequestDTO.getVehicle().isEmpty()) {
            throw new VehicleNotFoundException("Vehicle list in the request is either null or empty");
        }

        List<VehicleDTO> savedVehicles = new ArrayList<>();

        for (VehicleDTO vehicleDTO : vehicleRequestDTO.getVehicle()) {
            Long stationId = vehicleDTO.getStationId();

            if (vehicleRepository.existsById(vehicleDTO.getStationId())) {
                throw new VehicleAlreadyExistsException("Vehicle with ID " + vehicleDTO.getStationId() + " already exists");
            }

            if (vehicleDTO.getEncryptionKey() != null) {
                vehicleDTO.getEncryptionKey().setEncryptionKeyId(stationId);
                encryptionKeyService.save(vehicleDTO.getEncryptionKey());
            }

            vehicleDTO.getSignKey().setSignKeyId(stationId);
            signKeyService.save(vehicleDTO.getSignKey());

            vehicleDTO.getPosition().setPositionId(stationId);
            positionService.save(vehicleDTO.getPosition());

            SpeedLimitDTO defaultSpeedLimit = new SpeedLimitDTO();
            defaultSpeedLimit.setSpeedLimitId(stationId);
            SpeedLimitDTO actualSpeedLimit = speedLimitService.save(defaultSpeedLimit);
            vehicleDTO.setSpeedLimit(actualSpeedLimit);

            Vehicle vehicle = vehicleMapper.toEntity(vehicleDTO);
            Vehicle savedVehicle = vehicleRepository.save(vehicle);
            savedVehicles.add(vehicleMapper.toDTO(savedVehicle));
        }

        return savedVehicles;
    }

    @Transactional
    public List<VehicleDTO> update(VehicleUpdateRequestDTO vehicleUpdateRequestDTO, String responsible, LocalDateTime timestamp) {

        List<VehicleDTO> updatedVehicles = new ArrayList<>();

        for (VehicleUpdateDTO updateVehicleDTO : vehicleUpdateRequestDTO.getVehicle()) {
            Vehicle existingVehicle = vehicleRepository.findById(updateVehicleDTO.getStationId())
                    .orElseThrow(() -> new VehicleNotFoundPutException("Vehicle with ID " + updateVehicleDTO.getStationId() + " not found"));

            if (updateVehicleDTO.getSpeedLimit() != null) {
                updateVehicleDTO.getSpeedLimit().setSpeedLimitId(updateVehicleDTO.getStationId());
                SpeedLimitDTO updatedSpeedLimitDTO = speedLimitService.update(updateVehicleDTO.getSpeedLimit());
                speedLimitMapper.updateEntityFromDTO(updatedSpeedLimitDTO, existingVehicle.getSpeedLimit());
            }

            updateVehicleDTO.getPosition().setPositionId(updateVehicleDTO.getStationId());
            PositionDTO updatedPositionDTO = positionService.update(updateVehicleDTO.getPosition());
            positionMapper.updateEntityFromDTO(updatedPositionDTO, existingVehicle.getPosition());

            Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);
            updatedVehicles.add(vehicleMapper.toDTO(updatedVehicle));
        }

        return updatedVehicles;
    }

    @Transactional
    public List<VehicleDTO> getAllVehicles() {
        List<VehicleDTO> vehicleDTOs = findAll();
        return vehicleDTOs;
    }

    @Transactional
    public ResponsePostDeleteDTO createVehicle(VehicleRequestDTO vehicleRequestDTO, String responsible, LocalDateTime timestamp) {
        ResponsePostDeleteDTO response = new ResponsePostDeleteDTO();
        ResponseStatusDTO responseStatus = new ResponseStatusDTO();
        List<ResponseCreateDeleteDTO> responseVehicleList = new ArrayList<>();

        List<VehicleDTO> savedVehicles = save(vehicleRequestDTO, responsible, timestamp);
        for (VehicleDTO savedVehicleDTO : savedVehicles) {
            ResponseCreateDeleteDTO responseVehicleDTO = new ResponseCreateDeleteDTO();
            responseVehicleDTO.setStationId(savedVehicleDTO.getStationId());
            responseVehicleDTO.setErrorCode(0);
            responseVehicleDTO.setMessage("Vehicle created successfully");
            responseVehicleList.add(responseVehicleDTO);
        }
        responseStatus.setErrorCode(0);
        responseStatus.setMessage("Vehicles created successfully");

        response.setResponseStatus(responseStatus);
        response.setResponseVehicle(responseVehicleList);
        return response;
    }

    @Transactional
    public ResponsePutDTO updateVehicle(VehicleUpdateRequestDTO vehicleUpdateRequestDTO, String responsible, LocalDateTime timestamp) {
        ResponsePutDTO response = new ResponsePutDTO();
        ResponseStatusDTO responseStatus = new ResponseStatusDTO();
        List<ResponseUpdateDTO> responseVehicleList = new ArrayList<>();

        List<VehicleDTO> updatedVehicles = update(vehicleUpdateRequestDTO, responsible, timestamp);
        for (VehicleDTO updatedVehicleDTO : updatedVehicles) {
            ResponseUpdateDTO responseUpdateDTO = new ResponseUpdateDTO();
            SpeedLimitDTO speedLimitDTO = updatedVehicleDTO.getSpeedLimit();
            responseUpdateDTO.setSpeedLimit(speedLimitDTO);
            responseUpdateDTO.setSpeedLimitEncrypted("string");
            responseUpdateDTO.setStationId(updatedVehicleDTO.getStationId());
            responseUpdateDTO.setErrorCode(0);
            responseUpdateDTO.setMessage("Vehicle updated successfully");
            responseVehicleList.add(responseUpdateDTO);
        }
        responseStatus.setErrorCode(0);
        responseStatus.setMessage("Vehicles updated successfully");
        response.setResponseStatus(responseStatus);
        response.setResponseVehicle(responseVehicleList);
        return response;
    }

    @Transactional
    public ResponsePostDeleteDTO deleteVehiclesById(List<Long> stationIds, String responsible, LocalDateTime timestamp) {
        ResponsePostDeleteDTO response = new ResponsePostDeleteDTO();
        ResponseStatusDTO responseStatus = new ResponseStatusDTO();
        List<ResponseCreateDeleteDTO> responseVehicles = new ArrayList<>();

        for (Long stationId : stationIds) {
            ResponseCreateDeleteDTO responseVehicleDTO = new ResponseCreateDeleteDTO();
            Vehicle vehicle = vehicleRepository.findById(stationId)
                    .orElseThrow(() -> new VehicleNotFoundException("Vehicle with ID " + stationId + " not found"));

            vehicleRepository.delete(vehicle);
            responseVehicleDTO.setStationId(stationId);
            responseVehicleDTO.setErrorCode(0);
            responseVehicleDTO.setMessage("Vehicle deleted successfully");
            responseVehicles.add(responseVehicleDTO);
        }

        responseStatus.setErrorCode(0);
        responseStatus.setMessage("Vehicle deleted successfully");
        response.setResponseStatus(responseStatus);
        response.setResponseVehicle(responseVehicles);
        return response;
    }
}