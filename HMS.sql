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
    job VARCHAR(50) NOT NULL,
    salary VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    aadhar VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    department VARCHAR(50),
    PRIMARY KEY (aadhar)
);

-- Department Table
CREATE TABLE department (
    department_name VARCHAR(50) NOT NULL,
    budget VARCHAR(50) NOT NULL,
    PRIMARY KEY (department_name)
);

-- Insert Initial Data (Login Table)
INSERT INTO login (username, password) 
VALUES ('admin', 'root');

-- Insert Sample Data (Optional)

-- Customer Table
INSERT INTO customer (id_type, id_number, name, gender, country, room, status, deposit) 
VALUES 
    ('Aadhar Card', '123456789012', 'John Doe', 'Male', 'USA', '101', 'Checked In', '1000'),
    ('Passport', 'AB1234567', 'Jane Smith', 'Female', 'UK', '202', 'Checked In', '1500');

-- Room Table
INSERT INTO room (room_number, availability, status, price, bed_type) 
VALUES 
    ('101', 'Occupied', 'Clean', '500', 'Double'),
    ('202', 'Occupied', 'Clean', '600', 'Single'),
    ('303', 'Available', 'Clean', '450', 'Double');

-- Driver Table
INSERT INTO driver (name, age, gender, car_company, car_model, availability, location) 
VALUES 
    ('Peter Jones', '45', 'Male', 'Toyota', 'Camry', 'Available', 'City Center'),
    ('Mary Brown', '38', 'Female', 'Honda', 'Civic', 'Busy', 'Airport');

-- Employee Table
INSERT INTO employee (name, age, gender, job, salary, phone, aadhar, email, department) 
VALUES 
    ('Alice Johnson', '28', 'Female', 'Front Desk Clerks', '25000', '9876543210', '111122223333', 'alice.johnson@example.com', 'Reception'),
    ('Bob Williams', '35', 'Male', 'Manager', '40000', '1234567890', '444455556666', 'bob.williams@example.com', 'Management');

-- Department Table
INSERT INTO department (department_name, budget) 
VALUES 
    ('Reception', '50000'),
    ('Housekeeping', '40000'),
    ('Management', '75000');