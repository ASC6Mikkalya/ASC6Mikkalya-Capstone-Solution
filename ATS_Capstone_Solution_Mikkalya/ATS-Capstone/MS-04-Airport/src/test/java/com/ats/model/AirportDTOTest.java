package com.ats.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AirportDTOTest {
    private AirportDTO airportDetails;
    @BeforeEach
    void setUp(){
        airportDetails=new AirportDTO("AP0001","Indira Gandhi International Airport","New Delhi","India","IN");
    }
    @Test
    void testAirportCreation(){
        assertNotNull(airportDetails);
    }
    @Test
    void testId(){
        assertEquals("AP0001",airportDetails.getId());
    }
    @Test
    void testAirportName(){
        assertEquals("Indira Gandhi International Airport",airportDetails.getAirportName());
    }
    @Test
    void testCity(){
        assertEquals("New Delhi",airportDetails.getCity());
    }
    @Test
    void testCoutry(){
        assertEquals("India",airportDetails.getCountry());
    }
    @Test
    void testCountryCode(){
        assertEquals("IN",airportDetails.getCountryCode());
    }
}
