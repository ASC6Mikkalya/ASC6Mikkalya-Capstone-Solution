package com.ats.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class UserCredentialsDTOTest {
    private UserCredentialsDTO userDetails;
    @BeforeEach
    void setUp(){
        userDetails=new UserCredentialsDTO();
        userDetails.setEmailId("miks662003@gmail.com");
        userDetails.setPassword("Miks@123");
        userDetails.setLastAttempt(LocalDateTime.of(2024,8,28,17,56,47));
        userDetails.setIsActive(true);
    }
    @Test
    void testUsersCreation(){
        assertNotNull(userDetails);
    }
    @Test
    void testEmailId(){
        assertEquals("miks662003@gmail.com",userDetails.getEmailId());
    }
    @Test
    void testPassword(){
        assertEquals("Miks@123",userDetails.getPassword());
    }
    @Test
    void testLastAttempt(){
        assertEquals(LocalDateTime.of(2024,8,28,17,56,47),userDetails.getLastAttempt());
    }
    @Test
    void testIsActive(){
        assertTrue(userDetails.getIsActive());
    }
}
