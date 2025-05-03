package ShoppingCartSystem;

public class User {
	
	String name;
	
	byte age;
	
	String gender;
	
	String userName;
	
	String password;

	String role;

	public User(){

		//To create a object to call a method.

	}
	
	public User(String name, byte age, String gender,String userName, String password, String role){
		
		this.name = name;
		
		this.age = age;
		
		this.gender = gender;
		
		this.userName = userName;
		
		this.password = password;

		this.role = role;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setAge(byte age) {
		
		this.age = age;
		
	}
	
	public byte getAge() {
		
		return age;
		
	}
	
	public void setGender(String gender) {
		
		this.gender = gender;
		
	}
	
	public String getGender() {
		
		return gender;
		
	}
	
	public void setUserName(String userName) {
		
		this.userName = userName;
		
	}
	
	public String getUserName() {
		
		return userName;
		
	}
	
	public void setPassword(String password) {
		
		this.password = password;
		
	}
	
	public String getPassword() {
		
		return password;
		
	}

	public void setRole(String role){

		this.role = role;

	}

	public String getRole(){

		return role;

	}

	public void printUserDetails(User user){

		String password = "";
		
		for(int i=0;i<user.password.length();i++){
			
			password+="*";

		}

		System.out.println("\n-------- User Details ----------\nName : " + user.name + "\nAge : " + user.age + "\nGender : " + user.gender + "\nUser Name : " + user.name + "\nPassword : " + password);

	}





	//To get the most-selling product......

	public void mostSelling(){

		for(Product product : DataManager.getProducts()){

			if(product.quantitySold > 1){

				System.out.println("Product Id : " + product.productId + "\nProduct Name : " + product.name + "\nNo.of products sold : " + product.quantitySold + "\n");

			}

		}
		
	}


	//To get the most-liked product......

	public void mostLiked(){

		for(Product product : DataManager.getProducts()){

			if(product.noOfLikes >= 1){

				System.out.println("Product Id : " + product.productId + "\nProduct Name : " + product.name + "\nNo.of likes : " + product.noOfLikes + "\n");

			}

		}

	}

}
