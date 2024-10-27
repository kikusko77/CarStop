package org.but.eloryksauthorization.newbackend.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseUpdateDTO {

    @JsonProperty("StationId")
    private Long stationId;

    @JsonProperty("SpeedLimit")
    private SpeedLimitDTO speedLimit;

    @JsonProperty("SpeedLimitEncrypted")
    private String speedLimitEncrypted;

    @JsonProperty("ErrorCode")
    private int errorCode;

    @JsonProperty("Message")
    private String message;

    public ResponseUpdateDTO() {
    }

    ;

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SpeedLimitDTO getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(SpeedLimitDTO speedLimit) {
        this.speedLimit = speedLimit;
    }

    public String getSpeedLimitEncrypted() {
        return speedLimitEncrypted;
    }

    public void setSpeedLimitEncrypted(String speedLimitEncrypted) {
        this.speedLimitEncrypted = speedLimitEncrypted;
    }
}