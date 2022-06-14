Drop table if exists assesment;

Drop table if exists imaging;

Drop table if exists lab_res;

Drop table if exists plans;

Drop table if exists vitals;

Drop table if exists CHARTS;
CREATE TABLE charts(
    id BIGSERIAL PRIMARY KEY,
    uuid UUID not null,
    name VARCHAR(20) not null,
    surname VARCHAR(20) not null ,
    hospital_number VARCHAR(20) not null ,
    dob VARCHAR(20) not null ,
    operation VARCHAR(20) not null
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