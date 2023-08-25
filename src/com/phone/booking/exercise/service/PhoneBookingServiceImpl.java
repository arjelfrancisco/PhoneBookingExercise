package com.phone.booking.exercise.service;

import java.util.List;
import java.util.stream.Collectors;

import com.phone.booking.exercise.model.Booking;
import com.phone.booking.exercise.model.BookingRecord;
import com.phone.booking.exercise.model.Phone;
import com.phone.booking.exercise.model.PhoneInventory;

public class PhoneBookingServiceImpl implements PhoneBookingService{

	private PhoneInventory phoneInventory;
	private BookingRecord bookingRecord;
	
	public PhoneBookingServiceImpl() {
		phoneInventory = PhoneInventory.getInstance();
		bookingRecord = BookingRecord.getInstance();
	}
	
	@Override
	public Booking bookPhone(String name, Phone phone) {
		Booking booking = new Booking(phone, name);
		bookingRecord.addBooking(booking);
		phone.getPhoneAvailability().decreaseQuantity();
		return booking;
	}

	@Override
	public void returnPhone(Booking booking) {
		booking.getPhone().getPhoneAvailability().increaseQuantity();
		bookingRecord.removeBooking(booking);
	}

	@Override
	public List<Phone> getAllPhones() {
		return phoneInventory.getAllPhones();
		
	}

	@Override
	public List<Phone> getAllAvailablePhones() {
		return getAllPhones().stream()
			.filter(phone -> phone.getPhoneAvailability().isAvailable())
			.collect(Collectors.toList());
	}

	@Override
	public List<Booking> getAllBookings() {
		return bookingRecord.getAllBookings();
	}


}
