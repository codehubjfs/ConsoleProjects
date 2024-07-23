-- Drop tables with CASCADE CONSTRAINT

-- Drop PAYMENT table
DROP TABLE PAYMENT CASCADE CONSTRAINTS;

-- Drop book_event table
DROP TABLE book_event CASCADE CONSTRAINTS;

-- Drop booking table
DROP TABLE booking CASCADE CONSTRAINTS;

-- Drop event table
DROP TABLE event CASCADE CONSTRAINTS;

-- Drop Hall_Seating table
DROP TABLE Hall_Seating CASCADE CONSTRAINTS;

DROP TABLE amenties_hall CASCADE CONSTRAINTS;

DROP TABLE amenities CASCADE CONSTRAINTS;

-- Drop Seating_Arrangement table
DROP TABLE Seating_Arrangement CASCADE CONSTRAINTS;

-- Drop halls table
DROP TABLE halls CASCADE CONSTRAINTS;

-- Drop users table
DROP TABLE users CASCADE CONSTRAINTS;

-- Create the users table
CREATE TABLE users (
    user_id NUMBER PRIMARY KEY,
    name VARCHAR2(20),
    gender VARCHAR2(20),
    email_id VARCHAR2(30) UNIQUE,
    phone_number VARCHAR2(10),
    address VARCHAR2(1000),
    account_type VARCHAR2(20),
    account_status VARCHAR2(10),
    username VARCHAR2(20) UNIQUE,
    password VARCHAR2(20)
);

-- Create the halls table
CREATE TABLE halls (
    hall_id NUMBER PRIMARY KEY,
    hall_name VARCHAR2(30),
    hall_price NUMBER(10,2),
    is_Ac VARCHAR2(10),
    hallAvail VARCHAR2(1),
    hallCapacity NUMBER(7),
    Location varchar2(252),
    hall_link VARCHAR2(1000)
);

-- Create the amenties table
CREATE TABLE amenities(
    amenity_id NUMBER PRIMARY KEY,
    amenity_name VARCHAR2(30)
);

-- Create the amenties of hall table
CREATE TABLE amenties_hall(
    hall_id NUMBER,
    amenity_id NUMBER,
    FOREIGN KEY (hall_id) REFERENCES halls(hall_id),
    FOREIGN KEY (amenity_id) REFERENCES amenities(amenity_id)
);

-- Create the Seating_Arrangement table
CREATE TABLE Seating_Arrangement (
    arrangement_id NUMBER PRIMARY KEY,
    arrangement_type VARCHAR2(40)
);

-- Create the Hall_Seating table
CREATE TABLE Hall_Seating (
    hall_id NUMBER,
    arrangement_id NUMBER,
    capacity NUMBER,
    FOREIGN KEY (hall_id) REFERENCES halls(hall_id),
    FOREIGN KEY (arrangement_id) REFERENCES Seating_Arrangement(arrangement_id)
);

-- Create the event table
CREATE TABLE event (
    event_id NUMBER PRIMARY KEY,
    event_name VARCHAR2(20)
);

-- Create the booking table
CREATE TABLE booking (
    book_id NUMBER PRIMARY KEY,
    user_id NUMBER,
    hall_id NUMBER,
    event_id NUMBER,
    arrangement_id NUMBER,
    requested_time TIMESTAMP,
    start_date DATE,
    end_date DATE,
    book_status VARCHAR2(50),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (hall_id) REFERENCES halls(hall_id),
    FOREIGN KEY (event_id) REFERENCES event(event_id)
);

-- Create the book_event table
CREATE TABLE book_event (
    hall_id NUMBER,
    event_id NUMBER,
    FOREIGN KEY (event_id) REFERENCES event(event_id),
    FOREIGN KEY (hall_id) REFERENCES halls(hall_id)
);

-- Create the PAYMENT table
CREATE TABLE PAYMENT (
    payment_id NUMBER,
    book_id NUMBER,
    payment_time TimeStamp,
    paid_status VARCHAR2(20),
    price NUMBER(17,2),
    FOREIGN KEY (book_id) REFERENCES booking(book_id)
);

