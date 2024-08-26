package com.ats.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlaneDTOTest {
    private PlaneDTO planeDetails;
    @BeforeEach
    void setUp(){
        planeDetails=new PlaneDTO("PL0001","Embraer E190","Embraer","embraer_e190.jpg",114);
    }
    @Test
    void testPlaneCreation(){
        assertNotNull(planeDetails);
    }
    @Test
    void testId(){
        assertEquals("PL0001",planeDetails.getId());
    }
    @Test
    void testModel(){
        assertEquals("Embraer E190",planeDetails.getModel());
    }
    @Test
    void testManufacturer(){
        assertEquals("Embraer",planeDetails.getManufacturer());
    }
    @Test
    void testImage(){
        assertEquals("embraer_e190.jpg",planeDetails.getImage());
    }
    @Test
    void testSeatingCapacity(){
        assertEquals(114,planeDetails.getSeatingCapacity());
    }
}
