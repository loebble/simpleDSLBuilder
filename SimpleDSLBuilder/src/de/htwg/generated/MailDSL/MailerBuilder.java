package de.htwg.generated.MailDSL;


public class MailerBuilder {

	private MailerBuilder(){}

	private String fromString;
	private String toString;
	private String subjectString;
	private String bodyString;


	    /**
	    *
	    * Entry point method. This method provides access to the DSL.
	    * Use a static import in your code to use the DSL without context.
	    */
	    public static MailerBuilder mail() {
	    	MailerBuilder builder = new MailerBuilder();
	    	return builder;
	    }

	    /**
	    * Generated chain method.
	    *
	    */
	    public MailerBuilder from (String val) {
	    	//TODO auto generated chain method codeblock
	    	this.fromString = val;
	    	return this;
	    }
	    
	    /**
	    * Generated chain method.
	    *
	    */
	    public MailerBuilder to (String val) {
	    	//TODO auto generated chain method codeblock
	    	this.toString = val;
	    	return this;
	    }
	    
	    /**
	    * Generated chain method.
	    *
	    */
	    public MailerBuilder subject (String val) {
	    	//TODO auto generated chain method codeblock
	    	this.subjectString = val;
	    	return this;
	    }
	    
	    /**
	    * Generated chain method.
	    *
	    */
	    public MailerBuilder body (String val) {
	    	//TODO auto generated chain method codeblock
	    	this.bodyString = val;
	    	return this;
	    }
	    

	    /**
	    *
	    * Generated build method
	    */
	    public Mailer send() {
	    	//TODO auto generated build method codeblock
	    	Mailer modelInstance = new Mailer();
	    	modelInstance.setFromString(this.fromString); 
	    	modelInstance.setToString(this.toString); 
	    	modelInstance.setSubjectString(this.subjectString); 
	    	modelInstance.setBodyString(this.bodyString); 

	    	return modelInstance;
	    }

}