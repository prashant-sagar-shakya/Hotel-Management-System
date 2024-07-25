CREATE DATABASE hotel;

USE hotel;

-- Login Table
CREATE TABLE login (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    PRIMARY KEY (username)
);

-- Customer Table
CREATE TABLE customer (
    id_type VARCHAR(50) NOT NULL,
    id_number VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    gender VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    room VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    deposit VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_number)
);

-- Room Table
CREATE TABLE room (
    room_number VARCHAR(50) NOT NULL,
    availability VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    price VARCHAR(50) NOT NULL,
    bed_type VARCHAR(50) NOT NULL,
    PRIMARY KEY (room_number)
);

-- Driver Table
CREATE TABLE driver (
    name VARCHAR(50) NOT NULL,
    age VARCHAR(50) NOT NULL,
    gender VARCHAR(50) NOT NULL,
    car_company VARCHAR(50) NOT NULL,
    car_model VARCHAR(50) NOT NULL,
    availability VARCHAR(50) NOT NULL,
    location VARCHAR(50) NOT NULL,
    PRIMARY KEY (name)
);

-- Employee Table
CREATE TABLE employee (
    name VARCHAR(50) NOT NULL,
    age VARCHAR(50) NOT NULL,
    gender VARCHAR(50) NOT NULL,
    department VARCHAR(50) NOT NULL,
    salary VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    aadhar VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    PRIMARY KEY (aadhar)
);

-- Insert Initial Data (Login Table)
INSERT INTO login (username, password)
VALUES ('admin', 'root');
