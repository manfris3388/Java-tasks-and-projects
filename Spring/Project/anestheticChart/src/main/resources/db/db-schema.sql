Drop table if exists assesment;

Drop table if exists imaging;

Drop table if exists lab_res;

Drop table if exists plans;

Drop table if exists vitals;

drop table if exists users_authorities;

Drop table if exists users;

Drop table if exists CHARTS;

DROP table if exists authority;

DROP TABLE IF EXISTS file;

CREATE TABLE charts
(
    id              BIGSERIAL PRIMARY KEY,
    uuid            UUID        not null,
    name            VARCHAR(20) not null,
    surname         VARCHAR(20) not null,
    hospital_number VARCHAR(20) not null,
    dob             VARCHAR(20) not null,
    operation       VARCHAR(20) not null
);

create table assesment
(
    chart_id             bigint not null
        primary key
        references charts
            on update cascade on delete cascade,
    airway_assesment     varchar(255),
    anesthetic_assesment varchar(255),
    dh                   varchar(255),
    pmh                  varchar(255)
);

create table imaging
(
    chart_id  bigint not null
        primary key
        references charts
            on update cascade on delete cascade,
    ecg       varchar(255),
    other_img varchar(255)
);

create table lab_res
(
    chart_id      bigint not null
        primary key
        references charts
            on update cascade on delete cascade,
    cr            integer,
    k             double precision,
    na            integer,
    other_lab_res varchar(255),
    urea          double precision
);

create table plans
(
    chart_id          bigint not null
        primary key
        references charts
            on update cascade on delete cascade,
    anesthetic_plan   varchar(255),
    anesthetic_workup varchar(255)
);


create table vitals
(
    chart_id     bigint not null
        primary key
        references charts
            on update cascade on delete cascade,
    dbp          integer,
    hr           integer,
    other_vitals varchar(255),
    rr           integer,
    sats         integer,
    sbp          integer
);

create table users
(
    id bigserial primary key,
    name varchar(20) not null ,
    surname varchar(20) not null,
    email varchar(50) not null,
    password varchar(100) not null,
    zip_code varchar(20) not null,
    phone_number varchar(20) not null,
    CONSTRAINT users_key UNIQUE (email)
);

CREATE TABLE authority
(
    id                BIGSERIAL PRIMARY KEY,
    name              VARCHAR(100)    NOT NULL,
    CONSTRAINT authority_key UNIQUE (name)
);

CREATE TABLE users_authorities
(
    user_id         BIGINT NOT NULL,
    authorities_id  BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (authorities_id) REFERENCES authority(id)
);

CREATE TABLE file
(
    id                BIGSERIAL PRIMARY KEY,
    file_id           UUID           NOT NULL,
    file_name         VARCHAR(100)   NOT NULL,
    file_extension    VARCHAR(15)    NOT NULL,
    media_type        VARCHAR(10)    NOT NULL,
    size              BIGINT         NOT NULL,
    timestamp         TIMESTAMP      DEFAULT current_timestamp
);