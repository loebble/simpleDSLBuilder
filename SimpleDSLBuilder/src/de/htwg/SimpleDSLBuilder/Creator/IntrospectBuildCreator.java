package de.htwg.SimpleDSLBuilder.Creator;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.xml.type.internal.RegEx.REUtil;

public class IntrospectBuildCreator {
	private Class modelClass;
	private Set<String> primitiveTypes;

	private String dslName;
	private String entryPointMethod;
	private Map<String, String> setterMethods;
	private Map<String, String> optionalMethods;
	private Map<String, String> nextMethods;
	private String buildMethodName;
	private ArrayList<String> imports;

	private IntrospectBuildCreator() {}

	public static IntrospectBuildCreator getInstance(String fullyQUalifiedModelName) {
		IntrospectBuildCreator creator = new IntrospectBuildCreator();
		try {
			creator.modelClass = Class.forName(fullyQUalifiedModelName);
			creator.getSetterMethods();
		} catch (ClassNotFoundException e) {
			System.err.println("The Class at " + fullyQUalifiedModelName
					+ " was not found.");
		}
		return creator;
	}

	public Map<String, String> getSetterMethods() {
		if (this.setterMethods == null) {
			this.setterMethods = new LinkedHashMap<>();
			for (Method m : modelClass.getMethods()) {
				String methodName = m.getName();
				Class[] parameterTypes = m.getParameterTypes();
				if (!methodName.startsWith("set") || parameterTypes.length == 0) //|| m.getModifiers() != Modifier.PUBLIC if Impl is itrospected
					continue;
				for (Class paramType : parameterTypes) {
					String canocicalType = paramType.getCanonicalName();
					setterMethods.put(methodName, canocicalType);
				}
			}
		}
		return this.setterMethods;
	}

}
