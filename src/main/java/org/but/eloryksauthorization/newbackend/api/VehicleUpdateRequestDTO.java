package org.but.eloryksauthorization.newbackend.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class VehicleUpdateRequestDTO {

    @NotEmpty(message = "Vehicle list must not be null")
    @JsonProperty("Vehicle")
    private List<@Valid VehicleUpdateDTO> vehicle;

    public List<VehicleUpdateDTO> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<VehicleUpdateDTO> vehicle) {
        this.vehicle = vehicle;
    }
}
