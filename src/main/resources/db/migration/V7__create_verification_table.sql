create table if not exists verification
(
    id    serial PRIMARY KEY,
    valid BIT,
    code  INT
);