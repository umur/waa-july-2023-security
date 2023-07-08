INSERT INTO role (id, name) VALUES (1, 'ADMIN');
INSERT INTO role (id, name) VALUES (2, 'USER');

SELECT SETVAL('role_seq',2);


insert into category (id, name) values (1,'Seats');
insert into category (id, name) values (2,'Desks');
insert into category (id, name) values (3,'Laptops');
insert into category (id, name) values (4,'Smart Phones');
insert into product (id, name, price, rating, category_id) values (1,'Standard Seat',70,4.5,1);
insert into product (id, name, price, rating, category_id) values (2,'Luxury Seat',200,4.9,1);
insert into product (id, name, price, rating, category_id) values (3,'Normal Desk',90,4,2);
insert into product (id, name, price, rating, category_id) values (4,'Standing Desk', 120,4.2,2);
insert into product (id, name, price, rating, category_id) values (5,'Lenevo',700,4,3);
insert into product (id, name, price, rating, category_id) values (6,'MacBook Pro',1500,4.5,3);
--insert into review (id,comment,rating,product_id, user_id) values (1, "very good product", 4.5, 4,1);

SELECT setval('category_seq', 4);
SELECT setval('product_seq', 6);
