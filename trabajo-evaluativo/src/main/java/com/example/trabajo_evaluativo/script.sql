CREATE DATABASE IF NOT EXISTS trabajo_evaluativo;
USE trabajo_evaluativo;

CREATE TABLE IF NOT EXISTS product_model (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    price DOUBLE NOT NULL,
    quantity INT NOT NULL,
    category VARCHAR(100) NOT NULL,
    creation_date DATETIME
    );