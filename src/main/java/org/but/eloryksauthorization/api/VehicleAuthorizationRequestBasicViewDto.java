package org.but.eloryksauthorization.api;

import org.but.eloryksauthorization.data.entity.enums.AuthorizedToSpeedLimitTargetVehicle;
import org.but.eloryksauthorization.data.entity.enums.EloryksAction;

import java.time.LocalDateTime;

public class VehicleAuthorizationRequestBasicViewDto {

    private Long id;
    private String vin;
    private String key;
    private LocalDateTime actionTimestamp;
    private EloryksAction action;
    private AuthorizedToSpeedLimitTargetVehicle authorizedToSpeedLimitTargetVehicle;

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

    public LocalDateTime getActionTimestamp() {
        return actionTimestamp;
    }

    public void setActionTimestamp(LocalDateTime actionTimestamp) {
        this.actionTimestamp = actionTimestamp;
    }

    public EloryksAction getAction() {
        return action;
    }

    public void setAction(EloryksAction action) {
        this.action = action;
    }

    public AuthorizedToSpeedLimitTargetVehicle getAuthorizedToSpeedLimitTargetVehicle() {
        return authorizedToSpeedLimitTargetVehicle;
    }

    public void setAuthorizedToSpeedLimitTargetVehicle(AuthorizedToSpeedLimitTargetVehicle authorizedToSpeedLimitTargetVehicle) {
        this.authorizedToSpeedLimitTargetVehicle = authorizedToSpeedLimitTargetVehicle;
    }

    @Override
    public String toString() {
        return "VehicleAuthorizationRequestBasicViewDto{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", key='" + key + '\'' +
                ", actionTimestamp=" + actionTimestamp +
                ", action=" + action +
                ", authorizedToSpeedLimitTargetVehicle=" + authorizedToSpeedLimitTargetVehicle +
                '}';
    }
}
