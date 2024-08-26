package com.ats.service;

import com.ats.entity.Booking;
import com.ats.model.BookingDTO;
import com.ats.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{
    private final BookingRepository bookingRepository;
    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository){
        this.bookingRepository=bookingRepository;
    }
    @Override
    public String generateId() {
        String bookingId = bookingRepository.findTopId();
        if (bookingId == null || bookingId.isEmpty()) {
            bookingId = "BO0000";
        }
        String id="BO";
        int num=Integer.parseInt(bookingId.substring(2,6));
        num++;
        String digit=Integer.toString(num);
        switch(4-digit.length()){
            case 1:
                id+="0";
                break;
            case 2:
                id+="00";
                break;
            case 3:
                id+="000";
                break;
            default:
                break;
        }
        id+=digit;
        return id;
    }
    @Override
    public List<BookingDTO> getAllBooking() {
        List<Booking> bookingEntityList=bookingRepository.findAll();
        List<BookingDTO> bookingModelList=new ArrayList<>();
        for(Booking bookingDetails:bookingEntityList){
            BookingDTO bookingModel= new BookingDTO.BookingBuilder(bookingDetails.getId(),bookingDetails.getPassengerName())
                    .bookingDate(bookingDetails.getBookingDate())
                    .seatNumber(bookingDetails.getSeatNumber())
                    .ticketCost(bookingDetails.getTicketCost())
                    .totalAmount(bookingDetails.getTotalAmount())
                    .departureDate(bookingDetails.getDepartureDate())
                    .departureTime(bookingDetails.getDepartureTime())
                    .arrivalDate(bookingDetails.getArrivalDate())
                    .arrivalTime(bookingDetails.getArrivalTime())
                    .build();
            bookingModelList.add(bookingModel);
        }
        return bookingModelList;
    }
    @Override
    public boolean isValidSeat(int seatNumber) {
        try{
            bookingRepository.findSeatNumberBySeatNumber(seatNumber);
            return true;
        }
        catch(NullPointerException nullPointerException){
            return false;
        }
    }

}
