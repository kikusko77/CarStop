\connect "eloryks-db";

CREATE TABLE eloryks.telemetry (
    telemetry_id BIGSERIAL PRIMARY KEY,
    vehicle_id BIGINT NOT NULL,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    speed_kph INTEGER NOT NULL,
    measured_at TIMESTAMPTZ NOT NULL,
    received_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    message_id VARCHAR(64)
);

CREATE INDEX telemetry_vehicle_measured_at_idx
    ON eloryks.telemetry (vehicle_id, measured_at DESC);

CREATE TABLE eloryks.alert (
    alert_id BIGSERIAL PRIMARY KEY,
    vehicle_id BIGINT NOT NULL,
    alert_type VARCHAR(32) NOT NULL,
    detail TEXT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    telemetry_id BIGINT REFERENCES eloryks.telemetry(telemetry_id) ON DELETE SET NULL
);

CREATE INDEX alert_created_at_idx ON eloryks.alert (created_at DESC);

GRANT SELECT, INSERT, UPDATE, DELETE ON eloryks.telemetry, eloryks.alert TO "eloryks-app";
GRANT USAGE, SELECT ON SEQUENCE eloryks.telemetry_telemetry_id_seq, eloryks.alert_alert_id_seq TO "eloryks-app";
