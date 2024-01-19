create table user_status
(
    id   bigserial
        constraint status_pk
            primary key,
    name varchar(30) not null
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
            references user_status,
    password          varchar(200)                        not null
);

create table user_roles
(
    id   bigserial
        constraint roles_pk
            primary key,
    name varchar(50)
);

create table user_belong_roles
(
    user_id bigint
        constraint user_belong_roles_users_id_fk
            references users,
    role_id bigint
        constraint user_belong_roles_user_roles_id_fk
            references user_roles
);

create table game_status
(
    id   bigserial
        constraint games_status_pk
            primary key,
    name varchar(50)
);

create table games
(
    id             bigserial
        constraint games_pk
            primary key,
    game_status_id bigint not null
        constraint games_games_status_id_fk
            references game_status
);

