package org.but.eloryksauthorization.newbackend.service;

import org.but.eloryksauthorization.newbackend.api.EncryptionKeyDTO;
import org.but.eloryksauthorization.newbackend.data.entity.EncryptionKey;
import org.but.eloryksauthorization.newbackend.data.repository.EncryptionKeyRepository;
import org.but.eloryksauthorization.newbackend.mappers.EncryptionKeyMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EncryptionKeyServiceTest {

    @Mock
    private EncryptionKeyRepository encryptionKeyRepository;

    @Mock
    private EncryptionKeyMapper encryptionKeyMapper;

    @InjectMocks
    private EncryptionKeyService encryptionKeyService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        // Arrange
        EncryptionKeyDTO dto = new EncryptionKeyDTO();
        dto.setKeyType(123);
        dto.setCoordX("100.123");
        dto.setCoordY("200.456");

        EncryptionKey entity = new EncryptionKey();
        entity.setKeyType(dto.getKeyType());
        entity.setCoordX(dto.getCoordX());
        entity.setCoordY(dto.getCoordY());

        EncryptionKey savedEntity = new EncryptionKey();
        savedEntity.setEncryptionKeyId(1L);
        savedEntity.setKeyType(entity.getKeyType());
        savedEntity.setCoordX(entity.getCoordX());
        savedEntity.setCoordY(entity.getCoordY());

        when(encryptionKeyMapper.toEntity(dto)).thenReturn(entity);
        when(encryptionKeyRepository.save(entity)).thenReturn(savedEntity);
        when(encryptionKeyMapper.toDTO(savedEntity)).thenReturn(dto);

        // Act
        EncryptionKeyDTO result = encryptionKeyService.save(dto);

        // Assert
        assertEquals(dto, result);
        verify(encryptionKeyMapper).toEntity(dto);
        verify(encryptionKeyRepository).save(entity);
        verify(encryptionKeyMapper).toDTO(savedEntity);
    }
}
