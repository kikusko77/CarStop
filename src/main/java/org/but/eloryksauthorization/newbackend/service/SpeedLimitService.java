package org.but.eloryksauthorization.newbackend.service;


import jakarta.persistence.EntityNotFoundException;
import org.but.eloryksauthorization.newbackend.api.SpeedLimitDTO;
import org.but.eloryksauthorization.newbackend.data.entity.SpeedLimit;
import org.but.eloryksauthorization.newbackend.data.repository.SpeedLimitRepository;
import org.but.eloryksauthorization.newbackend.mappers.SpeedLimitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpeedLimitService {

    private final SpeedLimitRepository repository;
    private final SpeedLimitMapper mapper;

    @Autowired
    public SpeedLimitService(SpeedLimitRepository repository, SpeedLimitMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<SpeedLimitDTO> findAll() {
        List<SpeedLimit> entities = repository.findAll();
        return entities.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<SpeedLimitDTO> findById(Long id) {
        Optional<SpeedLimit> entity = repository.findById(id);
        return entity.map(mapper::toDTO);
    }

    @Transactional
    public SpeedLimitDTO save(SpeedLimitDTO speedLimitDTO) {
        SpeedLimit speedLimit = mapper.toEntity(speedLimitDTO);
        SpeedLimit savedSpeedLimit = repository.save(speedLimit);
        return mapper.toDTO(savedSpeedLimit);
    }

    @Transactional
    public SpeedLimitDTO update(SpeedLimitDTO speedLimitDTO) {
        if (!repository.existsById(speedLimitDTO.getSpeedLimitId())) {
            throw new EntityNotFoundException("SpeedLimit with ID " + speedLimitDTO.getSpeedLimitId() + " not found.");
        }

        SpeedLimit speedLimit = mapper.toEntity(speedLimitDTO);
        SpeedLimit updatedSpeedLimit = repository.save(speedLimit);
        return mapper.toDTO(updatedSpeedLimit);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public SpeedLimit findByVehicleId(Long vehicleId) {
        Optional<SpeedLimit> optionalSpeedLimit = repository.findByVehicle_StationId(vehicleId);
        return optionalSpeedLimit.orElse(null);
    }
}
