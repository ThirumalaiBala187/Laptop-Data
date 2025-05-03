package BackendAssignment002;

import java.util.Comparator;

public class PriceComparatorHTL implements Comparator<Product> {

	@Override
	public int compare(Product product1, Product product2) {
		
		return Integer.compare(product1.price, product2.price);
		
	}
	

}
