package org.but.eloryksauthorization.newbackend.api;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class VehicleSpeedLimitRequestFromWebCreateDto {

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

    @Override
    public String toString() {
        return "VehicleSpeedLimitRequestFromWebCreateDto{" +
                "requestAuthorEmail='" + requestAuthorEmail + '\'' +
                ", heading=" + heading +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", local=" + local +
                ", secured=" + secured +
                ", speed=" + speed +
                ", stationId=" + stationId +
                ", stationType='" + stationType + '\'' +
                '}';
    }
}
