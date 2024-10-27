package org.but.eloryksauthorization.newbackend.data.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "vehicle_speed_limit_request_from_web")
public class VehicleSpeedLimitRequestFromWeb implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_speed_limit_request_from_web_id")
    private Long id;
    @Column(name = "request_author_email")
    private String requestAuthorEmail;
    @Column(name = "heading")
    private Integer heading;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "local")
    private Boolean local;
    @Column(name = "secured")
    private Integer secured;
    @Column(name = "speed")
    private Integer speed;
    @Column(name = "station_id")
    private Long stationId;
    @Column(name = "station_type")
    private String stationType;
    @Column(name = "timestamp")
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }


    public String getRequestAuthorEmail() {
        return requestAuthorEmail;
    }

    public void setRequestAuthorEmail(String requestAuthorEmail) {
        this.requestAuthorEmail = requestAuthorEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleSpeedLimitRequestFromWeb that)) return false;
        return Objects.equals(getRequestAuthorEmail(), that.getRequestAuthorEmail()) && Objects.equals(getHeading(), that.getHeading()) && Objects.equals(getLatitude(), that.getLatitude()) && Objects.equals(getLongitude(), that.getLongitude()) && Objects.equals(getLocal(), that.getLocal()) && Objects.equals(getSecured(), that.getSecured()) && Objects.equals(getSpeed(), that.getSpeed()) && Objects.equals(getStationId(), that.getStationId()) && Objects.equals(getStationType(), that.getStationType()) && Objects.equals(getTimestamp(), that.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequestAuthorEmail(), getHeading(), getLatitude(), getLongitude(), getLocal(), getSecured(), getSpeed(), getStationId(), getStationType(), getTimestamp());
    }

    @Override
    public String toString() {
        return "VehicleSpeedLimitRequestFromWeb{" +
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
