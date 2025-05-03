package Zoho_Music;

import java.util.ArrayList;

public class LoginSystem {
	
	User loginedAs = null;
	
	DataManager dataManager = new DataManager();
	
	ArrayList<User> availableUsers = dataManager.availableUsers;

	public User login(String userName, String password) {
		
		for(User user : availableUsers) {
			
			if(user.userName.equals(userName) && user.password.equals(password)) {
				
				loginedAs = user;
				
			}
			
		}
		
		return loginedAs;
		
	}
	
}
