package org.but.eloryksauthorization.newbackend.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EncryptionKeyDTO {

    @JsonIgnore
    private Long encryptionKeyId;

    @JsonProperty("KeyType")
    private Integer keyType;

    @JsonProperty("CoordX")
    private String coordX;

    @JsonProperty("CoordY")
    private String coordY;

    public Long getEncryptionKeyId() {
        return encryptionKeyId;
    }

    public void setEncryptionKeyId(Long encryption_key_id) {
        this.encryptionKeyId = encryption_key_id;
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
