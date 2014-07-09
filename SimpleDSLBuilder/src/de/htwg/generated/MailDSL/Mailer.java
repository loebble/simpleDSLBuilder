package de.htwg.generated.MailDSL;

public class Mailer {

	private Mailer(){}

	    /**
	    *
	    * Entry point method. This method provides access to the DSL.
	    * Use a static import in your code to use the DSL without context.
	    */
	    public static Mailer mail() {
	    	Mailer builder = new Mailer();
	    	return builder;
	    }

	    /**
	    * Generated chain method.
	    *
	    */
	    public Mailer from(String sender) {
	    	//TODO auto generated chain method codeblock
	    	return this;
	    }
	    
	    /**
	    * Generated chain method.
	    *
	    */
	    public Mailer to(String receiver) {
	    	//TODO auto generated chain method codeblock
	    	return this;
	    }
	    
	    /**
	    * Generated chain method.
	    *
	    */
	    public Mailer subject(String subject) {
	    	//TODO auto generated chain method codeblock
	    	return this;
	    }
	    
	    /**
	    * Generated chain method.
	    *
	    */
	    public Mailer body(String text) {
	    	//TODO auto generated chain method codeblock
	    	return this;
	    }
	    

	    /**
	    *
	    * Generated build method
	    */
	    public Mailer send() {
	    	//TODO auto generated build method codeblock
	    	return this;
	    }

}