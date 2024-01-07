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



INSERT INTO status (id, name, description) VALUES (1, 'OK', 'User is ok');
INSERT INTO status (id, name, description) VALUES (2, 'BANNED', 'The user is banned');
INSERT INTO status (id, name, description) VALUES (3, 'SUSPENDED', 'The user is suspended');

INSERT INTO status_reason (id, name, description, status_id) VALUES (1, 'CHEATING', 'The player was banned for cheating', 2);
INSERT INTO status_reason (id, name, description, status_id) VALUES (3, 'ABUSE', 'The player was banned for abusing a system', 2);
INSERT INTO status_reason (id, name, description, status_id) VALUES (2, 'SCAM', 'The player was banned for scamming other players', 2);
INSERT INTO status_reason (id, name, description, status_id) VALUES (4, 'STRANGE_ACTIVITY', 'The player account was suspended for a strange activity', 3);
INSERT INTO status_reason (id, name, description, status_id) VALUES (5, 'ALL_OK', 'The player is playing according the rules of platform', 1);

