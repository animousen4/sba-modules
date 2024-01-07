create table status
(
    id          bigserial
        constraint status_pk
            primary key,
    name        varchar(30)  not null,
    description varchar(300) not null
);

create table status_reason
(
    id          bigserial
        constraint status_reason_pk
            primary key,
    name        varchar(30)  not null,
    description varchar(300) not null,
    status_id   bigint       not null
        constraint status_reason_status_id_fk
            references status
);

create table users
(
    id                bigserial
        constraint users_pk
            primary key,
    username          varchar(50)                         not null,
    registration_date timestamp default CURRENT_TIMESTAMP not null,
    close_date        timestamp,
    email             varchar(200),
    status_id         bigint                              not null
        constraint users_status_id_fk
            references status,
    status_reason_id  bigint
        constraint users_status_reason_id_fk
            references status_reason,
    password          varchar(200)                        not null
);

create table roles
(
    id   bigserial
        constraint roles_pk
            primary key,
    name varchar(50)
);

create table users_roles
(
    user_id bigint not null
        references users,
    role_id bigint not null
        references roles,
    primary key (user_id, role_id)
);

