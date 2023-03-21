create table if not exists job
(
    id
    serial
    Primary
    key,
    main_category
    varchar
(
    30
),
    sub_category varchar
(
    30
),
    description varchar
(
    30
),
    customer_id int
    );