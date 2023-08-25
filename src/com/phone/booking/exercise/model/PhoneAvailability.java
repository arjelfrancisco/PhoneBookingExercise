package com.phone.booking.exercise.model;

public class PhoneAvailability {
	
	private int quantity;
	private boolean available;
	
	public PhoneAvailability(int initialQuantity) {
        this.quantity = initialQuantity;
        this.available = initialQuantity > 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isAvailable() {
		return available;
	}

	public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
            if (quantity == 0) {
                available = false;
            }
        }
    }

    public void increaseQuantity() {
        quantity++;
        available = true;
    }
}
