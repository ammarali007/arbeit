create table if not exists customer (
    id int  primary key,
    first_name varchar(30),
    last_name varchar(30),
    dob date,
    phone varchar(30)
);