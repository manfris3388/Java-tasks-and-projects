INSERT INTO charts(uuid, name, surname, hospital_number, dob, operation)
VALUES ('47ab05ac-db6e-11ec-9d64-0242ac120001', 'Jonas', 'Jonaitis', 'D123456', '1972-05-27', 'Appendectomy'),
       ('47ab0796-db6e-11ec-9d64-0242ac120002', 'Petras', 'Petraitis', 'D654321', '1984-04-11', 'Tonsillectomy'),
       ('47ab0796-db6e-11ec-9d64-0242ac120003', 'Aloyzas', 'Kaminskas', 'D577972', '2014-04-98', 'Tooth Extraction'),
       ('47ab0796-db6e-11ec-9d64-0242ac120004', 'Elzyte', 'Petraityte', 'D369545', '1974-08-19', 'TAH'),
       ('47ab0796-db6e-11ec-9d64-0242ac120005', 'Onute', 'Anusauskiene', 'D985632', '1964-11-11', 'THR'),
       ('47ab0796-db6e-11ec-9d64-0242ac120006', 'Aldute', 'Dzekeviciene', 'D748523', '1942-12-18', 'Laparotomy'),
       ('47ab0796-db6e-11ec-9d64-0242ac120007', 'Evelina', 'Armonaite', 'D375913', '2005-01-04', 'Tonsillectomy'),
       ('47ab0796-db6e-11ec-9d64-0242ac120008', 'Giedrius', 'Puidokas', 'D986431', '1979-10-25', 'TURP'),
       ('47ab0796-db6e-11ec-9d64-0242ac120009', 'Kentauras', 'Karvelis', 'D597614', '1975-02-05', 'Tibia ORIF');

insert into vitals(chart_id, sats, rr, hr, sbp, dbp, other_vitals)
values (1,100, 11, 78, 140, 90, 'GCS15'),
       (2,99, 12, 94, 128, 75, 'GCS15'),
       (3,100, 13, 78, 140, 90, 'GCS15'),
       (4,99, 14, 94, 128, 75, 'GCS15'),
       (5,100, 15, 78, 140, 90, 'GCS15'),
       (6,99, 16, 94, 128, 75, 'GCS15'),
       (7,100, 17, 78, 140, 90, 'GCS15'),
       (8,99, 18, 94, 128, 75, 'GCS15'),
       (9,99, 19, 94, 128, 75, 'GCS15');

insert into lab_res(chart_id, na, k, urea, cr, other_lab_res)
values (1,145, 4.5, 9.0, 90, 'clotting normal'),
       (2,130, 4.3, 9.8, 101, 'clotting normal'),
       (3,125, 3.2, 14.0, 225, 'clotting normal'),
       (4,130, 4.3, 9.8, 101, 'clotting normal'),
       (5,125, 3.2, 14.0, 225, 'clotting normal'),
       (6,130, 4.3, 9.8, 101, 'clotting normal'),
       (7,125, 3.2, 14.0, 225, 'clotting normal'),
       (8,130, 4.3, 9.8, 101, 'clotting normal'),
       (9,125, 3.2, 14.0, 225, 'clotting normal');

insert into assesment(chart_id, pmh, dh, airway_assesment, anesthetic_assesment)
values (1,'COPD', 'Salbutamol', 'Mallampati 3', 'ASA 3'),
       (2,'AAA', 'Labetalol', 'Mallampati 2, edentulous', 'ASA 3'),
       (3,'HTN', 'Amlodipine', 'Mallampati 2, Teeth Healthy', 'ASA 3'),
       (4,'AAA', 'Labetalol', 'Mallampati 2, edentulous', 'ASA 3'),
       (5,'HTN', 'Amlodipine', 'Mallampati 2, Teeth Healthy', 'ASA 3'),
       (6,'AAA', 'Labetalol', 'Mallampati 2, edentulous', 'ASA 3'),
       (7,'HTN', 'Amlodipine', 'Mallampati 2, Teeth Healthy', 'ASA 3'),
       (8,'AAA', 'Labetalol', 'Mallampati 2, edentulous', 'ASA 3'),
       (9,'HTN', 'Amlodipine', 'Mallampati 2, Teeth Healthy', 'ASA 3');

insert into imaging(chart_id, ecg, other_img)
values (1,'SR74, no ischemic changes', 'none'),
       (2,'SR74, no ischemic changes', 'none'),
       (3,'SR74, no ischemic changes', 'none'),
       (4,'SR74, no ischemic changes', 'none'),
       (5,'SR74, no ischemic changes', 'none'),
       (6,'SR74, no ischemic changes', 'none'),
       (7,'SR74, no ischemic changes', 'none'),
       (8,'SR74, no ischemic changes', 'none'),
       (9,'SR74, no ischemic changes', 'none');

insert into plans(chart_id,anesthetic_plan, anesthetic_workup)
values (1,'GA', 'None'),
       (2,'RA', 'needs ECHO'),
       (3,'LA', 'None'),
       (4,'RA', 'needs ECHO'),
       (5,'LA', 'None'),
       (6,'RA', 'needs ECHO'),
       (7,'LA', 'None'),
       (8,'RA', 'needs ECHO'),
       (9,'LA', 'None');

insert into users( name, surname, email, password, repeated_password, zip_code, phone_number)
values ( 'Admin', 'Jonaitis', 'admin@j.lt', '{bcrypt}$2a$08$2xZNrqMS04hMaGEBBaKQT.cgEpaUCgi6fREC2JaBITX/9vJLPcTqW', '$2a$08$2xZNrqMS04hMaGEBBaKQT.cgEpaUCgi6fREC2JaBITX/9vJLPcTqW', 'LL572WE', '+37064725423'),--pass admin
       ( 'User', 'Jonaitis', 'user@j.lt', '{bcrypt}$2a$08$on.qwvCiIYfNVX1KqyBVDu7G8Z3JjK6knmW3SnipkCfi1KqWBZF9.', '$2a$08$on.qwvCiIYfNVX1KqyBVDu7G8Z3JjK6knmW3SnipkCfi1KqWBZF9.', 'LL572WE', '+37064725423'); --pass user
INSERT INTO authority(name)
VALUES
    ('ADMIN'),
    ('USER');

INSERT INTO users_authorities(user_id, authorities_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2);