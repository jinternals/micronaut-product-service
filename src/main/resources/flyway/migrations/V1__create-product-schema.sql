create table products
(
    id int not null primary key,
    name varchar(255) not null,
    description varchar(255),
    constraint id unique (id),
);

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;
