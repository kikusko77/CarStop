package org.but.eloryksauthorization.api;

public class VehicleAuthorizationRequestIdDto {

    private Long vehicleAuthorizationRequestId;

    public Long getVehicleAuthorizationRequestId() {
        return vehicleAuthorizationRequestId;
    }

    public void setVehicleAuthorizationRequestId(Long vehicleAuthorizationRequestId) {
        this.vehicleAuthorizationRequestId = vehicleAuthorizationRequestId;
    }

    @Override
    public String toString() {
        return "VehicleAuthorizationRequestIdDto{" +
                "vehicleAuthorizationRequestId=" + vehicleAuthorizationRequestId +
                '}';
    }
}
