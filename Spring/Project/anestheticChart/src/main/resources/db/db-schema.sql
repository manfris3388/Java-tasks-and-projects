CREATE TABLE ANESTHETIC_CHARTS(
    id INT PRIMARY KEY,
    uuid UUID not null,
    name VARCHAR(20) not null,
    surname VARCHAR(20) not null ,
    hospital_number VARCHAR(10) not null ,
    dob VARCHAR(10) not null ,
    operation VARCHAR(20) not null
);