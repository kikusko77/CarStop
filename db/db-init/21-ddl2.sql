\connect "eloryks-db";

CREATE TABLE eloryks.position (
    position_id BIGSERIAL PRIMARY KEY,
    speed INTEGER NOT NULL,
    heading INTEGER NOT NULL,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    timestamp TIMESTAMP NOT NULL
);

CREATE TABLE eloryks.encryption_key (
    encryption_key_id BIGSERIAL PRIMARY KEY,
    key_type INTEGER,
    coord_x VARCHAR(255),
    coord_y VARCHAR(255)
);

CREATE TABLE eloryks.sign_key (
    sign_key_id BIGSERIAL PRIMARY KEY,
    key_type INTEGER NOT NULL,
    coord_x VARCHAR(255) NOT NULL,
    coord_y VARCHAR(255) NOT NULL
);

CREATE TABLE eloryks.speed_limit (
    speed_limit_id BIGSERIAL PRIMARY KEY,
    speed INTEGER,
    engine_speed INTEGER
);

CREATE TABLE eloryks.vehicle (
    station_id BIGSERIAL PRIMARY KEY,
    station_type VARCHAR(255) NOT NULL,
    position_id INTEGER,
    certificate_id VARCHAR(255) NOT NULL,
    encryption_key_id INTEGER,
    sign_key_id INTEGER,
    speed_limit_id INTEGER,

    CONSTRAINT fk_position_id FOREIGN KEY (position_id) REFERENCES eloryks.position(position_id) ON DELETE CASCADE,
    CONSTRAINT fk_encryption_key_id FOREIGN KEY (encryption_key_id) REFERENCES eloryks.encryption_key(encryption_key_id) ON DELETE CASCADE,
    CONSTRAINT fk_sign_key_id FOREIGN KEY (sign_key_id) REFERENCES eloryks.sign_key(sign_key_id) ON DELETE CASCADE,
    CONSTRAINT fk_speed_limit_id FOREIGN KEY (speed_limit_id) REFERENCES eloryks.speed_limit(speed_limit_id) ON DELETE CASCADE
);



CREATE TABLE eloryks.vehicle_speed_limit_request_from_web (
    vehicle_speed_limit_request_from_web_id BIGSERIAL PRIMARY KEY,
    request_author_email VARCHAR(255) NOT NULL,
    heading INTEGER,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    local BOOLEAN,
    secured INTEGER,
    speed INTEGER,
    station_id BIGINT NOT NULL,
    station_type VARCHAR(255) NOT NULL,
    timestamp TIMESTAMP NOT NULL
);
