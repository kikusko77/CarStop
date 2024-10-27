package org.but.eloryksauthorization.newbackend.api;

import java.util.List;

public class ResponsePutDTO {
    private ResponseStatusDTO responseStatus;

    private List<ResponseUpdateDTO> responseVehicle;

    public ResponsePutDTO() {
    }

    public ResponseStatusDTO getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatusDTO responseStatus) {
        this.responseStatus = responseStatus;
    }

    public List<ResponseUpdateDTO> getResponseVehicle() {
        return responseVehicle;
    }

    public void setResponseVehicle(List<ResponseUpdateDTO> responseVehicle) {
        this.responseVehicle = responseVehicle;
    }
}
