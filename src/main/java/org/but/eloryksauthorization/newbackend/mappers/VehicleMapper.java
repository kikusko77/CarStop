package org.but.eloryksauthorization.newbackend.mappers;

import org.but.eloryksauthorization.newbackend.api.VehicleDTO;
import org.but.eloryksauthorization.newbackend.data.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    VehicleDTO toDTO(Vehicle entity);

    Vehicle toEntity(VehicleDTO dto);

    void updateEntityFromDTO(VehicleDTO dto, @MappingTarget Vehicle entity);

    List<VehicleDTO> toDTOList(List<Vehicle> entities);

    List<Vehicle> toEntityList(List<VehicleDTO> dtos);
}
