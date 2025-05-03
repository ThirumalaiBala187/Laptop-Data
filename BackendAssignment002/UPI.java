package BackendAssignment002;

public class UPI implements PaymentMethod{

	@Override
	public void pay(double amount) {
		
		System.out.println("Amount $" + amount + " has been successfully paid using UPI.");
		
	}

	@Override
	public boolean authenticate(double UPIId) {
		
		long integerPart = (long) UPIId;
		
		String upiString = String.valueOf(integerPart).trim();
		
		if(upiString.length() >= 8 && upiString.length() <= 10) {
			
			return true;
			
		}
		
		return false;
	}

}
