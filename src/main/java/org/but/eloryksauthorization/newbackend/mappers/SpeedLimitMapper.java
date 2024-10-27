package org.but.eloryksauthorization.newbackend.mappers;

import org.but.eloryksauthorization.newbackend.api.SpeedLimitDTO;
import org.but.eloryksauthorization.newbackend.data.entity.SpeedLimit;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpeedLimitMapper {

    SpeedLimitDTO toDTO(SpeedLimit entity);

    SpeedLimit toEntity(SpeedLimitDTO dto);

    void updateEntityFromDTO(SpeedLimitDTO dto, @MappingTarget SpeedLimit entity);

    List<SpeedLimitDTO> toDTOlist(List<SpeedLimit> entities);

    List<SpeedLimit> toEntityList(List<SpeedLimitDTO> dtos);
}
