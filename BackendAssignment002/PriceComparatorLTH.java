package BackendAssignment002;

import java.util.Comparator;

public class PriceComparatorLTH implements Comparator<Product> {

	@Override
	public int compare(Product product1, Product product2) {
		
		return Integer.compare(product2.price, product1.price);
		
	}
	

}
