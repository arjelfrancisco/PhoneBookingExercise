package com.phone.booking.exercise.model;

import java.util.Date;

public class Booking {
	private Date bookedDate;
    private String bookedBy;
    private Phone phone;
    

    public Booking(Phone phone, String bookedBy) {
    	this.bookedBy = bookedBy;
        this.phone = phone;
    	bookedDate = new Date();
    }

    public Date getBookedDate() {
        return bookedDate;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

}
