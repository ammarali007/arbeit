create table if not exists email
(
    id
    serial
    PRIMARY
    KEY,
    send_to
    VARCHAR
(
    30
),
    subject VARCHAR
(
    30
),
    message VARCHAR
(
    50
),
    code INT
    );