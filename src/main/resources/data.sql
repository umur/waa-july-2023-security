-- Insert statements for address table
INSERT INTO address (city, street, zip) VALUES
('City1', 'Street1', '12345'),
('City2', 'Street2', '67890');

-- Insert statements for app_role table
INSERT INTO app_role (role_name) VALUES
('Role1'),
('Role2');

-- Insert statements for app_user table
INSERT INTO app_user (email, first_name, last_name, password, username, address_id) VALUES
('user1@example.com', 'John', 'Doe', 'password1', 'user1', 1),
('user2@example.com', 'Jane', 'Smith', 'password2', 'user2', 2);

-- Insert statements for app_user_roles table
INSERT INTO app_user_roles (app_user_id, roles_id) VALUES
(1, 1),
(2, 2);

-- Insert statements for category table
INSERT INTO category (name) VALUES
('Category1'),
('Category2');

-- Insert statements for product table
INSERT INTO product (name, price, rating, category_id) VALUES
('Product1', 10.0, 4.5, 1),
('Product2', 20.0, 3.8, 2);


-- Insert statements for review table
INSERT INTO review (comment, user_id, product_id) VALUES
('Great product!', 1, 1),
('Not satisfied with the quality.', 2, 1),
('Highly recommended!', 1, 2),
('Average product.', 2, 2);
