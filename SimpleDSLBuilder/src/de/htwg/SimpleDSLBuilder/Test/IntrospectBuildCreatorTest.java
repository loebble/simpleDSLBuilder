package de.htwg.SimpleDSLBuilder.Test;

import java.util.Map;

import de.htwg.SimpleDSLBuilder.Creator.IntrospectBuildCreator;

public class IntrospectBuildCreatorTest {

	public static void main(String[] args) {
		IntrospectBuildCreator creator = IntrospectBuildCreator.getInstance("de.htwg.user.emf.UserModel.User");
		for (Map.Entry<String,String> method : creator.getSetterMethods().entrySet()) {
			System.out.println(method.getKey() +" paramType: "+ method.getValue());
		}
	}

}
