package BackendAssignment002;

public class Customer extends User{
	
	double creditNumber;
	
	double UPIid;

	public Customer(String name, String email, String password) {
		
		super(name, email, password);
		
	}
	
	void viewDashboard() {
		
		System.out.println("\n----- Customer Dashboard -----\nWelcome Mr." + this.name + ".\nPress '1' to 'View' Product.\nPress '2' to 'Sort' Product by 'Name'.\nPress '3' to 'Sort' Product by 'Price'(Highest to Lowest).\nPress '4' to 'Sort' Product by 'Price'(Lowest to Highest).\nPress '5' to 'Sort' Product by 'Ratings' (Highest to Lowest).\nPress '6' to 'Sort' product by Ratings(Lowest to Highest).\nPress '7' to 'Sort' Product by 'Popularity'(Highest to Lowest).\nPress '8' to 'Sort' Product 'Popularity'(Lowest to Highest).\nPress '9' to 'Buy' Product.\nPress '10' to 'Exit'.");
		
	}
	
	public void buyProduct(Product product) {
		
		product.popularity++;
		
		System.out.println("You have successfully bought this product.");
		
	}

}
