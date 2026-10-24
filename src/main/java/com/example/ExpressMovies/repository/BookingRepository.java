package com.example.ExpressMovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ExpressMovies.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}