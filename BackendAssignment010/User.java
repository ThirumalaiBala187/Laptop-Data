package BackendAssignment010;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class User {
	
	String userName;
	
	String password;

	public User(String userName, String password) {

		this.userName = userName;
		
		this.password = password;

	}

	public String getUserName() {
		
		return userName;
	
	}

	public void setUserName(String userName) {
	
		this.userName = userName;
	
	}

	public String getPassword() {
	
		return password;
	
	}

	public void setPassword(String password) {
	
		this.password = password;
	
	}
	
	@Override
	public String toString() {
		
		return "----- User Details -----\nUser Name : " + userName + "\nPassword : " + password;
	
	}
	
	
	public ArrayList<Room> loadRooms() {
		
		ArrayList<Room> availableRooms = new ArrayList<>();
		
		String query = "Select * from Rooms";
		
		try(Connection connection = JDBCConnection.getConnection()) {
			
			Statement stmt = connection.createStatement();
			
			ResultSet resultSet = stmt.executeQuery(query);
			
			while (resultSet.next()) {
				
				int roomId = resultSet.getInt("RoomId");
				
				String roomType = resultSet.getString("Room_Type");
				
				double pricePerDay = resultSet.getDouble("PricePerDay");
				
				boolean isAvailable = resultSet.getBoolean("Availability");
				
				Room newRoom = new Room(roomId,roomType, pricePerDay, isAvailable);
				
				availableRooms.add(newRoom);
				
			}
			
			return availableRooms;
			
		} 
		
		catch (SQLException e) {
			
			System.out.println("Error appo idhulaya: " + e.getMessage());
		
		}	
		
		return new ArrayList<>();
		
	}
	
	
	public void bookRoom(String name, Room room, LocalDate checkInDate, int noOfDays) {
		
		int roomNo = room.roomNo;
		
		LocalDate checkOutDate = checkInDate.plusDays(noOfDays);
		
		double totalPrice = room.pricePerDay * noOfDays;
		
		room.isAvailable = false;
		
		String query1 = "Update Room set Availability = ? where RoomId = ?";
		
		String query2 = "Insert into Bookings (Customer_Name, Room_Number, Check_In_Date, Check_Out_Date, Total_Price) values (?, ?, ?, ?, ?)";
		
		try(Connection connection = JDBCConnection.getConnection()) {
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
			
			preparedStatement1.setString(1, "false");
			
			preparedStatement1.setInt(2, roomNo);
			
			preparedStatement1.executeUpdate();
			
			PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
			
			preparedStatement2.setString(1, name);
			
			preparedStatement2.setInt(2, roomNo);
			
			preparedStatement2.setDate(3, Date.valueOf(checkInDate));
			
			preparedStatement2.setDate(4, Date.valueOf(checkOutDate));
			
			preparedStatement2.setDouble(5, totalPrice);
			
			preparedStatement2.executeUpdate();
			
			System.out.println("Room with Room no : " + roomNo + " has been booked Successfully.\n");
			
		} 
		
		catch (Exception e) {

			System.out.println("Error : " + e.getMessage());			

		}
		
	}
	
	
	public void viewBookings() {
		
		ArrayList<Booking> bookings = new ArrayList<>();
		
		String query = "Select * from Bookings";	
			
		try(Connection connection = JDBCConnection.getConnection()) {
			
			Statement stmt = connection.createStatement();
			
			ResultSet resultSet = stmt.executeQuery(query);
			
			while (resultSet.next()) {
				
				int bookingId = resultSet.getInt("Booking_id");
				
				String name = resultSet.getString("Customer_Name");
				
				int roomNo = resultSet.getInt("Room_Number");
				
				Date checkIn = resultSet.getDate("Check_In_Date");
				
				LocalDate checkInDate = checkIn.toLocalDate();
				
				Date checkOut = resultSet.getDate("Check_Out_Date");
				
				LocalDate checkOutDate = checkOut.toLocalDate();
				
				double totalPrice = resultSet.getDouble("Total_Price");
				
				Booking booking = new Booking(bookingId,name, roomNo, checkInDate, checkOutDate, totalPrice);
				
				bookings.add(booking);
				
			}
			
			bookings.forEach(System.out::println);
			
		} 
		
		catch (SQLException e) {
			
			System.out.println("Error : " + e.getMessage());
		
		}		
				
	}
	
	
	public void updateName(String name, int bookingId) {
		
		String query = "Update Bookings set Customer_Name = ? where Booking_id = ?";
		
		try(Connection connection = JDBCConnection.getConnection()) {
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			if(name == null || name.isEmpty()) {
				
				System.out.println("Invalid Name Provided.");
				
			}
			
			else {
			
				preparedStatement.setString(1, name);
				
				preparedStatement.setInt(2, bookingId);
				
				int rowsChanged = preparedStatement.executeUpdate();
				
				if(rowsChanged > 0) {
					
					System.out.println("Your name has been updated to " + name + " for the Booking id - " + bookingId);
					
				}
				
				else{
					
					System.out.println("No details found for the given Booking id : " + bookingId);
					
				}
			
			}
			
		} 
		
		catch (Exception e) {

			System.out.println("Error : " + e.getMessage());

		}
		
	}
	
	
	public void updateRoomNo(int roomNo, int bookingId) {
		
		String query1 = "Select Room_Number from Bookings where Booking_id = ?";
		
		String query2 = "Update Rooms set Availability = ? where RoomId = ?";
		
		String query3 = "Update Bookings set Room_Number = ? where Booking_id = ?";
		
		String query4 = "Update Rooms set Availability = ? where RoomId = ?";
		
		try(Connection connection = JDBCConnection.getConnection()) {
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
			
			preparedStatement1.setInt(1, bookingId);
			
			ResultSet resultSet = preparedStatement1.executeQuery();
			
			if(resultSet.next()) {
				
				int oldRoomNumber = resultSet.getInt("Room_Number");
				
				PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
				
				preparedStatement2.setString(1, "true");
				
				preparedStatement2.setInt(2, oldRoomNumber);
				
				preparedStatement2.executeUpdate();
				
				PreparedStatement preparedStatement3 = connection.prepareStatement(query3);
				
				preparedStatement3.setInt(1, roomNo);
				
				preparedStatement3.setInt(2, bookingId);
				
				preparedStatement3.executeUpdate();	
				
				PreparedStatement preparedStatement4 = connection.prepareStatement(query4);
				
				preparedStatement4.setString(1, "false");
				
				preparedStatement4.setInt(2, roomNo);
				
				int rowsChanged = preparedStatement4.executeUpdate();
				
				if(rowsChanged > 0) {
					
					System.out.println("Your Room number has been updated to " + roomNo + " for the Booking id - " + bookingId);
					
				}
				
				else{
					
					System.out.println("No details found for the given Booking id : " + bookingId);
					
				}
								
			}
			
		} 
		
		catch (Exception e) {

			System.out.println("Error : " + e.getMessage());

		}
		
	}
	
	public void updateCheckIn(LocalDate date, int bookingId) {
		
		String query = "Update Bookings set Check_In_Date = ? where Booking_id = ?";
		
		try(Connection connection = JDBCConnection.getConnection()) {
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setDate(1, Date.valueOf(date));
			
			preparedStatement.setInt(2, bookingId);
			
			int rowsChanged = preparedStatement.executeUpdate();
			
			if(rowsChanged > 0) {
				
				System.out.println("Your Check in date has been updated to " + date + " for the Booking id - " + bookingId);
				
			}
			
			else{
				
				System.out.println("No details found for the given Booking id : " + bookingId);
				
			}
			
		} 
		
		catch (Exception e) {

			System.out.println("Error : " + e.getMessage());

		}
		
	}
	
	
	public void updateCheckOut(int noOfDays, int bookingId) {
		
		String query1 = "Select Check_In_Date from Bookings where Booking_id = ?";
		
		String query2 = "Update Bookings set Check_OUt_Date = ? where Booking_id = ?";
		
		LocalDate checkOutDate = null;
		
		try(Connection connection = JDBCConnection.getConnection()) {
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
			
			preparedStatement1.setInt(1, bookingId);
			
			ResultSet resultSet = preparedStatement1.executeQuery();
			
			if(resultSet.next()) {
				
				LocalDate checkInDate = resultSet.getDate("Check_In_Date").toLocalDate();
				
				PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
				
				checkOutDate = checkInDate.plusDays(noOfDays);		
				
				preparedStatement2.setDate(1, Date.valueOf(checkOutDate));
				
				preparedStatement2.setInt(2, bookingId);
				
				preparedStatement2.executeUpdate();
				
				int rowsChanged = preparedStatement2.executeUpdate();
				
				if(rowsChanged > 0) {
					
					System.out.println("Your Check out date has been updated to " + checkOutDate + " for the Booking id - " + bookingId);
					
				}
				
				else{
					
					System.out.println("No details found for the given Booking id : " + bookingId);
					
				}
				
			}	
			
		} 
		
		catch (Exception e) {

			System.out.println("Error : " + e.getMessage());

		}
		
	}
	
	
	public void viewBookings(int bId) {
		
		String query = "Select * from Bookings where Booking_id = ?";	
			
		try(Connection connection = JDBCConnection.getConnection()) {			
			
			PreparedStatement stmt = connection.prepareStatement(query);
			
			stmt.setInt(1, bId);
			
			ResultSet resultSet = stmt.executeQuery();
			
			if(resultSet.next()) {
				
				int bookingId = resultSet.getInt("Booking_id");
				
				String name = resultSet.getString("Customer_Name");
				
				int roomNo = resultSet.getInt("Room_Number");
				
				Date checkIn = resultSet.getDate("Check_In_Date");
				
				LocalDate checkInDate = checkIn.toLocalDate();
				
				Date checkOut = resultSet.getDate("Check_Out_Date");
				
				LocalDate checkOutDate = checkOut.toLocalDate();
				
				double totalPrice = resultSet.getDouble("Total_Price");
				
				Booking booking = new Booking(bookingId,name, roomNo, checkInDate, checkOutDate, totalPrice);
				
				System.out.println(booking.toString());
				
			}
			
			else {
			
				System.out.println("No booking found with the given details.");
				
			}			

			
		} 
		
		catch (SQLException e) {
			
			System.out.println("Error : " + e.getMessage());
		
		}	
				
	}
	
	
	public void cancelBooking(int bookingId) {
		
		String query1 = "Select Room_Number from Bookings where Booking_id = ?";
		
		String query2 = "Update Rooms set Availability = ? where RoomId = ?";
		
		String query3 = "Delete from Bookings where Booking_Id= ?";
		
		int roomNumber = 0;
		
		try(Connection connection = JDBCConnection.getConnection()) {
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
			
			preparedStatement1.setInt(1, bookingId);
			
			ResultSet resultSet = preparedStatement1.executeQuery();
			
			if(resultSet.next()) {
				
				roomNumber = resultSet.getInt("Room_Number");
				
			}
			
			PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
			
			preparedStatement2.setString(1, "true");
			
			preparedStatement2.setInt(2, roomNumber);
			
			preparedStatement2.executeUpdate();
			
			PreparedStatement preparedStatement3 = connection.prepareStatement(query3);
			
			preparedStatement3.setInt(1, bookingId);
			
			preparedStatement3.executeUpdate();
			
			System.out.println("Room with Room no : " + roomNumber + " has been cancelled Successfully.\n");
			
		} 
		
		catch (Exception e) {

			System.out.println("Error : " + e.getMessage());			

		}
		
	}

}
