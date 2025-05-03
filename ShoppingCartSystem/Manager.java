package ShoppingCartSystem;

import java.util.ArrayList;

public class Manager extends User{

    Manager(){

        //To create an object to call a method.

    }

    Manager(String name, byte age, String gender, String userName, String password, String role){

        super(name, age, gender, userName, password, role);

    }

    ArrayList<Product> productArray = DataManager.getProducts();

	public void addNewProduct(Product newProduct){

		productArray.add(newProduct);

		DataManager.saveProducts(productArray);

	}

    void checkProductAvailability(int productId){

		System.out.println(productArray.get(productId-1001).toString());

		System.out.println("Remaining stock quantity : " + productArray.get(productId-1001).availableQuantity + "\n");

	}


    //Filter products

	public void filterProducts(String filterType, String catName){

		String category = catName.substring(0,1).toUpperCase() + catName.substring(1).toLowerCase();

		System.out.printf("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n");

		System.out.printf("%-2s %-143s %-2s%n","|", "\t\t\t\t\t\t\t----- Available Products in this " + filterType + " -----", "|");

		System.out.printf("|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");

		System.out.printf("%-2s %-10s %-2s %-45s %-2s %-25s %-2s %-25s %-2s %-25s %-2s %-10s %-2s %-10s %-2s %-10s %-2s%n","|", "Product Id", "|", "Product Name", "|", "Category", "|", "Sub-Category", "|", "Brand", "|", "Price", "|", "Discount", "|", "Final Price", "|");

		System.out.printf("|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");

		for(Product product: DataManager.getProducts()){

			if(filterType.equalsIgnoreCase("category")){

				if(product.category.contains(category)){

					renderProduct(product);				

				}

			}

			else if(filterType.equalsIgnoreCase("productType")){

				if(product.productType.contains(category)){

					renderProduct(product);				

				}

			}

			else if(filterType.equalsIgnoreCase("brand")){

				if(product.brand.contains(category)){

					renderProduct(product);				

				}

			}

		}
		
	}

	//To filter by price

	public void filterByPrice(int priceRange){

		System.out.printf("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n");

		System.out.printf("%-2s %-143s %-2s%n","|", "\t\t\t\t\t\t\t----- Available Products in this Price-range -----", "|");

		System.out.printf("|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");

		System.out.printf("%-2s %-10s %-2s %-45s %-2s %-25s %-2s %-25s %-2s %-25s %-2s %-10s %-2s %-10s %-2s %-10s %-2s%n","|", "Product Id", "|", "Product Name", "|", "Category", "|", "Sub-Category", "|", "Brand", "|", "Price", "|", "Discount", "|", "Final Price", "|");

		System.out.printf("|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");

		for(Product product: DataManager.getProducts()){

			if(product.price <= priceRange){

				renderProduct(product);				

			}

		}
		
	}


	// To print a product in tabular column

	static void renderProduct(Product product){
				
		System.out.printf("%-2s %-10s %-2s %-45s %-2s %-25s %-2s %-25s %-2s %-25s %-2s %-10s %-2s %-10s %-2s %-11s %-2s%n","|", product.productId, "|", product.name, "|", product.category, "|", product.productType, "|", product.brand, "|", product.price, "|", product.discount, "|", String.format("%.2f", product.price-(product.price*(product.discount/100))) , "|");

		System.out.printf("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n");

		
	}


	void changePrice(int productId, int newPrice){

		ArrayList<Product> availableProducts = DataManager.getProducts();

		availableProducts.get(productId-1001).setPrice(newPrice);

		System.out.println("Price has been updated for the given product.");

		DataManager.saveProducts(availableProducts);

	}


	void changeDiscount(int productId, double newDiscount){

		ArrayList<Product> availableProducts = DataManager.getProducts();

		availableProducts.get(productId-1001).setDiscount(newDiscount);

		System.out.println("Discount has been updated for the given product.");
		
		DataManager.saveProducts(availableProducts);

	}


	void removeProduct(int productID){
		
		productArray.remove(productID-1001);

		Product.productIdCounter--;

		DataManager.saveProducts(productArray);

		System.out.println("Product has been successfully removed from our shop.\n");

	}
    
}
