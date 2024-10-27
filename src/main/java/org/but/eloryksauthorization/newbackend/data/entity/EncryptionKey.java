package org.but.eloryksauthorization.newbackend.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "encryption_key")
public class EncryptionKey {

    @Id
    @Column(name = "encryption_key_id")
    private Long encryptionKeyId;

    @Column(name = "key_type")
    private Integer keyType;

    @Column(name = "coord_x")
    private String coordX;

    @Column(name = "coord_y")
    private String coordY;
    @OneToOne(mappedBy = "encryptionKey")
    private Vehicle vehicle;

    public EncryptionKey(Long encryptionKeyId, Integer keyType, String coordX, String coordY, Vehicle vehicle) {
        this.encryptionKeyId = encryptionKeyId;
        this.keyType = keyType;
        this.coordX = coordX;
        this.coordY = coordY;
        this.vehicle = vehicle;
    }

    public EncryptionKey() {
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getEncryptionKeyId() {
        return encryptionKeyId;
    }

    public void setEncryptionKeyId(Long id) {
        this.encryptionKeyId = id;
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

    public void setCoordX(String cordX) {
        this.coordX = cordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }
}
