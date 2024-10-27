package org.but.eloryksauthorization.newbackend.rest;

import jakarta.validation.Valid;
import org.but.eloryksauthorization.newbackend.api.*;
import org.but.eloryksauthorization.newbackend.service.VehicleService;
import org.but.eloryksauthorization.newbackend.service.VehicleSpeedLimitRequestFromWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/its/vehicle")
public class VehicleAuthorizationRequestRestController2 {
    private VehicleService vehicleService;
    private VehicleSpeedLimitRequestFromWebService vehicleSpeedLimitRequestFromWebService;

    @Autowired
    public VehicleAuthorizationRequestRestController2(VehicleService vehicleService, VehicleSpeedLimitRequestFromWebService vehicleSpeedLimitRequestFromWebService) {
        this.vehicleService = vehicleService;
        this.vehicleSpeedLimitRequestFromWebService = vehicleSpeedLimitRequestFromWebService;
    }

    @GetMapping(value = "/all", produces = "application/json", headers = "Accept=application/json")
    public ResponseEntity<Map<String, List<VehicleDTO>>> getAllVehicles(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timestamp,
                                                                        @RequestParam(required = false) String responsible,
                                                                        @RequestHeader(name = "Accept") String acceptHeader) {
        Map<String, List<VehicleDTO>> response = new HashMap<>();
        List<VehicleDTO> vehicleDTOs = vehicleService.getAllVehicles();
        response.put("Vehicle", vehicleDTOs);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json", headers = "Accept=application/json")
    public ResponseEntity<Map<String, List<VehicleDTO>>> getVehicleById(@PathVariable Long id,
                                                                        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timestamp,
                                                                        @RequestParam(required = false) String responsible,
                                                                        @RequestHeader(name = "Accept") String acceptHeader) {
        VehicleDTO vehicleDTO = vehicleService.findById(id);
        Map<String, List<VehicleDTO>> response = new HashMap<>();
        response.put("Vehicle", Arrays.asList(vehicleDTO));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponsePostDeleteDTO> createVehicle(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timestamp,
                                                               @RequestParam(required = false) String responsible,
                                                               @Valid @RequestBody VehicleRequestDTO vehicleRequestDTO,
                                                               @RequestHeader(name = "Accept") String acceptHeader) {
        ResponsePostDeleteDTO response = vehicleService.createVehicle(vehicleRequestDTO, responsible, timestamp);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponsePutDTO> updateVehicle(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timestamp,
                                                        @RequestParam(required = false) String responsible,
                                                        @Valid @RequestBody VehicleUpdateRequestDTO vehicleUpdateRequestDTO,
                                                        @RequestHeader(name = "Accept") String acceptHeader) {
        ResponsePutDTO response = vehicleService.updateVehicle(vehicleUpdateRequestDTO, responsible, timestamp);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(headers = "Accept=application/json", produces = "application/json")
    public ResponseEntity<ResponsePostDeleteDTO> deleteVehiclesById(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timestamp,
            @RequestParam(required = false) String responsible,
            @RequestParam(name = "vehicles", required = false) List<Long> vehiclesList,
            @RequestHeader(name = "Accept") String acceptHeader) {
        ResponsePostDeleteDTO response = vehicleService.deleteVehiclesById(vehiclesList, responsible, timestamp);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/vehicle-speed-limiting-requests")
    public List<VehicleSpeedLimitRequestFromWebDto> getAllVehicleSpeedLimitRequestsFromWeb() {
        return vehicleSpeedLimitRequestFromWebService.findAll();
    }

    @PostMapping(path = "/vehicle-speed-limiting-requests")
    public ResponseEntity<Void> createVehicleSpeedLimitRequestFromWeb(@Valid @RequestBody VehicleSpeedLimitRequestFromWebCreateDto vehicleSpeedLimitRequestFromWebCreateDto) {
        vehicleSpeedLimitRequestFromWebService.createVehicleSpeedLimitRequestFromWeb(vehicleSpeedLimitRequestFromWebCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/vehicle-speed-limiting-requests/{id}")
    public ResponseEntity<Void> updateVehicleSpeedLimitRequestFromWeb(@PathVariable("id") Long id, @Valid @RequestBody VehicleSpeedLimitRequestFromWebUpdateDto vehicleSpeedLimitRequestFromWebUpdateDto) {
        vehicleSpeedLimitRequestFromWebService.updateVehicleSpeedLimitRequestFromWeb(vehicleSpeedLimitRequestFromWebUpdateDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/vehicle-speed-limiting-requests/{id}")
    public ResponseEntity<Void> updateVehicleSpeedLimitRequestFromWeb(@PathVariable("id") Long id) {
        vehicleSpeedLimitRequestFromWebService.deleteVehicleSpeedLimitRequestFromWeb(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
