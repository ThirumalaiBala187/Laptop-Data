package ShoppingCartSystem;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class JDBCConnector {
	
	static Connection jdbcConnection;
	
	static private String url = "jdbc:mysql://localhost:3306/Shopping_Cart";
	
	static private String userName = "root";
	
	static private String password = "bala@2627";

	public JDBCConnector() {	
		
		
	}
	
	static public Connection getConnection() {
		
		try {
			
			if(jdbcConnection == null || jdbcConnection.isClosed()) {
				
				jdbcConnection = DriverManager.getConnection(url, userName, password);
				
			}
		
		}
		
		catch (SQLException e) {
			
			System.out.println(e.getMessage());

		}
		
		return jdbcConnection;
		
	}

}
