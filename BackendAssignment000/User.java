package BackendAssignment000;

public abstract class User {

	int userId;

	String name;

	String email;

	public User(int userId, String name, String email) {

		this.userId = userId;

		this.name = name;

		this.email = email;

	}

	public void setUserId(int userId) {

		this.userId = userId;

	}

	public int getUserId() {

		return this.userId;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getName() {

		return this.name;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public String getEmail() {

		return email;

	}

	public void login() {

		System.out.println(this.name + " Logged in Successfully.");

	}

	public void logout() {

		System.out.println(this.name + " Logged out Successfully.");

	}

	abstract void viewDashboard();

}
