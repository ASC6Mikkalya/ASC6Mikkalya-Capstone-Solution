package com.ats.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookingDTOTest {
    private BookingDTO bookingDetails;
    @BeforeEach
    void setUp(){
        bookingDetails=new BookingDTO("BO0001","Mikkalya", LocalDate.of(2024,9,6),20,500,550,"2024-09-06","09:15 AM","2024-09-06","01:15 PM");
    }
    @Test
    void testBookingCreation(){
        assertNotNull(bookingDetails);
    }
    @Test
    void testId(){
        assertEquals("BO0001",bookingDetails.getId());
    }
    @Test
    void testPassengerName(){
        assertEquals("Mikkalya",bookingDetails.getPassengerName());
    }
    @Test
    void testBookingDate(){
        assertEquals(LocalDate.of(2024,9,6),bookingDetails.getBookingDate());
    }
    @Test
    void testSeatNumber(){
        assertEquals(20,bookingDetails.getSeatNumber());
    }
    @Test
    void testTicketCost(){
        assertEquals(500,bookingDetails.getTicketCost());
    }
    @Test
    void testTotalAmount(){
        assertEquals(550,bookingDetails.getTotalAmount());
    }
    @Test
    void testDepartureDate(){
        assertEquals("2024-09-06",bookingDetails.getDepartureDate());
    }
    @Test
    void testDepartureTime(){
        assertEquals("09:15 AM",bookingDetails.getDepartureTime());
    }
    @Test
    void testArrivalDate(){
        assertEquals("2024-09-06",bookingDetails.getArrivalDate());
    }
    @Test
    void testArrivalTime(){
        assertEquals("01:15 PM",bookingDetails.getArrivalTime());
    }
}
