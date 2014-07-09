package de.htwg.generated.UserDSL;

import de.htwg.user.Address;

public class User {

	private final String firstName;
	private final String lastName;
	private final String email;
	private final String phoneNumber;
	private final int age;
	private final Address address;


	public static class UserBuilder{

		private String firstName;
		private String lastName;
		private String email;
		private String phoneNumber;
		private int age;
		private Address address;

		private UserBuilder(){}

		    /**
		    *
		    * Entry point method. This method provides access to the DSL.
		    * Use a static import in your code to use the DSL without context.
		    */
		    public static UserBuilder user() {
		    	UserBuilder builder = new UserBuilder();
		    	return builder;
		    }

		    /**
		    * Generated chain method.
		    *
		    */
		    public UserBuilder name(String firstName, String lastName) {
		    	//TODO auto generated chain method codeblock
		    	this.firstName = firstName; 
		    	this.lastName = lastName; 

		    	return this;
		    }
		    
		    /**
		    * Generated chain method.
		    *
		    */
		    public UserBuilder email(String email) {
		    	//TODO auto generated chain method codeblock
		    	this.email = email; 

		    	return this;
		    }
		    
		    /**
		    * Generated chain method.
		    *
		    */
		    public UserBuilder phone(String phoneNumber) {
		    	//TODO auto generated chain method codeblock
		    	this.phoneNumber = phoneNumber; 

		    	return this;
		    }
		    
		    /**
		    * Generated chain method.
		    *
		    */
		    public UserBuilder age(int age) {
		    	//TODO auto generated chain method codeblock
		    	this.age = age; 

		    	return this;
		    }
		    
		    /**
		    * Generated chain method.
		    *
		    */
		    public UserBuilder adress(Address address) {
		    	//TODO auto generated chain method codeblock
		    	this.address = address; 

		    	return this;
		    }
		    

		    /**
		    *
		    * Generated build method
		    */
		    public User build() {
		    	//TODO auto generated build method codeblock
		    	return new User(this);
		    }
	}

	private User(UserBuilder builder){
		this.firstName = builder.firstName; 
		this.lastName = builder.lastName; 
		this.email = builder.email; 
		this.phoneNumber = builder.phoneNumber; 
		this.age = builder.age; 
		this.address = builder.address; 

	}
}