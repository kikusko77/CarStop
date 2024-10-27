package org.but.eloryksauthorization.newbackend.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseCreateDeleteDTO {
    @JsonProperty("StationId")
    private Long stationId;
    @JsonProperty("ErrorCode")
    private int errorCode;
    @JsonProperty("Message")
    private String message;

    public ResponseCreateDeleteDTO() {
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
}
