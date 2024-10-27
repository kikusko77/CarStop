package org.but.eloryksauthorization.newbackend.mappers;

import org.but.eloryksauthorization.newbackend.api.EncryptionKeyDTO;
import org.but.eloryksauthorization.newbackend.data.entity.EncryptionKey;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EncryptionKeyMapper {

    EncryptionKeyDTO toDTO(EncryptionKey entity);

    EncryptionKey toEntity(EncryptionKeyDTO dto);

    void updateEntityFromDTO(EncryptionKeyDTO dto, @MappingTarget EncryptionKey entity);

    List<EncryptionKeyDTO> toDTOList(List<EncryptionKey> entities);

    List<EncryptionKey> toEntityList(List<EncryptionKeyDTO> dtos);
}
