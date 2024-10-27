package org.but.eloryksauthorization.newbackend.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class PositionDTO {
    @JsonIgnore
    private Long positionId;

    @NotNull(message = "Speed must not be null")
    @Min(value = 0, message = "Speed must be a positive number")
    @JsonProperty("Speed")
    private Integer speed;

    @NotNull(message = "heading must not be null")
    @JsonProperty("Heading")
    private Integer heading;

    @NotNull(message = "latitude must not be null")
    @JsonProperty("Latitude")
    private Double latitude;

    @NotNull(message = "longitude must not be null")
    @JsonProperty("Longitude")
    private Double longitude;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @NotNull(message = "Timestamp must not be null")
    @JsonProperty("Timestamp")
    private LocalDateTime timestamp;

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getHeading() {
        return heading;
    }

    public void setHeading(Integer heading) {
        this.heading = heading;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
