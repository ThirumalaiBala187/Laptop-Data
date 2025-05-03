package BackendAssignment002;

public class Product implements Comparable<Product>{
	
	String productName;
	
	int price;
	
	double ratings;
	
	int popularity;

	public Product(String productName, int price, double ratings, int popularity) {
		
		this.productName = productName;
		
		this.price = price;
		
		this.ratings = ratings;
		
		this.popularity = popularity;
		
	}

	public String getProductName() {
		
		return productName;
		
	}

	public void setProductName(String productName) {
		
		this.productName = productName;
		
	}

	public int getPrice() {
		
		return price;
		
	}

	public void setPrice(int price) {
		
		this.price = price;
		
	}

	public double getRatings() {
		
		return ratings;
		
	}

	public void setRatings(byte ratings) {
		
		this.ratings = ratings;
		
	}

	public int getPopularity() {
		
		return popularity;
		
	}

	public void setPopularity(int popularity) {
		
		this.popularity = popularity;
		
	}
	
	@Override
	public String toString() {
		
		return "\n----- Product Details -----\nProduct Name : " + this.productName + "\nProduct Price : " + this.price + "\nProduct Ratings : " + this.ratings + "\nQuantities Sold : " + this.popularity + "\n";
		
	}

	@Override
	public int compareTo(Product product) {
		
		return this.productName.compareTo(product.productName);
		
	}
	
}
