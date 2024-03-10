INSERT INTO permission(role)
VALUES ('ROLE_USER'),
       ('ROLE_STUDENT'),
       ('ROLE_ADMIN');

INSERT INTO users (email, fullname, password)
VALUES ('xxx@mail.ru', 'Marat Maratov', '$2a$12$3U4bSE9P/HiFArqoERDOdu2H0ZekXAHhJ/ER0dMYGBX4j8FgEVpVO'),
       ('serik@mail.ru', 'Serik Serikov', '$2a$12$clldki9Qxcu9OdBZAhmfm.l2WRJmhY7Pr83SjaGzcdba/DgQPdsz24'),
       ('mikhail.lipkovich@gmail.com', 'Mikhail Mikhailov',
        '$2a$10$CwOPRDtb7DJtikqDkOdjseoJvmI7rdizopK.3Y0FHFtsBlDb2Tbh2'),
       ('yedil.bakenov@gmail.com', 'Yedil Bakenov', '$2a$10$T40bY5V4.1DM2fuD2Q4qu.5rXxCoiQULuVqrFlWcsFHJ9I1FZdsfy');

INSERT INTO items(created_at, updated_at, description, mark, name, point, price)
VALUES ('2024-03-06 00:19:29.973166', '2024-03-06 00:20:21.390785', 'Iphone 8+',
        'BAD', 'Iphone', 1, 100000);

INSERT INTO users_permissions(user_id, permissions_id)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 2),
       (2, 3);
