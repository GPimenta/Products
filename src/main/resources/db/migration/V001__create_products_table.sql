CREATE TABLE IF NOT EXISTS products (
    id IDENTITY NOT NULL PRIMARY KEY,
    product_id VARCHAR(200) NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    inventory INTEGER NOT NULL,
    available BOOLEAN NOT NULL,
    brand VARCHAR(50) NOT NULL
);

--INSERT INTO products (product_id, name, price, inventory, available, brand)
--INSERT INTO products (product_id,name,price,inventory,available,brand)
--VALUES ('aabb-1122', 'dummy_name_1', 10.01, 20, TRUE, 'dummy_brand_1');


