\connect "eloryks-db";

CREATE TABLE eloryks.person (
    id_person bigserial NOT NULL,
    email character varying(100) NOT NULL,
    given_name character varying(45),
    family_name character varying(45),
    nickname character varying(45),
    pwd character varying(255) NOT NULL,
    PRIMARY KEY (id_person)
);

CREATE TABLE eloryks.role (
    id_role serial NOT NULL,
    role varchar(45) NOT NULL,
    PRIMARY KEY (id_role)
);

CREATE TABLE eloryks.person_has_role (
    id_person bigserial NOT NULL,
    id_role serial NOT NULL,
    started_at TIMESTAMP NOT NULL,
    ended_at TIMESTAMP,
    expiration_date TIMESTAMP,
    PRIMARY KEY (id_role, id_person),
    CONSTRAINT fk_person_has_role_person1
        FOREIGN KEY (id_person)
        REFERENCES eloryks.person (id_person)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT fk_person_has_role_role1
        FOREIGN KEY (id_role)
        REFERENCES eloryks.role (id_role)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

create table eloryks.vehicle_authorization_request (
    vehicle_authorization_request_id bigserial not null,
    vin        varchar(255) not null,
    key        varchar(255) not null,
    action     varchar(255) not null,
	action_timestamp timestamp not null,
	authorized_to_speed_limit_target_vehicle varchar(255) not null,
    primary key (vehicle_authorization_request_id)
);

CREATE OR REPLACE FUNCTION eloryks.resetSequences() RETURNS SETOF BIGINT AS $$
DECLARE
i text;
	rec record;
BEGIN
FOR i IN (
	SELECT 'SELECT SETVAL(' ||
	       quote_literal(quote_ident(PGT.schemaname) || '.' || quote_ident(S.relname)) ||
	       ', COALESCE(MAX(' ||quote_ident(C.attname)|| '), 1) ) FROM ' ||
	       quote_ident(PGT.schemaname)|| '.'||quote_ident(T.relname)|| ';'
	FROM pg_class AS S,
	     pg_depend AS D,
	     pg_class AS T,
	     pg_attribute AS C,
	     pg_tables AS PGT
	WHERE S.relkind = 'S'
	    AND S.oid = D.objid
	    AND D.refobjid = T.oid
	    AND D.refobjid = C.attrelid
	    AND D.refobjsubid = C.attnum
	    AND T.relname = PGT.tablename
	ORDER BY S.relname) loop

	RETURN query
	EXECUTE i;
END loop;
END;
$$ LANGUAGE plpgsql;
