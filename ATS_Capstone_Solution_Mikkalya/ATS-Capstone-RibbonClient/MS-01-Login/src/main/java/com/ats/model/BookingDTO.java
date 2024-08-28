package com.ats.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingDTO {
    private String id;
    private String passengerName;
    private LocalDate bookingDate;
    private int seatNumber;
    private int ticketCost;
    private int totalAmount;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
}
