package org.but.eloryksauthorization.newbackend.service;

import jakarta.persistence.EntityNotFoundException;
import org.but.eloryksauthorization.newbackend.api.EncryptionKeyDTO;
import org.but.eloryksauthorization.newbackend.data.entity.EncryptionKey;
import org.but.eloryksauthorization.newbackend.data.repository.EncryptionKeyRepository;
import org.but.eloryksauthorization.newbackend.mappers.EncryptionKeyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EncryptionKeyService {

    private EncryptionKeyRepository encryptionKeyRepository;

    private EncryptionKeyMapper encryptionKeyMapper;

    @Autowired
    public EncryptionKeyService(EncryptionKeyRepository encryptionKeyRepository, EncryptionKeyMapper encryptionKeyMapper) {
        this.encryptionKeyRepository = encryptionKeyRepository;
        this.encryptionKeyMapper = encryptionKeyMapper;
    }

    @Transactional(readOnly = true)
    public List<EncryptionKeyDTO> findAll() {
        List<EncryptionKey> entities = encryptionKeyRepository.findAll();
        return encryptionKeyMapper.toDTOList(entities);
    }

    @Transactional(readOnly = true)
    public Optional<EncryptionKeyDTO> findById(Long id) {
        Optional<EncryptionKey> entity = encryptionKeyRepository.findById(id);
        return entity.map(encryptionKeyMapper::toDTO);
    }

    @Transactional
    public EncryptionKeyDTO save(EncryptionKeyDTO encryptionKeyDTO) {
        EncryptionKey encryptionKey = encryptionKeyMapper.toEntity(encryptionKeyDTO);
        EncryptionKey savedEncryptionKey = encryptionKeyRepository.save(encryptionKey);
        return encryptionKeyMapper.toDTO(savedEncryptionKey);
    }

    @Transactional
    public EncryptionKeyDTO update(EncryptionKeyDTO encryptionKeyDTO) {
        if (!encryptionKeyRepository.existsById(encryptionKeyDTO.getEncryptionKeyId())) {
            throw new EntityNotFoundException("EncryptionKey with ID " + encryptionKeyDTO.getEncryptionKeyId() + " not found.");
        }
        EncryptionKey encryptionKey = encryptionKeyMapper.toEntity(encryptionKeyDTO);
        EncryptionKey updatedEncryptionKey = encryptionKeyRepository.save(encryptionKey);
        return encryptionKeyMapper.toDTO(updatedEncryptionKey);
    }

    @Transactional(readOnly = true)
    public EncryptionKey findByVehicleId(Long vehicleId) {
        Optional<EncryptionKey> optionalEncryptionKey = encryptionKeyRepository.findByVehicle_StationId(vehicleId);
        return optionalEncryptionKey.orElse(null);
    }

    public void deleteById(Long id) {
        if (encryptionKeyRepository.existsById(id)) {
            encryptionKeyRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Position with ID " + id + " not found.");
        }
    }

}
