package BackendAssignment002;

public interface PaymentMethod {
	
	public void pay(double amount);
	
	public boolean authenticate(double id);

}
