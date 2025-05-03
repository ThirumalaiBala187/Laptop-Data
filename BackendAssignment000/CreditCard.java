package BackendAssignment000;

public class CreditCard implements PaymentMethod {

	public void pay(double amount) {

		System.out.println("Paid $" + amount + " using Credit Card Successfully.");

	}

	public void refund(double amount) {

		System.out.println("Refunded $" + amount + " to Credit Card Successfully.");

	}

	public boolean authenticate() {

		System.out.println("Credit Card Successfully Authenticated.");

		return true;

	}

}
