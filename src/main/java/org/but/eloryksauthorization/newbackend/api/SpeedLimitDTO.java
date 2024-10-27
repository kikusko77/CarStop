package org.but.eloryksauthorization.newbackend.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SpeedLimitDTO {

    @JsonIgnore
    private Long speedLimitId;

    @JsonProperty("Speed")
    private Integer speed;

    @JsonProperty("EngineSpeed")
    private Integer engineSpeed;

    public SpeedLimitDTO() {
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
