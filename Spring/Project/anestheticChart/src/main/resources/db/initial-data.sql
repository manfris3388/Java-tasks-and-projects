INSERT INTO anesthetic_charts(uuid, name, surname, hospital_number, dob, operation)
VALUES
('47ab05ac-db6e-11ec-9d64-0242ac120002', 'Jonas', 'Jonaitis', 'D123456', '1972-05-27', 'Appendectomy'),
('47ab0796-db6e-11ec-9d64-0242ac120002', 'Petras', 'Petraitis', 'D654321', '1984-04-11', 'Tonsillectomy'),
('47ab0796-db6e-11ec-9d64-0242ac120003', 'Aloyzas', 'Kaminskas', 'D577972', '2014-04-98', 'Tooth Extraction'),
('47ab0796-db6e-11ec-9d64-0242ac120004', 'Elzyte', 'Petraityte', 'D369545', '1974-08-19', 'TAH'),
('47ab0796-db6e-11ec-9d64-0242ac120005', 'Onute', 'Anusauskiene', 'D985632', '1964-11-11', 'THR'),
('47ab0796-db6e-11ec-9d64-0242ac120006', 'Aldute', 'Dzekeviciene', 'D748523', '1942-12-18', 'Laparotomy'),
('47ab0796-db6e-11ec-9d64-0242ac120007', 'Evelina', 'Armonaite', 'D375913', '2005-01-04', 'Tonsillectomy'),
('47ab0796-db6e-11ec-9d64-0242ac120008', 'Giedrius', 'Puidokas', 'D986431', '1979-10-25', 'TURP'),
('47ab0796-db6e-11ec-9d64-0242ac120009', 'Kentauras', 'Karvelis', 'D597614', '1975-02-05', 'Tibia ORIF');

insert into patient_vitals(sats, rr, hr, sbp, dbp, other_vitals)
values
(100,18,78,140,90,'GCS15'),
(99,14,94,128,75,'GCS15');