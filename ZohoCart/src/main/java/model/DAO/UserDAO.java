package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.DTO.User;
import model.DTO.User.Gender;

public class UserDAO {
	public static User addUser (String name, String userName, String password, String mobile, Date DOB, Gender gender, String authtype) {
		int userId=0;
		try(Connection connection = JDBCConnector.getConnection()){
			String query = "Insert into Users (Name, DOB, Gender, User_Name, Password_Hash, Mobile_Number, Role_Id) values (?,?,?,?,?,?,?)";
			PreparedStatement stmt=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,  name);
			stmt.setDate(2, DOB);
			stmt.setString(3, gender.toString());
			stmt.setString(4,  userName);
			stmt.setString(5, PasswordUtil.HashPassword(password));
			stmt.setString(6, mobile);
			stmt.setInt(7, 2);
			int rowsInserted = stmt.executeUpdate();
			
			if(rowsInserted > 0) {
				ResultSet rs=stmt.getGeneratedKeys();
				if(rs.next()) {
					userId=rs.getInt(1);
					return new User(userId, name, DOB, gender, userName, password, mobile, 1, authtype);					
				}
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static User getUser(String userName, String password) {
		try(Connection connection = JDBCConnector.getConnection()) {
			String passwordQuery = "Select Password_Hash from Users where User_Name = ?";
			PreparedStatement passwordStmt=connection.prepareStatement(passwordQuery);
			passwordStmt.setString(1, userName);
			ResultSet passwordRs=passwordStmt.executeQuery();
			if(passwordRs.next()) {
				String storedHash=passwordRs.getString("Password_Hash");
				if(PasswordUtil.ValidatePassword(password, storedHash)) {
					String userQuery = "Select * from Users where User_Name = ?";
					PreparedStatement userStmt=connection.prepareStatement(userQuery);
					userStmt.setString(1, userName);
					ResultSet userRs=userStmt.executeQuery();
					if(userRs.next()) {
						return new User(userRs.getInt("User_Id"), userRs.getString("Name"), userRs.getDate("DOB"), User.Gender.valueOf(userRs.getString("Gender")), userRs.getString("User_Name"), userRs.getString("Password_Hash"), userRs.getString("Mobile_Number"), userRs.getInt("Role_Id"), userRs.getString("Auth_Type"));						
					}
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;	
	}
		
		
	public static User getUser(String userName) {
		try(Connection connection = JDBCConnector.getConnection()) {
			String passwordQuery = "Select * from Users where User_Name = ?";
			PreparedStatement userStmt=connection.prepareStatement(passwordQuery);
			userStmt.setString(1, userName);
			ResultSet userRs=userStmt.executeQuery();
			if(userRs.next()) {
				return new User(userRs.getInt("User_Id"), userRs.getString("Name"), userRs.getDate("DOB"), User.Gender.valueOf(userRs.getString("Gender")), userRs.getString("User_Name"), userRs.getString("Password_Hash"), userRs.getString("Mobile_Number"), userRs.getInt("Role_Id"), userRs.getString("Auth_Type"));						
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
