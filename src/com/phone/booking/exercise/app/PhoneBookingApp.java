package com.phone.booking.exercise.app;

import com.phone.booking.exercise.model.Phone;
import com.phone.booking.exercise.model.PhoneBrand;
import com.phone.booking.exercise.model.PhoneInventory;
import com.phone.booking.exercise.view.ConsoleView;
import com.phone.booking.exercise.view.View;

public class PhoneBookingApp {

	public static void main(String[] args) {
		View view = ConsoleView.getInstance();
		
		// Initialize Phone Inventory
		PhoneInventory phoneInventory = PhoneInventory.getInstance();
		phoneInventory.addPhone(new Phone("Samsung Galaxy S9", PhoneBrand.SAMSUNG, "Galaxy S9", 1));
		phoneInventory.addPhone(new Phone("Samsung Galaxy S8", PhoneBrand.SAMSUNG, "Galaxy S8", 2));
		phoneInventory.addPhone(new Phone("Motorola Nexus 6", PhoneBrand.MOTOROLA, "Nexus 6", 1));
		phoneInventory.addPhone(new Phone("Oneplus 9", PhoneBrand.ONEPLUS, "Oneplus 9", 1));
		phoneInventory.addPhone(new Phone("Apple iPhone 13", PhoneBrand.APPLE, "iPhone 13", 1));
		phoneInventory.addPhone(new Phone("Apple iPhone 12", PhoneBrand.APPLE, "iPhone 12", 1));
		phoneInventory.addPhone(new Phone("Apple iPhone 11", PhoneBrand.APPLE, "iPhone 11", 1));
		phoneInventory.addPhone(new Phone("iPhone X", PhoneBrand.APPLE, "iPhone X", 1));
		phoneInventory.addPhone(new Phone("Nokia 3310", PhoneBrand.NOKIA, "3310", 1));
		
		view.start();
	}

}
