package de.htwg.SimpleDSLBuilder.Model;

import de.htwg.SimpleDSLBuilder.Creator.*;

public class DSLModels {
	
	public final static String simpleMailerDescription = "dslName=Mailer"
			+ ".ep=mail.m=from(String)"
			+ ".m=to(String)"
			+ ".m=subject(String)"
			+ ".m=body(String)"
			+ ".build=send";
	
	public final static String multiParamMailerDescription = "dslName=MultiParamMailer"
			+ ".ep=mail.m=fromTo(String sender, String receiver)"
			+ ".m=subject(String subject)"
			+ ".m=body(String text)"
			+ ".build=send";
	
	public final static String userDescription = "dslName=User"
			+ ".ep=user.m=name(String firstName)"
			+ ".m=email(String email)"
			+ ".m=phone(String phoneNumber)"
			+ ".m=age(int age)"
			+ ".m=adress(Address address)"
			+ ".imp=(de.htwg.user.Address)"
			+ ".build=build";
	
	public final static String userScopeDescription = "dslName=User"
			+ ".ep=user.m=firstName(String)"
			+ ".m=lastName(String)"
			+ ".m=email(String)"
			+ ".m=phone(String)"
			+ ".m=age(int)"
			+ ".m=address(Address)"
			+ ".imp=(de.htwg.user.Address, de.htwg.user.User)"
			+ ".build=build";
	

	public static SimpleBuildPatternCreator createSimpleBuilderModel() {
		SimpleBuildPatternCreator creator = SimpleBuildPatternCreator.getInstance(simpleMailerDescription);
		return creator;
	}
	
	
	public static MultiParamBuildPatternCreator createMultipleParameterModel() {
		MultiParamBuildPatternCreator creator = MultiParamBuildPatternCreator.getInstance(multiParamMailerDescription);
		return creator;
	}
	
	public static MultiParamBuildPatternCreator createUserModel() {
		MultiParamBuildPatternCreator creator = MultiParamBuildPatternCreator.getInstance(userDescription);
		return creator;
	}
	
	
	

}
