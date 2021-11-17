DROP TABLE family-basic-info;

CREATE TABLE basic-info (
    id BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(55) NOT NULL DEFAULT '',
    middle_name VARCHAR(55) DEFAULT '',
    last_name VARCHAR(255) NOT NULL DEFAULT '',
    created_date DATE NOT NULL,
    last_updated_date DATE NOT NULL,
    PRIMARY KEY (id));

DROP SEQUENCE hibernate_sequence;

CREATE SEQUENCE hibernate_sequence;