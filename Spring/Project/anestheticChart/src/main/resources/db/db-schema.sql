CREATE TABLE PATIENTS_DETAILS(
    id INT PRIMARY KEY AUTO_INCREMENT,
    uuid UUID not null,
    name VARCHAR(20) not null,
    surname VARCHAR(20) not null ,
    hospital_number VARCHAR(20) not null ,
    dob VARCHAR(20) not null ,
    operation VARCHAR(20) not null
);