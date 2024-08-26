use atsdb;
create table booking(id VARCHAR(6),Passenger_Name VARCHAR(20),Booking_Date DATE,Seat_Number INT,Ticket_Cost INT,Total_Amount INT,Departure_Date VARCHAR(20),Departure_Time VARCHAR(20),Arrival_Date VARCHAR(20),Arrival_Time VARCHAR(20));
select * from booking;
drop table booking;