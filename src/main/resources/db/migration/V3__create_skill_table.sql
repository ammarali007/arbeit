create table if not exists skill
(
    id
    serial
    primary
    key,
    name
    varchar
(
    30
),
    rating int,
    experience numeric
(
    5,
    2
),
    employee_id int,
    FOREIGN KEY
(
    employee_id
) REFERENCES employee
(
    id
)
    );

