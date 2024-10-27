package org.but.eloryksauthorization.newbackend.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class SignKeyDTO {

    @JsonIgnore
    private Long signKeyId;

    @NotNull(message = "KeyType must not be null")
    @JsonProperty("KeyType")
    private Integer keyType;

    @NotEmpty(message = "CoordX must not be null")
    @JsonProperty("CoordX")
    private String coordX;

    @NotEmpty(message = "CoordY must not be null")
    @JsonProperty("CoordY")
    private String coordY;

    public Long getSignKeyId() {
        return signKeyId;
    }

    public void setSignKeyId(Long signKeyId) {
        this.signKeyId = signKeyId;
    }

    public Integer getKeyType() {
        return keyType;
    }

    public void setKeyType(Integer keyType) {
        this.keyType = keyType;
    }

    public String getCoordX() {
        return coordX;
    }

    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }
}
