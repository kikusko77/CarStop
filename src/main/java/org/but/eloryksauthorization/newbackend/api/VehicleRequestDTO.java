package org.but.eloryksauthorization.newbackend.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class VehicleRequestDTO {

    @NotEmpty(message = "Vehicle list must not be empty")
    @JsonProperty("Vehicle")
    private List<@Valid VehicleDTO> vehicle;

    public List<VehicleDTO> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<VehicleDTO> vehicle) {
        this.vehicle = vehicle;
    }
}
