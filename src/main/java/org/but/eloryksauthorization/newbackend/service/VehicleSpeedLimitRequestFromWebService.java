package org.but.eloryksauthorization.newbackend.service;

import org.but.eloryksauthorization.newbackend.api.VehicleSpeedLimitRequestFromWebCreateDto;
import org.but.eloryksauthorization.newbackend.api.VehicleSpeedLimitRequestFromWebDto;
import org.but.eloryksauthorization.newbackend.api.VehicleSpeedLimitRequestFromWebUpdateDto;
import org.but.eloryksauthorization.newbackend.data.entity.VehicleSpeedLimitRequestFromWeb;
import org.but.eloryksauthorization.newbackend.data.repository.VehicleSpeedLimitRequestFromWebRepository;
import org.but.eloryksauthorization.newbackend.mappers.VehicleSpeedLimitRequestFromWebMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class VehicleSpeedLimitRequestFromWebService {

    private VehicleSpeedLimitRequestFromWebRepository vehicleSpeedLimitRequestFromWebRepository;
    private VehicleSpeedLimitRequestFromWebMapper mapper;

    @Autowired
    public VehicleSpeedLimitRequestFromWebService(VehicleSpeedLimitRequestFromWebRepository vehicleSpeedLimitRequestFromWebRepository, VehicleSpeedLimitRequestFromWebMapper mapper) {
        this.vehicleSpeedLimitRequestFromWebRepository = vehicleSpeedLimitRequestFromWebRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<VehicleSpeedLimitRequestFromWebDto> findAll() {
        List<VehicleSpeedLimitRequestFromWeb> vehicles = vehicleSpeedLimitRequestFromWebRepository.findAll(Sort.by(Sort.Direction.DESC, "timestamp"));
        return mapper.mapToDtoList(vehicles);
    }

    public void createVehicleSpeedLimitRequestFromWeb(VehicleSpeedLimitRequestFromWebCreateDto vehicleSpeedLimitRequestFromWebCreateDto) {
        VehicleSpeedLimitRequestFromWeb vehicleSpeedLimitRequestFromWeb = mapper.mapToEntity(vehicleSpeedLimitRequestFromWebCreateDto);
        vehicleSpeedLimitRequestFromWeb.setTimestamp(LocalDateTime.now(Clock.systemUTC()));
        vehicleSpeedLimitRequestFromWebRepository.save(vehicleSpeedLimitRequestFromWeb);
    }

    public void updateVehicleSpeedLimitRequestFromWeb(VehicleSpeedLimitRequestFromWebUpdateDto vehicleSpeedLimitRequestFromWebUpdateDto) {
        VehicleSpeedLimitRequestFromWeb vehicleSpeedLimitRequestFromWeb = mapper.mapUpdateDtoToEntity(vehicleSpeedLimitRequestFromWebUpdateDto);
        mapper.mapUpdateDtoToEntity(vehicleSpeedLimitRequestFromWebUpdateDto);
        vehicleSpeedLimitRequestFromWeb.setTimestamp(LocalDateTime.now(Clock.systemUTC()));
        vehicleSpeedLimitRequestFromWebRepository.save(vehicleSpeedLimitRequestFromWeb);
    }

    public void deleteVehicleSpeedLimitRequestFromWeb(Long id) {
        vehicleSpeedLimitRequestFromWebRepository.deleteById(id);
    }

}
