package org.but.eloryksauthorization.mappers;

import org.but.eloryksauthorization.api.VehicleAuthorizationRequestBasicViewDto;
import org.but.eloryksauthorization.api.VehicleAuthorizationRequestCreateDto;
import org.but.eloryksauthorization.api.VehicleAuthorizationRequestDetailViewDto;
import org.but.eloryksauthorization.data.entity.VehicleAuthorizationRequest;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleAuthorizationRequestMapper {

    VehicleAuthorizationRequestDetailViewDto mapToVehicleDetail(VehicleAuthorizationRequest vehicle);

    VehicleAuthorizationRequestBasicViewDto mapToVehicleBasicView(VehicleAuthorizationRequest vehicleAuthorizationRequest);

    VehicleAuthorizationRequest mapToVehicleEntity(VehicleAuthorizationRequestCreateDto vehicleAuthorizationRequestCreateDto);

    List<VehicleAuthorizationRequestBasicViewDto> mapToListBasicView(List<VehicleAuthorizationRequest> vehicleAuthorizationRequests);

    default Page<VehicleAuthorizationRequestBasicViewDto> mapToPageDto(Page<VehicleAuthorizationRequest> vehicleAuthorizationRequests) {
        return new PageImpl<>(
                mapToListBasicView(vehicleAuthorizationRequests.getContent()),
                vehicleAuthorizationRequests.getPageable(),
                vehicleAuthorizationRequests.getContent().size());
    }
}
