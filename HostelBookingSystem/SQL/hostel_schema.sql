-- Run this against your MySQL server before using the app.
CREATE DATABASE IF NOT EXISTS HostelBookingSystem;
USE HostelBookingSystem;

CREATE TABLE IF NOT EXISTS User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    phone VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    name VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Room (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_number VARCHAR(10),
    room_type VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS RoomAllocation (
    allocation_id INT AUTO_INCREMENT PRIMARY KEY,
    room_id INT,
    duration_months INT,
    beds_available INT,
    FOREIGN KEY (room_id) REFERENCES Room(room_id)
);

CREATE TABLE IF NOT EXISTS Booking (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    allocation_id INT,
    beds_booked INT,
    FOREIGN KEY (allocation_id) REFERENCES RoomAllocation(allocation_id)
);

CREATE TABLE IF NOT EXISTS Fee (
    fee_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT,
    amount DOUBLE,
    fee_type VARCHAR(20),
    FOREIGN KEY (booking_id) REFERENCES Booking(booking_id)
);

CREATE TABLE IF NOT EXISTS Complaint (
    complaint_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    description VARCHAR(255)
);
