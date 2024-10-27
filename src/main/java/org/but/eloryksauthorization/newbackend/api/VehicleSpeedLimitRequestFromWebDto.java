package org.but.eloryksauthorization.newbackend.api;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Objects;

public class VehicleSpeedLimitRequestFromWebDto {
    private Long id;
    private String requestAuthorEmail;
    private Integer heading;
    private Double latitude;
    private Double longitude;
    private Boolean local;
    private Integer secured;
    private Integer speed;
    private Long stationId;
    private String stationType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRequestAuthorEmail() {
        return requestAuthorEmail;
    }

    public void setRequestAuthorEmail(String requestAuthorEmail) {
        this.requestAuthorEmail = requestAuthorEmail;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "VehicleSpeedLimitRequestFromWebDto{" +
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
