package org.but.eloryksauthorization.newbackend.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @Column(name = "station_id")
    private Long stationId;

    @Column(name = "station_type")
    private String stationType;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "position_id", referencedColumnName = "position_id")
    private Position position;

    @Column(name = "certificate_id")
    private String certificateId;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "encryption_key_id", referencedColumnName = "encryption_key_id")
    private EncryptionKey encryptionKey;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "sign_key_id", referencedColumnName = "sign_key_id")
    private SignKey signKey;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "speed_limit_id", referencedColumnName = "speed_limit_id")
    private SpeedLimit speedLimit;

    public Vehicle(Long stationId, String stationType, Position position, String certificateId, EncryptionKey encryptionKey, SignKey signKey, SpeedLimit speedLimit) {
        this.stationId = stationId;
        this.stationType = stationType;
        this.position = position;
        this.certificateId = certificateId;
        this.encryptionKey = encryptionKey;
        this.signKey = signKey;
        this.speedLimit = speedLimit;
    }

    public Vehicle() {
    }

    public SpeedLimit getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(SpeedLimit speedLimit) {
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public EncryptionKey getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(EncryptionKey encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public SignKey getSignKey() {
        return signKey;
    }

    public void setSignKey(SignKey signKey) {
        this.signKey = signKey;
    }
}
