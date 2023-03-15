create table if not exists customer (
    id int  primary key,
    first_name varchar(30),
    last_name varchar(30),
    dob date,
    phone varchar(30),
    password varchar(50),
    salt varchar(50),
    created_on TIMESTAMP DEFAULT NOW(),
    modified_on TIMESTAMP DEFAULT NOW()
);