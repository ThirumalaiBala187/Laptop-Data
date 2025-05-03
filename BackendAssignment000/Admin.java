package BackendAssignment000;

public class Admin extends User {

	public Admin(int userId, String name, String email) {

		super(userId, name, email);

	}

	public void viewDashboard() {

		System.out.println("Admin Dashboard.");

	}

}
