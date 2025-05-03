package BackendAssignment010;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelManager {

	public HotelManager() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Enter the user name to login : ");
		
		String userName = userInput.nextLine();
		
		System.out.println("Enter your password : ");
		
		String password = userInput.nextLine();
		
		User user = LoginSystem.getLoginObject().loginSystem(userName, password);
		
		if(user == null) {
			
			System.out.println("Invalid Username or password. Please Enter valid credentials.");
			
		}
		
		else {
			
			loop1: while(true) {
				
				ArrayList<Room> availableRooms =  user.loadRooms();
			
				System.out.println("----- Hotel Bookings -----\nPress '1' to 'Book' Room.\nPress '2' to 'View' Bookings.\nPress '3' to 'Update' Bookings.\nPress '4' to 'Cancel' Bookings.\nPress '5' to 'Exit'.");
				
				int input1 = userInput.nextInt();
				
				if (input1 == 5) {
					
					System.out.println("Thank you for visiting Zoho Hotels. Bye.");
					
					break loop1;
					
				}
				
				else if(input1 == 1) {
					
					userInput.nextLine();					
					
					System.out.println("Enter your name : ");
					
					String name = userInput.nextLine();
					
					System.out.println("--- Select any room ---");
					
					for(int i=0;i<availableRooms.size();i++) {
						
						if(availableRooms.get(i).isAvailable) {
						
							System.out.println(availableRooms.get(i).toString());
						
						}
						
					}
					
					System.out.println("\nEnter any room id :");
					
					int roomId = userInput.nextInt();
					
					Room selectedRoom = availableRooms.get(roomId - 101);
					
					selectedRoom.isAvailable = false; 
					
					userInput.nextLine();
					
					LocalDate checkInDate = null;
					
					while(checkInDate == null || !checkInDate.isAfter(LocalDate.now())) {	
						
						try {
							
							System.out.println("Enter the correct Check-in date : (yyyy-mm-dd)");
							
							String checkIn = userInput.nextLine();
							
							checkInDate = LocalDate.parse(checkIn);
							
						} 
						
						catch (Exception e) {

							System.out.println("Invalid Date format. Please give in this format (yyyyyy-mm-dd).\n");

						}
					
					}
					
					System.out.println("Enter the number of days you want to stay : ");
					
					int noOfDays = userInput.nextInt();
					
					user.bookRoom(name, selectedRoom, checkInDate, noOfDays);
					
				}
				
				else if(input1 == 2) {
					
					loop2: while(true) {
					
						System.out.println("\nWhat do you want to view?\n(1) => 'View All Bookings'.\n(2) => 'View Specific Booking'.\n(3) => 'Exit'.");
						
						int input2 = userInput.nextInt();
						
						if(input2 == 3) {
							
							System.out.println("Exitting.....\n");
							
							break loop2;
							
						}
						
						else if (input2 == 1) {
							
							System.out.println("----- Listing all Bookings -----\n");
							
							user.viewBookings();
							
						}
						
						else if (input2 == 2) {
							
							System.out.println("Enter the booking id to view it : ");
							
							int bid = userInput.nextInt();
							
							user.viewBookings(bid);
							
						}
						
						else {
							
							System.out.println("Please select a valid choice.");
							
						}
					
					}
					
				}
				
				else if (input1 == 3) {
					
					System.out.println("Enter your Booking Id : ");
					
					int bookingId = userInput.nextInt();
					
					loop2: while (true) {
						
						System.out.println("\nWhat do you want to view?\n(1) => Update 'Customer Name'.\n(2) => Update 'Room Number' .\n(3) => Update 'Check-in Date'.\n(4) => Update 'Check-out Date'.\n(5) => 'Exit'.");
						
						int input2 = userInput.nextInt();
						
						if (input2 == 5) {
							
							System.out.println("Exitting...\n");
							
							break loop2;
							
						}
						
						else if (input2 == 1) {
							
							userInput.nextLine();
							
							System.out.println("Enter your new Name to update : ");
							
							String newName = userInput.nextLine();
							
							user.updateName(newName, bookingId);							
							
						}
						
						else if (input2 == 2) {
							
							userInput.nextLine();
							
							System.out.println("--- Select any other room ---");
							
							for(int i=0;i<availableRooms.size();i++) {
								
								if(availableRooms.get(i).isAvailable) {
								
									System.out.println(availableRooms.get(i).toString());
								
								}
								
							}
							
							System.out.println("\nEnter any room id :");
							
							int roomId = userInput.nextInt();
							
							Room selectedRoom = availableRooms.get(roomId - 101);
							
							selectedRoom.isAvailable = false; 
							
							user.updateRoomNo(selectedRoom.roomNo, bookingId);
							
						}
						
						else if (input2 == 3) {
							
							userInput.nextLine();
							
							LocalDate checkInDate = null;
							
							while(checkInDate == null || !checkInDate.isAfter(LocalDate.now())) {	
								
								try {
									
									System.out.println("Enter the correct Check-in date : (yyyy-mm-dd)");
									
									String checkIn = userInput.nextLine();
									
									checkInDate = LocalDate.parse(checkIn);
									
								} 
								
								catch (Exception e) {

									System.out.println("Invalid Date format. Please give in this format (yyyyyy-mm-dd).\n");

								}
							
							}
							
							user.updateCheckIn(checkInDate, bookingId);							
														
						}
						
						else if (input2 == 4) {
							
							System.out.println("Enter the number of Days you want to Stay :");
							
							int noOfDays = userInput.nextInt();
							
							user.updateCheckOut(noOfDays, bookingId);
							
						}
						
					}
					
				}
				
				else if (input1 == 4) {
					
					System.out.println("Enter the booking id to Cancel it.");
					
					int bookingId = userInput.nextInt();
					
					user.cancelBooking(bookingId);
					
				}
				
				else {
					
					System.out.println("Please select a valid choice.");
					
				}
				
			}
			
		}
		
		userInput.close();
		
	}

}
