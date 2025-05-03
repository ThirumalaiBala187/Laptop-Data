package BackendAssignment000;

public class UPI {

	public void pay(double amount) {

		System.out.println("Paid $" + amount + " using UPI Successfully.");

	}

	public void refund(double amount) {

		System.out.println("Refunded $" + amount + " through UPI Successfully.");

	}

	public boolean authenticate() {

		System.out.println("UPI Successfully Authenticated.");

		return true;

	}

}
