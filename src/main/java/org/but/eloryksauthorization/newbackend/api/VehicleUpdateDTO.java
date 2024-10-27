package org.but.eloryksauthorization.newbackend.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class VehicleUpdateDTO {

    @NotNull(message = "StationId must not be null")
    @JsonProperty("StationId")
    private Long stationId;

    @Valid
    @JsonProperty("SpeedLimit")
    private SpeedLimitDTO speedLimit;

    @NotNull(message = "Position must not be null")
    @Valid
    @JsonProperty("Position")
    private PositionDTO position;

    public VehicleUpdateDTO() {
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public SpeedLimitDTO getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(SpeedLimitDTO speedLimit) {
        this.speedLimit = speedLimit;
    }

    public PositionDTO getPosition() {
        return position;
    }

    public void setPosition(PositionDTO position) {
        this.position = position;
    }
}
