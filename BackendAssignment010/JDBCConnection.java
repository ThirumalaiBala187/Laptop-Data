package BackendAssignment010;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class JDBCConnection {
	
	static private String url = "jdbc:mysql://localhost:3306/HotelBookings";
	
	static private String user = "root";
	
	static private String password = "bala@2627";
	
	static private Connection connection;
	
	static public Connection getConnection() throws SQLException {
		
		if(connection == null || connection.isClosed()) {
		
			try {
	
				connection = DriverManager.getConnection(url, user, password);
		
			}
			
			catch(SQLException e) {
				
				System.out.println(e.getMessage());
				
			}
		
		}
		
		return connection;
		
	}

}
