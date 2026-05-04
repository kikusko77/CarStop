package org.but.eloryksauthorization.newbackend.api;

import java.time.OffsetDateTime;

public class TelemetryDTO {
    private Long telemetryId;
    private Long vehicleId;
    private Double latitude;
    private Double longitude;
    private Integer speedKph;
    private OffsetDateTime measuredAt;
    private OffsetDateTime receivedAt;
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
