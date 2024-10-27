package org.but.eloryksauthorization.newbackend.service;

import jakarta.persistence.EntityNotFoundException;
import org.but.eloryksauthorization.newbackend.api.SignKeyDTO;
import org.but.eloryksauthorization.newbackend.data.entity.SignKey;
import org.but.eloryksauthorization.newbackend.data.repository.SignKeyRepository;
import org.but.eloryksauthorization.newbackend.mappers.SignKeyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SignKeyService {

    private SignKeyRepository signKeyRepository;

    private SignKeyMapper signKeyMapper;

    @Autowired
    public SignKeyService(SignKeyRepository signKeyRepository, SignKeyMapper signKeyMapper) {
        this.signKeyRepository = signKeyRepository;
        this.signKeyMapper = signKeyMapper;
    }

    @Transactional(readOnly = true)
    public List<SignKeyDTO> findAll() {
        List<SignKey> signKeys = signKeyRepository.findAll();
        return signKeyMapper.toDTOList(signKeys);
    }

    @Transactional(readOnly = true)
    public Optional<SignKeyDTO> findById(Long id) {
        Optional<SignKey> entity = signKeyRepository.findById(id);
        return entity.map(signKeyMapper::toDTO);
    }

    @Transactional
    public SignKeyDTO save(SignKeyDTO signKeyDTO) {
        SignKey signKey = signKeyMapper.toEntity(signKeyDTO);
        SignKey savedSignKey = signKeyRepository.save(signKey);
        return signKeyMapper.toDTO(savedSignKey);
    }

    @Transactional
    public SignKeyDTO update(SignKeyDTO signKeyDTO) {
        if (!signKeyRepository.existsById(signKeyDTO.getSignKeyId())) {
            throw new EntityNotFoundException("SignKey with ID " + signKeyDTO.getSignKeyId() + " not found.");
        }
        SignKey signKey = signKeyMapper.toEntity(signKeyDTO);
        SignKey updatedSignKey = signKeyRepository.save(signKey);
        return signKeyMapper.toDTO(updatedSignKey);
    }

    @Transactional
    public void deleteById(Long id) {
        signKeyRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public SignKey findByVehicleId(Long vehicleId) {
        Optional<SignKey> optionalSignKey = signKeyRepository.findByVehicle_StationId(vehicleId);
        return optionalSignKey.orElse(null);
    }
}
