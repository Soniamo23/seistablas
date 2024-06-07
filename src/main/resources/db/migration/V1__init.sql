CREATE TABLE IF NOT EXISTS country (
    id SERIAL,
    code VARCHAR(10) NOT NULL,
    country_name VARCHAR(100) NOT NULL,
    continent_name VARCHAR(100),
    PRIMARY KEY (id),
    UNIQUE (code)
);

CREATE TABLE IF NOT EXISTS "user" (
    id SERIAL,
    fullname VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
    date_of_birth DATE,
    created_at TIMESTAMP,
    country_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (country_id) REFERENCES country (id),
    UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS merchant (
    id SERIAL,
    merchant_name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP,
    admin_id INT,
    country_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (admin_id) REFERENCES user (id),
    FOREIGN KEY (country_id) REFERENCES country (id)
);

CREATE TABLE IF NOT EXISTS product (
    id SERIAL,
    description VARCHAR(200) NOT NULL,
    price DECIMAL(9,2) DEFAULT 0.00,
    status VARCHAR(50),
    created_at TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (merchant_id) REFERENCES merchant (id)
);

CREATE TABLE IF NOT EXISTS "order" (
    id SERIAL,
    status VARCHAR(50),
    created_at TIMESTAMP,
    user_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES "user" (id)
);

CREATE TABLE IF NOT EXISTS order_item (
    id SERIAL,
    quantity INT NOT NULL,
    order_id INT,
    product_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES order (id),
    FOREIGN KEY (product_id) REFERENCES product (id),
    UNIQUE (order_id, product_id)
);