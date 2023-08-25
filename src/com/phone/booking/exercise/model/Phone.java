package com.phone.booking.exercise.model;

public class Phone {
	
	private String name;
	private PhoneBrand phoneBrand;
	private String model;
	private PhoneAvailability phoneAvailability;
	
	public Phone(String name, PhoneBrand phoneBrand, String model, int initialQuantity) {
		this.name = name;
		this.phoneBrand = phoneBrand;
		this.model = model;
		this.phoneAvailability = new PhoneAvailability(initialQuantity);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PhoneBrand getPhoneBrand() {
		return phoneBrand;
	}

	public void setPhoneBrand(PhoneBrand phoneBrand) {
		this.phoneBrand = phoneBrand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public PhoneAvailability getPhoneAvailability() {
		return phoneAvailability;
	}

	public void setPhoneAvailability(PhoneAvailability phoneAvailability) {
		this.phoneAvailability = phoneAvailability;
	}
	
	
	
}
