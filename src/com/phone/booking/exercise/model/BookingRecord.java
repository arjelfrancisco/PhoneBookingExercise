package com.phone.booking.exercise.model;

import java.util.ArrayList;
import java.util.List;

public class BookingRecord {
	
	private static BookingRecord instance;
	private List<Booking> bookings;

    private BookingRecord() {
        bookings = new ArrayList<>();
    }
    
    public static BookingRecord getInstance() {
        if (instance == null) {
            instance = new BookingRecord();
        }
        return instance;
    }
    
    public List<Booking> getAllBookings() {
    	return bookings;
    }
    
    public void addBooking(Booking booking) {
    	bookings.add(booking);
    }
    
    public void removeBooking(Booking booking) {
    	bookings.remove(booking);
    }
    
    public void clearBookings() {
    	bookings.clear();
    }
	
}
