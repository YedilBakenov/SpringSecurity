CREATE TABLE permission(
    id SERIAL PRIMARY KEY,
    role varchar(255)
);

CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    email varchar(255),
    fullname varchar(255),
    password varchar(255)
);

CREATE TABLE users_permissions(
    user_id int,
    permissions_id int
);

CREATE TABLE items(
    id SERIAL PRIMARY KEY,
    created_at timestamp(6),
    updated_at timestamp(6),
    description text,
    mark varchar(255),
    name varchar(255),
    point int,
    price int
);

ALTER TABLE users_permissions
    ADD CONSTRAINT fk_users_permissions_users
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON UPDATE CASCADE;

ALTER TABLE users_permissions
    ADD CONSTRAINT fk_users_permissions_permission
        FOREIGN KEY (permissions_id)
            REFERENCES permission (id)
            ON DELETE CASCADE;

