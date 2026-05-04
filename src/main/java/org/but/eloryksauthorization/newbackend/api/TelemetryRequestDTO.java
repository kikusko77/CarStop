package org.but.eloryksauthorization.newbackend.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public class TelemetryRequestDTO {

    @NotNull
    private Long vehicleId;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @NotNull
    @Min(0)
    private Integer speedKph;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime measuredAt;

    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long v) { this.vehicleId = v; }
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double v) { this.latitude = v; }
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double v) { this.longitude = v; }
    public Integer getSpeedKph() { return speedKph; }
    public void setSpeedKph(Integer v) { this.speedKph = v; }
    public OffsetDateTime getMeasuredAt() { return measuredAt; }
    public void setMeasuredAt(OffsetDateTime v) { this.measuredAt = v; }
}
