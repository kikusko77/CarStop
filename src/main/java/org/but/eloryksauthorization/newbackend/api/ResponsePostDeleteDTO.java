package org.but.eloryksauthorization.newbackend.api;

import java.util.List;

public class ResponsePostDeleteDTO {
    private ResponseStatusDTO responseStatus;
    private List<ResponseCreateDeleteDTO> responseVehicle;

    public ResponsePostDeleteDTO() {
    }

    public ResponseStatusDTO getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatusDTO responseStatus) {
        this.responseStatus = responseStatus;
    }

    public List<ResponseCreateDeleteDTO> getResponseVehicle() {
        return responseVehicle;
    }

    public void setResponseVehicle(List<ResponseCreateDeleteDTO> responseVehicle) {
        this.responseVehicle = responseVehicle;
    }
}
