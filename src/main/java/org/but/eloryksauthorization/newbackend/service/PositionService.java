package org.but.eloryksauthorization.newbackend.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.but.eloryksauthorization.newbackend.api.PositionDTO;
import org.but.eloryksauthorization.newbackend.data.entity.Position;
import org.but.eloryksauthorization.newbackend.data.repository.PositionRepository;
import org.but.eloryksauthorization.newbackend.mappers.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    private PositionRepository positionRepository;

    private PositionMapper positionMapper;

    @Autowired
    public PositionService(PositionRepository positionRepository, PositionMapper positionMapper) {
        this.positionRepository = positionRepository;
        this.positionMapper = positionMapper;
    }

    public List<PositionDTO> findAll() {
        List<Position> positions = positionRepository.findAll();
        return positionMapper.toDTOList(positions);
    }

    public Position findByVehicleId(Long vehicleId) {
        Optional<Position> optionalPosition = positionRepository.findByVehicle_StationId(vehicleId);
        return optionalPosition.orElse(null);
    }

    public Optional<PositionDTO> findById(Long id) {
        Optional<Position> position = positionRepository.findById(id);
        return position.map(positionMapper::toDTO);
    }

    @Transactional
    public PositionDTO save(PositionDTO positionDTO) {
        Position position = positionMapper.toEntity(positionDTO);
        Position savedPosition = positionRepository.save(position);
        return positionMapper.toDTO(savedPosition);
    }

    @Transactional
    public PositionDTO update(PositionDTO positionDTO) {
        if (!positionRepository.existsById(positionDTO.getPositionId())) {
            throw new EntityNotFoundException("Position with ID " + positionDTO.getPositionId() + " not found.");
        }
        Position position = positionMapper.toEntity(positionDTO);
        Position updatedPosition = positionRepository.save(position);
        return positionMapper.toDTO(updatedPosition);
    }

    public void deleteById(Long id) {
        positionRepository.deleteById(id);
    }
}
