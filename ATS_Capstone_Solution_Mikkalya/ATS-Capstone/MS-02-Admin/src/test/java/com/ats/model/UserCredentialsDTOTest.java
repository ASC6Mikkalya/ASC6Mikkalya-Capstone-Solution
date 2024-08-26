package com.ats.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserCredentialsDTOTest {
    private UserCredentialsDTO userDetails;
    @BeforeEach
    void setUp(){
        userDetails=new UserCredentialsDTO("AD0001","Mikkalya","miks662003@gmail.com","Miks@123","7888129182");
    }
    @Test
    void testUsersCreation(){
        assertNotNull(userDetails);
    }
    @Test
    void testId(){
        assertEquals("AD0001",userDetails.getId());
    }
    @Test
    void testUserName(){
        assertEquals("Mikkalya",userDetails.getUserName());
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
    void testPhoneNumber(){
        assertEquals("7888129182",userDetails.getPhoneNumber());
    }
}
