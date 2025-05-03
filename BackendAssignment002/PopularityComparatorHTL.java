package BackendAssignment002;

import java.util.Comparator;

public class PopularityComparatorHTL implements Comparator<Product>{

	@Override
	public int compare(Product product1, Product product2) {
		
		return Integer.compare(product1.popularity, product2.popularity);
		
	}

}
