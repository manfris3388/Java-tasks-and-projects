INSERT INTO charts(id, uuid, name, surname, hospital_number, dob, operation)
VALUES
(1,'47ab05ac-db6e-11ec-9d64-0242ac120002', 'Jonas', 'Jonaitis', 'D123456', '1972-05-27', 'Appendectomy'),
(2,'47ab0796-db6e-11ec-9d64-0242ac120002', 'Petras', 'Petraitis', 'D654321', '1984-04-11', 'Tonsillectomy'),
(3,'47ab0796-db6e-11ec-9d64-0242ac120003', 'Aloyzas', 'Kaminskas', 'D577972', '2014-04-98', 'Tooth Extraction'),
(4,'47ab0796-db6e-11ec-9d64-0242ac120004', 'Elzyte', 'Petraityte', 'D369545', '1974-08-19', 'TAH'),
(5,'47ab0796-db6e-11ec-9d64-0242ac120005', 'Onute', 'Anusauskiene', 'D985632', '1964-11-11', 'THR'),
(6,'47ab0796-db6e-11ec-9d64-0242ac120006', 'Aldute', 'Dzekeviciene', 'D748523', '1942-12-18', 'Laparotomy'),
(7,'47ab0796-db6e-11ec-9d64-0242ac120007', 'Evelina', 'Armonaite', 'D375913', '2005-01-04', 'Tonsillectomy'),
(8,'47ab0796-db6e-11ec-9d64-0242ac120008', 'Giedrius', 'Puidokas', 'D986431', '1979-10-25', 'TURP'),
(9,'47ab0796-db6e-11ec-9d64-0242ac120009', 'Kentauras', 'Karvelis', 'D597614', '1975-02-05', 'Tibia ORIF');

insert into vitals(sats, rr, hr, sbp, dbp, other_vitals)
values
(100,11,78,140,90,'GCS15'),
(99,12,94,128,75,'GCS15'),
(100,13,78,140,90,'GCS15'),
(99,14,94,128,75,'GCS15'),
(100,15,78,140,90,'GCS15'),
(99,16,94,128,75,'GCS15'),
(100,17,78,140,90,'GCS15'),
(99,18,94,128,75,'GCS15'),
(99,19,94,128,75,'GCS15');