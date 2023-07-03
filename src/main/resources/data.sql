
INSERT INTO `category` (`id`, `name`) VALUES (1,'Monitors'),(2,'Laptops'),(3,'Phones');

INSERT INTO `product` (`price`, `rating`, `category_id`, `id`, `name`) VALUES (119.99,4.3,1,1,'Dell monitor'),(213.16,4.7,1,2,'Samsung monitor'),(1999.99,4.2,2,3,'Alienware'),(3499.99,4.8,2,4,'MacBook Pro'),(1299.99,4.3,3,5,'Samsung Galaxy 23'),(1199.99,4.4,3,6,'iPhone 14 pro');

INSERT INTO `address` (`id`, `city`, `street`, `zip`)
VALUES (1,'Fairfield','1000 north 4th street','52557'),
       (2,'Destin','76 Coala','35532'),
       (3,'Destin','76 Coala','35532');

INSERT INTO `user` (`address_id`, `id`, `email`, `first_name`, `last_name`, `password`)
VALUES (1,1,'adam@miu.edu','Adam','Pavlov', '$2a$10$oZpW1LsE9i.HoyWvUhjy/.xrNx/oPJmc8PefV9UGMjzrPVsN7JKdu'), /* password */
       (2,2,'anna@miu.edu','Anna','Pavlova','$2a$10$oZpW1LsE9i.HoyWvUhjy/.xrNx/oPJmc8PefV9UGMjzrPVsN7JKdu'),
       (3,3,'admin@miu.edu','Admin','Admin','$2a$10$oZpW1LsE9i.HoyWvUhjy/.xrNx/oPJmc8PefV9UGMjzrPVsN7JKdu');

INSERT INTO `role` (`id`, `role`)
VALUES (1,'ADMIN'), (2,'CLIENT');

INSERT INTO user_roles (user_id, roles_id)
VALUES (1, 2);
INSERT INTO user_roles (user_id, roles_id)
VALUES (2, 2);
INSERT INTO user_roles (user_id, roles_id)
VALUES (3, 1);



INSERT INTO `review` (`id`, `product_id`, `comment`)
VALUES (1,1,'Really cool product, I do recommend it'),(2,6,'I love this phone');