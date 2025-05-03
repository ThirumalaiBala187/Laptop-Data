package ShoppingCartSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Manager extends User implements UserInterface {
	
	static Connection jdbConnection = JDBCConnector.getConnection();

    Manager(){

        //To create an object to call a method.

    }
    
    // To create a Manager Object

    Manager(String name, byte age, Gender gender, String userName, String password, int role, String mobileNumber){

        super(name, age, gender, userName, password, role, mobileNumber);

    }

    
    // To add a User
	
	public static void addUser(User user) {
		
		String addProductValues = "Insert into Users (Name, Age, Gender, User_Name , Password, Mobile_Number, RoleId) values (?, ?, ?, ?, ?, ?, ?) ";
		
		PreparedStatement preparedStatement; 
		
		try {
			
			preparedStatement = jdbConnection.prepareStatement(addProductValues);
			
			preparedStatement.setString(1, user.getName());
			
			preparedStatement.setByte(2, user.getAge());
			
			preparedStatement.setString(3, user.getGender().toString());
		
			preparedStatement.setString(4, user.getUserName() );
			
			preparedStatement.setString(5, user.getPassword());
			
			preparedStatement.setString(6, user.getMobileNumber());	
			
			if(user instanceof Manager) {
			
				preparedStatement.setInt(7, 1);
			
			}
			
			else {
				
				preparedStatement.setInt(7, 2);	;
				
			}
			
			preparedStatement.executeUpdate();
		
		}
		
		catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	
	// To add a Product
	
	public static void addProducts(Product product) {
		
		String addProductValues = "Insert into Products (Product_Name, Category_Id, SubCategory_Id, Brand_Id , Price, Availabile_Quantity , Discount , No_Of_Likes , Quantity_Sold)  select ?, Category.Category_Id, SubCategory.SubCategory_Id, Brands.Brand_Id ,?, ? ,?, ? , ? FROM Category, SubCategory, Brands where Category.Category_Name = ? AND SubCategory.SubCategory_Name = ? AND Brands.Brand_Name = ? AND NOT EXISTS (Select 1 from Products WHERE Products.Product_Name = ?)";
		
		PreparedStatement preparedStatement;
		
		try {
			
			preparedStatement = jdbConnection.prepareStatement(addProductValues);
			
			preparedStatement.setString(1, product.name);
			
			preparedStatement.setInt(2, product.price);
			
			preparedStatement.setInt(3, product.availableQuantity);
			
			preparedStatement.setDouble(4, product.discount);
			
			preparedStatement.setInt(5, product.noOfLikes);
			
			preparedStatement.setInt(6, product.quantitySold);
			
			preparedStatement.setString(7, product.category);
			
			preparedStatement.setString(8, product.productType);
			
			preparedStatement.setString(9, product.brand);
			
			preparedStatement.setString(10, product.name);
			
			preparedStatement.executeUpdate();	
		
		}
		
		catch (SQLException e) {
			
			System.out.println(e.getMessage());
		
		}
		
	}

	@Override
	void viewDashboard() {
		
		System.out.println("\nWhat do you want to do ?\n(1) => Top Selling Products'.\n(2) => 'Most Liked Product'.\n(3) => Add a new 'User'.\n(4) => Add a new 'Product'.\n(5) =>  Check 'Product Availability'.\n(6) => 'Modify' Product price.\n(7) => 'Modify' the Prouct discount.\n(8) => 'Remove Product'.\nPress 9 to 'Exit'.\n");
		
	}

	@Override
	void printUserDetails() {
		
		System.out.println("----- Admin Details -----\nAdmin Name : " + name + ".\nAdmin age : " + age + ".\nGender : " + gender + ".\nUser_Name : " + userName + ".\nPassword : " + "*".repeat(password.length()) + ".\nMobile Number : " + mobileNumber + ".\n");
		
	}

	@Override
	public void mostSelling() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostLiked() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBio() {
		// TODO Auto-generated method stub
		
	}
	

//    ArrayList<Product> productArray = DataManager.getProducts();
//
//	public void addNewProduct(Product newProduct){
//
//		productArray.add(newProduct);
//
//		DataManager.saveProducts(productArray);
//
//	}
//
//    void checkProductAvailability(int productId){
//
//		System.out.println(productArray.get(productId-1001).toString());
//
//		System.out.println("Remaining stock quantity : " + productArray.get(productId-1001).availableQuantity + "\n");
//
//	}


    //Filter products

//	public void filterProducts(String filterType, String catName){
//
//		String category = catName.substring(0,1).toUpperCase() + catName.substring(1).toLowerCase();
//
//		System.out.printf("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n");
//
//		System.out.printf("%-2s %-143s %-2s%n","|", "\t\t\t\t\t\t\t----- Available Products in this " + filterType + " -----", "|");
//
//		System.out.printf("|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");
//
//		System.out.printf("%-2s %-10s %-2s %-45s %-2s %-25s %-2s %-25s %-2s %-25s %-2s %-10s %-2s %-10s %-2s %-10s %-2s%n","|", "Product Id", "|", "Product Name", "|", "Category", "|", "Sub-Category", "|", "Brand", "|", "Price", "|", "Discount", "|", "Final Price", "|");
//
//		System.out.printf("|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");
//
//		for(Product product: DataManager.getProducts()){
//
//			if(filterType.equalsIgnoreCase("category")){
//
//				if(product.category.contains(category)){
//
//					renderProduct(product);				
//
//				}
//
//			}
//
//			else if(filterType.equalsIgnoreCase("productType")){
//
//				if(product.productType.contains(category)){
//
//					renderProduct(product);				
//
//				}
//
//			}
//
//			else if(filterType.equalsIgnoreCase("brand")){
//
//				if(product.brand.contains(category)){
//
//					renderProduct(product);				
//
//				}
//
//			}
//
//		}
//		
//	}
//
//	//To filter by price
//
//	public void filterByPrice(int priceRange){
//
//		System.out.printf("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n");
//
//		System.out.printf("%-2s %-143s %-2s%n","|", "\t\t\t\t\t\t\t----- Available Products in this Price-range -----", "|");
//
//		System.out.printf("|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");
//
//		System.out.printf("%-2s %-10s %-2s %-45s %-2s %-25s %-2s %-25s %-2s %-25s %-2s %-10s %-2s %-10s %-2s %-10s %-2s%n","|", "Product Id", "|", "Product Name", "|", "Category", "|", "Sub-Category", "|", "Brand", "|", "Price", "|", "Discount", "|", "Final Price", "|");
//
//		System.out.printf("|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");
//
//		for(Product product: DataManager.getProducts()){
//
//			if(product.price <= priceRange){
//
//				renderProduct(product);				
//
//			}
//
//		}
//		
//	}
//
//
//	// To print a product in tabular column
//
//	static void renderProduct(Product product){
//				
//		System.out.printf("%-2s %-10s %-2s %-45s %-2s %-25s %-2s %-25s %-2s %-25s %-2s %-10s %-2s %-10s %-2s %-11s %-2s%n","|", product.productId, "|", product.name, "|", product.category, "|", product.productType, "|", product.brand, "|", product.price, "|", product.discount, "|", String.format("%.2f", product.price-(product.price*(product.discount/100))) , "|");
//
//		System.out.printf("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n");
//
//		
//	}
//
//
//	void changePrice(int productId, int newPrice){
//
//		ArrayList<Product> availableProducts = DataManager.getProducts();
//
//		availableProducts.get(productId-1001).setPrice(newPrice);
//
//		System.out.println("Price has been updated for the given product.");
//
//		DataManager.saveProducts(availableProducts);
//
//	}
//
//
//	void changeDiscount(int productId, double newDiscount){
//
//		ArrayList<Product> availableProducts = DataManager.getProducts();
//
//		availableProducts.get(productId-1001).setDiscount(newDiscount);
//
//		System.out.println("Discount has been updated for the given product.");
//		
//		DataManager.saveProducts(availableProducts);
//
//	}
//
//
//	void removeProduct(int productID){
//		
//		productArray.remove(productID-1001);
//
//		Product.productIdCounter--;
//
//		DataManager.saveProducts(productArray);
//
//		System.out.println("Product has been successfully removed from our shop.\n");
//
//	}
    
}
