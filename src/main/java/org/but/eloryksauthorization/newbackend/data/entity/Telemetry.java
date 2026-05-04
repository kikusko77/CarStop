package org.but.eloryksauthorization.newbackend.data.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "telemetry")
public class Telemetry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "telemetry_id")
    private Long telemetryId;

    @Column(name = "vehicle_id", nullable = false)
    private Long vehicleId;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "speed_kph", nullable = false)
    private Integer speedKph;

    @Column(name = "measured_at", nullable = false)
    private OffsetDateTime measuredAt;

    @Column(name = "received_at", nullable = false, insertable = false, updatable = false)
    private OffsetDateTime receivedAt;

    @Column(name = "message_id", length = 64)
    private String messageId;

    public Long getTelemetryId() { return telemetryId; }
    public void setTelemetryId(Long v) { this.telemetryId = v; }
    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long v) { this.vehicleId = v; }
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double v) { this.latitude = v; }
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double v) { this.longitude = v; }
    public Integer getSpeedKph() { return speedKph; }
    public void setSpeedKph(Integer v) { this.speedKph = v; }
    public OffsetDateTime getMeasuredAt() { return measuredAt; }
    public void setMeasuredAt(OffsetDateTime v) { this.measuredAt = v; }
    public OffsetDateTime getReceivedAt() { return receivedAt; }
    public void setReceivedAt(OffsetDateTime v) { this.receivedAt = v; }
    public String getMessageId() { return messageId; }
    public void setMessageId(String v) { this.messageId = v; }
}
