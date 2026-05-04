package org.but.eloryksauthorization.newbackend.api;

import java.time.OffsetDateTime;

public class AlertDTO {
    private Long alertId;
    private Long vehicleId;
    private String alertType;
    private String detail;
    private OffsetDateTime createdAt;
    private Long telemetryId;

    public Long getAlertId() { return alertId; }
    public void setAlertId(Long v) { this.alertId = v; }
    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long v) { this.vehicleId = v; }
    public String getAlertType() { return alertType; }
    public void setAlertType(String v) { this.alertType = v; }
    public String getDetail() { return detail; }
    public void setDetail(String v) { this.detail = v; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime v) { this.createdAt = v; }
    public Long getTelemetryId() { return telemetryId; }
    public void setTelemetryId(Long v) { this.telemetryId = v; }
}
