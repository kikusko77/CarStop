package org.but.eloryksauthorization.newbackend.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sign_key")
public class SignKey {

    @Id
    @Column(name = "sign_key_id")
    private Long signKeyId;

    @Column(name = "key_type")
    private Integer keyType;

    @Column(name = "coord_x")
    private String coordX;

    @Column(name = "coord_y")
    private String coordY;
    @OneToOne(mappedBy = "signKey")
    private Vehicle vehicle;

    public SignKey(Long signKeyId, Integer keyType, String coordX, String cordY, Vehicle vehicle) {
        this.signKeyId = signKeyId;
        this.keyType = keyType;
        this.coordX = coordX;
        this.coordY = cordY;
        this.vehicle = vehicle;

    }

    public SignKey() {
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

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

    public void setCoordX(String cordX) {
        this.coordX = cordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(String cordY) {
        this.coordY = cordY;
    }
}
