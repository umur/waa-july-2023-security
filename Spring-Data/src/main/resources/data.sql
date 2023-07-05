-- Insert dummy data for Address table
INSERT INTO address (id,street, zip, city) VALUES (NULL,'123 Main St', 12345, 'City1'),
       (NULL,'456 Elm St', 67890, 'City2'),
       (NULL,'789 Oak St', 54321, 'City3');
-- Insert dummy data for Category table
INSERT INTO Category (id,name) VALUES (NULL,'Category1'),
       (NULL,'Category2'),
       (NULL,'Category3');
INSERT INTO User (id,email, first_Name, last_Name, password, address_id) VALUES (NULL,'user1@example.com', 'John', 'Doe', '$2a$12$fzuUlf5Di.eFG01VsL0WI.j4vLDjL.DPpK952/U8HquzTEooUJ5n.', 1),
                                                                                (NULL,'user2@example.com', 'Jane', 'Smith', '$2a$12$fzuUlf5Di.eFG01VsL0WI.j4vLDjL.DPpK952/U8HquzTEooUJ5n.', 2);
INSERT INTO role (id, role)VALUES (1, 'ADMIN'), (2, 'USER');

INSERT INTO user_roles (user_id, roles_id)
VALUES (1, 1), (2, 2);
-- Insert dummy data for Product table
INSERT INTO Product (id,name, price, rating, category_id,user_id) VALUES (NULL,'Product1', 10.99, 4, 1,1),
       (NULL,'Product2', 19.99, 3, 2,1),
       (NULL,'Product3', 9.99, 5, 3,2);


-- Insert dummy data for User table

# INSERT INTO user_roles (user_id, roles) VALUES (1, 'ADMIN'); -- Jane Smith has USER role
# INSERT INTO user_roles (user_id, roles) VALUES (2, 'USER'); -- Jane Smith has USER role
-- Insert dummy data for Review table
INSERT INTO Review (id,comment, product_id, user_id) VALUES (NULL,'Review1', 1, 1),
                                                            (NULL,'Review2', 2, 1),
                                                            (NULL,'Review3', 3, 2);
