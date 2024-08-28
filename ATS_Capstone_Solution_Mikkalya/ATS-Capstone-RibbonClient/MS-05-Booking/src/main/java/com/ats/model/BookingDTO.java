package com.ats.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
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
    private BookingDTO(BookingBuilder bookingBuilder){
        this.id=bookingBuilder.id;
        this.passengerName=bookingBuilder.passengerName;
        this.bookingDate=bookingBuilder.bookingDate;
        this.seatNumber=bookingBuilder.seatNumber;
        this.ticketCost=bookingBuilder.ticketCost;
        this.totalAmount=bookingBuilder.totalAmount;
        this.departureDate=bookingBuilder.departureDate;
        this.departureTime=bookingBuilder.departureTime;
        this.arrivalDate=bookingBuilder.arrivalDate;
        this.arrivalTime=bookingBuilder.arrivalTime;
    }
    public static class BookingBuilder{
        private final String id;
        private final String passengerName;
        private LocalDate bookingDate;
        private int seatNumber;
        private int ticketCost;
        private int totalAmount;
        private String departureDate;
        private String departureTime;
        private String arrivalDate;
        private String arrivalTime;
        public BookingBuilder(String id,String passengerName){
            this.id=id;
            this.passengerName=passengerName;
        }
        public BookingBuilder bookingDate(LocalDate bookingDate){
            this.bookingDate=bookingDate;
            return this;
        }
        public BookingBuilder seatNumber(int seatNumber){
            this.seatNumber=seatNumber;
            return this;
        }
        public BookingBuilder ticketCost(int ticketCost){
            this.ticketCost=ticketCost;
            return this;
        }
        public BookingBuilder totalAmount(int totalAmount){
            this.totalAmount=totalAmount;
            return this;
        }
        public BookingBuilder departureDate(String departureDate){
            this.departureDate=departureDate;
            return this;
        }
        public BookingBuilder departureTime(String departureTime){
            this.departureTime=departureTime;
            return this;
        }
        public BookingBuilder arrivalDate(String arrivalDate){
            this.arrivalDate=arrivalDate;
            return this;
        }
        public BookingBuilder arrivalTime(String arrivalTime){
            this.arrivalTime=arrivalTime;
            return this;
        }
        public BookingDTO build(){
            return new BookingDTO(this);
        }
    }
    public BookingDTO(){

    }
}
