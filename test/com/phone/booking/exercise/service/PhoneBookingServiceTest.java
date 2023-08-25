package com.phone.booking.exercise.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.phone.booking.exercise.model.Booking;
import com.phone.booking.exercise.model.BookingRecord;
import com.phone.booking.exercise.model.Phone;
import com.phone.booking.exercise.model.PhoneBrand;
import com.phone.booking.exercise.model.PhoneInventory;


public class PhoneBookingServiceTest {

	private PhoneBookingService phoneBookingService = new PhoneBookingServiceImpl();
	
	private PhoneInventory phoneInventory = PhoneInventory.getInstance();
	private BookingRecord bookingRecord = BookingRecord.getInstance();
	
	private Phone phone1 = new Phone("Samsung Galaxy S9", PhoneBrand.SAMSUNG, "Galaxy S9", 1);
	private Phone phone2 = new Phone("Samsung Galaxy S8", PhoneBrand.SAMSUNG, "Galaxy S8", 2);
	private Phone phone3 = new Phone("Motorola Nexus 6", PhoneBrand.MOTOROLA, "Nexus 6", 1);
	private Phone phone4 = new Phone("Oneplus 9", PhoneBrand.ONEPLUS, "Oneplus 9", 1);
	private Phone phone5 = new Phone("Apple iPhone 13", PhoneBrand.APPLE, "iPhone 13", 1);
	private Phone phone6 = new Phone("Apple iPhone 12", PhoneBrand.APPLE, "iPhone 12", 1);
	private Phone phone7 = new Phone("Apple iPhone 11", PhoneBrand.APPLE, "iPhone 11", 1);
	private Phone phone8 = new Phone("iPhone X", PhoneBrand.APPLE, "iPhone X", 1);
	private Phone phone9 = new Phone("Nokia 3310", PhoneBrand.NOKIA, "3310", 1);
	
	@Before
	public void setUp() {
		phoneInventory.clearPhones();
		bookingRecord.clearBookings();
		phoneInventory.addPhone(phone1);
		phoneInventory.addPhone(phone2);
		phoneInventory.addPhone(phone3);
		phoneInventory.addPhone(phone4);
		phoneInventory.addPhone(phone5);
		phoneInventory.addPhone(phone6);
		phoneInventory.addPhone(phone7);
		phoneInventory.addPhone(phone8);
		phoneInventory.addPhone(phone9);
	}
	
	@Test
	public void testBookPhone() {
		phoneBookingService.bookPhone("User1", phone1);
		assertEquals(false, phone1.getPhoneAvailability().isAvailable());
		
		phoneBookingService.bookPhone("User2", phone2);
		assertEquals(true, phone2.getPhoneAvailability().isAvailable());
	}
	
	@Test
	public void testReturnPhone() {
		Booking booking = phoneBookingService.bookPhone("User1", phone1);
		List<Booking> bookings = phoneBookingService.getAllBookings();
		assertEquals(1, bookings.size());
		assertEquals(false, phone1.getPhoneAvailability().isAvailable());
		
		phoneBookingService.returnPhone(booking);
		assertEquals(true, phone1.getPhoneAvailability().isAvailable());
	}
	
}
