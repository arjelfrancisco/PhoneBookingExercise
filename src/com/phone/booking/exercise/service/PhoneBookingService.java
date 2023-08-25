package com.phone.booking.exercise.service;

import java.util.List;

import com.phone.booking.exercise.model.Booking;
import com.phone.booking.exercise.model.Phone;

public interface PhoneBookingService {

	public Booking bookPhone(String name, Phone phone);
	
	public void returnPhone(Booking booking);
	
	public List<Phone> getAllPhones();
	
	public List<Phone> getAllAvailablePhones();
	
	public List<Booking> getAllBookings();
	
}
