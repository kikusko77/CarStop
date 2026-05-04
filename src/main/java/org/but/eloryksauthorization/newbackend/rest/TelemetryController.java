package org.but.eloryksauthorization.newbackend.rest;

import jakarta.validation.Valid;
import org.but.eloryksauthorization.newbackend.api.AlertDTO;
import org.but.eloryksauthorization.newbackend.api.TelemetryDTO;
import org.but.eloryksauthorization.newbackend.api.TelemetryRequestDTO;
import org.but.eloryksauthorization.newbackend.data.entity.Alert;
import org.but.eloryksauthorization.newbackend.data.entity.Telemetry;
import org.but.eloryksauthorization.newbackend.data.repository.AlertRepository;
import org.but.eloryksauthorization.newbackend.data.repository.TelemetryRepository;
import org.but.eloryksauthorization.newbackend.service.ServiceBusPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/its/vehicle")
public class TelemetryController {

    @Autowired
    private ServiceBusPublisher publisher;

    @Autowired
    private TelemetryRepository telemetryRepository;

    @Autowired
    private AlertRepository alertRepository;

    @PostMapping(value = "/telemetry", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> ingest(@Valid @RequestBody TelemetryRequestDTO body) {
        if (body.getMeasuredAt() == null) {
            body.setMeasuredAt(OffsetDateTime.now());
        }
        String messageId = UUID.randomUUID().toString();
        Map<String, Object> payload = Map.of(
                "messageId", messageId,
                "vehicleId", body.getVehicleId(),
                "latitude", body.getLatitude(),
                "longitude", body.getLongitude(),
                "speedKph", body.getSpeedKph(),
                "measuredAt", body.getMeasuredAt().toString()
        );
        publisher.publish(payload, messageId);
        return ResponseEntity.accepted().body(Map.of("messageId", messageId, "status", "queued"));
    }

    @GetMapping(value = "/telemetry/recent", produces = "application/json")
    public ResponseEntity<List<TelemetryDTO>> recentTelemetry(
            @RequestParam(defaultValue = "20") int limit) {
        List<TelemetryDTO> result = telemetryRepository
                .findAllByOrderByReceivedAtDesc(PageRequest.of(0, Math.min(limit, 100)))
                .stream().map(TelemetryController::toDto).toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/alerts/recent", produces = "application/json")
    public ResponseEntity<List<AlertDTO>> recentAlerts(
            @RequestParam(defaultValue = "20") int limit) {
        List<AlertDTO> result = alertRepository
                .findAllByOrderByCreatedAtDesc(PageRequest.of(0, Math.min(limit, 100)))
                .stream().map(TelemetryController::toDto).toList();
        return ResponseEntity.ok(result);
    }

    private static TelemetryDTO toDto(Telemetry t) {
        TelemetryDTO d = new TelemetryDTO();
        d.setTelemetryId(t.getTelemetryId());
        d.setVehicleId(t.getVehicleId());
        d.setLatitude(t.getLatitude());
        d.setLongitude(t.getLongitude());
        d.setSpeedKph(t.getSpeedKph());
        d.setMeasuredAt(t.getMeasuredAt());
        d.setReceivedAt(t.getReceivedAt());
        d.setMessageId(t.getMessageId());
        return d;
    }

    private static AlertDTO toDto(Alert a) {
        AlertDTO d = new AlertDTO();
        d.setAlertId(a.getAlertId());
        d.setVehicleId(a.getVehicleId());
        d.setAlertType(a.getAlertType());
        d.setDetail(a.getDetail());
        d.setCreatedAt(a.getCreatedAt());
        d.setTelemetryId(a.getTelemetryId());
        return d;
    }
}
