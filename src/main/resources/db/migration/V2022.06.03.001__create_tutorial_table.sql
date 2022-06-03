create table tutorial
(
    id        serial
        constraint tutorial_pk
            primary key,
    title     varchar not null,
    description  varchar,
    published boolean
);
