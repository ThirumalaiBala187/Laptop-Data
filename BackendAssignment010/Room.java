package BackendAssignment010;

public class Room {
	
	static int roomIdCounter = 101;
	
	int roomNo;
	
	String roomType;
	
	double pricePerDay;
	
	boolean isAvailable;	

	public Room(int roomNo, String roomType, double pricePerDay, boolean isAvailable) {
		
		this.roomNo = roomNo;
		
		this.roomType = roomType;
		
		this.pricePerDay = pricePerDay;
		
		this.isAvailable = isAvailable;
		
		roomIdCounter++;
		
	}

	public int getRoomNo() {
		
		return roomNo;
	
	}

	public void setRoomNo(int roomNo) {
	
		this.roomNo = roomNo;
	
	}

	public double getPricePerDay() {
	
		return pricePerDay;
	
	}

	public void setPricePerDay(double pricePerDay) {
	
		this.pricePerDay = pricePerDay;
	
	}

	public boolean isAvailable() {
	
		return isAvailable;
	
	}

	public void setAvailable(boolean isAvailable) {
	
		this.isAvailable = isAvailable;
	
	}
	
	
	@Override
	public String toString() {
		
		return "\n----- Booking Details -----\nRoom No : " + roomNo + "\nRoom Type : " + roomType + "\nPrice per day : " + pricePerDay + "\nAvailability : " + isAvailable;
	
	}
	

}
