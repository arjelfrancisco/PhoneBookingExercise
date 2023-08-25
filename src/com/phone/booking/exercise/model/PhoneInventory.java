package com.phone.booking.exercise.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneInventory {
	
	private static PhoneInventory instance;
    private Map<String, Phone> phoneInventory;

    private PhoneInventory() {
    	 // Initialize phone inventory
        phoneInventory = new HashMap<>();
    }
    
    public static PhoneInventory getInstance() {
        if (instance == null) {
            instance = new PhoneInventory();
        }
        return instance;
    }
    
    public void addPhone(Phone phone) {
    	phoneInventory.put(phone.getName(), phone);
    }
    
    public void clearPhones() {
    	phoneInventory.clear();
    }

    public Phone getPhone(String name) {
        return phoneInventory.get(name);
    }

    public List<Phone> getAllPhones() {
    	return new ArrayList<>(phoneInventory.values());
    }
    
}
