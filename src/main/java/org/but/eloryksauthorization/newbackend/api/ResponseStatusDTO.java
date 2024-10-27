package org.but.eloryksauthorization.newbackend.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseStatusDTO {

    @JsonProperty("ErrorCode")
    private int errorCode;

    @JsonProperty("Message")
    private String message;

    public ResponseStatusDTO() {
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
