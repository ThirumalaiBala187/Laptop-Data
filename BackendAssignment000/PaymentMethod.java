package BackendAssignment000;

public interface PaymentMethod {

	public void pay(double amount);

	public void refund(double amount);

	public boolean authenticate();

}
