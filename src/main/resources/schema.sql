create table address (
        customer_id integer,
        id INT AUTO_INCREMENT PRIMARY KEY,
        city VARCHAR(255) NOT NULL,
        state VARCHAR(255) NOT NULL,
        street VARCHAR(255),
        zipCode VARCHAR(255) NOT NULL
);

CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE sales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customerId INT NOT NULL,
    productName VARCHAR(MAX) NOT NULL,
    saleAmount DECIMAL(10,2),
    saleDate DATE
);

alter table if exists address
     add constraint FK93c3js0e22ll1xlu21nvrhqgg
     foreign key (customer_id)
     references customer;
