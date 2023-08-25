package com.phone.booking.exercise.view;

import java.util.List;
import java.util.Scanner;

import com.phone.booking.exercise.model.Booking;
import com.phone.booking.exercise.model.Phone;
import com.phone.booking.exercise.service.PhoneBookingService;
import com.phone.booking.exercise.service.PhoneBookingServiceImpl;

public class ConsoleView implements View{
	
	private static ConsoleView instance;
    private Scanner scanner;
    private PhoneBookingService phoneBookingService;

    private ConsoleView() {
        scanner = new Scanner(System.in);
        phoneBookingService = new PhoneBookingServiceImpl();
    }

    public static ConsoleView getInstance() {
        if (instance == null) {
            instance = new ConsoleView();
        }
        return instance;
    }
    
    @Override
	public void start() {
    	String choice;
        do {
            showMenu();
            
            System.out.print("Please enter an option: ");
            choice = scanner.nextLine();
            generateSpaces();
            
            switch (choice) {
                case "1":
                	showBookPhoneMenu();
                	break;
                case "2":
                    showReturnPhoneMenu();
                    break;
                case "3":
                    displayPhoneStatus();
                    break;
                case "4":
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        } while (!choice.equals("4"));
	}

    private void showMenu() {
        System.out.println("Phone Booking System");
        System.out.println("[1] Book a Phone");
        System.out.println("[2] Return a Phone");
        System.out.println("[3] Display Phone Status");
        System.out.println("[4] Exit");
        
        
    }
    
    private void showBookPhoneMenu() {
    	System.out.println("AVAILABLE PHONES: ");
    	
    	int counter = 1;
    	String choice;
    	List<Phone> phones = phoneBookingService.getAllAvailablePhones();
    	
    	for (Phone phone : phones) {
    		if(phone.getPhoneAvailability().isAvailable()) {
    			System.out.println("[" + counter +"] " + phone.getName());
    			counter++;
    		}
    	}
    	
    	Phone bookedPhone = null;
    	do {
    		try {
    			System.out.print("Enter [number] of the phone to book: ");
            	choice = scanner.nextLine(); 
                bookedPhone = phones.get(Integer.parseInt(choice) - 1);
                break;
    		} catch(RuntimeException e) {
    			System.out.println("Invalid choice. Please enter a valid option.");
    		}
    		
    	} while (true);
    	
        
        System.out.print("Enter your name: ");
    	String name = scanner.nextLine(); 
    	
    	phoneBookingService.bookPhone(name, bookedPhone);
    	
    	System.out.println("Phone booked successfully.");
    	
    	generateSpaces();
    }

    private void showReturnPhoneMenu() {
    	List<Booking> bookings = phoneBookingService.getAllBookings();
    	if(bookings.isEmpty()) {
    		System.out.println("There are no bookings yet.");
    		return;
    	}
    	System.out.println("RENTED PHONES: ");
    	
    	int counter = 1;
    	String choice;
    	
    	for(Booking booking : bookings) {
    		System.out.println("[" + counter + "]" + " Phone Name: " + booking.getPhone().getName() + " | Booked By: " 
    				+ booking.getBookedBy() + " | Booking Date: " + booking.getBookedDate());
    	}
    	
    	Booking returnBooking = null;
    	
    	do {
    		try {
    			System.out.print("Enter [number] of phone to return: ");
            	choice = scanner.nextLine();
            	returnBooking = bookings.get(Integer.parseInt(choice) - 1);
            	break;
    		} catch(RuntimeException e) {
    			System.out.println("Invalid choice. Please enter a valid option.");
    		}
    	} while(true);
    	
    	phoneBookingService.returnPhone(returnBooking);
    	
    	System.out.println("Phone returned successfully.");
    	generateSpaces();
    }

    private void displayPhoneStatus() {
    	for (Phone phone : phoneBookingService.getAllPhones()) {
	        System.out.println("Phone: " + phone.getName());
	        System.out.println("Brand: " + phone.getPhoneBrand());
	        System.out.println("Availability: " + (phone.getPhoneAvailability().isAvailable() ? "Available" : "Not Available"));
	        System.out.println("Quantity: " + phone.getPhoneAvailability().getQuantity());
            System.out.println("---------------------");
        }
    	
    	generateSpaces();
    }
    
    private void generateSpaces() {
    	System.out.println();
    	System.out.println();
    }

}
