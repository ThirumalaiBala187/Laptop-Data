package BackendAssignment002;

abstract public class User {
	
	static int count = 1001;
	
	int userId;
	
	String name;
	
	String email;
	
	String password;

	public User(String name, String email, String password) {
		
		this.userId = count;
		
		this.name = name;
		
		this.email = email;
		
		this.password = password;
		
		count++;
		
	}
	
	public void setUserId() {
		
		this.userId = count;
		
		count++;
		
	}
	
	public int getUserId() {
		
		return userId;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setEmail(String email) {
		
		this.email = email;
		
	}
	
	public String getEmail() {
		
		return email;
		
	}
	
	public void setPassword(String password) {
		
		this.password = password;
		
	}
	
	public String getPassword() {
		
		return password;
		
	}
	
	abstract void viewDashboard();

}
