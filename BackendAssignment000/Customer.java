package BackendAssignment000;

public class Customer extends User implements OrderActions {

	public Customer(int userId, String name, String email) {

		super(userId, name, email);

	}

	public void viewDashboard() {

		System.out.println("Customer Dashboard.");

	}

	public void placeOrder() {

		System.out.println("Order placed successfully.");

	}

	public void cancelOrder() {

		System.out.println("Order cancelled successfully.");

	}

	public void trackOrder() {

		System.out.println("Order tracked successfully.");

	}

}
