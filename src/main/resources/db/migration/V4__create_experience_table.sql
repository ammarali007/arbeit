create table if not exists experience
(
    id
    int
    primary
    key,
    company_name
    VarChar
(
    50
) not null,
    location VarChar
(
    50
),
    start_date Date,
    end_date Date,
    employee_id int,
    FOREIGN KEY
(
    employee_id
) REFERENCES employee
(
    id
)
    );