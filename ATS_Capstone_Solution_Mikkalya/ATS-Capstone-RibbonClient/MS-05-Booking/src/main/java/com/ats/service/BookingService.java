package com.ats.service;

import com.ats.model.BookingDTO;

import java.util.List;

public interface BookingService {
    List<BookingDTO> getAllBooking();
    String generateId();
    boolean isValidSeat(int seatNumber);
}
