package de.htwg.generated.MultiParamMailDSL;

public class MultiParamMailer {

	private String sender;
	private String receiver;
	private String subject;
	private String text;

	private MultiParamMailer(){}

	    /**
	    *
	    * Entry point method. This method provides access to the DSL.
	    * Use a static import in your code to use the DSL without context.
	    */
	    public static MultiParamMailer mail() {
	    	MultiParamMailer builder = new MultiParamMailer();
	    	return builder;
	    }

	    /**
	    * Generated chain method.
	    *
	    */
	    public MultiParamMailer fromTo(String sender, String receiver) {
	    	//TODO auto generated chain method codeblock
	    	this.sender = sender; 
	    	this.receiver = receiver; 

	    	return this;
	    }
	    
	    /**
	    * Generated chain method.
	    *
	    */
	    public MultiParamMailer subject(String subject) {
	    	//TODO auto generated chain method codeblock
	    	this.subject = subject; 

	    	return this;
	    }
	    
	    /**
	    * Generated chain method.
	    *
	    */
	    public MultiParamMailer body(String text) {
	    	//TODO auto generated chain method codeblock
	    	this.text = text; 

	    	return this;
	    }
	    

	    /**
	    *
	    * Generated build method
	    */
	    public MultiParamMailer send() {
	    	//TODO auto generated build method codeblock
	    	return this;
	    }

}