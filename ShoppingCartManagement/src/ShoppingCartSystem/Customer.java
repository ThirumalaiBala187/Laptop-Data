package ShoppingCartSystem;

import java.util.ArrayList;
import java.util.Arrays;

public class Customer extends User {

    String likedProduct;

    String orderedProduct;

    String cart;

    String address;

    long mobileNumber;

    // static ArrayList<User> availableUsers = DataManager.getUsers();

    static ArrayList<Product> availableProducts = DataManager.getProducts();

    public Customer(){

        //To create an object to call a method.

    }

    public Customer(String name, byte age, String gender, String userName, String password, String role, String liked, String ordered, String cart, String address, long mobileNumber){

        super(name, age, gender, userName, password, role);
        
        this.likedProduct = liked;

        this.orderedProduct = ordered;

        this.cart = cart;

        this.address = address;

        this.mobileNumber = mobileNumber;

    } 

    public void setLikedProduct(Product productToLike){

        this.likedProduct = productToLike.productId + "";

    }

    public String getLikedProduct(){

        return likedProduct;

    }

    public void setOrderedProduct(Product productToBuy){

        this.orderedProduct = productToBuy.productId + "";

    }

    public String getOrderedProduct(){

        return orderedProduct;

    }

    public void setCart(Product productToAddCart){

        this.cart = productToAddCart.productId + "";

    }

    public String getCart(){

        return this.cart;

    }

    // To buy a product......

	public void buyProduct(Product productToBuy, String address, long mobileNo){

        ArrayList<User> availableUsers = DataManager.getUsers();

		for(User user : availableUsers){

			if((user.userName).equals(this.userName)){

				if(user instanceof Customer){

                    availableProducts.get(productToBuy.productId-1001).quantitySold++;

                    availableProducts.get(productToBuy.productId-1001).availableQuantity--;

					Customer customerToBuy = (Customer) user;

					String newlyBuyed = customerToBuy.orderedProduct + "-" + productToBuy.productId;

					customerToBuy.orderedProduct = newlyBuyed;

                    customerToBuy.address = address;

                    customerToBuy.mobileNumber = mobileNo;

					DataManager.saveUsers(availableUsers);
			
					DataManager.saveProducts(availableProducts);

					break;

				}

			}

		}

		System.out.println("You have successfully bought this product.");

	}



    public void buyProduct(Product productToBuy){

        ArrayList<User> availableUsers = DataManager.getUsers();

		for(User user : availableUsers){

			if((user.userName).equals(this.userName)){

				if(user instanceof Customer){

                    availableProducts.get(productToBuy.productId-1001).quantitySold++;

                    availableProducts.get(productToBuy.productId-1001).availableQuantity--;

					Customer customerToBuy = (Customer) user;

					String newlyBuyed = customerToBuy.orderedProduct + "-" + productToBuy.productId;

					customerToBuy.orderedProduct = newlyBuyed;

					DataManager.saveUsers(availableUsers);
			
					DataManager.saveProducts(availableProducts);

					break;

				}

			}

		}

		System.out.println("You have successfully bought this product.");

	}


    //To return a product......

    public void returnProduct(int productId){

        String userCart = this.orderedProduct;

        ArrayList<User> availableUsers = DataManager.getUsers();

        if(userCart.split("-").length == 1){

            System.out.println("There is no orders to remove");

        }

        else{

            for(User user : availableUsers){

                if(this.userName.equals(user.userName)){

                    if(user instanceof Customer){

                        String idToRemove = "-" + productId;

                        Customer customer = (Customer) user;

                        if(customer.orderedProduct.contains(idToRemove)){

                            customer.orderedProduct = customer.orderedProduct.replace(idToRemove,"");

                            DataManager.saveUsers(availableUsers);

                            availableProducts.get(productId-1000).quantitySold--;
                            
                            availableProducts.get(productId-1000).availableQuantity++;
                                                
                            DataManager.saveProducts(availableProducts);
                    
                            System.out.println("Your order has been cancelled successfully.");

                        }

                        else{

                            System.out.println("Incorrect Id number. Please check your product ID");
                                
                        }
                        

                    }
                        
                }

           }

        }

    }


    //To remove product from Cart

    public void removeCart(int productId){

        String userCart = this.cart;

        ArrayList<User> availableUsers = DataManager.getUsers();

        if(userCart.split("-").length == 1){

            System.out.println("The Cart is Empty.");

        }

        else{

            for(User user : availableUsers){

                if(this.userName.equals(user.userName)){

                    if(user instanceof Customer){

                        String idToRemove = "-" + productId;

                        Customer customer = (Customer) user;

                        String[] cartItems = customer.cart.split("-");

                        System.out.println("Cart items: " + Arrays.toString(cartItems));

                        if (customer.cart.contains(idToRemove)) {

                            customer.cart = customer.cart.replace(idToRemove, "");

                            DataManager.saveUsers(availableUsers);
                    
                            System.out.println("Your products has been removed from the cart successfully.");

                        } 

                        else {
    
                            System.out.println("Product ID not found in cart.");

                        }                        

                    }
                        
                }

           }

        }

    }



	//To Like a product......

	public void likeProduct(Product productToLike){

        ArrayList<User> availableUsers = DataManager.getUsers();

        ArrayList<Product> availableProducts = DataManager.getProducts();

		for(User user : availableUsers){
			
			if((user.userName).equals(this.userName)){

				if(user instanceof Customer){

                    availableProducts.get(productToLike.productId-1001).noOfLikes = availableProducts.get(productToLike.productId-1001).noOfLikes + 1;

					Customer customerToLike = (Customer) user;

					String newlyLiked = customerToLike.likedProduct + "-" + productToLike.productId;

                    customerToLike.likedProduct = newlyLiked;

					DataManager.saveUsers(availableUsers);
			
					DataManager.saveProducts(availableProducts);

					break;

				}

			}

		}

		System.out.println("You have liked this product.");

	}


    //To unlike a product

     public void unlike(int productId){

        String userLiked = this.likedProduct;

        if(userLiked.split("-").length > 1){

            ArrayList<User> availableUsers = DataManager.getUsers();

            ArrayList<Product> availableProducts = DataManager.getProducts();

            for(User user : availableUsers){

                if(this.userName.equals(user.userName)){

                    if(user instanceof Customer){

                        String idToRemove = "-" + productId;

                        Customer customer = (Customer) user;

                        if(customer.likedProduct.contains(idToRemove)){

                            customer.likedProduct = customer.likedProduct.replace(idToRemove,"");

                            if(availableProducts.get(productId-1001).noOfLikes < 1){

                                availableProducts.get(productId - 1001).noOfLikes = 0;

                            }

                            else{

                                availableProducts.get(productId - 1001).noOfLikes--;

                            }

                            DataManager.saveProducts(availableProducts);

                            DataManager.saveUsers(availableUsers);

                        }

                        else{

                            System.out.println("Incorrect Id number. Please check your product ID");
                                
                        }
                        

                    }
                        
                }

            }

        }

        else{

            System.out.println("You haven't liked any product.");

        }

    }


	//To Add in the Cart......

	public void addToCart(Product productToAdd){

        ArrayList<User> availableUsers = DataManager.getUsers();

		for(User user : availableUsers){
			
			if((user.userName).equals(this.userName)){

				if(user instanceof Customer){

					Customer customerToAddCart = (Customer) user;

					String newlyAdded = customerToAddCart.cart + "-" + productToAdd.productId;

                    customerToAddCart.cart = newlyAdded;

					DataManager.saveUsers(availableUsers);
			
					DataManager.saveProducts(availableProducts);

					break;

				}

			}

		}

		System.out.println("Product has been added to the cart Successfully.");

	}


    //To get the products in the User's cart......

	public void printCartItems(){

        for(User user : DataManager.getUsers()){
    
            if((user.userName).equals(this.userName)){
    
                if(user instanceof Customer){
    
                    Customer customerObj = (Customer) user;
    
                    String[] cartArray = customerObj.cart.split("-");

                    if(cartArray.length>1){
    
                        for(int i=1;i<cartArray.length;i++){
    
                            System.out.println(availableProducts.get(Integer.parseInt(cartArray[i])-1001).toString() + "\n");
    
                        }
    
                    }

                    else{
                
                        System.out.println("You Cart is Empty.\n");
                
                    }
    
                }
    
            }

        }

	}

    
    //To get the User-liked products......

	public void printLikedItems(){

        ArrayList<User> availableUsers = DataManager.getUsers();

            for(User user : availableUsers){
    
                if((user.userName).equals(this.userName)){
    
                    if(user instanceof Customer){
    
                        Customer customerObj = (Customer) user;
    
                        String[] likedArray = customerObj.likedProduct.split("-");

                        if(likedArray.length>1){
    
                            for(int i=1;i<likedArray.length;i++){
        
                                System.out.println(availableProducts.get(Integer.parseInt(likedArray[i])-1001).toString() + "\n");
        
                            }
                            
                        }

                        else{
                
                            System.out.println("You haven't liked any products.");
                
                        }
    
                    }
    
                }
    
            }

        }



    //To get the User-buyed products.....

	public void printBuyedItems(){

        ArrayList<User> availableUsers = DataManager.getUsers();

            for(User user : availableUsers){
    
                if((user.userName).equals(this.userName)){
    
                    if(user instanceof Customer){
    
                        Customer customerObj = (Customer) user;
    
                        String[] boughtArray = customerObj.orderedProduct.split("-");

                        if(boughtArray.length>1){
    
                            for(int i=1;i<boughtArray.length;i++){
        
                                System.out.println(availableProducts.get(Integer.parseInt(boughtArray[i])-1001).toString() + "\n");
        
                            }

                        }

                        else{
                
                            System.out.println("You haven't bought any products.");
                
                        }
    
                    }
    
                }
    
            }

	    }


    //To print the User's details......

    public String toString(){

        String password = "";
		
		for(int i=0;i<password.length();i++){
			
			password+="*";

		}

		return ("\n-------- User Details ----------\nName : " + name + "\nAge : " + age + "\nGender : " + gender + "\nUser Name : " + name + "\nPassword : " + password + "\nLiked Products : " + likedProduct + "\nOrdered products : " + orderedProduct);

    }


	void updateProfile(int choiceSelected, String newDetails){

        ArrayList<User> availableUsers = DataManager.getUsers();

        for(User user : availableUsers){

            if(this.userName.equalsIgnoreCase(user.userName)){

                if(user instanceof Customer){

                    Customer customer = (Customer) user;


            		if(choiceSelected == 1){

            			customer.name = newDetails;

            			DataManager.saveUsers(availableUsers);

            		}  

            		else if(choiceSelected == 2){

            			customer.age = Byte.parseByte(newDetails);

            			DataManager.saveUsers(availableUsers);

            		}  

            		else if(choiceSelected == 3){

            			customer.gender = newDetails;

            			DataManager.saveUsers(availableUsers);

            		}  

            		else if(choiceSelected == 4){

            			customer.userName = newDetails;

            			DataManager.saveUsers(availableUsers);

            		}  

                	else if(choiceSelected == 5){

                		customer.password = newDetails;

                		DataManager.saveUsers(availableUsers);

            		}

                }


            }

        }

	}

}
