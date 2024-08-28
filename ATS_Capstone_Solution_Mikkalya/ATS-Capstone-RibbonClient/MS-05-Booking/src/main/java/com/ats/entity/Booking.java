package com.ats.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import jakarta.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="booking")
public class Booking {
    @Id
    private String id;
    @Column(name = "Passenger_Name",nullable = false)
    private String passengerName;
    @Column(name = "Booking_Date",nullable = false)
    private LocalDate bookingDate;
    @Column(name = "Seat_Number",nullable = false)
    private int seatNumber;
    @Column(name = "Ticket_Cost",nullable = false)
    private int ticketCost;
    @Column(name = "Total_Amount",nullable = false)
    private int totalAmount;
    @Column(name = "Departure_Date",nullable = false)
    private String departureDate;
    @Column(name = "Departure_Time",nullable = false)
    private String departureTime;
    @Column(name = "Arrival_Date",nullable = false)
    private String arrivalDate;
    @Column(name = "ArrivalTime",nullable = false)
    private String arrivalTime;
    public Booking(){

    }
}
