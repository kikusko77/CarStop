package org.but.eloryksauthorization.api;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.but.eloryksauthorization.data.entity.enums.AuthorizedToSpeedLimitTargetVehicle;
import org.but.eloryksauthorization.data.entity.enums.EloryksAction;
import org.but.eloryksauthorization.validators.EloryksActionSubset;

import java.time.LocalDateTime;

public class VehicleAuthorizationRequestCreateDto {

    @NotNull
    @NotEmpty
    private String vin;
    @NotNull
    @NotEmpty
    private String key;
    private LocalDateTime actionTimestamp;
    @EloryksActionSubset(anyOf = {EloryksAction.SPEED_LIMIT, EloryksAction.STOP})
    private EloryksAction action;
    private AuthorizedToSpeedLimitTargetVehicle authorizedToSpeedLimitTargetVehicle;

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
}
