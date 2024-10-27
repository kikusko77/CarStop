\connect "eloryks-db";

INSERT INTO eloryks.vehicle_authorization_request (vin, key, action, action_timestamp,
                                                   authorized_to_speed_limit_target_vehicle)
VALUES ('4Y1-SL658-4-8-Z-41-1439', 'asdqweczzxc', 'SPEED_LIMIT', '2007-11-13 10:00:00', 'NOT_DECIDED_YET'),
       ('4Y1-SL658-4-8-Z-41-1439', 'asdqweczzxc', 'STOP', '2007-11-13 10:15:00', 'NOT_DECIDED_YET');

INSERT INTO eloryks.position (speed, heading, latitude, longitude, timestamp)
VALUES (45, 180, 49.22665695615129, 16.57624027502927, '2023-01-01 10:00:00'),
       (45, 180, 49.22621989911591, 16.574210267250237, '2023-01-01 10:00:00'),
       (45, 180, 49.22777871818001, 16.572994493360596, '2023-01-01 10:00:00'),
       (45, 180, 49.22920637847363, 16.572849492804952, '2023-01-01 10:00:00'),
       (45, 180, 49.22855082529785, 16.57657489169569, '2023-01-01 10:00:00'),
       (45, 180, 50.1034985835616, 14.394866517677745, '2023-01-01 10:00:00'),
       (45, 180, 50.10260024700853, 14.393934449627764, '2023-01-01 10:00:00'),
       (45, 180, 50.10451077357635, 14.393959107512897, '2023-01-01 10:00:00'),
       (45, 180, 50.10451077357635, 14.392780460613697, '2023-01-01 10:00:00'),
       (45, 180, 50.105092773149686, 14.392420455493863, '2023-01-01 10:00:00'),
       (45, 180, 49.392450440984746, 15.547825026196014, '2023-01-01 10:00:00'),
       (45, 180, 49.393214376132306, 15.548224483931744, '2023-01-01 10:00:00'),
       (45, 180, 49.39442124106169, 15.548692983745248, '2023-01-01 10:00:00'),
       (45, 180, 49.3937022612702, 15.54755378946178, '2023-01-01 10:00:00'),
       (45, 180, 49.39263019150008, 15.546878163414952, '2023-01-01 10:00:00');

INSERT INTO eloryks.encryption_key (key_type, coord_x, coord_y)
VALUES (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2');

INSERT INTO eloryks.sign_key (key_type, coord_x, coord_y)
VALUES (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2'),
       (1, 'random1', 'random2');

INSERT INTO eloryks.speed_limit (speed, engine_speed)
VALUES (80, 2000),
       (80, 2000),
       (80, 2000),
       (80, 2000),
       (80, 2000),
       (80, 2000),
       (80, 2000),
       (80, 2000),
       (80, 2000),
       (80, 2000),
       (80, 2000),
       (80, 2000),
       (80, 2000),
       (80, 2000),
       (80, 2000);

INSERT INTO eloryks.vehicle (station_type, position_id, certificate_id, encryption_key_id, sign_key_id, speed_limit_id)
VALUES ('Type-01', 1, 'Cert-0001', 1, 1, 1),
       ('Type-02', 2, 'Cert-0002', 2, 2, 2),
       ('Type-03', 3, 'Cert-0003', 3, 3, 3),
       ('Type-04', 4, 'Cert-0004', 4, 4, 4),
       ('Type-05', 5, 'Cert-0005', 5, 5, 5),
       ('Type-06', 6, 'Cert-0006', 6, 6, 6),
       ('Type-07', 7, 'Cert-0007', 7, 7, 7),
       ('Type-08', 8, 'Cert-0008', 8, 8, 8),
       ('Type-09', 9, 'Cert-0009', 9, 9, 9),
       ('Type-11', 10, 'Cert-0010', 10, 10, 10),
       ('Type-11', 11, 'Cert-0011', 11, 11, 11),
       ('Type-12', 12, 'Cert-0012', 12, 12, 12),
       ('Type-13', 13, 'Cert-0013', 13, 13, 13),
       ('Type-14', 14, 'Cert-0014', 14, 14, 14),
       ('Type-15', 15, 'Cert-0015', 15, 15, 15);

INSERT INTO eloryks.person (email, given_name, family_name, nickname, pwd)
VALUES ('user1@vut.com', 'Wayne', 'Johnson', 'The Rock', '$argon2id$v=19$m=65536,t=5,p=1$ePIGlUa0L/LZ0qWmX5jXXw$WUT3w8pgtydXCR6e8rVoLH+y8CmZU+lj9oBsx3mr+sY'),
       ('eloryks@vut.cz', 'Eloryks', 'Admin', 'Eloryks Admin' ,'$argon2id$v=19$m=65536,t=5,p=1$ePIGlUa0L/LZ0qWmX5jXXw$WUT3w8pgtydXCR6e8rVoLH+y8CmZU+lj9oBsx3mr+sY');

INSERT INTO eloryks.role (role)
VALUES ('ADMIN'),
       ('USER');

INSERT INTO eloryks.person_has_role (id_person, id_role, started_at, ended_at, expiration_date)
VALUES (1, 2, '2023-01-01 00:00:00', '2023-12-31 23:59:59', '2024-01-01 00:00:00'),
       (2, 1, '2023-01-02 00:00:00', '2023-12-30 23:59:59', '2024-01-02 00:00:00');
