create sequence person_id_seq increment by 1 start with 1 cache 20;

create table t_persons(
                          id bigint DEFAULT nextval('person_id_seq') constraint t_persons_pkey primary key,
                          first_name varchar(100),
                          last_name varchar(100),
                          phone_number varchar(10),
                          date_of_birth date,
                          department_id bigint,
                          constraint t_persons_pkey unique (id)
);

create table t_addresses(
                            id bigint primary key not null,
                            street varchar(100),
                            city varchar(100),
                            country varchar(100),
                            person_id bigint,
                            constraint fk_person_id foreign key (person_id) references t_persons
);