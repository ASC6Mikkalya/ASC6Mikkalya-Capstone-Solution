package com.ats.repository;

import com.ats.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,String> {
    @Query(value = "SELECT id FROM booking ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String findTopId();
    Integer findSeatNumberBySeatNumber(Integer seatNumber);
}

