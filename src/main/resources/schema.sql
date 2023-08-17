create table employee
(
    id         serial
        primary key,
    name       varchar(15),
    surname    varchar(25),
    department varchar(20),
    salary     integer
);
