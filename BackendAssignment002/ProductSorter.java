package BackendAssignment002;

import java.util.Arrays;

import java.util.Scanner;

public class ProductSorter{

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		Product product1 = new Product("Samsung QLED Smart TV",124712, 4.5, 17);
		
		Product product2 = new Product("Apple iPhone16 Pro Titanium",98236, 4.7, 25);
		
		Product product3 = new Product("Whirlpool 240L Double-Door Refrigerator",26499, 4.4, 11);
		
		Product product4 = new Product("Samsung Galaxy S23",107617, 4.9, 25);
		
		Product product5 = new Product("Samsung Washing Machine",33699, 4.2, 15);
		
		Product product6 = new Product("LG Dishwasher",17349, 3.9, 12);

		Product product7 = new Product("Apple MacBook Air M2",114900, 4.3, 33);

		Product product8 = new Product("Dell Inspiron 15",62499, 4.1, 29);
		
		Product product9 = new Product("Apple AirPods Pro (2nd Gen)",26900, 4.8, 19);
		
		Product product10 = new Product("Samsung Galaxy Watch 6",34999, 4.5, 11);
		
		Product[] productsArray = {product1, product2, product3, product4, product5, product6, product7, product8, product9, product10};
		
		
		
		Admin admin1 = new Admin("Thirumalai","thirumalai@gmail.com","tmb@2627");
		
		Customer customer1 = new Customer("Bala","bala@gmail.com","bala@2627");
		
		Login.users.add(admin1);
		
		Login.users.add(customer1);
		
		
		
		loop1 : while(true) {
		
			System.out.println("\nHello Mr.User. Welcome to Shopping Cart.\n--- What do you want to do?\n=> Press (1) to 'Login'.\n=> Press (2) to 'Sign Up'.\n=> Press (3) to 'Exit'.");
			
			int option = userInput.nextInt();
			
			if(option == 3) {
				
				System.out.println("Thank you for visiting my Shopping Cart.");
				
				break loop1;
				
			}
			
			else if(option == 2) {
				
				userInput.nextLine();
				
				System.out.println("Please Enter your name : ");
				
				String name = userInput.nextLine();
				
				System.out.println("Please Enter your Email address : ");
				
				String email = userInput.nextLine();
				
				System.out.println("Please Enter your Password : ");
				
				String password = userInput.nextLine();
				
				System.out.println("Please confirm your password : ");
				
				String confirmPassowrd = userInput.nextLine(); 
				
				loop3 : while(true) {
					
					if(password.equals(confirmPassowrd)) {
						
						break loop3;
						
					}
					
					System.out.println("Incorrect Password. Please confirm your password : ");
					
					confirmPassowrd = userInput.nextLine();
					
				}
				
				Customer newCustomer = new Customer(name, email, password);
				
				Login.users.add(newCustomer);
				
				System.out.println("Your details has been added Successfully.");
				
				
			}
			
			else if(option == 1) {
				
				userInput.nextLine();
				
				System.out.println("Enter your username to Login : ");
				
				String userName = userInput.nextLine();
				
				System.out.println("Enter your password : ");
				
				String password = userInput.nextLine();
				
				User loginedUser = Login.login(userName, password);
				
				if(loginedUser == null) {
					
					System.out.println("No users found. Please check your credentials.");
					
				}
				
				else if(loginedUser != null) {
					
					if(loginedUser instanceof Customer) {
						
						Customer customer = (Customer) loginedUser;
						
						loop2 : while(true) {
							
							customer.viewDashboard();
							
							int choice = userInput.nextInt();
							
							if(choice == 10) {
								
								Login.logout(customer);
								
								break loop2;
								
							}
							
							else if(choice == 1) {
								
								System.out.println("---------- Available Products ----------");
								
								printProducts(productsArray);
								
							}
							
							else if(choice == 2) {
								
								System.out.println("----- Products after sorted by name -----");
								
								Arrays.sort(productsArray);						
								
								printProducts(productsArray);
								
							}
							
							else if(choice == 3) {
								
								System.out.println("----- Products after sorted by price (Highest to Lowest) -----");
								
								Arrays.sort(productsArray, new PriceComparatorHTL());
								
								printProducts(productsArray);
								
							}
							
							else if(choice == 4) {
								
								System.out.println("----- Products after sorted by price (Lowest to Highest) -----");
								
								Arrays.sort(productsArray, new PriceComparatorLTH());
								
								printProducts(productsArray);
								
							}
							
							else if(choice == 5) {
								
								System.out.println("----- Products after sorted by Ratings (Highest to Lowest) -----");
								
								Arrays.sort(productsArray, new RatingsComparatorHTL());
								
								printProducts(productsArray);
								
							}
							
							else if(choice == 6) {
								
								System.out.println("----- Products after sorted by Ratings (Lowest to Highest) -----");
								
								Arrays.sort(productsArray, new RatingsComparatorLTH());
								
								printProducts(productsArray);
								
							}
							
							else if(choice == 7) {
								
								System.out.println("----- Products after sorted by Popularity (Highest to Lowest) -----");
								
								Arrays.sort(productsArray, new PopularityComparatorHTL());
								
								printProducts(productsArray);
								
							}
							
							else if(choice == 8) {
								
								System.out.println("----- Products after sorted by Popularity (Lowest to Highest) -----");
								
								Arrays.sort(productsArray, new PopularityComparatorLTH());
								
								printProducts(productsArray);
								
							}
							
							else if(choice == 9) {
								
								userInput.nextLine();
								
								System.out.println("Enter the product name you want to buy :");
								
								String productName = userInput.nextLine();
								
								String productToFind = productName.substring(0,1).toUpperCase() + productName.substring(1).toLowerCase();
								
								for(Product product : productsArray) {
									
									if(product != null && product.productName.contains(productToFind)) {
										
										System.out.println("Select any Transaction method :\nPress (1) for 'Credit Card'.\nPress (2) for 'UPI'");
										
										int payment = userInput.nextInt();
										
										switch(payment) {
										
										case 1:
											
											CreditCard credit = new CreditCard();
											
											System.out.println("Please Enter your credit card number.");
											
											double creditNumber = userInput.nextDouble();
											
											while(!credit.authenticate(creditNumber)) {
												
												System.out.println("Plese Enter a valid 16-digit Credit card number : ");
												
												creditNumber = userInput.nextDouble();
												
											}
											
											System.out.println("Credit Card Authenticated Successfully");
											
											break;
											
										
											case 2:
											
											UPI upi = new UPI();
											
											System.out.println("Please Enter your UPI Id");
											
											double upiId = userInput.nextDouble();
											
											while(!upi.authenticate(upiId)) {
												
												System.out.println("Plese Enter a valid 8 to 10-digit UPI Id : ");
												
												upiId = userInput.nextDouble();										
												
											}
											
											System.out.println("UPI ID Authenticated Successfully");
											
											break;
											
										}
										
										customer.buyProduct(product);
										
										break;
										
									}
									
								}
								
							}
							
						}
						
					}
					
					else if	(loginedUser instanceof Admin) {
						
						Admin admin = (Admin) loginedUser;
						
						loop4 : while(true) {
							
							admin.viewDashboard();
							
							int choice = userInput.nextInt();
							
							if(choice == 10) {
								
								Login.logout(admin);
								
								break loop4;
								
							}
							
							else if(choice == 1) {	
								
								userInput.nextLine();
								
								System.out.println("Please Enter the product name : ");
								
								String productName = userInput.nextLine();
								
								System.out.println("Please Enter the product price : ");
								
								int price = userInput.nextInt();
								
								System.out.println("Please Enter the product ratings : ");
								
								byte ratings = userInput.nextByte();
								
								System.out.println("Please Enter the no.of quantities sold.");
								
								int popularity = userInput.nextInt();
								
								Product newProduct = new Product(productName, price, ratings, popularity);
								
								for(int i=0;i<productsArray.length;i++) {
									
									if(productsArray[i] == null) {
										
										productsArray[i] = newProduct;
										
										System.out.println("Product has been added Successfully.");
										
										printProducts(productsArray);
										
										break;
										
									}
									
									else {
										
										continue;
										
									}
									
								}
								
								System.out.println("Maximum Limit to add Products has been reached.");
								
							}
							
							else if(choice == 2) {
								
								System.out.println("----- Products after sorted by name -----");
								
								Arrays.sort(productsArray);						
								
								printProducts(productsArray);
								
							}
							
							else if(choice == 3) {
								
								System.out.println("----- Products after sorted by price (Highest to Lowest) -----");
								
								Arrays.sort(productsArray, new PriceComparatorHTL());
								
								printProducts(productsArray);
								
							}
							
							else if(choice == 4) {
								
								System.out.println("----- Products after sorted by price (Lowest to Highest) -----");
								
								Arrays.sort(productsArray, new PriceComparatorLTH());
								
								printProducts(productsArray);
								
							}
							
							else if(choice == 5) {
								
								System.out.println("----- Products after sorted by Ratings (Highest to Lowest) -----");
								
								Arrays.sort(productsArray, new RatingsComparatorHTL());
								
								printProducts(productsArray);
								
							}
							
							else if(choice == 6) {
								
								System.out.println("----- Products after sorted by Ratings (Lowest to Highest) -----");
								
								Arrays.sort(productsArray, new RatingsComparatorLTH());
								
								printProducts(productsArray);
								
							}
							
							else if(choice == 7) {
								
								System.out.println("----- Products after sorted by Popularity (Highest to Lowest) -----");
								
								Arrays.sort(productsArray, new PopularityComparatorHTL());
								
								printProducts(productsArray);
								
							}
							
							else if(choice == 8) {
								
								System.out.println("----- Products after sorted by Popularity (Lowest to Highest) -----");
								
								Arrays.sort(productsArray, new PopularityComparatorLTH());
								
								printProducts(productsArray);
								
							}
							
							else if(choice == 9) {
								
								userInput.nextLine();
								
								printProducts(productsArray);
								
								System.out.println("Enter the product name you want to remove it from our Shop :");
								
								String productName = userInput.nextLine();
								
								String productToFind = productName.substring(0,1).toUpperCase() + productName.substring(1).toLowerCase();
								
								for(int i=0;i<productsArray.length;i++) {
									
									if(productsArray[i] != null && productsArray[i].productName.contains(productToFind)) {
										
										productsArray[i] = null;
										
										System.out.println("Product has been Successfully removed from our cart.");
										
										break;
										
									}
								
								}
								
								printProducts(productsArray);
								
							}
						
						}
						
					}
					
				}
				
			}
		
		}
		
		userInput.close();
		
	}
	
	
	static void printProducts(Product[] productArray) {
		
		for(Product product : productArray) {
			
			if(product != null) {
				
				System.out.println(product.toString());
				
			}
			
		}
		
	}

}
