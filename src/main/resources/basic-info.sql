DROP TABLE family-basic-info;

CREATE TABLE basic-info (
    id BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(55) NOT NULL DEFAULT '',
    last_name VARCHAR(255) NOT NULL DEFAULT '',
    date_uploaded DATE NOT NULL,
    description TEXT,
    PRIMARY KEY (id));

DROP SEQUENCE hibernate_sequence;

CREATE SEQUENCE hibernate_sequence;