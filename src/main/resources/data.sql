-- Insert data into the 'category' table
INSERT INTO category (name)
VALUES
    ('Electronics'),
    ('Clothing'),
    ('Home & Kitchen'),
    ('Books'),
    ('Sports');

-- Insert data into the 'product' table
INSERT INTO product (name, price, rating, category_id)
VALUES
    ('iPhone 12', 999.99, 4, 1),
    ('T-shirt', 19.99, 5, 2),
    ('Coffee Maker', 49.99, 4, 3),
    ('Harry Potter and the Sorcerer\'s Stone', 12.99, 5, 4),
    ('Soccer Ball', 24.99, 4, 5);

-- Insert data into the 'user' table
INSERT INTO user (email, first_name, last_name, password, role)
VALUES
    ('john.doe@example.com', 'John', 'Doe', 'password123', 'ADMIN'),
    ('jane.smith@example.com', 'Jane', 'Smith', 'pass321', 'ADMIN'),
    ('mike.wilson@example.com', 'Mike', 'Wilson', 'securepwd', 'ADMIN'),
    ('amy.jones@example.com', 'Amy', 'Jones', 'password456', 'ADMIN'),
    ('mark.johnson@example.com', 'Mark', 'Johnson', 'pwd789', 'ADMIN');

-- Insert data into the 'address' table
INSERT INTO address (city, street, zip, user_id)
VALUES
    ('New York', '123 Main St', '10001', 1),
    ('Los Angeles', '456 Elm St', '90001', 2),
    ('Chicago', '789 Oak St', '60601', 3),
    ('Houston', '321 Pine St', '77001', 4),
    ('Miami', '654 Maple St', '33101', 5);

-- Insert data into the 'review' table
INSERT INTO review (comment, product_id, user_id)
VALUES
    ('Great phone!', 1, 1),
    ('Comfortable and stylish.', 2, 2),
    ('Makes delicious coffee.', 3, 3),
    ('A fantastic read!', 4, 4),
    ('Excellent quality.', 5, 5);
