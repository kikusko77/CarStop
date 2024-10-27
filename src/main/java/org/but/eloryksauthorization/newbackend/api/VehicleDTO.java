package org.but.eloryksauthorization.newbackend.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class VehicleDTO {

    @NotNull(message = "StationId must not be null")
    @JsonProperty("StationId")
    private Long stationId;

    @NotEmpty(message = "StationType must not be null")
    @JsonProperty("StationType")
    private String stationType;

    @NotNull(message = "Position must not be null")
    @Valid
    @JsonProperty("Position")
    private PositionDTO position;

    @NotEmpty(message = "CertificateId must not be null")
    @JsonProperty("CertificateId")
    private String certificateId;

    @Valid
    @JsonProperty("EncryptionKey")
    private EncryptionKeyDTO encryptionKey;

    @NotNull(message = "SignKey must not be null")
    @Valid
    @JsonProperty("SignKey")
    private SignKeyDTO signKey;

    @Valid
    @JsonProperty("SpeedLimit")
    private SpeedLimitDTO speedLimit;

    public VehicleDTO() {
    }

    public SpeedLimitDTO getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(SpeedLimitDTO speedLimit) {
        this.speedLimit = speedLimit;
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

    public PositionDTO getPosition() {
        return position;
    }

    public void setPosition(PositionDTO position) {
        this.position = position;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public EncryptionKeyDTO getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(EncryptionKeyDTO encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public SignKeyDTO getSignKey() {
        return signKey;
    }

    public void setSignKey(SignKeyDTO signKey) {
        this.signKey = signKey;
    }
}
