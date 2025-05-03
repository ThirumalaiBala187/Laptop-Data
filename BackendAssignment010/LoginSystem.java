package BackendAssignment010;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginSystem {
	
	static LoginSystem loginSystemObj;

	private LoginSystem() {
		// TODO Auto-generated constructor stub
	}
	
	static public LoginSystem getLoginObject() {
		
		if(loginSystemObj == null) {
			
			loginSystemObj = new LoginSystem();
			
		}
		
		return loginSystemObj;
		
	}
	
	public User loginSystem(String userName, String password) {
		
		String query = "Select * from Users where UserName = ? AND Password = ?";
		
		try(Connection connection = JDBCConnection.getConnection()) {
			
			PreparedStatement stmt = connection.prepareStatement(query);
			
			stmt.setString(1, userName);
			
			stmt.setString(2, password);
			
			ResultSet resultSet = stmt.executeQuery();
			
			if(resultSet.next()) {
					
				return new User(userName, password);				
				
			}
			
			else {
				
				System.out.println("Invalid Username or Password.");
				
				return null;
				
			}
			
		} 
		
		catch (Exception e) {

			System.out.println("Error : " + e.getMessage());

		}
		
		return null;			
		
	}

}
