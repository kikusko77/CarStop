package org.but.eloryksauthorization.newbackend.mappers;

import org.but.eloryksauthorization.newbackend.api.PositionDTO;
import org.but.eloryksauthorization.newbackend.data.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    @Mapping(source = "positionId", target = "positionId")
    PositionDTO toDTO(Position entity);

    @Mapping(source = "positionId", target = "positionId")
    Position toEntity(PositionDTO dto);

    void updateEntityFromDTO(PositionDTO dto, @MappingTarget Position entity);

    List<PositionDTO> toDTOList(List<Position> entities);

    List<Position> toEntityList(List<PositionDTO> dtos);
}

