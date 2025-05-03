package jdbc_Intro;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

public class JDBCMain {

	public static void main(String[] args) {
		
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ZSTTK26","root","bala@2627");
		
			Statement crStatement = connection.createStatement();
			
//			Statement prStatement = connection.prepareStatement("Select * from ");
			
			ResultSet resultSet = crStatement.executeQuery("Select * from Students");
			
			while (resultSet.next()) {
				
				System.out.println(resultSet.getString("First_Name"));
				
			}
			
			resultSet.close();
			
			crStatement.close();
			
			connection.close();
			
			
			
		}
		
		catch (SQLException e) {
		
			System.out.println("Error : " + e.getMessage());
		
		}

	}

}
