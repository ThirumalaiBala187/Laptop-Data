package BackendAssignment002;

public class CreditCard implements PaymentMethod {

	@Override
	public void pay(double amount) {
		
		System.out.println("Amount $" + amount + " has been successfully paid using Credit card.");
		
	}

	@Override
	public boolean authenticate(double creditId) {
		
		long integerPart = (long) creditId;
		
		String creditString = String.valueOf(integerPart).trim();
		
		if(creditString.length() == 16) {
			
			return true;
			
		}
		
		return false;
	}

}
