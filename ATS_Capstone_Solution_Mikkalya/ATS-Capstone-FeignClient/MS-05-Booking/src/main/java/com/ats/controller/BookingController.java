package com.ats.controller;

import com.ats.entity.Booking;
import com.ats.model.BookingDTO;
import com.ats.repository.BookingRepository;
import com.ats.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class BookingController {
    private final BookingRepository bookingRepository;
    private final BookingService bookingService;
    @Autowired
    public BookingController(BookingRepository bookingRepository,BookingService bookingService){
        this.bookingRepository=bookingRepository;
        this.bookingService=bookingService;
    }
    @GetMapping("/booking")
    public List<BookingDTO> getAllBooking(){
        return bookingService.getAllBooking();
    }
    @GetMapping("/booking/{boId}")
    public BookingDTO getBookingDetails(@PathVariable(value = "boId") String bookingId){
        try{
            Booking bookingDetails=bookingRepository.findById(bookingId).get();
            return new BookingDTO.BookingBuilder(bookingId,bookingDetails.getPassengerName())
                    .bookingDate(bookingDetails.getBookingDate())
                    .seatNumber(bookingDetails.getSeatNumber())
                    .ticketCost(bookingDetails.getTicketCost())
                    .totalAmount(bookingDetails.getTotalAmount())
                    .departureDate(bookingDetails.getDepartureDate())
                    .departureTime(bookingDetails.getDepartureTime())
                    .arrivalDate(bookingDetails.getArrivalDate())
                    .arrivalTime(bookingDetails.getArrivalTime())
                    .build();

        }
        catch(NoSuchElementException noSuchElementException){
            return null;
        }
    }
    @PostMapping("/booking")
    public String insertBookingDetails(@RequestBody BookingDTO bookingInfo){
//        need to add
        if(bookingInfo.getPassengerName()==null||bookingInfo.getPassengerName().isEmpty()||bookingInfo.getSeatNumber()<=0||!bookingService.isValidSeat(bookingInfo.getSeatNumber())||bookingInfo.getTicketCost()<=0||bookingInfo.getDepartureDate()==null||bookingInfo.getDepartureDate().isEmpty()||bookingInfo.getDepartureTime()==null||bookingInfo.getDepartureTime().isEmpty()||bookingInfo.getArrivalDate()==null||bookingInfo.getArrivalDate().isEmpty()||bookingInfo.getArrivalTime()==null||bookingInfo.getArrivalTime().isEmpty()){
            return "Please provide the required details";
        }
        String bookingId=bookingService.generateId();
        int totalAmount=(int)(bookingInfo.getTicketCost()+(bookingInfo.getTicketCost()*0.2)+(bookingInfo.getTicketCost()*0.05)+(bookingInfo.getTicketCost()*0.1));
        Booking bookingDetails=new Booking(bookingId,bookingInfo.getPassengerName(), LocalDate.now(),bookingInfo.getSeatNumber(),bookingInfo.getTicketCost(),totalAmount,bookingInfo.getDepartureDate(),bookingInfo.getDepartureTime(),bookingInfo.getArrivalDate(),bookingInfo.getArrivalTime());
        bookingRepository.save(bookingDetails);
        return "Booking Details inserted successfully";
    }
    @DeleteMapping("/booking/{boId}")
    public String deleteBookingDetails(@PathVariable(value = "boId") String bookingId){
        try{
            Booking bookingDetailsToBeDeleted=bookingRepository.findById(bookingId).get();
            bookingRepository.delete(bookingDetailsToBeDeleted);
            return "Booking Details deleted successfully";
        }
        catch(NoSuchElementException noSuchElementException){
            return "Booking Details is not available";
        }
    }
    @PutMapping("/booking")
    public String updateBookingDetails(@RequestBody BookingDTO bookingInfo){
        try{
            Booking bookingDetailsToBeUpdated=bookingRepository.findById(bookingInfo.getId()).get();
            if(bookingInfo.getPassengerName()!=null&&!bookingInfo.getPassengerName().isEmpty()) bookingDetailsToBeUpdated.setPassengerName(bookingInfo.getPassengerName());
            bookingInfo.setBookingDate(LocalDate.now());
            if(bookingInfo.getSeatNumber()>0&&bookingService.isValidSeat(bookingInfo.getSeatNumber())){
                bookingDetailsToBeUpdated.setSeatNumber(bookingInfo.getSeatNumber());
            }
            if(bookingInfo.getTicketCost()>0){
                bookingDetailsToBeUpdated.setTicketCost(bookingInfo.getTicketCost());
                int totalAmount=(int)(bookingInfo.getTicketCost()+(bookingInfo.getTicketCost()*0.2)+(bookingInfo.getTicketCost()*0.05)+(bookingInfo.getTicketCost()*0.1));
                bookingDetailsToBeUpdated.setTotalAmount(totalAmount);
            }
            if(bookingInfo.getDepartureDate()!=null&&!bookingInfo.getDepartureDate().isEmpty())bookingDetailsToBeUpdated.setDepartureDate(bookingInfo.getDepartureDate());
            if(bookingInfo.getDepartureTime()!=null&&!bookingInfo.getDepartureTime().isEmpty())bookingDetailsToBeUpdated.setDepartureTime(bookingInfo.getDepartureTime());
            if(bookingInfo.getArrivalDate()!=null&&!bookingInfo.getArrivalDate().isEmpty())bookingDetailsToBeUpdated.setArrivalDate(bookingInfo.getArrivalDate());
            if(bookingInfo.getArrivalTime()!=null&&!bookingInfo.getArrivalTime().isEmpty())bookingDetailsToBeUpdated.setArrivalTime(bookingInfo.getArrivalTime());
            bookingRepository.save(bookingDetailsToBeUpdated);
            return "Booking Details updated successfully";
        }
        catch(NoSuchElementException noSuchElementException){
            return "Booking Details not updated for the provided Booking Id";
        }
    }
}
