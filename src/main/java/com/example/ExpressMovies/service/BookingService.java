package com.example.ExpressMovies.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ExpressMovies.entity.Booking;
import com.example.ExpressMovies.repository.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // Create a new booking
    public Booking bookTicket(Booking booking) {

        if (booking.getCustomerName() == null ||
                booking.getCustomerName().isBlank()) {
            throw new IllegalArgumentException("Customer name is required");
        }

        if (booking.getMovieId() == null) {
            throw new IllegalArgumentException("Movie ID is required");
        }

        if (booking.getNumberOfTickets() <= 0) {
            throw new IllegalArgumentException(
                    "Number of tickets must be greater than zero");
        }

        if (booking.getShowDate() == null) {
            throw new IllegalArgumentException("Show date is required");
        }

        if (booking.getSeats() == null ||
                booking.getSeats().isBlank()) {
            throw new IllegalArgumentException("Please select seats");
        }

        booking.setStatus("BOOKED");

        return bookingRepository.save(booking);
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get booking by ID
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Booking not found: " + id));
    }

    // Cancel booking
    public Booking cancelBooking(Long id) {
        Booking booking = getBookingById(id);

        booking.setStatus("CANCELLED");

        return bookingRepository.save(booking);
    }

    // Delete booking
    public void deleteBooking(Long id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }
}