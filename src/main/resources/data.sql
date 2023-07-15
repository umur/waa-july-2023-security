INSERT INTO `address` (`id`, `city`, `street`, `zip`) VALUES (NULL, 'Fairfield', 'Main St', '52557'), (NULL, 'New york', '4th St', '11101');
INSERT INTO `category` (`id`, `name`) VALUES (NULL, 'Food'), (NULL, 'Cloths');
INSERT INTO `product` (`category_id`, `price`, `rating`, `id`, `name`) VALUES ('2', '100', '3', NULL, 'Jacket'), ('1', '3', '5', NULL, 'Apple');
INSERT INTO `user` (`address_id`, `id`, `email`, `first_name`, `last_name`, `password`) VALUES ('1', NULL, 'ts.battushig@yahoo.com', 'Battushig', 'Tsogtbaatar', '$2a$10$dgc7cclth4CKxyG.Mggk0uREujsVUrkSKHmDfWke/lBylzSVGHOvC'), ('2', NULL, 'tso.battushig@gmail.com', 'Tsogt', 'Baatar', '$2a$10$B1G/HPROvv0h6Q935JOgkuT7skAYvsJdBxGkmgvGdBbB8vb6rbr7K');
INSERT INTO `review` (`id`, `product_id`, `user_id`, `text`) VALUES (NULL, '2', '1', 'It\'s good'), (NULL, '1', '2', 'It\'s bad');
INSERT INTO `role` (`id`, `name`) VALUES (NULL, 'USER'), (NULL, 'ADMIN');
INSERT INTO `user_roles` (`roles_id`, `user_id`) VALUES ('2', '2'), ('2', '1'), ('2', '2');