INSERT INTO receptionist (NAME, PASSWORD, EMAIL, PHONE_NO) VALUES 
('Teja', 'teju@123', 'teju@gmail.com', '9087654289'),
('Vimal Raj', 'vimal1', 'vimal@gmail.com', '8908890201');



INSERT INTO customer (F_NAME, L_NAME, EMAIL, PHONE_NO, ADDRESS, PASSWORD) VALUES 
('Gowtham', 'G', 'gurtham@gmail.com', '9080238190', 'Salem', '123456'),
('Surrendra', 'T', 'suru@gmail.com', '9080200198', 'Bangalore', 'Suru@123');


INSERT INTO housekeeper (NAME, KEEPER_ID, EMAIL, PHONE_NO, PASSWORD, LAST_CLEA, NEXT_CLEA) VALUES 
('Rangaraj', 22, 'rangu@gmail.com', '9080290890', 'Rangu@123', TO_DATE('25-MAY-24', 'DD-MON-YY'), TO_DATE('30-MAY-24', 'DD-MON-YY')),
('Worker1', 23, 'worker1@gmail.com', '8878909873', 'Worker@123', TO_DATE('03-JUN-24', 'DD-MON-YY'), TO_DATE('03-JUN-24', 'DD-MON-YY'));


INSERT INTO booking (BOOKING_ID, CUSTOMER_ID, ROOM_NO, CHECKIN, CHECKOUT, BOOKING_STATUS) VALUES 
(146, 26, 4, TO_DATE('16-MAY-24', 'DD-MON-YY'), TO_DATE('18-MAY-24', 'DD-MON-YY'), 'Booked'),
(151, 29, 7, TO_DATE('18-MAY-24', 'DD-MON-YY'), TO_DATE('19-MAY-24', 'DD-MON-YY'), 'Vacated'),
(182, 63, 1, TO_DATE('03-JUN-24', 'DD-MON-YY'), TO_DATE('04-JUN-24', 'DD-MON-YY'), 'Occupied'),
(130, 27, 3, TO_DATE('04-MAR-24', 'DD-MON-YY'), TO_DATE('05-MAR-24', 'DD-MON-YY'), 'Canceled');


INSERT INTO payment (PAYMENT_ID, BOOKING_ID, PAYMENT_AMT, PAYMENT_D, PAYMENT_METHOD, PAYMENT_STATUS) VALUES 
(161, 146, 2000, TO_DATE('17-JUL-24', 'DD-MON-YY'), 'UPI', 'Paid'),
(130, 155, 1500, TO_DATE('22-MAY-24', 'DD-MON-YY'), 'UPI', 'Paid');




INSERT INTO room (ROOM_NO, TYPE_ID, ROOM_STATUS, ROOM_CONDITION, HOUSEKEEPING_REQUEST) VALUES 
(3, 1, 'AVAILABLE', 'CLEAN', NULL),
(8, 2, 'AVAILABLE', 'CLEAN', NULL),
(11, 3, 'AVAILABLE', 'Clean', NULL),
(13, 3, 'AVAILABLE', 'CLEAN', NULL),
(1, 1, 'Occupied', 'Clean', NULL),
(6, 2, 'AVAILABLE', 'CLEAN', NULL),
(4, 1, 'AVAILABLE', 'CLEAN', NULL),
(9, 2, 'Occupied', 'Clean', NULL),
(2, 1, 'Booked', 'CLEAN', NULL),
(7, 2, 'AVAILABLE', 'CLEAN', NULL),
(12, 3, 'Booked', 'Scheduled', 'Cleaning assigned to keeper ID: 12'),
(14, 3, 'Scheduled', 'Clean', NULL),
(5, 1, 'AVAILABLE', 'CLEAN', NULL),
(10, 2, 'AVAILABLE', 'Clean', NULL);



INSERT INTO roomtype (TYPE_ID, TYPE_NAME, ROOM_CAPACITY, AMENITIES, PRICEPERNIGHT) VALUES 
(1, 'Standard', 3, 'Media and Technology(Tv and Free wifi), Laundry Service, Elevator/Lift', 500),
(2, 'Luxury', 5, 'Beauty and spa, AC, Bar, General Services-(wakeup-call, Doctor on call)', 3000),
(3, 'Family Room', 8, 'Free Breakfast, lunch and dinner, TV, Room Service', 2000);

