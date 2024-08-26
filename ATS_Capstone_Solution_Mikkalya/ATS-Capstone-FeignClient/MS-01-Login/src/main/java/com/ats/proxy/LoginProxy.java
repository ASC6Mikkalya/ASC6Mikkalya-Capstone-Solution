package com.ats.proxy;
import com.ats.model.BookingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
@FeignClient(name="MS-05-Booking-FeignClient")
public interface LoginProxy {
    @GetMapping("/ats/api/booking")
    List<BookingDTO> getAllBooking();
}



