//package org.but.eloryksauthorization.rest;
//
//import com.querydsl.core.types.Predicate;
//import jakarta.validation.Valid;
//import org.but.eloryksauthorization.api.*;
//import org.but.eloryksauthorization.data.entity.VehicleAuthorizationRequest;
//import org.but.eloryksauthorization.service.VehicleAuthorizationRequestService;
//import org.springdoc.api.annotations.ParameterObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.querydsl.binding.QuerydslPredicate;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/vehicle-authorization-request")
//public class VehicleAuthorizationRequestRestController {
//
//    private VehicleAuthorizationRequestService vehicleService;
//
//    @Autowired
//    public VehicleAuthorizationRequestRestController(VehicleAuthorizationRequestService vehicleService) {
//        this.vehicleService = vehicleService;
//    }
//
//    @GetMapping(value = "/{requestId}")
//    public ResponseEntity<VehicleAuthorizationRequestDetailViewDto> getVehicleAuthorizationRequestStatus(@PathVariable(value = "requestId") Long id) {
//        return ResponseEntity.ok(vehicleService.findById(id));
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<VehicleAuthorizationRequestBasicViewDto>> getVehicleAuthorizationRequests(
//            @QuerydslPredicate(root = VehicleAuthorizationRequest.class) Predicate predicate,
//            @ParameterObject Pageable pageable) {
//        return ResponseEntity.ok(vehicleService.findAll(predicate, pageable));
//    }
//
//
//    @PatchMapping(value = "/{requestId}")
//    public ResponseEntity<VehicleAuthorizationRequestIdDto> updateVehicleAuthorizationRequestState(
//            @PathVariable(value = "requestId") Long vehicleRequestId,
//            @Valid @RequestBody VehicleAuthorizationRequestStatusUpdateDto vehicleAuthorizationRequestStatusUpdateDto) {
//        return ResponseEntity.ok(vehicleService.updateVehicleRequestState(vehicleRequestId, vehicleAuthorizationRequestStatusUpdateDto));
//    }
//
//    @PostMapping
//    public ResponseEntity<VehicleAuthorizationRequestIdDto> insertVehicleAuthorizationRequest(@Valid @RequestBody VehicleAuthorizationRequestCreateDto vehicleAuthorizationRequestCreateDto) {
//        return ResponseEntity.ok(vehicleService.insertAuthorizationRequest(vehicleAuthorizationRequestCreateDto));
//    }
//
//
//}
