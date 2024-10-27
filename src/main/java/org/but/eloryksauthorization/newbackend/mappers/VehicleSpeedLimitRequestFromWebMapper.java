package org.but.eloryksauthorization.newbackend.mappers;

import org.but.eloryksauthorization.newbackend.api.VehicleSpeedLimitRequestFromWebCreateDto;
import org.but.eloryksauthorization.newbackend.api.VehicleSpeedLimitRequestFromWebDto;
import org.but.eloryksauthorization.newbackend.api.VehicleSpeedLimitRequestFromWebUpdateDto;
import org.but.eloryksauthorization.newbackend.data.entity.VehicleSpeedLimitRequestFromWeb;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleSpeedLimitRequestFromWebMapper {

    VehicleSpeedLimitRequestFromWebDto mapToDto(VehicleSpeedLimitRequestFromWeb vehicleSpeedLimitRequestFromWeb);

    List<VehicleSpeedLimitRequestFromWebDto> mapToDtoList(List<VehicleSpeedLimitRequestFromWeb> vehicleSpeedLimitRequestFromWeb);

    VehicleSpeedLimitRequestFromWeb mapToEntity(VehicleSpeedLimitRequestFromWebCreateDto vehicleSpeedLimitRequestFromWebCreateDto);

    VehicleSpeedLimitRequestFromWeb mapUpdateDtoToEntity(VehicleSpeedLimitRequestFromWebUpdateDto vehicleSpeedLimitRequestFromWebUpdateDto);

}
