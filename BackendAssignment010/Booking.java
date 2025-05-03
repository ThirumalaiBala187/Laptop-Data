package BackendAssignment010;

import java.time.LocalDate;

public class Booking {
	
	private String customerName;
	
	private int bookingId;
	
	private int roomNo;
	
	private LocalDate checkIn;
	
	private LocalDate checkOut;
	
	private double totalPrice;

	public Booking(String customerName, int roomNo, LocalDate checkIn, LocalDate checkOut, double totalPrice) {
		
		this.customerName = customerName;
		
		this.roomNo = roomNo;
		
		this.checkIn = checkIn;
		
		this.checkOut = checkOut;
		
		this.totalPrice = totalPrice;

	}
	


	public Booking(int bookingId, String customerName, int roomNo, LocalDate checkIn, LocalDate checkOut, double totalPrice) {
		
		this.bookingId = bookingId;
		
		this.customerName = customerName;
		
		this.roomNo = roomNo;
		
		this.checkIn = checkIn;
		
		this.checkOut = checkOut;
		
		this.totalPrice = totalPrice;

	}

	public String getCustomerName() {
	
		return customerName;
	
	}

	public void setCustomerName(String customerName) {
	
		this.customerName = customerName;
	
	}

	public int getRoomNo() {
	
		return roomNo;
	
	}

	public void setRoomNo(int roomNo) {
	
		this.roomNo = roomNo;
	
	}

	public LocalDate getCheckIn() {
	
		return checkIn;
	
	}

	public void setCheckIn(LocalDate checkIn) {
	
		this.checkIn = checkIn;
	
	}

	public LocalDate getCheckOut() {
	
		return checkOut;
	
	}

	public void setCheckOut(LocalDate checkOut) {
	
		this.checkOut = checkOut;
	
	}

	public double getTotalPrice() {
	
		return totalPrice;
	
	}

	public void setTotalPrice(double totalPrice) {
	
		this.totalPrice = totalPrice;
	
	}
	
	
	@Override
	public String toString() {
		
		return "----- Booking Details -----\nBooking Id : " + bookingId + "\nCustomer Name : " + customerName + "\nRoom Number : " + roomNo + "\nCheck In Date : " + checkIn + "\nCheck Out Date : " + checkOut + "\nTotal Price : " + totalPrice + "\n------------------------------\n";   
	
	}

}
