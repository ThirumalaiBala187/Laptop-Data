package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {
	private static final String url="jdbc:mysql://localhost:3306/ZohoCart";
	private static final String user="root";
	private static final String password="bala@2627";
	private static Connection jdbcConnection;
	
	public static Connection getConnection() {
		try {
			if(jdbcConnection==null || jdbcConnection.isClosed()) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				jdbcConnection= DriverManager.getConnection(url, user, password);
			}
		} 
		catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return jdbcConnection;
	}	
}
