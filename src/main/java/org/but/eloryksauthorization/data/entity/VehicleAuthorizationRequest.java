package org.but.eloryksauthorization.data.entity;

import jakarta.persistence.*;
import org.but.eloryksauthorization.data.entity.enums.AuthorizedToSpeedLimitTargetVehicle;
import org.but.eloryksauthorization.data.entity.enums.EloryksAction;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "vehicle_authorization_request")
public class VehicleAuthorizationRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_authorization_request_id")
    private Long id;
    @Column(name = "vin", length = 255)
    private String vin;
    @Column(name = "key", length = 255)
    private String key;
    @Column(name = "action_timestamp")
    private LocalDateTime actionTimestamp;
    @Column(name = "action", length = 20)
    @Enumerated(EnumType.STRING)
    private EloryksAction action;
    @Column(name = "authorized_to_speed_limit_target_vehicle", length = 255)
    @Enumerated(EnumType.STRING)
    private AuthorizedToSpeedLimitTargetVehicle authorizedToSpeedLimitTargetVehicle;

    public VehicleAuthorizationRequest() {
    }

    public VehicleAuthorizationRequest(Long id, String vin, String key, EloryksAction action) {
        this.id = id;
        this.vin = vin;
        this.key = key;
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public EloryksAction getAction() {
        return action;
    }

    public void setAction(EloryksAction action) {
        this.action = action;
    }

    public LocalDateTime getActionTimestamp() {
        return actionTimestamp;
    }

    public void setActionTimestamp(LocalDateTime actionTimestamp) {
        this.actionTimestamp = actionTimestamp;
    }

    public AuthorizedToSpeedLimitTargetVehicle getAuthorizedToSpeedLimitTargetVehicle() {
        return authorizedToSpeedLimitTargetVehicle;
    }

    public void setAuthorizedToSpeedLimitTargetVehicle(AuthorizedToSpeedLimitTargetVehicle authorizedToSpeedLimitTargetVehicle) {
        this.authorizedToSpeedLimitTargetVehicle = authorizedToSpeedLimitTargetVehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleAuthorizationRequest vehicle = (VehicleAuthorizationRequest) o;
        return getVin().equals(vehicle.getVin()) && actionTimestamp.equals(vehicle.actionTimestamp) && getAction() == vehicle.getAction();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVin(), actionTimestamp, getAction());
    }

    @Override
    public String toString() {
        return "VehicleAuthorizationRequest{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", key='" + key + '\'' +
                ", actionTimestamp=" + actionTimestamp +
                ", action=" + action +
                ", authorizedToSpeedLimitTargetVehicle=" + authorizedToSpeedLimitTargetVehicle +
                '}';
    }
}
