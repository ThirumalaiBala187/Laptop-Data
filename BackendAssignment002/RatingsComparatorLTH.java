package BackendAssignment002;

import java.util.Comparator;

public class RatingsComparatorLTH implements Comparator<Product> {
	
	public int compare(Product product1, Product product2) {
		
		return Double.compare(product2.ratings, product1.ratings);
		
	}

}
