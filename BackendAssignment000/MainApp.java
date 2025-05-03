package BackendAssignment000;

public class MainApp {

	public static void main(String[] args) {

		System.out.println("----- Admin Id -----");

		Admin admin = new Admin(1001, "Thirumalai", "thirumalai187@gmail.com");

		System.out.println("\nAdmin Logging in...");

		admin.login();

		System.out.println("\nViewing Admin's dashboard...");

		admin.viewDashboard();

		System.out.println("\nAdmin Logging out...");

		admin.logout();

		System.out.println("\n----- Customer Id -----");

		Customer customer = new Customer(1002, "Bala", "balaprince718@gmail.com");

		System.out.println("\nCustomer Logging in...");

		customer.login();

		System.out.println("\nViewing Customer's dashboard...");

		customer.viewDashboard();

		System.out.println("\nCustomer Logging out...");

		customer.logout();

		System.out.println("\nCustomer Placing an order...");

		customer.placeOrder();

		System.out.println("\nCustomer Cancelling the order...");

		customer.cancelOrder();

		System.out.println("\nCustomer Tracking the order...");

		customer.trackOrder();

		System.out.println("\n----- Credit Card Transaction -----");

		CreditCard credit = new CreditCard();

		System.out.println("\nPayment using Credit card...");

		credit.pay(10000);

		System.out.println("\nRefunding to the Credit card...");

		credit.refund(10000);

		System.out.println("\nAuthenticating the Credit card...");

		credit.authenticate();

		System.out.println("\n----- UPI Transaction -----");

		UPI upi = new UPI();

		System.out.println("\nPayment using UPI...");

		upi.pay(12345);

		System.out.println("\nRefunding to the UPI Account...");

		upi.refund(12345);

		System.out.println("\nAuthenticating the UPI Account...");

		upi.authenticate();

	}

}
