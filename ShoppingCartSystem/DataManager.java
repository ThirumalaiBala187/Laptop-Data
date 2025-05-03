package ShoppingCartSystem;

import java.io.*;
import java.util.*;

public class DataManager {

	private static final String USER_FILE_NAME = "UsersList.csv";

	private static final String PRODUCTS_FILE_NAME = "ProductsList.csv";

	//To get all the available users from the csv file......
	
	public static ArrayList<User> getUsers(){

		ArrayList<User> usersList = new ArrayList<>();
		
		File file = new File(USER_FILE_NAME);

		try (Scanner fileInput = new Scanner(file)) {

			String userLine = fileInput.nextLine();

			while (fileInput.hasNextLine()) {

				userLine = fileInput.nextLine();

				String[] inputUserDetailsArray = userLine.split(",");

				if(inputUserDetailsArray[5].equals("Admin")){

					usersList.add(new Manager(inputUserDetailsArray[0], Byte.parseByte(inputUserDetailsArray[1]), inputUserDetailsArray[2], inputUserDetailsArray[3], inputUserDetailsArray[4], inputUserDetailsArray[5]));

				}

				else{

					usersList.add(new Customer(inputUserDetailsArray[0], Byte.parseByte(inputUserDetailsArray[1]), inputUserDetailsArray[2], inputUserDetailsArray[3], inputUserDetailsArray[4], inputUserDetailsArray[5], inputUserDetailsArray[6], inputUserDetailsArray[7], inputUserDetailsArray[8], inputUserDetailsArray[9],Long.parseLong(inputUserDetailsArray[10])));
					
				}
					
			}
				
		}
			
		catch (IOException e) {

			System.out.println("Error in reading the user details from the user file.\n" + e.getMessage());
				
		}

		return usersList;

	}

	//To get all the available products from the csv file......

	public static ArrayList<Product> getProducts(){
     
		ArrayList<Product> productsList = new ArrayList<>();

		File file = new File(PRODUCTS_FILE_NAME);

		try(Scanner fileInput = new Scanner(file)) {

			String productLine = fileInput.nextLine();

			while(fileInput.hasNextLine()){

				productLine = fileInput.nextLine();

				if(productLine!=null){

					String[] inputProductDetailsArray = productLine.split(",");

					productsList.add(new Product(Integer.parseInt(inputProductDetailsArray[0]), inputProductDetailsArray[1], inputProductDetailsArray[2],inputProductDetailsArray[3],inputProductDetailsArray[4], Integer.parseInt( inputProductDetailsArray[5]), Byte.parseByte(inputProductDetailsArray[6]), Double.parseDouble(inputProductDetailsArray[7]), Integer.parseInt(inputProductDetailsArray[8]), Byte.parseByte(inputProductDetailsArray[9])));

				}
				
			}
				
		}
		
		catch (IOException e) {
				
			System.out.println("Error in reading products input the products file.\n" + e.getMessage());

		}

		return productsList;

	}

	
	//To modify the csv file with new updated details of the users......

	public static void saveUsers(ArrayList<User> userArray){

		try(FileWriter writer = new FileWriter(USER_FILE_NAME)){

			writer.write("Name,Age,Gender,UserName,Password,Role,Like Products,Ordered Products,Cart,Address,Mobile Number\n");

			for(User user : userArray){

				if(user instanceof Customer){

					Customer customer = (Customer) user;

					writer.write(customer.name + "," + customer.age + "," + customer.gender + "," + customer.userName + "," + customer.password + "," + customer.role + "," + customer.likedProduct + "," + customer.orderedProduct + "," + customer.cart + "," + customer.address + "," + customer.mobileNumber + "," + "\n");

				}

				else{

					writer.write(user.name + "," + user.age + "," + user.gender + "," + user.userName + "," + user.password + "," + user.role + "," + " " + "," + " " + "," + " " + "\n");

				}
				
			}

			System.out.println("Your User details has been added successfully.\n");

		}

		catch(IOException e){

			System.out.println("Error in adding your details : " + e.getMessage());

		}

	}

	//To modify the csv file with new updated details of the products......

	public static void saveProducts(ArrayList<Product> productArray){

		try(FileWriter writer = new FileWriter(PRODUCTS_FILE_NAME)){

			writer.write("Product ID,Product Name,Brand,Category,Product Type,Price,Available Quantity,Discount,No.of.Likes,Quantity Sold\n");

			for(Product product : productArray){

				writer.write(product.productId + "," + product.name + "," + product.brand + "," + product.category + "," + product.productType + "," + product.price + "," + product.availableQuantity + "," + product.discount + "," + product.noOfLikes + "," + product.quantitySold + "\n");
				
			}

			System.out.println("Your Product details has been updated successfully.");

		}

		catch(IOException e){

			System.out.println("Error in adding your details : " + e.getMessage());

		}

	}


	//To search a product......

	static ArrayList<Product> allProducts = DataManager.getProducts();

	static ArrayList<String> allCategories = new ArrayList<>();


	//To print all the available categories of the product......

	public void printCategories(){

		for(Product product : allProducts){

			if(!allCategories.contains(product.category)){

				allCategories.add(product.category);

			}
			
		}

		System.out.println("+-------------------------------------+");
		
		System.out.printf("%-2s %-5s %-2s %-25s %-2s %n", "|", "S.No", "|", "Available Categories","|");

		System.out.println("|--------|----------------------------|");

		System.out.printf("%-2s %-5s %-2s %-25s %-2s %n", "|", "0.", "|", "Exit", "|");

		System.out.printf("%-2s %-5s %-2s %-25s %-2s %n", "|", "1.", "|", "Main Menu", "|");

		System.out.println("|-------------------------------------|");

		for (int i = 0; i < allCategories.size(); i++) {
    
			System.out.printf("%-2s %-5s %-2s %-25s %-2s %n", "|", (i + 2) + ".", "|", allCategories.get(i), "|");

		}

		System.out.println("+-------------------------------------+");

	}

	static ArrayList<String> subCategories;


	//To print all the available Sub-category (Product-type) in the selected category......
	
	public void printSubCategories(int categorySelected){

		subCategories = new ArrayList<>();

		for(Product product : allProducts){

			if(((product.category).equals(allCategories.get(categorySelected))) && (!subCategories.contains(product.productType))){

				subCategories.add(product.productType);

			}

		}

		System.out.println("+-------------------------------------+");
		
		System.out.printf("%-2s %-5s %-2s %-25s %-2s %n", "|", "S.No", "|", "Product Types","|");

		System.out.println("|--------|----------------------------|");

		System.out.printf("%-2s %-5s %-2s %-25s %-2s %n", "|", "0.", "|", "Exit", "|");

		System.out.printf("%-2s %-5s %-2s %-25s %-2s %n", "|", "1.", "|", "Main Menu", "|");

		System.out.println("|-------------------------------------|");

		for (int i = 0; i < subCategories.size(); i++) {
    
			System.out.printf("%-2s %-5s %-2s %-25s %-2s %n", "|", (i + 2) + ".", "|", subCategories.get(i), "|");

		}

		System.out.println("+-------------------------------------+");

	}


	static ArrayList<String> allBrands;


	//To print all the available brands in the selected Sub-category......

	public void printAllBrands(int subCategorySelected){

		allBrands = new ArrayList<>();

		for(Product product : allProducts){

			if((product.productType).equals(subCategories.get(subCategorySelected)) && (!allBrands.contains(product.brand))){

				allBrands.add(product.brand);

			}

		}

		System.out.println("+-------------------------------------+");
		
		System.out.printf("%-2s %-5s %-2s %-25s %-2s %n", "|", "S.No", "|", "Available Brands","|");

		System.out.println("|--------|----------------------------|");

		System.out.printf("%-2s %-5s %-2s %-25s %-2s %n", "|", "0.", "|", "Exit", "|");

		System.out.printf("%-2s %-5s %-2s %-25s %-2s %n", "|", "1.", "|", "Main Menu", "|");

		System.out.println("|-------------------------------------|");

		for (int i = 0; i < allBrands.size(); i++) {
    
			System.out.printf("%-2s %-5s %-2s %-25s %-2s %n", "|", (i + 2) + ".", "|", allBrands.get(i), "|");

		}

		System.out.println("+-------------------------------------+");

	}


	//To print all the available products in the selected brand......

	public Product getAvailableProducts(int categorySelected,int subCategorySelected, int brandNum){

		Product selectedProduct = null;

		System.out.println("\n+------------------------------------------------------------------------------+");
		
		System.out.printf("%-2s %-58s %-2s %-10s %-2s %n", "|", "Product Name", "|", "Product Price","|");

		System.out.println("|------------------------------------------------------------------------------|");

		for(Product product : allProducts){

			if((product.category).equals(allCategories.get(categorySelected)) && (product.productType).equals(subCategories.get(subCategorySelected)) && (product.brand).equals(allBrands.get(brandNum))){

				System.out.printf("%-2s %-58s %-2s %-13s %-2s %n", "|", product.name, "|", product.price,"|");

				selectedProduct = product;

			}

		}

		System.out.println("+------------------------------------------------------------------------------+");

		return selectedProduct;

	}

	
	public void initializeUsers() {
		
		File file = new File(USER_FILE_NAME);
		
		if(!file.exists()){

			System.out.println("New file created to add users data.");

			ArrayList<User> usersArray = new ArrayList<>();

			usersArray.add(new Manager("Thirumalai", (byte)18, "Male", "balaprince187","bala@2627", "Admin"));

			usersArray.add(new Manager("Prabhu", (byte)23, "Male", "prabhu@bharanicandles123","prabhu@1234", "Admin"));
				
			usersArray.add(new Customer("Ragavan", (byte)19, "Male","Ragav187", "prncragav@2006","Customer","*","*","*"," ",0));
				
			usersArray.add(new Customer("Hari Ramanujam", (byte)18, "Male", "Hariram123","hram@2026","Customer","*","*","*"," ",0));
	
			saveUsers(usersArray);

		}

	}

	public void initializeProducts(){

		File file = new File(PRODUCTS_FILE_NAME);

		if(!file.exists()){		

			ArrayList<Product> productsArray = new ArrayList<>();

			//Electronics

			productsArray.add(new Product("LG 65-Inch 4K OLED TV", "LG", "Electronics", "TV", 124712, (byte)6, 7 , 0, (byte) 0));

			productsArray.add(new Product("Samsung 65-Inch QLED Smart TV", "Samsung","Electronics", "TV", 99717, (byte)5, 12 , 0, (byte) 0));

			productsArray.add(new Product("Apple iPhone16 Pro Titanium", "Apple","Electronics" ,"Smartphones", 98236, (byte)16, 6 , 0, (byte) 0));

			productsArray.add(new Product("Samsung Galaxy S23", "Samsung","Electronics", "Smartphones", 107617, (byte)19, 5 , 0, (byte) 0));

			productsArray.add(new Product("Oneplus 11 5G", "Oneplus","Electronics", "Smartphones", 64999, (byte)19, 10 , 0, (byte) 0));

			productsArray.add(new Product("Whirlpool 240L Double-Door Refrigerator", "Whirlpool", "Electronics", "Fridge", 26499, (byte)5, 12 , 0, (byte) 0));

			productsArray.add(new Product("LG 190L Single-Door Refrigerator", "LG", "Electronics", "Fridge", 19999, (byte)7, 10 , 0, (byte) 0));

			productsArray.add(new Product("Samsung Washing Machine", "Samsung", "Electronics", "Washing Machine", 33699, (byte)9, 5 , 0, (byte) 0));

			productsArray.add(new Product("Whirlpool Washing Machine", "Whirlpool", "Electronics", "Washing Machine", 19449, (byte)6, 8 , 0, (byte) 0));

			productsArray.add(new Product("LG Dishwasher", "LG", "Electronics", "Dishwasher", 17349, (byte)12, 12 , 0, (byte) 0));

			productsArray.add(new Product("Haier Dishwasher", "Haier", "Electronics", "Dishwasher", 29899, (byte)14, 7, 0, (byte) 0));

			productsArray.add(new Product("Apple MacBook Air M2","Apple","Electronics", "Laptops", 114900, (byte)3, 0, 0, (byte) 0));

			productsArray.add(new Product("Dell Inspiron 15","Dell","Electronics", "Laptops", 62499, (byte)5, 10 , 0, (byte) 0));

			productsArray.add(new Product("HP Pavilion x360","HP","Electronics", "Laptops", 72999, (byte)6, 7 , 0, (byte) 0));

			productsArray.add(new Product("Bose QuietComfort 45", "Bose", "Electronics", "Headphones", 27360, (byte)20, 7.5 , 0, (byte) 0));

			productsArray.add(new Product("Apple AirPods Pro (2nd Gen)", "Apple", "Electronics", "Headphones", 26900, (byte)10, 10 , 0, (byte) 0));

			productsArray.add(new Product("Sony WH-1000XM5 Noise Cancelling Headphones", "Sony", "Electronics", "Headphones", 29999, (byte)15, 10 , 0, (byte) 0));

			productsArray.add(new Product("Samsung Galaxy Watch 6", "Samsung", "Electronics", "Smartwatch", 34999, (byte)10, 12 , 0, (byte) 0));

			productsArray.add(new Product("Apple Watch Series 9", "Apple", "Electronics", "Smartwatch", 41900, (byte)8, 8 , 0, (byte) 0));

			productsArray.add(new Product("Xiaomi Mi Smart Band 6", "Xiaomi","Electronics", "Smartwatch", 3320, (byte)9, 15 , 0, (byte) 0));

			productsArray.add(new Product("Canon EOS R50 Mirrorless Camera", "Canon", "Electronics", "Camera", 86999, (byte)10, 10 , 0, (byte) 0));

			productsArray.add(new Product("Sony ZV-E10 Mirrorless Camera", "Sony", "Electronics", "Camera", 68999, (byte)7, 7 , 0, (byte) 0));

			productsArray.add(new Product("GoPro HERO12 Action Camera", "GoPro", "Electronics", "Camera", 49500, (byte)8, 5 , 0, (byte) 0));

			productsArray.add(new Product("Samsung Galaxy Tab S9", "Samsung", "Electronics", "Tablets", 79999, (byte)11, 5 , 0, (byte) 0));

			productsArray.add(new Product("Apple iPad Air (10.9-inch)", "Apple", "Electronics", "Tablets", 69900, (byte)8, 10 , 0, (byte) 0));

			productsArray.add(new Product("Amazon Fire HD 10", "Amazon", "Electronics", "Tablets", 15999, (byte)6, 15 , 0, (byte) 0));

			productsArray.add(new Product("LG 2.1 Channel Soundbar", "LG","Electronics", "Audio & Sound", 14917, (byte)35, 10 , 0, (byte) 0));

			productsArray.add(new Product("Epson EcoTank L3250 All-in-One Printer", "Epson","Electronics", "Printers", 14999, (byte)20, 8 , 0, (byte) 0));

			productsArray.add(new Product("HP LaserJet Pro MFP", "HP","Electronics", "Printers", 21999, (byte)25, 10 , 0, (byte) 0));

			productsArray.add(new Product("Canon PIXMA MG3070S", "Canon","Electronics", "Printers", 6999, (byte)12, 12 , 0, (byte) 0));

			productsArray.add(new Product("Sony PlayStation 5", "Sony", "Electronics", "Gaming Consoles", 53917, (byte)11, 5 , 0, (byte) 0));

			productsArray.add(new Product("Philips Steam Iron", "Philips", "Electronics", "Iron Box", 3320, (byte)10, 11 , 0, (byte) 0));

			productsArray.add(new Product("Preethi Zodiac Mixer Grinder", "Preethi","Electronics", "Kitchen Appliances", 12367, (byte)9, 12 , 0, (byte) 0));

			productsArray.add(new Product("Instant Vortex Plus Air Fryer", "Instant", "Electronics", "Kitchen Appliances", 11557, (byte)15, 10 , 0, (byte) 0));

			productsArray.add(new Product("Cuisinart 14-Cup Food Processor", "Cuisinart","Electronics", "Kitchen Appliances", 16832, (byte)11, 12 , 0, (byte) 0));

			productsArray.add(new Product("KitchenAid Stand Mixer", "KitchenAid", "Electronics", "Kitchen Appliances", 35687, (byte)5, 2 , 0, (byte) 0));


			//Books

			productsArray.add(new Product("The Alchemist", "HarperOne", "Books", "Fiction", 1413, (byte)10, 5 , 0, (byte) 0));

			productsArray.add(new Product("Man's Search for Meaning", "Beacon Press", "Books", "Philosophy", 914, (byte)5, 11 , 0, (byte) 0));

			productsArray.add(new Product("The Night Circus", "Vintage", "Books", "Fiction", 399, (byte)10, 20, 0, (byte)0));

			productsArray.add(new Product("It Ends with Us", "Simon & Schuster", "Books", "Fiction", 350, (byte)15, 15, 0, (byte)0));

			productsArray.add(new Product("The Silent Patient", "Celadon Books", "Books", "Mystery/Thriller", 450, (byte)12, 10, 0, (byte)0));

			productsArray.add(new Product("Gone Girl", "Crown Publishing", "Books", "Mystery/Thriller", 400, (byte)10, 12, 0, (byte)0));

			productsArray.add(new Product("A Game of Thrones", "Bantam Books", "Books", "Fantasy", 599, (byte)13, 10, 0, (byte)0));

			productsArray.add(new Product("The Hobbit", "HarperCollins", "Books", "Fantasy", 499, (byte)10, 15, 0, (byte)0));

			productsArray.add(new Product("Atomic Habits", "Penguin Random House", "Books", "Self-Help", 550, (byte)15, 0, 0, (byte)0));

			productsArray.add(new Product("The Power of Now", "New World Library", "Books", "Self-Help", 399, (byte)10, 10, 0, (byte)0));

			productsArray.add(new Product("Meditations", "Penguin Classics", "Books", "Philosophy", 299, (byte)5, 5, 0, (byte)0));

			productsArray.add(new Product("The Republic", "Hackett Publishing", "Books", "Philosophy", 350, (byte)10, 10, 0, (byte)0));

			productsArray.add(new Product("Steve Jobs", "Simon & Schuster", "Books", "Biography/Autobiography", 799, (byte)15, 8, 0, (byte)0));

			productsArray.add(new Product("Becoming", "Crown Publishing", "Books", "Biography/Autobiography", 599, (byte)10, 15, 0, (byte)0));

			productsArray.add(new Product("The Gruffalo", "Macmillan Children's Books", "Books", "Kids", 250, (byte)8, 10, 0, (byte)0));

			productsArray.add(new Product("Harry Potter and the Sorcerer's Stone", "Bloomsbury", "Books", "Kids", 450, (byte)7, 10, 0, (byte)0));

			productsArray.add(new Product("Sapiens: A Brief History of Humankind", "Penguin Random House", "Books", "Kids", 599, (byte)10, 0, 0, (byte)0));


			//Home and Kitchen

			productsArray.add(new Product("Tefal Non-Stick Fry Pan", "Tefal", "Home and Kitchen", "Cookware", 1599, (byte)5, 15, 0, (byte)0));

			productsArray.add(new Product("Prestige Induction Cooker", "Prestige", "Home and Kitchen", "Cookware", 5999, (byte)10, 20, 0, (byte)0));

			productsArray.add(new Product("Philips Induction Stove", "Philips", "Home and Kitchen", "Cookware", 5999, (byte)10, 20, 0, (byte)0));

			productsArray.add(new Product("Milton Airtight Storage Containers (Set of 10)", "Milton", "Home and Kitchen", "Kitchen Storage", 799, (byte)8, 12, 0, (byte)0));

			productsArray.add(new Product("Amazon Bamboo Drawer Organizer", "AmazonBasics", "Home and Kitchen", "Kitchen Storage", 1199, (byte)10, 10, 0, (byte)0));

			productsArray.add(new Product("IKEA Spice Rack", "IKEA", "Home and Kitchen", "Kitchen Storage", 999, (byte)5, 8, 0, (byte)0));

			productsArray.add(new Product("Philips 600W Hand Blender", "Philips", "Home and Kitchen", "Appliances", 1799, (byte)10, 10, 0, (byte)0));

			productsArray.add(new Product("Bajaj 3-in-1 Electric Griller", "Bajaj", "Home and Kitchen", "Appliances", 2799, (byte)15, 15, 0, (byte)0));

			productsArray.add(new Product("Cello 1.7L Electric Kettle", "Cello", "Home and Kitchen", "Appliances", 899, (byte)7, 5, 0, (byte)0));

			productsArray.add(new Product("Philips Air Fryer", "Philips", "Home and Kitchen", "Appliances", 6499, (byte)8, 20, 0, (byte)0));

			productsArray.add(new Product("Bosch Food Processor", "Bosch", "Home and Kitchen", "Small Appliances", 7499, (byte)6, 12, 0, (byte)0));

			productsArray.add(new Product("Black+Decker Coffee Maker", "Black+Decker", "Home and Kitchen", "Small Appliances", 2199, (byte)10, 10, 0, (byte)0));

			productsArray.add(new Product("Amazon Wooden Storage Cabinet", "Amazon Basics", "Home and Kitchen", "Furniture", 3299, (byte)15, 10, 0, (byte)0));

			productsArray.add(new Product("Seville Classics 3-Tier Rolling Cart", "Seville Classics", "Home and Kitchen", "Furniture", 2799, (byte)10, 12, 0, (byte)0));

			productsArray.add(new Product("Urban Ladder Office Chair", "Urban Ladder", "Home and Kitchen", "Furniture", 7499, (byte)12, 15, 0, (byte)0));

			productsArray.add(new Product("Amazon Microfiber Bed Sheet Set (King Size)", "AmazonBasics", "Home and Kitchen", "Bedding", 1199, (byte)10, 8, 0, (byte)0));

			productsArray.add(new Product("Wakefit Memory Foam Pillow", "Wakefit", "Home and Kitchen", "Bedding", 999, (byte)15, 10, 0, (byte)0));

			productsArray.add(new Product("Wipro LED Ceiling Light", "Wipro", "Home and Kitchen", "Lighting", 1499, (byte)12, 12, 0, (byte)0));

			productsArray.add(new Product("Philips Hue Table Lamp", "Philips Hue", "Home and Kitchen", "Lighting", 3199, (byte)8, 15, 0, (byte)0));

			productsArray.add(new Product("Long Cylindrical Candles", "Bharani Candles", "Home and Kitchen", "Candles", 199, (byte)40, 5, 0, (byte)0));

			productsArray.add(new Product("Designer Cup Candles", "Bharani Candles", "Home and Kitchen", "Candles", 399, (byte)30, 7, 0, (byte)0));

			productsArray.add(new Product("Godrej Decorative Wall Mirror", "Godrej Interio", "Home and Kitchen", "Decor", 2495, (byte)10, 10, 0, (byte)0));

			productsArray.add(new Product("Godrej Decorative Wall Mirror", "Godrej Interio", "Home and Kitchen", "Decor", 2495, (byte)10, 10, 0, (byte)0));


			//Fashion

			productsArray.add(new Product("Cotton Casual Shirt", "Peter England", "Fashion", "Men's Clothing", 1199, (byte)25, 20, 0, (byte)0));

			productsArray.add(new Product("Slim Fit Denim Jeans", "Levi's", "Fashion", "Men's Clothing", 2499, (byte)20, 25, 0, (byte)0));

			productsArray.add(new Product("Round Neck Graphic T-Shirt", "Puma", "Fashion", "Men's Clothing", 999, (byte)15, 15, 0, (byte)0));

			productsArray.add(new Product("A-Line Maxi Dress", "FabAlley", "Fashion", "Women's Clothing", 1799, (byte)20, 10, 0, (byte)0));

			productsArray.add(new Product("High-Waist Skinny Jeans", "H&M", "Fashion", "Women's Clothing", 1999, (byte)10, 15, 0, (byte)0));

			productsArray.add(new Product("Chiffon Floral Scarf", "Zara", "Fashion", "Women's Clothing", 699, (byte)12, 8, 0, (byte)0));

			productsArray.add(new Product("Boys' Cotton Polo T-Shirt", "U.S. Polo Assn.", "Fashion", "Kid's Clothing", 899, (byte)10, 12, 0, (byte)0));

			productsArray.add(new Product("Girls' Party Wear", "Max", "Fashion", "Kid's Clothing", 1499, (byte)14, 10, 0, (byte)0));

			productsArray.add(new Product("Unisex Hooded Sweatshirt", "TRENDS", "Fashion", "Kid's Clothing", 1199, (byte)15, 20, 0, (byte)0));

			productsArray.add(new Product("Running Shoes", "Nike", "Fashion", "Men's Footwear", 4299, (byte)30, 15, 0, (byte)0));

			productsArray.add(new Product("Leather Formal Shoes", "Bata", "Fashion", "Men's Footwear", 2499, (byte)35, 10, 0, (byte)0));

			productsArray.add(new Product("Casual Loafers", "Woodland", "Fashion", "Men's Footwear", 3199, (byte)27, 12, 0, (byte)0));

			productsArray.add(new Product("Ballet Flats", "Bata", "Fashion", "Women's Footwear", 999, (byte)25, 8, 0, (byte)0));

			productsArray.add(new Product("Heeled Sandals", "Catwalk", "Fashion", "Women's Footwear", 2199, (byte)20, 15, 0, (byte)0));

			productsArray.add(new Product("Sneakers", "Skechers", "Fashion", "Women's Footwear", 3499, (byte)43, 20, 0, (byte)0));

			productsArray.add(new Product("Chronograph Watch", "Fossil", "Fashion", "Men's Watches", 8999, (byte)13, 10, 0, (byte)0));

			productsArray.add(new Product("Digutal Watch", "Casio", "Fashion", "Men's Watches", 6499, (byte)15, 12, 0, (byte)0));

			productsArray.add(new Product("Rose Gold Analog Watch", "Titan Raga", "Fashion", "Women's Watches", 5799, (byte)17, 15, 0, (byte)0));

			productsArray.add(new Product("Bracelet Watch", "Michael Kors", "Fashion", "Women's Watches", 12999, (byte)15, 10, 0, (byte)0));

			productsArray.add(new Product("Leather Wallet", "Tommy Hilfiger", "Fashion", "Men's Accessories", 2199, (byte)35, 8, 0, (byte)0));

			productsArray.add(new Product("Aviator Sunglasses", "Ray-Ban", "Fashion", "Men's Accessories", 6999, (byte)25, 20, 0, (byte)0));

			productsArray.add(new Product("Tote Bag", "Lavie", "Fashion", "Women's Accessories", 2899, (byte)25, 15, 0, (byte)0));

			productsArray.add(new Product("Designer Clutch", "Hidesign", "Fashion", "Women's Accessories", 4999, (byte)30, 10, 0, (byte)0));

			productsArray.add(new Product("Kurta Set", "Manyavar", "Fashion", "Men's Ethnic Wear", 3999, (byte)20, 20, 0, (byte)0));

			productsArray.add(new Product("Cotton Nehru Jacket", "FabIndia", "Fashion", "Men's Ethnic Wear", 2999, (byte)17, 10, 0, (byte)0));

			productsArray.add(new Product("Embroidered Anarkali Suit", "Biba", "Fashion", "Women's Ethnic Wear", 5499, (byte)22, 15, 0, (byte)0));

			productsArray.add(new Product("Printed Saree with Blouse", "Sabyasachi", "Fashion", "Women's Ethnic Wear", 8999, (byte)15, 10, 0, (byte)0));

			productsArray.add(new Product("Leather Backpack", "Wildcraft", "Fashion", "Bags", 3199, (byte)45, 15, 0, (byte)0));

			productsArray.add(new Product("Waterproof Hiking Backpack", "American Tourister", "Fashion", "Bags", 6999, (byte)32, 20, 0, (byte)0));

			productsArray.add(new Product("Travel & Trekking Backpack", "Skybags", "Fashion", "Bags", 2299, (byte)24, 10, 0, (byte)0));


			//Cosmetics

			productsArray.add(new Product("Maybelline Liquid Foundation", "Maybelline", "Cosmetics", "Face Makeup", 599, (byte)27, 10, 0, (byte)0));

			productsArray.add(new Product("Lakme Compact Powder", "Lakme", "Cosmetics", "Face Makeup", 299, (byte)25, 8, 0, (byte)0));

			productsArray.add(new Product("Sugar Contour & Highlighter Palette", "Sugar Cosmetics", "Cosmetics", "Face Makeup", 849, (byte)20, 12, 0, (byte)0));

			productsArray.add(new Product("Loreal Waterproof Eyeliner", "Loreal Paris", "Cosmetics", "Eye Makeup", 699, (byte)23, 15, 0, (byte)0));

			productsArray.add(new Product("Maybelline Volumizing Mascara", "Maybelline", "Cosmetics", "Eye Makeup", 499, (byte)15, 10, 0, (byte)0));

			productsArray.add(new Product("Huda Eyeshadow Palette (All Shades)", "Huda Beauty", "Cosmetics", "Eye Makeup", 2199, (byte)20, 5, 0, (byte)0));

			productsArray.add(new Product("MAC Matte Lipstick", "MAC", "Cosmetics", "Lip Makeup", 1699, (byte)22, 8, 0, (byte)0));

			productsArray.add(new Product("Nykaa Liquid Lipstick", "Nykaa", "Cosmetics", "Lip Makeup", 599, (byte)35, 10, 0, (byte)0));

			productsArray.add(new Product("Nivea Lip Balm", "Nivea", "Cosmetics", "Lip Makeup", 199, (byte)28, 15, 0, (byte)0));

			productsArray.add(new Product("Luxury Perfume (100ml)", "Chanel", "Cosmetics", "Perfume", 29999, (byte)10, 15, 0, (byte)0));

			productsArray.add(new Product("Colorbar Nail Polish Set (Glossy Finish)", "Colorbar", "Cosmetics", "Nail Products", 499, (byte)26, 10, 0, (byte)0));

			productsArray.add(new Product("OPI Gel Nail Polish Remover", "OPI", "Cosmetics", "Nail Products", 999, (byte)22, 8, 0, (byte)0));

			productsArray.add(new Product("Garnier BB Cream", "Garnier", "Cosmetics", "Skin Care", 349, (byte)20, 10, 0, (byte)0));

			productsArray.add(new Product("Smashbox Primer", "Smashbox", "Cosmetics", "Skin Care", 3299, (byte)30, 5, 0, (byte)0));

			productsArray.add(new Product("Loreal Hair Serum", "Loreal Paris", "Cosmetics", "Hair Styling", 999, (byte)27, 15, 0, (byte)0));

			productsArray.add(new Product("Schwarzkopf Styling Hair Spray", "Schwarzkopf", "Cosmetics", "Hair Styling", 1299, (byte)32, 10, 0, (byte)0));

			productsArray.add(new Product("Gatsby Strong Hold Hair Gel", "Gatsby", "Cosmetics", "Hair Styling", 399, (byte)45, 10, 0, (byte)0));

			productsArray.add(new Product("Ustraa Matte Finish Hair Clay", "Ustraa", "Cosmetics", "Hair Styling", 499, (byte)43, 12, 0, (byte)0));

			productsArray.add(new Product("OGX Curl Defining Mousse", "OGX", "Cosmetics", "Hair Styling", 1099, (byte)31, 10, 0, (byte)0));

			productsArray.add(new Product("Livon Anti-Frizz Hair Cream", "Livon", "Cosmetics", "Hair Care", 599, (byte)27, 15, 0, (byte)0));

			productsArray.add(new Product("Tresemme Heat Protection Spray", "Tresemme", "Cosmetics", "Hair Care", 1099, (byte)23, 10, 0, (byte)0));


			//Health and Wellness

			productsArray.add(new Product("Dr.Trust Digital Thermometer", "Dr.Trust", "Health and Wealness", "Medical Devices" , 5499, (byte)18, 10, 0 , (byte)0));

			productsArray.add(new Product("Omron BP Monitor", "Omron", "Health and Wealness", "Medical Devices" , 2499, (byte)12, 15, 0 , (byte)0));

			productsArray.add(new Product("Beurer Pulse Oximeter", "Beurer", "Health and Wealness", "Medical Devices" , 1599, (byte)5, 20, 0 , (byte)0));

			productsArray.add(new Product("GNC Multivitamin Gummies", "GNC", "Health and Wealness", "Medical Devices" , 699, (byte)15, 12, 0 , (byte)0));

			productsArray.add(new Product("Muscle Blaze Protein Powder", "Muscle Blaze", "Health and Wealness", "Medical Devices" , 2499, (byte)18, 10, 0 , (byte)0));

			productsArray.add(new Product("Amazon Yoga Mat", "Amazon Basics", "Health and Wealness", "Medical Devices" , 999, (byte)13, 15, 0 , (byte)0));

			productsArray.add(new Product("Kore Dumbbell Set", "Kore", "Health and Wealness", "Fitness Equipments" , 2499, (byte)5, 8, 0 , (byte)0));

			productsArray.add(new Product("Organic IndiaHerbal Tea", "Organic India", "Health and Wealness", "Medical Devices" , 299, (byte)8, 12, 0 , (byte)0));

			productsArray.add(new Product("Dettol Hand Sanitizer", "Dettol", "Health and Wealness", "Personal Care" , 199, (byte)5, 10, 0 , (byte)0));
			
			productsArray.add(new Product("3M Face Mask (Pack of 10)", "3M", "Health and Wealness", "Medical Devices" , 499, (byte)12, 8, 0 , (byte)0));
			
			productsArray.add(new Product("Savlon Disinfectant Spray", "Savlon", "Health and Wealness", "Medical Devices" , 299, (byte)8, 10, 0 , (byte)0));

			productsArray.add(new Product("Caresmith Electric Massager", "Caresmith", "Health and Wealness", "Pain Releif" , 2999, (byte)5, 15, 0 , (byte)0));

			productsArray.add(new Product("Dr.Physio Heating Pad", "Dr.Physio", "Health and Wealness", "Pain Releif" , 1299, (byte)18, 8, 0 , (byte)0));
			
			productsArray.add(new Product("Morpheus Sleep Mask", "Morpheus", "Health and Wealness", "Relaxation" , 299, (byte)10, 5, 0 , (byte)0));


			//Toys and Games

			productsArray.add(new Product("Hot Wheels Track Builder", "Hot Wheels", "Toys and Games", "Vehicle Toys" , 999, (byte)12, 10, 0 , (byte)0));

			productsArray.add(new Product("Barbie Dreamhouse Doll Set", "Barbie", "Toys and Games", "Dolls" , 8999, (byte)18, 20, 0 , (byte)0));

			productsArray.add(new Product("NERF Elite Blaster", "NERF", "Toys and Games", "Action Toys" , 1499, (byte)15, 12, 0 , (byte)0));

			productsArray.add(new Product("Hasbro Monopoly Classic Board Game", "Hasbro", "Toys and Games", "Board Games" , 1199, (byte)5, 10, 0 , (byte)0));
			
			productsArray.add(new Product("Mattel UNO Card Game", "Mattel", "Toys and Games", "Card Games" , 299, (byte)10, 8, 0 , (byte)0));

			productsArray.add(new Product("Rastar Remote Control Car", "Rastar", "Toys and Games", "Remote-Controlled Toys" , 1599, (byte)12, 15, 0 , (byte)0));

			productsArray.add(new Product("Hamley's Teddy Bear", "Hamleys", "Toys and Games", "Stuffed Toys" , 2499, (byte)18, 10, 0 , (byte)0));

			productsArray.add(new Product("Funskool Junior Doctor Kit", "Funskool", "Toys and Games", "Role Play Toys" , 899, (byte)12, 8, 0 , (byte)0));		
			
			productsArray.add(new Product("Rubik's Cube 3x3", "Rubik's", "Toys and Games", "Puzzles" , 499, (byte)21, 10, 0 , (byte)0));

			productsArray.add(new Product("Funskool Chess Set", "Funskool", "Toys and Games", "Board Games" , 699, (byte)5, 8, 0 , (byte)0));
			
			productsArray.add(new Product("Casio Musical Keyboard for Kids", "Casio", "Toys and Games", "Musical Toys" , 2999, (byte)18, 15, 0 , (byte)0));


	    
			//Sports 

			productsArray.add(new Product("Yonex Badminton Racket Set", "Yonex", "Sports and Games", "Badminton" , 1499, (byte)15, 10, 0 , (byte)0));

			productsArray.add(new Product("MRF Cricket Bat", "MRF", "Sports and Games", "Cricket" , 2499, (byte)18, 20, 0 , (byte)0));
			
			productsArray.add(new Product("Adidas Football", "Adidas", "Sports and Games", "Football" , 799, (byte)12, 15, 0 , (byte)0));
			
			productsArray.add(new Product("Wilson Tennis Racket", "Wilson", "Sports and Games", "Tennis" , 2499, (byte)10, 18, 0 , (byte)0));
			
			productsArray.add(new Product("Nike Basketball", "Nike", "Sports and Games", "Basketball" , 1799, (byte)18, 10, 0 , (byte)0));

			productsArray.add(new Product("Callaway Golf Club Set", "Callaway", "Sports and Games", "Golf" , 19999, (byte)5, 15, 0 , (byte)0));
			
			productsArray.add(new Product("Strauss Skipping Rope", "Strauss", "Sports and Games", "Fitness Equipment" , 199, (byte)10, 10, 0 , (byte)0));
			
			productsArray.add(new Product("Healthgenie Exercise Cycle", "Healthgenie", "Sports and Games", "Fitness Equipment" , 5999, (byte)5, 20, 0 , (byte)0));
			
			productsArray.add(new Product("Stag Table Tennis Set", "Stag", "Sports and Games", "Indoor Games" , 13999, (byte)10, 15, 0 , (byte)0));

			productsArray.add(new Product("Super Carrom Board", "Super", "Sports and Games", "Indoor Games" , 1499, (byte)18, 10, 0 , (byte)0));

			productsArray.add(new Product("Hasbro Ludo Board Game", "Hasbro", "Sports and Games", "Indoor Games" , 499, (byte)10, 8, 0 , (byte)0));
			
			productsArray.add(new Product("Funskool Snake and Ladder Game", "Funskool", "Sports and Games", "Indoor Games" , 299, (byte)5, 12, 0 , (byte)0));

			productsArray.add(new Product("Nivia Badminton Net", "Nivia", "Sports and Games", "Badminton" , 999, (byte)10, 8, 0 , (byte)0));
			
			productsArray.add(new Product("Cosco Volleyball Net", "Cosco", "Sports and Games", "Volleyball" , 799, (byte)12, 10, 0 , (byte)0));
			
			productsArray.add(new Product("Toyshine Bowling Set", "Toyshine", "Sports and Games", "Indoor Games" , 1299, (byte)15, 12, 0 , (byte)0));


	        //Baby products

			productsArray.add(new Product("Johnson's Baby Soap", "Johnson's", "Baby Products", "Soap" , 199, (byte)15, 12, 0 , (byte)0));

			productsArray.add(new Product("Johnson's Baby Shampoo", "Johnson's", "Baby Products", "Shampoo" , 199, (byte)15, 12, 0 , (byte)0));

			productsArray.add(new Product("Pampers Baby Diapers (Pack of 40)", "Pampers", "Baby Products", "Diapers" , 799, (byte)10, 20, 0 , (byte)0));

			productsArray.add(new Product("Huggies Baby Wipes (Pack of 72)", "Huggies", "Baby Products", "Wipes" , 299, (byte)12, 15, 0 , (byte)0));

			productsArray.add(new Product("Pigeon Baby Lotion", "Pigeon", "Baby Products", "Lotion" , 299, (byte)8, 10, 0 , (byte)0));

			productsArray.add(new Product("Chicco Baby Carrier", "Chicco", "Baby Products", "Carrier" , 2499, (byte)5, 15, 0 , (byte)0));
			
			productsArray.add(new Product("LuvLap Baby Walker", "LuvLap", "Baby Products", "Wlaker" , 1299, (byte)15, 18, 0 , (byte)0));
			
			productsArray.add(new Product("Philips Baby Feeding Bottle", "Philips Avent", "Baby Products", "Accessories" , 578, (byte)12, 8, 0 , (byte)0));

			productsArray.add(new Product("Babyhug Baby Clothes Set (5 Pcs)", "Babyhug", "Baby Products", "Clothing" , 999, (byte)5, 20, 0 , (byte)0));

			productsArray.add(new Product("Mothercare Baby Socks (Pack of 5)", "Mothercare", "Baby Products", "Clothing" , 299, (byte)31, 10, 0 , (byte)0));
			
			productsArray.add(new Product("Pigeon Baby Nail Clippers", "Pigeon", "Baby Products", "Grooming" , 199, (byte)11, 8, 0 , (byte)0));
			
			productsArray.add(new Product("Curaprox Baby Toothbrush", "Curaprox", "Baby Products", "Oral Care" , 249, (byte)27, 5, 0 , (byte)0));
			
			productsArray.add(new Product("Graco Baby Car Seat", "Graco", "Baby Products", "Car Seat" , 6499, (byte)19, 15, 0 , (byte)0));


			//Groceries

			productsArray.add(new Product("Wheat Flour (5kg)", "Aashirvaad", "Groceries", "Flour", 229, (byte)15, 20, 0,(byte)0));

			productsArray.add(new Product("Sugar (1kg)", "Aashirvaad", "Groceries", "Sweeteners", 55, (byte)45, 5, 0,(byte)0));

			productsArray.add(new Product("Salt (1kg)", "Tata", "Groceries", "Salt", 18, (byte)50, 8, 0,(byte)0));
			
			productsArray.add(new Product("Cooking Oil (L)", "Fortune", "Groceries", "Oils", 185, (byte)40, 15, 0,(byte)0));
			
			productsArray.add(new Product("Ghee (500g)", "Amul", "Groceries", "Ghee", 229, (byte)30, 5, 0,(byte)0));
			
			productsArray.add(new Product("Soya Sauce (250ml)", "Kikkoman", "Groceries", "Sauces", 109, (byte)15, 3, 0,(byte)0));
			
			productsArray.add(new Product("Tomato Ketchup (500g)", "Heinz", "Groceries", "Sauces", 120, (byte)8, 4, 0,(byte)0));
			
			productsArray.add(new Product("Chilli Powder (100g)", "Everest", "Groceries", "Spices", 35, (byte)32, 8, 0,(byte)0));

			productsArray.add(new Product("Turmeric Powder (100g)", "MDH", "Groceries", "Spices", 45, (byte)30, 6, 0,(byte)0));
	        
			productsArray.add(new Product("Cumin Powder (100g)", "Tata Sampann", "Groceries", "Spices", 55, (byte)25, 0, 0,(byte)0));
			
			productsArray.add(new Product("Cardomom (50g)", "Tulsi", "Groceries", "Spices", 95, (byte)15, 4, 0,(byte)0));
			
			productsArray.add(new Product("Ginger-Garlic Paste (200g)", "Patanjali", "Groceries", "Pastes", 50, (byte)20, 0, 0,(byte)0));
			
			productsArray.add(new Product("Tamarind Paste (200g)", "Dabur", "Groceries", "Pastes", 85, (byte)17, 2, 0,(byte)0));

			productsArray.add(new Product("Toor Dal (1kg)", "Fortune", "Groceries", "Pulses", 95, (byte)25, 5, 0,(byte)0));

			productsArray.add(new Product("Moong Dal (1kg)", "Tata", "Groceries", "Pulses", 110, (byte)25, 3, 0,(byte)0));
			
			productsArray.add(new Product("Chana Dal (1kg)", "Aashirvaad", "Groceries", "Pulses", 120, (byte)25, 6, 0,(byte)0));

			productsArray.add(new Product("Dried Raisins (250g)", "Raisin Sun", "Groceries", "Dry Fruits", 199, (byte)15, 10, 0,(byte)0));

			productsArray.add(new Product("Cashews (200g)", "Kohinoor", "Groceries", "Dry Fruits", 350, (byte)24, 5, 0,(byte)0));

			productsArray.add(new Product("Almonds (200g)", "Sundrop", "Groceries", "Dry Fruits", 299, (byte)20, 10, 0,(byte)0));

			productsArray.add(new Product("Pistachios (200g)", "Nutraj", "Groceries", "Dry Fruits", 399, (byte)18, 8, 0,(byte)0));
			
			productsArray.add(new Product("Oats (1kg)", "Quaker", "Groceries", "Breakfast", 149, (byte)15, 3, 0,(byte)0));

			productsArray.add(new Product("Cornflakes (500g)", "Kellog's", "Groceries", "Breakfast", 199, (byte)12, 4, 0,(byte)0));

			productsArray.add(new Product("Toor Dal (1kg)", "Fortune", "Groceries", "Pulses", 95, (byte)10, 5, 0,(byte)0));

			productsArray.add(new Product("Honey (500g)", "Dabur", "Groceries", "Sweeteners", 210, (byte)17, 7, 0,(byte)0));
			
			productsArray.add(new Product("Peanut Butter (200g)", "Sundrop", "Groceries", "Snacks", 125, (byte)25, 10, 0,(byte)0));

			productsArray.add(new Product("Jam (200g)", "Kissan", "Groceries", "Snacks", 85, (byte)30, 5, 0,(byte)0));

			productsArray.add(new Product("Chili Sauce (250g)", "Ching's Secret", "Groceries", "Sauces", 99, (byte)10, 12, 0,(byte)0));

			productsArray.add(new Product("Mayonnaise (300g)", "Hellmann's", "Groceries", "Sauces", 175, (byte)15, 0, 0,(byte)0));

			productsArray.add(new Product("Green Peas (400g)", "Britannia", "Groceries", "Canned Foods", 70, (byte)12, 15, 0,(byte)0));

			productsArray.add(new Product("Coriander Powder (100g)", "MDH", "Groceries", "Spices", 45, (byte)32, 5, 0,(byte)0));

			productsArray.add(new Product("Chili Flakes (100g)", "Kashmir", "Groceries", "Spices", 50, (byte)24, 8, 0,(byte)0));
			
			productsArray.add(new Product("Black Pepper (100g)", "Everest", "Groceries", "Spices", 60, (byte)29, 12, 0,(byte)0));

			productsArray.add(new Product("Cumin Seeds (100g)", "Tata Sampann", "Groceries", "Spices", 55, (byte)17, 10, 0,(byte)0));

			productsArray.add(new Product("Mustard Seeds (100g)", "Tata Sampann", "Groceries", "Spices", 45, (byte)15, 2, 0,(byte)0));
			
			productsArray.add(new Product("Kashmiri Red Chili Powder (100g)", "MDH", "Groceries", "Spices", 70, (byte)42, 5, 0,(byte)0));
			
			productsArray.add(new Product("Basmati Rice (1kg)", "India Gate", "Groceries", "Rice", 199, (byte)26, 8, 0,(byte)0));
			
			productsArray.add(new Product("Tea Bags (100 count)", "Tata Tea", "Groceries", "Beverages", 249, (byte)19, 1, 0,(byte)0));
			
			productsArray.add(new Product("Instant Coffee (100g)", "Nescafe", "Groceries", "Beverages", 195, (byte)22, 7, 0,(byte)0));
			
			productsArray.add(new Product("Whole Wheat Pasta (500g)", "Barilla", "Groceries", "Pasta & Noodles", 149, (byte)15, 5, 0,(byte)0));

			productsArray.add(new Product("2-min Instant Noodles", "Maggi", "Groceries", "Pasta & Noodles", 70, (byte)25, 7, 0,(byte)0));
			
			productsArray.add(new Product("Baking Sode (200g)", "Baking Time", "Groceries", "Baking", 45, (byte)17, 3, 0,(byte)0));


			//Pet supplies

			productsArray.add(new Product("Pedigree Dog Food", "Pedigree", "Pet Supplies", "Dog Food" , 299, (byte)10, 0, 0 , (byte)0));

			productsArray.add(new Product("Whiskas Cat Food", "Pedigree", "Pet Supplies", "Cat Food" , 350, (byte)8, 2, 0 , (byte)0));
			
			productsArray.add(new Product("Himalaya Pet Shampoo", "Himalaya", "Pet Supplies", "Pet Care" , 130, (byte)12, 5, 0 , (byte)0));
			
			productsArray.add(new Product("Trixie Dog Collar", "Trixie", "Pet Supplies", "Dog Accessories" , 450, (byte)15, 10, 0 , (byte)0));
			
			productsArray.add(new Product("Dog Leash", "PetSafe", "Pet Supplies", "Dog Accessories" , 599, (byte)34, 10, 0 , (byte)0));
			
			productsArray.add(new Product("Petmate Pet Bed", "Petmate", "Pet Supplies", "Pet Bedding" , 899, (byte)41, 18, 0 , (byte)0));
			
			productsArray.add(new Product("Prevue Hendryx Bird Cage", "Prevue Hendryx", "Pet Supplies", "Bird Care" , 1999, (byte)12, 25, 0 , (byte)0));

			productsArray.add(new Product("Aqua One Fish Tank", "Aqua One", "Pet Supplies", "Fish Care" , 799, (byte)5, 13, 0 , (byte)0));
			
			productsArray.add(new Product("Midwest Rabbit Cage", "Midwest", "Pet Supplies", "Animal Care" , 2499, (byte)10, 18, 0 , (byte)0));

			productsArray.add(new Product("Vision Parrot Cage", "Vision", "Pet Supplies", "Bird Care" , 3499, (byte)7, 25, 0 , (byte)0));

			
			//Automotive

			productsArray.add(new Product("Formula 1 Car Dashboard Cleaner", "Formula 1", "Automotive", "Car Care" , 399, (byte)10, 2, 0 , (byte)0));

			productsArray.add(new Product("Meguiar's Car Wax", "Meguiar's", "Automotive", "Car Care" , 899, (byte)17, 0, 0 , (byte)0));
			
			productsArray.add(new Product("Black+Decker Tyre Inflator", "Black+Decker", "Automotive", "Car Accessories" , 1899, (byte)8, 10, 0 , (byte)0));
			
			productsArray.add(new Product("Autozone Car Seat Covers", "Autozone", "Automotive", "Car Accessories" , 1499, (byte)15, 18, 0 , (byte)0));

			productsArray.add(new Product("Ambi Pur Car Air Freshener", "Ambi Pur", "Automotive", "Car Accessories" , 299, (byte)10, 12, 0 , (byte)0));
			
			productsArray.add(new Product("Black+Decker Car Vacuum Cleaner", "Black+Decker", "Automotive", "Car Care" , 2499, (byte)5, 25, 0 , (byte)0));

			productsArray.add(new Product("Ecoshine Car Sunshade", "Ecoshine", "Automotive", "Car Accessories" , 699, (byte)8, 10, 0 , (byte)0));
			
			productsArray.add(new Product("Koolertron Car Seat Organizer", "Koolertron", "Automotive", "Car Accessories" , 799, (byte)23, 8, 0 , (byte)0));
			
			productsArray.add(new Product("Castrol Car Engine Oil", "Castrol", "Automotive", "Car Maintenance" , 599, (byte)60, 5, 0 , (byte)0));


			//Office and Stationeries

			productsArray.add(new Product("Parker Fountain Pen", "Parker", "Stationery", "Writing Instuments" , 599, (byte)40, 12, 0 , (byte)0));

			productsArray.add(new Product("Faber-Castell School Kit", "Faber-Castell", "Stationery", "Writing Instuments" , 349, (byte)35, 15, 0 , (byte)0));
			
			productsArray.add(new Product("B2B A4 paper (500 Sheets)", "B2B", "Stationery", "Paper", 250, (byte)55, 12, 0 , (byte)0));
			
			productsArray.add(new Product("Classmate Notebook (200 Pages)", "Classmate", "Stationery", "Notebooks" , 99, (byte)75, 10, 0 , (byte)0));
			
			productsArray.add(new Product("Post-it Sticky Notes (Pack of 5)", "Post-it", "Stationery", "Office Tools" , 175, (byte)43, 14, 0 , (byte)0));

			productsArray.add(new Product("Rorito Whiteboard Marker Set (4 Colors)", "Rorito", "Stationery", "Markers" , 350, (byte)25, 7, 0 , (byte)0));
			
			productsArray.add(new Product("Kangaroo Stapler", "Kangaroo", "Stationery", "Office Tools" , 400, (byte)40, 16, 0 , (byte)0));
			
			productsArray.add(new Product("Nataraj Paper Clips (Pack of 100)", "Nataraj", "Stationery", "Paper Clips" , 50, (byte)32, 10, 0 , (byte)0));
			
			productsArray.add(new Product("Faber-Castell Scissors (8 Inches)", "Faber-Castell", "Stationery", "Office Tools" , 120, (byte)373, 15, 0 , (byte)0));
			
			productsArray.add(new Product("Q-Connect File Folders (Pack of 10)", "Q-Connect", "Stationery", "Office Tools" , 255, (byte)30, 10, 0 , (byte)0));
			
			productsArray.add(new Product("HP Printer Ink (Black)", "HP", "Stationery", "Printing" , 1200, (byte)20, 18, 0 , (byte)0));
			
			productsArray.add(new Product("Casio Calculator", "Casio", "Stationery", "Office Tools" , 995, (byte)15, 5, 0 , (byte)0));
			
			productsArray.add(new Product("Rubbermaid Whiteboard (3x4 Feet)", "Rubbermaid", "Stationery", "Office Tools" , 2799, (byte)12, 3, 0 , (byte)0));
			
			productsArray.add(new Product("Fellowes Folders with Clip (Pack of 5)", "Fellowes", "Stationery", "Office Tools" , 299, (byte)25, 0, 0 , (byte)0));
			
			productsArray.add(new Product("Scotch Push Pins (Pack of 50)", "Scotch", "Stationery", "Office Tools" , 100, (byte)10, 10, 0 , (byte)0));

			productsArray.add(new Product("Camlin Envelope (Pack of 100)", "Camlin", "Stationery", "Envelopes" , 250, (byte)13, 2, 0 , (byte)0));
			
			productsArray.add(new Product("Stanley Paper Cutter", "Stanley", "Stationery", "Office Tools" , 450, (byte)8, 20, 0 , (byte)0));


			//Tools

			productsArray.add(new Product("Stanley Hammer (16oz)", "Stanley", "Tools", "Hand Tools" , 399, (byte)10, 16, 0 , (byte)0));

			productsArray.add(new Product("Dewalt Screwdriver Set (6 Pcs)", "Dewalt", "Tools", "Hand Tools" , 599, (byte)8, 3, 0 , (byte)0));
			
			productsArray.add(new Product("Komelon Measuring Tape", "Komelon", "Tools", "Measuring Tools" , 199, (byte)15, 10, 0 , (byte)0));
			
			productsArray.add(new Product("Bosch Electric Drill Machine", "Bosch", "Tools", "Power Tools" , 2499, (byte)12, 5, 0 , (byte)0));
			
			productsArray.add(new Product("Stanley Utility Knife", "Stanley", "Tools", "Hand Tools" , 150, (byte)100, 5, 0 , (byte)0));
			
			productsArray.add(new Product("Knipex Plier Set (4 Pcs)", "Knipex", "Tools", "Hand Tools" , 799, (byte)16, 16, 0 , (byte)0));
			
			productsArray.add(new Product("Stanley Toolbox (Large)", "Stanley", "Tools", "Storage Tools" , 999, (byte)25, 4, 0 , (byte)0));
			
			productsArray.add(new Product("Krause Ladder (6 Feet)", "Krause", "Tools", "Climbing Tools" , 1599, (byte)30, 10, 0 , (byte)0));


			//Jewelry

			productsArray.add(new Product("Tanishq Diamond Necklace", "Tanishq", "Jewelry", "Necklaces" , 299999, (byte)7, 2, 0 , (byte)0));
			
			productsArray.add(new Product("Cartier Gold Earrings", "Cartier", "Jewelry", "Earrings" , 149999, (byte)10, 3, 0 , (byte)0));

			productsArray.add(new Product("Bvlgari Platinum Ring", "Bvlgari", "Jewelry", "Rings" , 247899, (byte)12, 5, 0 , (byte)0));

			productsArray.add(new Product("Van Cleef Emerald Bracelet", "Van Cleef & Arples", "Jewelry", "Bracelets" , 199999, (byte)15, 2, 0 , (byte)0));

	        productsArray.add(new Product("Mikimoto Pearl Necklace", "Mikimoto", "Jewelry", "Necklaces" , 156599, (byte)8, 0, 0 , (byte)0));

			productsArray.add(new Product("Rolex Gold Watch", "Rolex", "Jewelry", "Watches" , 699999, (byte)30, 12, 0 , (byte)0));

			productsArray.add(new Product("Diamond Stud Earrings", "Harry Winston", "Jewelry", "Earrings" , 796599, (byte)15, 2, 0 , (byte)0));
			
			productsArray.add(new Product("Chopard Sapphire Ring", "Chopard", "Jewelry", "Rings" , 349999, (byte)25, 5, 0 , (byte)0));
			
			productsArray.add(new Product("Pandora Silver Anklet", "Pandora", "Jewelry", "Anklets" , 59999, (byte)20, 8, 0 , (byte)0));

			productsArray.add(new Product("Tanishq Pearl Necklace Set", "Tanishq", "Jewelry", "Necklaces" , 22899, (byte)23, 10, 0 , (byte)0));
			
			productsArray.add(new Product("CaratLane Gold-Plated Drop Earrings", "CaratLane", "Jewelry", "Earrings" , 14699, (byte)22, 5, 0 , (byte)0));


			//Smart home

			productsArray.add(new Product("Nest Smart Thermostat", "Nest", "Smart Home", "Home Automation" , 12999, (byte)10, 15, 0 , (byte)0));

			productsArray.add(new Product("Philips Smart Light Bulb", "Philips", "Smart Home", "Lighting" , 3499, (byte)8, 20, 0 , (byte)0));
			
			productsArray.add(new Product("August Smart Door Lock", "August", "Smart Home", "Home Security" , 9999, (byte)12, 25, 0 , (byte)0));
			
			productsArray.add(new Product("Ring Smart Security Camera", "Ring", "Smart Home", "Home Security" , 7999, (byte)25, 10, 0 , (byte)0));
			
			productsArray.add(new Product("Amazon Echo Smart Speaker", "Amazon Echo", "Smart Home", "Audio & Video" , 6489, (byte)20, 25, 0 , (byte)0));
			
			productsArray.add(new Product("iRobot Automatic Vacuum Cleaner", "iRobot Roomba", "Smart Home", "Cleaning" , 24899, (byte)8, 5, 0 , (byte)0));

			productsArray.add(new Product("Haier Robot Floor Cleaner", "Haier", "Smart Home", "Cleaning" , 66499, (byte)6, 3, 0 , (byte)0));

			productsArray.add(new Product("Ring Smart Doorbell", "Ring", "Smart Home", "Home Security" , 4999, (byte)12, 20, 0 , (byte)0));

			productsArray.add(new Product("Nest Smart Smoke Detector", "Nest Protect", "Smart Home", "Home Safety" , 8499, (byte)10, 12, 0 , (byte)0));
			
			productsArray.add(new Product("Lutron Smart Curtain", "Lutron", "Smart Home", "Home Automation" , 14999, (byte)15, 18, 0 , (byte)0));
			
			productsArray.add(new Product("Dyson Smart Air Purifier", "Dyson", "Smart Home", "Appliances" , 21999, (byte)8, 18, 0 , (byte)0));


			//Travel Accessories

			productsArray.add(new Product("Samsonite Luggage Set", "Samsonite", "Travel Accessories", "Luggage" , 12999, (byte)10, 15, 0 , (byte)0));
			
			productsArray.add(new Product("Cabeau Travel Pillow", "Cabeou", "Travel Accessories", "Comfort" , 2999, (byte)8, 20, 0 , (byte)0));
			
			productsArray.add(new Product("Bose Noise Cancelling Headphones", "Bose", "Travel Accessories", "Audio" , 16999, (byte)12, 25, 0 , (byte)0));
			
			productsArray.add(new Product("Anker Portable Charger", "Anker", "Travel Accessories", "Electronics" , 2499, (byte)8, 18, 0 , (byte)0));
			
			productsArray.add(new Product("Zendure Travel Adapter", "Zendure", "Travel Accessories", "Electronics" , 1799, (byte)15, 10, 0 , (byte)0));
			
			productsArray.add(new Product("Bellroy Travel Wallet", "Bellroy", "Travel Accessories", "Comfort" , 4999, (byte)18, 12, 0 , (byte)0));

			productsArray.add(new Product("Osprey Foldable Backpack", "Osprey", "Travel Accessories", "Outdoor" , 1999, (byte)14, 18, 0 , (byte)0));
			
			productsArray.add(new Product("Cocoon Compact Travel Blanket", "Cocoon", "Travel Accessories", "Luggage" , 1299, (byte)15, 8, 0 , (byte)0));
			
			productsArray.add(new Product("Hydro Flask Portable Water Bottle", "Hydro Flask", "Travel Accessories", "Outdoor" , 2499, (byte)8, 15, 0 , (byte)0));

			productsArray.add(new Product("Nomatic Travel Backpack", "Nomatic", "Travel Accessories", "Luggage" , 9999, (byte)12, 25, 0 , (byte)0));


			//Movies

			productsArray.add(new Product("Bose Blu-ray Player", "Bose", "Movies", "Blu-ray & DVD Players" , 8999, (byte)15, 10, 0 , (byte)0));

			productsArray.add(new Product("Sony Home Theater System", "Sony", "Movies", "Audio Systems" , 25999, (byte)12, 15, 0 , (byte)0));
			
			productsArray.add(new Product("DVD Player", "LG", "Movies", "Blu-ray & DVD Players" , 2999, (byte)18, 10, 0 , (byte)0));
			
			productsArray.add(new Product("JBL Soundbar", "JBL", "Movies", "Audio Systems" , 7499, (byte)10, 12, 0 , (byte)0));
	        
			productsArray.add(new Product("Epson Projector EB-E01", "Epson", "Movies", "Projectors" , 19999, (byte)8, 20, 0 , (byte)0));

			productsArray.add(new Product("Samsumg 4K Blu-ray Player", "Samsung", "Movies", "Blu-ray & DVD Players" , 11999, (byte)10, 15, 0 , (byte)0));

			productsArray.add(new Product("Vizio 5.1 Channel Soundbar", "Vizio", "Movies", "Audio Systems" , 15449, (byte)13, 8, 0 , (byte)0));

			productsArray.add(new Product("BenQ 1080p Projector", "BenQ", "Movies", "Projectors" , 22499, (byte)6, 7, 0 , (byte)0));


			//Gaming systems

			productsArray.add(new Product("Sony PlayStation 5 Console", "Sony", "Video Games", "Consoles" , 49999, (byte)10, 15, 0 , (byte)0));

			productsArray.add(new Product("Microsoft Zbox Wireless Co troller", "Microsoft", "Video Games", "Accessories" , 4999, (byte)13, 12, 0 , (byte)0));
			
			productsArray.add(new Product("Minecraft for PS4", "Sony", "Video Games", "Games" , 2499, (byte)5, 15, 0 , (byte)0));
			
			productsArray.add(new Product("Razer Gaming Headset", "Razer", "Video Games", "Accessories" , 6499, (byte)10, 25, 0 , (byte)0));
			
			productsArray.add(new Product("Logitech Gaming Mouse", "Logitech", "Video Games", "Accessories" , 2499, (byte)15, 10, 0 , (byte)0));

			saveProducts(productsArray);

		}
		
	}

}

