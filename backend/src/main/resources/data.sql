INSERT IGNORE users (id, email, first_name, last_name, password)
VALUES (1, 'uinan@miu.edu', 'umur', 'inan', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); -- 123
INSERT IGNORE users (id, email, first_name, last_name, password)
VALUES (2, 'john@miu.edu', 'john', 'doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); -- 123
INSERT IGNORE users (id, email, first_name, last_name, password)
VALUES (3, 'dean@miu.edu', 'Dean', 'Altarawneh', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); -- 123

INSERT IGNORE role (id, role)
VALUES (1, 'ADMIN');
INSERT IGNORE role (id, role)
VALUES (2, 'CLIENT');


INSERT IGNORE users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT IGNORE users_roles (user_id, roles_id)
VALUES (2, 1);
INSERT IGNORE users_roles (user_id, roles_id)
VALUES (3, 2);



insert IGNORE category (id,name) values(1, 'Book');
insert IGNORE category (id,name) values(2, 'Pet');
insert IGNORE category (id,name) values(3, 'Video');
insert IGNORE category (id,name) values(4, 'Software');
insert IGNORE category (id,name) values(5, 'Music');
insert IGNORE category (id,name) values(6, 'Fine Art');


INSERT IGNORE  product (id,
                       name,
                       price,
                       rating,
                       category_id,
                       user_id)
 VALUES (1,
 'Clean Architecture: A Craftsman\'s Guide to Software Structure and Design (Robert C. Martin Series) 1st Edition',
30.39,
4.6,
1,
1);
INSERT IGNORE  product (id,
                       name,
                       price,
                       rating,
                       category_id,
                       user_id)
VALUES (2,
                       'Code Complete: A Practical Handbook of Software Construction, Second Edition 2nd Edition',
43.99,
4.5,
1,
1);

INSERT IGNORE address (id,
                      city,
                      zip) VALUES(1,'Fairfield','52676');


INSERT IGNORE review (id,
                     comment,
                     product_id,
                     user_id)
                     VALUES (1,'I like it',1,1);
INSERT IGNORE review (id,
                     comment,
                     product_id,
                     user_id)
                     VALUES (2,'I hate it',2,1);
