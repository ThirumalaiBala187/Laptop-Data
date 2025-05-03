package ShoppingCartSystem;

public abstract class User {
	
	public enum Gender{
		
		Male, Female, Others;
		
		@Override
		public String toString() {
			
			switch (this) {
			
				case Male: {
			
					return "Male";
		
				}
				
				case Female: {
					
					return "Female";
		
				}
				
				case Others: {
					
					return "Others";
		
				}
				
				default: throw new IllegalArgumentException("Unexpected value: " + this);
				
			}
			
		}		
	
	}
	
	protected String name;
	
	protected byte age;
	
	protected Gender gender;
	
	protected String userName;
	
	protected String password;

	protected int role;
	
	protected String mobileNumber;

	public User(){

		//To create a object to call a method.

	}
	
	public User(String name, byte age, Gender gender,String userName, String password, int role, String mobileNumber){
		
		this.name = name;
		
		this.age = age;
		
		this.gender = gender;
		
		this.userName = userName;
		
		this.password = password;

		this.role = role;
		
		this.mobileNumber = mobileNumber;
		
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
	
	public void setGender(Gender gender) {
		
		this.gender = gender;
		
	}
	
	public Gender getGender() {
		
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

	public void setRole(int role){

		this.role = role;

	}

	public int getRole(){

		return role;

	}
	
	public String getMobileNumber() {
	
		return mobileNumber;

	}

	public void setMobileNumber(String mobileNumber) {
	
		this.mobileNumber = mobileNumber;
	
	}

//	System.out.println("\n-------- User Details ----------\nName : " + user.name + "\nAge : " + user.age + "\nGender : " + user.gender + "\nUser Name : " + user.name + "\nPassword : " + password);
	
	abstract void printUserDetails();
	
	abstract void viewDashboard();

}
