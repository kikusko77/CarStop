package org.but.eloryksauthorization.newbackend.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "speed_limit")
public class SpeedLimit {

    @Id
    @Column(name = "speed_limit_id")
    private Long speedLimitId;

    private Integer speed;

    private Integer engineSpeed;

    @OneToOne(mappedBy = "speedLimit")
    private Vehicle vehicle;

    public SpeedLimit(Long speedLimitId, Integer speed, Integer engineSpeed, Vehicle vehicle) {
        this.speedLimitId = speedLimitId;
        this.speed = speed;
        this.engineSpeed = engineSpeed;
        this.vehicle = vehicle;
    }

    public SpeedLimit() {
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getSpeedLimitId() {
        return speedLimitId;
    }

    public void setSpeedLimitId(Long speedLimitId) {
        this.speedLimitId = speedLimitId;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(Integer engineSpeed) {
        this.engineSpeed = engineSpeed;
    }
}
