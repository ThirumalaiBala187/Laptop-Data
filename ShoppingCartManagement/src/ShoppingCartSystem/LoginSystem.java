package ShoppingCartSystem;

import java.util.ArrayList;

public class LoginSystem {
	
	DataManager dataManagerObj = new DataManager();

	User loginedUser = null;

	public void signUp(User newUser){

		ArrayList<User> userArray = DataManager.getUsers();

		userArray.add(newUser);

		DataManager.saveUsers(userArray);

	}
	
	public User login(String givenName, String passcode) {

		ArrayList<User> usersList = DataManager.getUsers();
		
		for(User userObj : usersList) {
			
			if((userObj.userName).equals(givenName) && (userObj.password).equals(passcode)) {
				
				loginedUser = userObj;

				break;
				
			}
			
		}
		
		return loginedUser;
		
	}

}
