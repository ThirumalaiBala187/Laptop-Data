package BackendAssignment002;

import java.util.ArrayList;

public class Login {
	
	static ArrayList<User> users = new ArrayList<>();
	
	public static User login(String email, String password) {
		
		User userObj = null;
		
		for(User user : users) {
			
			if(user.email.equals(email) && user.password.equals(password)) {
				
				System.out.println(user.name + " Logged in.");
				
				userObj = user;	
				
				break;
			
			}
			
		}
		
		return userObj;
		
	}
	
	public static void logout(User user) {
		
		System.out.println(user.name + " Logged out Successfully.");
		
	}

}
