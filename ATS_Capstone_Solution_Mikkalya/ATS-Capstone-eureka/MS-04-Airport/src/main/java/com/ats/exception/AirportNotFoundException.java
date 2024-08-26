package com.ats.exception;

public class AirportNotFoundException extends RuntimeException{
    AirportNotFoundException(String message){
        super(message);
    }
}
