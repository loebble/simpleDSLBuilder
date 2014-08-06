package de.htwg.generated.User;

import de.htwg.user.Address;
import de.htwg.user.User;


public class UserBuilder {
	//mandatory Attributes
	private String firstNameValue;
	private String lastNameValue;
	private String emailValue;
	private Address addressValue;

	//optional Attributes
	private  phoneValue;
	private boolean phoneValueIsSet = false;
	private  ageValue;
	private boolean ageValueIsSet = false;

	//mandatory Scopes
	private final FirstNameScope firstNameScope;
	private final LastNameScope lastNameScope;
	private final EmailScope emailScope;
	private final AddressScope addressScope;

	private final BuildUserScope buildUserScope;

	//optional Scopes
	private final PhoneScope phoneScope;
	private final AgeScope ageScope;


	private UserBuilder(){
		this.firstNameScope = this.new FirstNameScope();
		this.lastNameScope = this.new LastNameScope();
		this.emailScope = this.new EmailScope();
		this.addressScope = this.new AddressScope();

		this.buildUserScope = this.new BuildUserScope();

	}

	    /**
	    *
	    * Entry point method. This method provides access to the DSL.
	    * Use a static import in your code to use the DSL without context.
	    */
	    public static FirstNameScope user() {
	    	UserBuilder builder = new UserBuilder();
	    	return builder.firstNameScope;
	    }

	    /**
	    * Generated Scope Class for method order
	    */
	    public class FirstNameScope {
	    	    public LastNameScope lastName (String val) {
	    	    		//TODO auto generated chain method codeblock
	    	    		//You probably want to check the val
	    	    		UserBuilder.this.lastNameValue = val;
	    	    		return UserBuilder.this.lastNameScope;
	    	    	}
	    }
	    /**
	    * Generated Scope Class for method order
	    */
	    public class LastNameScope {
	    	    public EmailScope email (String val) {
	    	    		//TODO auto generated chain method codeblock
	    	    		//You probably want to check the val
	    	    		UserBuilder.this.emailValue = val;
	    	    		return UserBuilder.this.emailScope;
	    	    	}
	    }
	    /**
	    * Generated Scope Class for method order
	    */
	    public class EmailScope {
	    	    public AddressScope address (Address val) {
	    	    		//TODO auto generated chain method codeblock
	    	    		//You probably want to check the val
	    	    		UserBuilder.this.addressValue = val;
	    	    		return UserBuilder.this.addressScope;
	    	    	}
	    }
	    /**
	    * Generated Scope Class for method order
	    */
	    public class AddressScope {
	    	    public BuildUserScope buildUser ( val) {
	    	    		//TODO auto generated chain method codeblock
	    	    		//You probably want to check the val
	    	    		UserBuilder.this.buildUserValue = val;
	    	    		return UserBuilder.this.buildUserScope;
	    	    	}
	    }
	    


	    /**
	    *
	    * Generated Build Scope
	    */
	    public class BuildUserScope {

	    	public User buildUser () {
	    		//TODO auto generated build method codeblock
	    		User modelInstance = new User();
	    		modelInstance.setFirstName(UserBuilder.this.firstNameValue); 
	    		modelInstance.setLastName(UserBuilder.this.lastNameValue); 
	    		modelInstance.setEmail(UserBuilder.this.emailValue); 
	    		modelInstance.setAddress(UserBuilder.this.addressValue); 

	    		return modelInstance;
	    	}

	    }
	    

}