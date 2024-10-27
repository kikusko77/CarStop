package org.but.eloryksauthorization.api;

import org.but.eloryksauthorization.data.entity.enums.AuthorizedToSpeedLimitTargetVehicle;
import org.but.eloryksauthorization.validators.AuthorizedToSpeedLimitTargetVehicleSubset;

public class VehicleAuthorizationRequestStatusUpdateDto {

    @AuthorizedToSpeedLimitTargetVehicleSubset(anyOf = {AuthorizedToSpeedLimitTargetVehicle.APPROVED, AuthorizedToSpeedLimitTargetVehicle.DECLINED, AuthorizedToSpeedLimitTargetVehicle.NOT_DECIDED_YET})
    private AuthorizedToSpeedLimitTargetVehicle authorizedToSpeedLimitTargetVehicle;

    public AuthorizedToSpeedLimitTargetVehicle getAuthorizedToSpeedLimitTargetVehicle() {
        return authorizedToSpeedLimitTargetVehicle;
    }

    public void setAuthorizedToSpeedLimitTargetVehicle(AuthorizedToSpeedLimitTargetVehicle authorizedToSpeedLimitTargetVehicle) {
        this.authorizedToSpeedLimitTargetVehicle = authorizedToSpeedLimitTargetVehicle;
    }
}
