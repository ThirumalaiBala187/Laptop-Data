package model.DTO;

import java.sql.Date;

public class User {	
	
	public enum Gender{		
		Male, Female, Others, NOTSET;	
	}
	private int userId;
	protected String name;	
	protected Date dob;	
	protected Gender gender;	
	protected String userName;	
	protected String password;
	protected int role;	
	protected String mobileNumber;
	protected String authType;

	public User(){
		//To create a object to call a method.
	}
	
	public User(int userId, String name, Date dob, Gender gender,String userName, String password, String mobileNumber, int role, String authType){		
		this.userId=userId;
		this.name = name;		
		this.dob = dob;		
		this.gender = gender;		
		this.userName = userName;		
		this.password = password;		
		this.mobileNumber = mobileNumber;
		this.role = role;
		this.authType = authType;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setName(String name) {		
		this.name = name;		
	}
	
	public String getName() {		
		return name;		
	}
	
	public void setDob(Date dob) {		
		this.dob = dob;		
	}
	
	public Date getDob() {		
		return dob;		
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

	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}
}
