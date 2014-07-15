package de.htwg.generated.User;

import de.htwg.user.Address;
import de.htwg.user.User;


public class UserBuilder {

	private String firstNameValue;
	private String lastNameValue;
	private String emailValue;
	private String phoneValue;
	private int ageValue;
	private Address addressValue;


	private final FirstNameScope firstNameScope;
	private final LastNameScope lastNameScope;
	private final EmailScope emailScope;
	private final PhoneScope phoneScope;
	private final AgeScope ageScope;
	private final AddressScope addressScope;
	private final BuildScope buildScope;


	private UserBuilder(){
		this.firstNameScope = this.new FirstNameScope();
		this.lastNameScope = this.new LastNameScope();
		this.emailScope = this.new EmailScope();
		this.phoneScope = this.new PhoneScope();
		this.ageScope = this.new AgeScope();
		this.addressScope = this.new AddressScope();
		this.buildScope = this.new BuildScope();

	}

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
	    * Generated Scope Class for method order
	    */
	    public class FirstNameScope {

	    	public LastNameScope firstName (String val) {
	    		//TODO auto generated chain method codeblock
	    		//You probably want to check the val
	    		UserBuilder.this.firstNameValue = val;
	    		return UserBuilder.this.lastNameScope;
	    	}

	    }
	    /**
	    * Generated Scope Class for method order
	    */
	    public class LastNameScope {

	    	public EmailScope lastName (String val) {
	    		//TODO auto generated chain method codeblock
	    		//You probably want to check the val
	    		UserBuilder.this.lastNameValue = val;
	    		return UserBuilder.this.emailScope;
	    	}

	    }
	    /**
	    * Generated Scope Class for method order
	    */
	    public class EmailScope {

	    	public PhoneScope email (String val) {
	    		//TODO auto generated chain method codeblock
	    		//You probably want to check the val
	    		UserBuilder.this.emailValue = val;
	    		return UserBuilder.this.phoneScope;
	    	}

	    }
	    /**
	    * Generated Scope Class for method order
	    */
	    public class PhoneScope {

	    	public AgeScope phone (String val) {
	    		//TODO auto generated chain method codeblock
	    		//You probably want to check the val
	    		UserBuilder.this.phoneValue = val;
	    		return UserBuilder.this.ageScope;
	    	}

	    }
	    /**
	    * Generated Scope Class for method order
	    */
	    public class AgeScope {

	    	public AddressScope age (int val) {
	    		//TODO auto generated chain method codeblock
	    		//You probably want to check the val
	    		UserBuilder.this.ageValue = val;
	    		return UserBuilder.this.addressScope;
	    	}

	    }
	    /**
	    * Generated Scope Class for method order
	    */
	    public class AddressScope {

	    	public BuildScope address (Address val) {
	    		//TODO auto generated chain method codeblock
	    		//You probably want to check the val
	    		UserBuilder.this.addressValue = val;
	    		return UserBuilder.this.buildScope;
	    	}

	    }
	    

	    /**
	    *
	    * Generated build method
	    */
	    public class BuildScope {

	    	public User build () {
	    		//TODO auto generated build method codeblock
	    		User modelInstance = new User();
	    		modelInstance.setFirstName(UserBuilder.this.firstNameValue); 
	    		modelInstance.setLastName(UserBuilder.this.lastNameValue); 
	    		modelInstance.setEmail(UserBuilder.this.emailValue); 
	    		modelInstance.setPhone(UserBuilder.this.phoneValue); 
	    		modelInstance.setAge(UserBuilder.this.ageValue); 
	    		modelInstance.setAddress(UserBuilder.this.addressValue); 

	    		return modelInstance;
	    	}

	    }
	    

}