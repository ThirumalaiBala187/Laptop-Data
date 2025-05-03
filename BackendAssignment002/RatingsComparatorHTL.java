package BackendAssignment002;

import java.util.Comparator;

public class RatingsComparatorHTL implements Comparator<Product> {
	
	public int compare(Product product1, Product product2) {
		
		return Double.compare(product1.ratings, product2.ratings);
		
	}

}
