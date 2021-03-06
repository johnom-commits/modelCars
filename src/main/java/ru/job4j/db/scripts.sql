create table cars
(
    id        int4 generated by default as identity,
    model     varchar(255) not null,
    engine_id int4,
    primary key (id)
);

create table drivers
(
    id   int4 generated by default as identity,
    name varchar(255) not null,
    primary key (id)
);

create table engines
(
    id     int4 generated by default as identity,
    model  varchar(255) not null,
    power  float8       not null,
    volume float8       not null,
    primary key (id)
);

create table history_owner
(
    car_id    int4 not null,
    driver_id int4 not null,
    primary key (car_id, driver_id)
);

alter table if exists cars
    add constraint ENGINE_ID_FK
        foreign key (engine_id)
            references engines;

alter table if exists history_owner
    add constraint DRIVER_ID_FK
        foreign key (driver_id)
            references drivers;

