package org.but.eloryksauthorization.newbackend.data.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @Column(name = "position_id")
    private Long positionId;

    @Column(name = "speed")
    private Integer speed;

    @Column(name = "heading")
    private Integer heading;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @OneToOne(mappedBy = "position")
    private Vehicle vehicle;

    public Position(Long positionId, Integer speed, Integer heading, Double latitude, Double longitude, Vehicle vehicle, LocalDateTime timestamp) {
        this.positionId = positionId;
        this.speed = speed;
        this.heading = heading;
        this.latitude = latitude;
        this.longitude = longitude;
        this.vehicle = vehicle;
        this.timestamp = timestamp;
    }

    public Position() {
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

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
