package ShoppingCartSystem;

import java.io.IOException;

import java.util.Scanner;

import java.io.Console;

public class ShoppingCartManagement {

	static Scanner userInput = new Scanner(System.in);

	static DataManager dataManagerObj = new DataManager();

	static LoginSystem loginSystemObj = new LoginSystem();

	static User userObj = new User();

	static Manager managerObj = new Manager();

	static Console consoleObj = System.console();

	public static void main(String[] args) throws IOException {

		dataManagerObj.initializeProducts();

		dataManagerObj.initializeUsers();

		int optionSelected;

		printLogo();

		loop1: while (true) {

			System.out.println(Color.BLUE + Color.BOLD + "Hello Mr.User." + Color.REMOVE + Color.GREEN + "\nWhat do you want to do:\nPress 1 to SignUp(If you are new to ZohoKart).\nPress 2 to Login (If you already have an account).\nPress 3 to Exit" + Color.REMOVE);

			optionSelected = userInput.nextInt();

			userInput.nextLine();

			switch (optionSelected) {

				// To Signup

				case 1: {

					System.out.println("Please Enter your name : ");

					String name = userInput.nextLine();

					System.out.println("Please Enter your age : ");

					byte age = userInput.nextByte();

					userInput.nextLine();

					System.out.println("Please Enter your Gender : (M / F / Others)");

					String gender;

					loop17 :while(true){

						gender = userInput.nextLine();

						if(gender.equalsIgnoreCase("M")){

							gender = "Male";

							break loop17;
							
						}

						else if(gender.equalsIgnoreCase("F")){

							gender = "Female";

							break loop17;

						}

						else if(gender.equalsIgnoreCase("Others")){

							gender = "Others";

							break loop17;

						}

						else{

							System.out.println("Please select a vaild gender.");

						}

					}



					System.out.println("Please Enter your user name : ");

					String userName = userInput.nextLine();

					loop6: while (true) {

						for (User user : DataManager.getUsers()) {

							if ((user.userName).equals(userName)) {

								System.out.println("User name already exists. Please try another:");

								userName = userInput.nextLine();

								continue loop6;

							}

						}

						break;

					}

					System.out.println("Please set your password : ");

					char[] passwordArray = consoleObj.readPassword();

					String password = new String(passwordArray);

					System.out.println("Please confirm your password : ");

					char[] confirmPasswordArray = consoleObj.readPassword();

					String confirmPassword = new String(confirmPasswordArray);

					if (!password.equals(confirmPassword)) {

						while (true) {

							System.out.println("Please enter the correct password to confirm : ");

							confirmPasswordArray = consoleObj.readPassword();

							confirmPassword = new String(confirmPasswordArray);

							if (password.equals(confirmPassword)) {

								break;

							}

						}

					}

					String role = "Customer";

					Customer signUpedCustomer = new Customer(name, age, gender, userName, password, role, "*", "*", "*","", 0);

					loginSystemObj.signUp(signUpedCustomer);

					System.out.println("Welcome Mr." + signUpedCustomer.name + "! Your profile has been added succesfully.");

					userOptions(signUpedCustomer);

					break;

				}

				// To Login

				case 2: {

					System.out.println("Please Enter you username to Login : ");

					String userName = userInput.nextLine();

					System.out.println("Please Enter your password : ");

					char[] passwordArray = consoleObj.readPassword();

					String password = new String(passwordArray);

					User loginedUser = loginSystemObj.login(userName, password);

					if (loginedUser == null) {

						System.out.println("No user found with the given credentials. Please Enter valid details to Login.");

						continue;

					}

					else if (loginedUser != null) {

						System.out.println("You have logged in to your account successfully.");

						if (loginedUser instanceof Manager) {

							Manager loginedAs = (Manager) loginedUser;

							System.out.println(Color.BLUE + Color.BOLD + "Welcome back Admin " + loginedAs.name + "!"+ Color.REMOVE);

							loop2: while (true) {

								System.out.println(Color.GREEN + "\nWhat do you want to do ?\nPress 1 to view 'Top Selling Products'.\nPress 2 to view 'Most Liked Product'.\nPress 3 to 'Add' a new Product.\nPress 4 to check 'Product Availability'.\nPress 5 to 'Change' the Product price.\nPress 6 to 'Modify' the Prouct discount.\nPress 7 to 'Remove Product'.\nPress 8 to 'Exit'."+ Color.REMOVE);

								int choiceSelected = userInput.nextInt();

								if (choiceSelected == 8) {

									System.out.println("\nBye Admin! Catch you later!");

									userInput.nextLine();

									loginSystemObj.loginedUser = null;

									break loop2;

								}

								else if (choiceSelected == 1) {

									System.out.println("\n----- Top Selling Product -----\n");

									userObj.mostSelling();

								}

								else if (choiceSelected == 2) {

									System.out.println("\n----- Most Liked Product -----\n");

									userObj.mostLiked();

								}

								else if (choiceSelected == 3) {

									userInput.nextLine();

									System.out.println("\nEnter the product name : ");

									String productName = userInput.nextLine();

									System.out.println("Enter the product brand : ");

									String productBrand = userInput.nextLine();

									System.out.println("Enter the product category : ");

									String productCategory = userInput.nextLine();

									System.out.println("Enter the Product type / Sub-category of the product : ");

									String productType = userInput.nextLine();

									System.out.println("Enter the price of the product : ");

									int productPrice = userInput.nextInt();

									System.out.println("Enter the no.of quantities available for the product : ");

									byte productQuantity = userInput.nextByte();

									System.out.println("Enter the discount percentage (if available) for the product : ");

									double discountAmount = userInput.nextDouble();

									int noOfLikes = 0;

									byte quantitySold = 0;

									managerObj.addNewProduct(new Product(productName, productBrand, productCategory,productType, productPrice, productQuantity, discountAmount, noOfLikes,quantitySold));

								}

								else if (choiceSelected == 4) {

									selectProduct();

									System.out.println("\nPlease Enter the product Id to check its availability.");

									int productId = userInput.nextInt();

									System.out.println("\n----- Product Availability -----");

									managerObj.checkProductAvailability(productId);

								}

								else if (choiceSelected == 5) {

									selectProduct();

									System.out.println("\nPlease Enter the product Id to modify its price.");

									int productId = userInput.nextInt();

									System.out.println("\nEnter the new price for the product to update :");

									int newPrice = userInput.nextInt();

									managerObj.changePrice(productId, newPrice);

								}

								else if (choiceSelected == 6) {
									
									selectProduct();

									System.out.println("\nPlease Enter the Product Id to modify its discount");

									int productId = userInput.nextInt();

									System.out.println("\nEnter the new discount for the product to update :");

									int newDiscount = userInput.nextInt();

									managerObj.changeDiscount(productId, newDiscount);

								}

								else if (choiceSelected == 7) {

									selectProduct();

									System.out.println("\nPlease Enter the product Id to remove it from our shop.");

									int productId = userInput.nextInt();

									System.out.println(Color.GREEN + "Are you sure you want to remove this product from our shop :\nPress 'Y' to remove.\nPress 'N' to Cancel." + Color.REMOVE);

									String option = userInput.nextLine();

									if (option.equalsIgnoreCase("Y")) {

										managerObj.removeProduct(productId);

									}

									else if (!option.equalsIgnoreCase("N")) {

										System.out.println("Product removal cancelled successfully. The product still exists in our shop!\n");

									}

								}

							}

						}

						else if (loginedUser instanceof Customer) {

							Customer loginedAs = (Customer) loginedUser;

							System.out.println("Welcome Mr." + loginedAs.name + "!");

							userOptions(loginedAs);

						}

					}

					break;

				}

				default: {

					System.out.println("Thank you for visiting ZohoKart. See you later.");

					break loop1;

				}

			}

		}

	}



	static void selectProduct(){

		System.out.println(Color.GREEN + "\nWhich filter do you want to apply :\nPress 1 for 'Category'.\nPress 2 for 'Sub-Category'.\nPress 3 for 'Brand'.\nPress 4 for 'Price'." + Color.REMOVE);

		int choice = userInput.nextInt();

		if(choice == 1){

			userInput.nextLine();

			System.out.println("\nPlease Enter the category name to filter :");

			String catName = userInput.nextLine();

			managerObj.filterProducts("category",catName);

		}

		else if(choice == 2){

			userInput.nextLine();

			System.out.println("\nPlease Enter the Sub-Category Name/ Product Type to filter :");

			String subCatName = userInput.nextLine();

			managerObj.filterProducts("productType", subCatName);

		}

		else if(choice == 3){

			userInput.nextLine();

			System.out.println("\nPlease Enter the Brand name to filter :");

			String brandName = userInput.nextLine();

			managerObj.filterProducts("brand", brandName);

		}

		else if(choice == 4){

			System.out.println("\nPlease Enter the maximum price range you want to filter : ");

			int priceRange = userInput.nextInt();

			managerObj.filterByPrice(priceRange);

		}

	}



	static void printLogo(){

		System.out.println(Color.BLUE + "💴===============================💶\n" + "||                               ||\n" + "|| 💼                         💼 ||\n" + "||                               ||\n" + "|| 🎉" + Color.RED + "   Welcome to Zohokart!  🎉 " + Color.REMOVE + Color.BLUE + "||\n" + "||                               ||\n" + "|| 🛒                         🛒 ||\n" + "||                               ||\n" + "💵===============================💷\n" + Color.REMOVE);

	}




	static void userOptions(Customer customer) {

		loop3: while (true) {

			System.out.println(Color.GREEN+ "\nHow can we help you ?\nPress 1 to view 'Trending items' of the week.\nPress 2 to view 'Most Liked Product'.\nPress 3 to view 'Your favourites'\nPress 4 view 'Your orders'\nPress 5 to view your 'Cart'.\nPress 6 to search product by 'Name'.\nPress 7 to search product by 'Category number'.\nPress 8 to 'View/ Update your profile'\nPress 9 to 'Logout'"+ Color.REMOVE);

			int optionSelected = userInput.nextInt();

			if (optionSelected == 9) {

				System.out.println("Logout Successful. Thank you for visiting 'ZohoCart'. Catch you soon. Bye!");

				userInput.nextLine();

				loginSystemObj.loginedUser = null;

				break loop3;

			}

			else if (optionSelected == 1) {

				System.out.println("----- Trending items of the week -----\n");

				userObj.mostSelling();

			}

			else if (optionSelected == 2) {

				System.out.println("----- Most Liked Product -----\n");

				userObj.mostLiked();

			}

			else if (optionSelected == 3) {

				System.out.println("----- Your Favourites -----");

				customer.printLikedItems();

				if(customer.likedProduct.split("-").length>1){

					loop14: while(true){

						System.out.println(Color.GREEN + "Press 1 to Buy item from 'Liked Products' \nPress 2 to 'Unlike Products'.\nPress 3 to 'Exit'." + Color.REMOVE);
	
						optionSelected = userInput.nextInt();

						if(optionSelected == 3){

							System.out.println("Exitting....");

							break loop14;

						}

						else if(optionSelected == 1){

							loop15 : while ((true)) {

								System.out.println(Color.GREEN + "\nPress 1 to Buy a specific item from your favourites.\nPress 2 to Buy all items from your favourites.\nPress 3 to 'Exit" + Color.REMOVE);			
								
								optionSelected = userInput.nextInt();

								if(optionSelected == 3){

									System.out.println("Exitting....");

									break loop15;

								}

								else if(optionSelected == 1){

									System.out.println("Enter the product ID to buy it from your favourites.");

									int productId = userInput.nextInt();

									if(customer.mobileNumber == 0){

										userInput.nextLine();

										System.out.println("Please Enter your address in one-line.(Without commas) : ");

										String address = userInput.nextLine();

										customer.address = address;

										System.out.println("Please Enter your mobile number : ");

										long mobileNo = 0;

										loop12: while (true) {;

											mobileNo = userInput.nextLong();

											String noString = mobileNo + "";

											if (noString.length() == 10) {

												break loop12;

											}

											System.out.println("Please Enter a valid 10-digit mobile number.");

										}

										customer.buyProduct(DataManager.allProducts.get(productId-1001), address, mobileNo);
										
									}

									else{									

										customer.buyProduct(DataManager.allProducts.get(productId-1001));

									}

								}

								else if(optionSelected == 2){

									userInput.nextLine();

									System.out.println(Color.GREEN + "\nAre you sure you want to buy all the items in your favourites.\nPress 'Y' to Continue.\nPress 'N' to Exit." + Color.REMOVE);

									String choice = userInput.nextLine();

									if(choice.equalsIgnoreCase("Y")){

										if(customer.mobileNumber == 0){

											System.out.println("Please Enter your address in one-line.(Without commas) : ");

											String address = userInput.nextLine();

											customer.address = address;

											System.out.println("Please Enter your mobile number : ");

											long mobileNo = 0;

											loop12: while (true) {;

												mobileNo = userInput.nextLong();

												String noString = mobileNo + "";

												if (noString.length() == 10) {

													break loop12;

												}

												System.out.println("Please Enter a valid 10-digit mobile number.");

											}

											String[] likedArray = customer.likedProduct.split("-");

											for(int i=1;i<likedArray.length;i++){

												customer.buyProduct(DataManager.getProducts().get(Integer.parseInt(likedArray[i])-1001));

											}

											System.out.println("\nAll products has been bought from your favourites....");

											continue loop3;

										}

										else{

											String[] likedArray = customer.likedProduct.split("-");

											for(int i=1;i<likedArray.length;i++){

												customer.buyProduct(DataManager.getProducts().get(Integer.parseInt(likedArray[i])-1001));

											}

											System.out.println("\nAll products has been bought from your favourites....");

											continue loop3;

										}

									}

									else{

										System.out.println("Buying all products has been cancelled....");

										continue loop15;

									}

								}
								
							}

						}

						else if(optionSelected == 2){

							System.out.println(Color.GREEN + "Press '1' to unlike any specific item.\nPress '2' to Unlike all products.\nPress '3' to Exit." + Color.REMOVE);

							int choice = userInput.nextInt();

							if(choice == 3){

								System.out.println("Exitting....");

								continue loop14;

							}

							else if(choice == 1){

								System.out.println("Enter the product to unlike it.");
	
								int productID = userInput.nextInt();
	
								customer.unlike(productID);

								System.out.println("\nYour product has been successfully unliked.");
	
								System.out.println(Color.GREEN + "\nDo you want to 'unlike' any other product.\nPress 1 to 'Continue' : \nPress 2 to 'Exit'" + Color.REMOVE);
	
								optionSelected = userInput.nextInt();

							}

							else{

								userInput.nextLine();

								System.out.println(Color.GREEN + "Are you sure you want to unlike all products.\nPress 'Y' to Proceed.\nPress 'N' to Cancel" + Color.REMOVE);

								String option = userInput.nextLine();

								if(option.equalsIgnoreCase("Y")){

									String[] likedArray = customer.likedProduct.split("-");

									for(int i=1;i<likedArray.length;i++){

										customer.unlike(Integer.parseInt(likedArray[i]));

									}

									System.out.println("\nAll Products has been unliked successfully....");

									continue loop3;

								}

								else{

									System.out.println("Unliking all products has been cancelled....");

									continue loop14;

								}

							}

						}

					}
				
				}

			}

			else if (optionSelected == 4) {

				System.out.println("\n----- Your Orders -----");

				customer.printBuyedItems();

				if(customer.orderedProduct.split("-").length>1){

					System.out.println("Press 1 to 'Cancel Order' : \nPress 2 to 'Exit'");

					optionSelected = userInput.nextInt();

					loop13: while(true){

						if(optionSelected == 2){

							System.out.println("\nExitting ....");

							break loop13;

						}

						else if(optionSelected == 1){

							System.out.println("Enter the product Id to Cancel it.");

							int productID = userInput.nextInt();

							customer.returnProduct(productID);
												
							if(customer.orderedProduct.split("-").length>1){

								System.out.println(Color.GREEN + "\nDo you want to 'Cancel' any other product.\nPress 1 to 'Continue' : \nPress 2 to 'Exit'" + Color.REMOVE);
			
								optionSelected = userInput.nextInt();
			
							}

						}

					}
								
				}

			}

			else if (optionSelected == 5) {

				System.out.println("\n------------ Your Cart ------------");

				customer.printCartItems();

				if(customer.cart.split("-").length>1){

					loop14: while(true){

						System.out.println(Color.GREEN + "Press 1 to Buy item from 'Cart' \nPress 2 to Remove item from 'Cart'.\nPress 3 to 'Exit'." + Color.REMOVE);
	
						optionSelected = userInput.nextInt();

						if(optionSelected == 3){

							System.out.println("Exitting....");

							break loop14;

						}

						else if(optionSelected == 1){

							loop15 : while ((true)) {

								System.out.println(Color.GREEN + "\nPress 1 to Buy a specific item from Cart.\nPress 2 to Buy all items from the Cart.\nPress 3 to 'Exit" + Color.REMOVE);			
								
								optionSelected = userInput.nextInt();

								if(optionSelected == 3){

									System.out.println("Exitting....");

									break loop15;

								}

								else if(optionSelected == 1){

									System.out.println("Enter the product ID to buy it from the cart.");

									int productId = userInput.nextInt();

									if(customer.mobileNumber == 0){

										userInput.nextLine();

										System.out.println("Please Enter your address in one-line.(Without commas) : ");

										String address = userInput.nextLine();

										customer.address = address;

										System.out.println("Please Enter your mobile number : ");

										long mobileNo = 0;

										loop12: while (true) {;

											mobileNo = userInput.nextLong();

											String noString = mobileNo + "";

											if (noString.length() == 10) {

												break loop12;

											}

											System.out.println("Please Enter a valid 10-digit mobile number.");

										}

										customer.buyProduct(DataManager.allProducts.get(productId-1001), address, mobileNo);

										customer.removeCart(productId);
										
									}

									else{									

										customer.buyProduct(DataManager.allProducts.get(productId-1001));

										customer.removeCart(productId);

									}

								}

								else if(optionSelected == 2){

									userInput.nextLine();

									System.out.println(Color.GREEN + "\nAre you sure you want to buy all the items in the Cart.\nPress 'Y' to Continue.\nPress 'N' to Exit." + Color.REMOVE);

									String choice = userInput.nextLine();

									if(choice.equalsIgnoreCase("Y")){

										String[] cartArray = customer.cart.split("-");

										if(customer.mobileNumber == 0){

											System.out.println("Please Enter your address in one-line.(Without commas) : ");

											String address = userInput.nextLine();

											customer.address = address;

											System.out.println("Please Enter your mobile number : ");

											long mobileNo = 0;

											loop12: while (true) {;

												mobileNo = userInput.nextLong();

												String noString = mobileNo + "";

												if (noString.length() == 10) {

													break loop12;

												}

												System.out.println("Please Enter a valid 10-digit mobile number.");

											}

											for(int i=1;i<cartArray.length;i++){
	
												customer.buyProduct(DataManager.getProducts().get(Integer.parseInt(cartArray[i])-1001), address, mobileNo);
	
												customer.removeCart(Integer.parseInt(cartArray[i]));
	
											}

										}

										else{

											for(int i=1;i<cartArray.length;i++){

												customer.buyProduct(DataManager.getProducts().get(Integer.parseInt(cartArray[i])-1001));

												customer.removeCart(Integer.parseInt(cartArray[i]));

											}

										}

										System.out.println("\nAll products has been bought from the cart....");

										continue loop3;

									}

									else{

										System.out.println("Buying all products has been cancelled....");

										continue loop15;

									}

								}
								
							}

						}

						else if(optionSelected == 2){

							System.out.println(Color.GREEN + "Press '1' to remove any specific item from the cart.\nPress '2' to Empty Cart.\nPress '3' to Exit." + Color.REMOVE);

							int choice = userInput.nextInt();

							if(choice == 3){

								System.out.println("Exitting....");

								continue loop14;

							}

							else if(choice == 1){

								System.out.println("Enter the product Id to remove from cart.");
	
								int productID = userInput.nextInt();
	
								customer.removeCart(productID);
	
								System.out.println(Color.GREEN + "\nDo you want to 'remove' any other product from cart.\nPress 1 to 'Continue' : \nPress 2 to 'Exit'" + Color.REMOVE);
	
								optionSelected = userInput.nextInt();

							}

							else{

								userInput.nextLine();

								System.out.println(Color.GREEN + "Are you sure you want to Empty your cart.\nPress 'Y' to Empty.\nPress 'N' to Cancel" + Color.REMOVE);

								String option = userInput.nextLine();

								if(option.equalsIgnoreCase("Y")){

									String[] cartArray = customer.cart.split("-");

									for(int i=1;i<cartArray.length;i++){

										customer.removeCart(Integer.parseInt(cartArray[i]));

									}

									continue loop3;

								}

								else{

									System.out.println("Removing all products has been cancelled....");

									continue loop14;

								}

							}

						}

					}
				
				}

			}

			else if (optionSelected == 8) {

				System.out.println("What details do you want to update here");

				userObj.printUserDetails(customer);

				loop5: while (true) {

					System.out.println(Color.GREEN + "\nPress 1 to update 'Name'.\nPress 2 to update 'Age'.\nPress 3 to update 'Gender'.\nPress 4 to update 'Username'.\nPress 5 to update 'Password'\nPress 6 to 'Exit'." + Color.REMOVE);

					optionSelected = userInput.nextInt();

					if (optionSelected == 6) {

						break loop5;

					}

					else if (optionSelected == 1) {

						userInput.nextLine();

						System.out.println("Please Enter your new name to update : ");

						String nameToUpdate = userInput.nextLine();

						customer.updateProfile(optionSelected, nameToUpdate);

					}

					else if (optionSelected == 2) {

						userInput.nextLine();

						System.out.println("Please Enter your new age to update : ");

						String ageToUpdate = userInput.nextLine();

						customer.updateProfile(optionSelected, ageToUpdate);

					}

					else if (optionSelected == 3) {

						userInput.nextLine();

						System.out.println("Please Enter your gender to update : ");

						String genderToUpdate = userInput.nextLine();

						customer.updateProfile(optionSelected, genderToUpdate);

					}

					else if (optionSelected == 4) {

						userInput.nextLine();

						System.out.println("Please Enter your new user name to update : ");

						String userNameToUpdate = userInput.nextLine();

						customer.updateProfile(optionSelected, userNameToUpdate);

					}

					else if (optionSelected == 5) {

						userInput.nextLine();

						System.out.println("Please Enter your old password to update : ");

						char[] passwordArray = consoleObj.readPassword();

						String oldPassword = new String(passwordArray);

						if ((customer.password).equals(oldPassword)) {

							System.out.println("Please Enter your new password to confirm : ");

							passwordArray = consoleObj.readPassword();

							String newPassword = new String(passwordArray);

							customer.updateProfile(optionSelected, newPassword);

						}

						else {

							System.out.println("Failed to update password. Old password is wrong.");

						}

					}

					System.out.println("Do you want to update any other details");

				}

			}

			else if(optionSelected == 6){

				loop18 : while(true){

					selectProduct();

					System.out.println("Enter the product Id to visit");

					int productId = userInput.nextInt();

					Product selectedProduct = DataManager.allProducts.get(productId-1001);

					System.out.println(selectedProduct.toString());

					loop16: while(true){

						System.out.println(Color.GREEN + "\nDo you want to buy this product : \nPress 1 to 'Buy'\nPress 2 to 'Like'.\nPress 3 to 'Add to Cart'.\nPress 4 to 'Exit'.\nPress 5 to return to 'Main Menu'."+ Color.REMOVE);

						optionSelected = userInput.nextInt();

						if (optionSelected == 5) {

							System.out.println("Returning to the Main menu ...");

							continue loop3;

						}

						else if(optionSelected == 4){

							System.out.println("Please select any other product.");

							continue loop18;

						}

						else if (optionSelected == 1) {

							if(customer.mobileNumber != 0){

								selectedProduct.printBill();

								userInput.nextLine();

								System.out.println(Color.GREEN + "Are you sure you want to buy this product :\nPress 'Y' to continue\nPress 'N' to Cancel." + Color.REMOVE);

								String choice = userInput.nextLine();

								if (choice.equalsIgnoreCase("Y")) {

									customer.buyProduct(selectedProduct);

									System.out.println("Purchase Successful! Do you want to do anything else...");

									continue loop16;

								}

								else {

									System.out.println("Purchase cancelled....");

									continue loop16;
								}

							}

							else{

								userInput.nextLine();

								System.out.println("Please Enter your address in one-line.(Without commas) : ");

								String address = userInput.nextLine();

								customer.address = address;

								System.out.println("Please Enter your mobile number : ");

								long mobileNo = 0;

								loop12: while (true) {

									mobileNo = userInput.nextLong();

									String noString = mobileNo + "";

									if (noString.length() == 10) {

										break loop12;

									}

									System.out.println("Please Enter a valid 10-digit mobile number.");

								}

								userInput.nextLine();

								selectedProduct.printBill();

								System.out.println(Color.GREEN + "Are you sure you want to buy this product :\nPress 'Y' to continue\nPress 'N' to Cancel." + Color.REMOVE);

								String choice = userInput.nextLine();

								if (choice.equalsIgnoreCase("Y")) {

									customer.buyProduct(selectedProduct, address, mobileNo);

									System.out.println("Purchase Successful! Do you want to do anything else...");

									continue loop16;

								}

								else {

									System.out.println("Purchase cancelled....");

									continue loop16;
								}

							}
							
						}

						else if (optionSelected == 2) {

							customer.likeProduct(selectedProduct);
							
							System.out.println("Product Liked! Do you want to do anything else...");

							continue loop16;

						}

						else if (optionSelected == 3) {

							customer.addToCart(selectedProduct);

							System.out.println("Product Added to Cart! Do you want to do anything else...");

							continue loop16;
						}

					}

				}


			}

			else if (optionSelected == 7) {

				int categoryNum = 0;

				loop7: while (true) {

					System.out.println("\nPlease Enter the Category number you want to search products : ");

					dataManagerObj.printCategories();
					
					categoryNum = userInput.nextInt();

					loop8: while (true) {

						if (categoryNum == 0) {

							System.out.println("\nExitting ....");

							break loop7;

						}

						else if (categoryNum == 1) {

							System.out.println("\nReturning back to the Main menu ....");

							continue loop3;

						}

						else {

							int productTypeNum = 0;

							loop9: while (true) {

								System.out.println("\nSelect the product type you want to find in this category : ");

								dataManagerObj.printSubCategories(categoryNum - 2);productTypeNum = userInput.nextInt();

								if (productTypeNum == 0) {

									System.out.println("\nExitting ...");

									break loop8;

								}

								else if (productTypeNum == 1) {

									System.out.println("\nReturing to the Main menu ....");

									continue loop3;

								}

								else {
									
									int brandNum = 0;

									loop10: while (true) {

										System.out.println("\nSelect from the famous brands in this product : ");

										dataManagerObj.printAllBrands(productTypeNum - 2);brandNum = userInput.nextInt();

										if (brandNum == 0) {

											System.out.println("Returning to Product Type Selection...");

											break loop9;

										}

										else if (brandNum == 1) {

											System.out.println("Returning to the Main Menu...");

											continue loop3;

										}

										else {

											loop11: while (true) {

												Product selectedProduct = dataManagerObj.getAvailableProducts(categoryNum - 2, productTypeNum - 2, brandNum - 2);

												System.out.println(Color.GREEN + "\nPress 1 to 'View' its details.\nPress 2 to 'Select any other brand.\nPress 3 to 'Exit'."+ Color.REMOVE);

												optionSelected = userInput.nextInt();

												if (optionSelected == 1) {

													System.out.println(selectedProduct.toString());

													loop16: while(true){

														System.out.println(Color.GREEN + "\nDo you want to buy this product : \nPress 1 to 'Buy'\nPress 2 to 'Like'.\nPress 3 to 'Add to Cart'.\nPress 4 to 'Exit'"+ Color.REMOVE);

														optionSelected = userInput.nextInt();

														if (optionSelected == 4) {

															System.out.println("Returning to the Product Options ...");

															continue loop11;

														}

														else if (optionSelected == 1) {

															if(customer.mobileNumber != 0){

																selectedProduct.printBill();

																userInput.nextLine();

																System.out.println(Color.GREEN + "Are you sure you want to buy this product :\nPress 'Y' to continue\nPress 'N' to Cancel." + Color.REMOVE);

																String choice = userInput.nextLine();

																if (choice.equalsIgnoreCase("Y")) {

																	customer.buyProduct(selectedProduct);

																	System.out.println("Purchase Successful! Do you want to do anything else...");

																	continue loop16;

																}

																else {

																	System.out.println("Purchase cancelled....");

																	continue loop16;
																}

															}

															else{

																System.out.println("Please Enter your address in one-line.(Without commas) : ");

																String address = userInput.nextLine();

																customer.address = address;

																System.out.println("Please Enter your mobile number : ");

																long mobileNo = 0;

																loop12: while (true) {;

																	mobileNo = userInput.nextLong();

																	String noString = mobileNo + "";

																	if (noString.length() == 10) {

																		break loop12;

																	}

																	System.out.println("Please Enter a valid 10-digit mobile number.");

																}

																userInput.nextLine();

																selectedProduct.printBill();

																System.out.println("Are you sure you want to buy this product :\nPress 'Y' to continue\nPress 'N' to Cancel.");

																String choice = userInput.nextLine();

																if (choice.equalsIgnoreCase("Y")) {

																	customer.buyProduct(selectedProduct, address, mobileNo);

																	System.out.println("Purchase Successful! Do you want to do anything else...");

																	continue loop16;

																}

																else {

																	System.out.println("Purchase cancelled....");

																	continue loop16;
																}

															}
															
														}

														else if (optionSelected == 2) {

															customer.likeProduct(selectedProduct);
															
															System.out.println("Product Liked! Do you want to do anything else...");

															continue loop16;

														}

														else if (optionSelected == 3) {

															customer.addToCart(selectedProduct);

															System.out.println("Product Added to Cart! Do you want to do anything else...");

															continue loop16;
														}

													}

												}

												else if (optionSelected == 2) {
													
													System.out.println("Selecting another brand...");

													continue loop10;

												}

												else if (optionSelected == 3) {

													System.out.println("Exiting Brand Selection...");

													break loop10;

												}

											}

										}

									}

								}

							}

						}

					}

				}

			}

		}

	}

}
