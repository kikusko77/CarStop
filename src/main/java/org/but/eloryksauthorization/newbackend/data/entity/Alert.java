package org.but.eloryksauthorization.newbackend.data.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "alert")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alert_id")
    private Long alertId;

    @Column(name = "vehicle_id", nullable = false)
    private Long vehicleId;

    @Column(name = "alert_type", nullable = false, length = 32)
    private String alertType;

    @Column(name = "detail")
    private String detail;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "telemetry_id")
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
