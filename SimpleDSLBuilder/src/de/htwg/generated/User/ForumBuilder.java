package de.htwg.generated.User;

import de.htwg.user.Address;
import de.htwg.user.User;
import de.htwg.generated.emf.Forum.*;


public class ForumBuilder {
	User user;
	Address address;
	UserBuilder userBuilder;
	AddressBuilder addressBuilder;
	public final BuildForumScope buildForumScope;
	
	private ForumBuilder(){
		this.userBuilder = new UserBuilder();
		this.addressBuilder = new AddressBuilder();
		buildForumScope = new BuildForumScope();
	}
	
	public static UserBuilder.FirstNameScope user() {
    	ForumBuilder builder = new ForumBuilder();
    	return builder.userBuilder.firstNameScope;
    }
	
	class UserBuilder{
		//mandatory Attributes
		private String firstNameValue;
		private String lastNameValue;
		private String emailValue;
		private Address addressValue; // TODO needed?
		//optional Attributes
		private String phoneValue;
		private boolean phoneValueIsSet = false;
		private int ageValue;
		private boolean ageValueIsSet = false;
	
	
		//mandatory Scopes
		private final FirstNameScope firstNameScope;
		private final LastNameScope lastNameScope;
		private final EmailScope emailScope;
		private final BuildUserScope buildUserScope;
	
	
		private UserBuilder(){
			this.firstNameScope = this.new FirstNameScope();
			this.lastNameScope = this.new LastNameScope();
			this.emailScope = this.new EmailScope();
			this.buildUserScope = this.new BuildUserScope();
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
	    	
	    	    public BuildUserScope email (String val) {
	    	    		UserBuilder.this.emailValue = val;
	    	    		return UserBuilder.this.buildUserScope;
	    	    }
	    	    public EmailScope optionalPhone (String val) {
	        		//TODO auto generated chain method codeblock
	        		//You probably want to check the val
	    	    	UserBuilder.this.phoneValue = val;
	    	    	UserBuilder.this.phoneValueIsSet = true;
	        		return UserBuilder.this.emailScope;
	        	}
	    	    public EmailScope optionalAge (int val) {
	        		//TODO auto generated chain method codeblock
	        		//You probably want to check the val
	        		UserBuilder.this.ageValue = val;
	        		UserBuilder.this.ageValueIsSet = true;
	        		return UserBuilder.this.emailScope;
	        	}
	    }
	    
	    public class BuildUserScope {

	    	public AddressBuilder.CreateScope buildUser () {
	    		//TODO auto generated build method codeblock
	    		ForumBuilder.this.user = new User();
	    		user.setFirstName(UserBuilder.this.firstNameValue); 
	    		user.setLastName(UserBuilder.this.lastNameValue); 
	    		user.setEmail(UserBuilder.this.emailValue); 
	    		user.setAddress(UserBuilder.this.addressValue); 

	    		if(phoneValueIsSet)
	    			user.setPhone(UserBuilder.this.phoneValue); 
	    		if(ageValueIsSet)
	    			user.setAge(UserBuilder.this.ageValue); 

	    		return ForumBuilder.this.addressBuilder.createScope;
	    	}

	    }
		    
	}
	
	class AddressBuilder{
		private final StreetScope streetScope;
		private final CreateScope createScope;
		private final BuildAddressScope buildAddressScope;
		
		private String streetValue;
		
		public AddressBuilder(){
			this.streetScope = new StreetScope();
			this.createScope = new CreateScope();
			this.buildAddressScope = new BuildAddressScope();
		}
		
		public class CreateScope{
			public AddressBuilder.StreetScope address() {
		    	ForumBuilder builder = new ForumBuilder();
		    	return AddressBuilder.this.streetScope;
		    }
		}
		
	    /**
	    * Generated Scope Class for method order
	    */
	    public class StreetScope {
	    	public BuildAddressScope street (String val) {
	    		AddressBuilder.this.streetValue = val;
	    		return  AddressBuilder.this.buildAddressScope;
	    	}
	    }
	    	
	    public class BuildAddressScope {
	    	
			public BuildForumScope buildAddress () {
				ForumBuilder.this.address = new Address();
				address.setStreet(AddressBuilder.this.streetValue);
	    		return ForumBuilder.this.buildForumScope;
	    	}
			
	    }
		
	}
	    


	    /**
	    *
	    * Generated Build Scope
	    */
	    public class BuildForumScope {

	    	public void buildForum () {
	    		//TODO what should be returned?
//	    		User modelInstance = new User();
//	    		modelInstance.setFirstName(ForumBuilder.this.firstNameValue); 
//	    		modelInstance.setLastName(ForumBuilder.this.lastNameValue); 
//	    		modelInstance.setEmail(ForumBuilder.this.emailValue); 
//	    		modelInstance.setAddress(ForumBuilder.this.addressValue); 
//
//	    		if(phoneValueIsSet)
//	    			modelInstance.setPhone(ForumBuilder.this.phoneValue); 
//	    		if(ageValueIsSet)
//	    			modelInstance.setAge(ForumBuilder.this.ageValue); 
//
//	    		return modelInstance;
	    	}

	    
	}
}