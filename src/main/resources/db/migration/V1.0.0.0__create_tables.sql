create sequence person_id_seq;
-- CREATE SEQUENCE serial cycle;
create sequence address_id_seq;
--
-- CREATE SEQUENCE DOGINFO_SEQ MINVALUE 1 MAXVALUE 9999999999 START WITH 1 INCREMENT BY 1 CACHE 20;
--
-- CREATE SEQUENCE customers_seq
--     START WITH     1000
--     INCREMENT BY   1
--     NO CYCLE;

create table t_persons
(
    id            bigint
        constraint t_persons_pkey primary key not null,
    first_name    varchar(100),
    last_name     varchar(100),
    phone_number  varchar(10),
    date_of_birth date,
    department_id bigint,
    constraint t_persons_pkey unique (id)
);

create table t_addresses
(
    id        bigint
        constraint t_addresses_pkey primary key not null,
    street    varchar(100),
    city      varchar(100),
    country   varchar(100),
    person_id bigint,
    constraint t_addresses_pkey unique (id),
    constraint fk_person_id foreign key (person_id) references t_persons
);