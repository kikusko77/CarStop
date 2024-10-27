package org.but.eloryksauthorization.newbackend.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class VehicleSpeedLimitRequestFromWebUpdateDto {

    @NotNull(message = "id must not be null")
    private Long id;
    @NotNull(message = "requestAuthorEmail must not be null")
    private String requestAuthorEmail;
    private Integer heading;
    @NotNull(message = "latitude must not be null")
    private Double latitude;
    @NotNull(message = "longitude must not be null")
    private Double longitude;
    private Boolean local;
    private Integer secured;
    private Integer speed;
    @NotNull(message = "stationId must not be null")
    private Long stationId;
    @NotNull(message = "stationType must not be null")
    private String stationType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @NotNull (message = "timestamp must not be null")
    private LocalDateTime timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestAuthorEmail() {
        return requestAuthorEmail;
    }

    public void setRequestAuthorEmail(String requestAuthorEmail) {
        this.requestAuthorEmail = requestAuthorEmail;
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

    public Boolean getLocal() {
        return local;
    }

    public void setLocal(Boolean local) {
        this.local = local;
    }

    public Integer getSecured() {
        return secured;
    }

    public void setSecured(Integer secured) {
        this.secured = secured;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "VehicleSpeedLimitRequestFromWebUpdateDto{" +
                "id=" + id +
                ", requestAuthorEmail='" + requestAuthorEmail + '\'' +
                ", heading=" + heading +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", local=" + local +
                ", secured=" + secured +
                ", speed=" + speed +
                ", stationId=" + stationId +
                ", stationType='" + stationType + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
