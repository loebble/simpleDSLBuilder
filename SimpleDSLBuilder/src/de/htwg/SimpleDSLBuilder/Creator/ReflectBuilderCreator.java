package de.htwg.SimpleDSLBuilder.Creator;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.htwg.SimpleDSLBuilder.Creator.DSLBuilderModel.ClassAttribute;
import de.htwg.SimpleDSLBuilder.Creator.DSLBuilderModel.ModelClass;

public class ReflectBuilderCreator {
	private String modelPackage;
	private Class factoryClass;
	private Set<String> primitiveTypes;
	private Map<String, String> definedEClasses;
	private Map<String, String> parameterType;
	private Map<String, String> setterMethods;
	private Map<String, Map<String, String>> eclassWithMethods;

	private String dslName;
	private String entryPointMethod;
	private String buildMethodName;
	private ArrayList<String> imports;
	
	private DSLBuilderModel builderModel;

	public DSLBuilderModel getBuilderModel() {
		return builderModel;
	}

	private ReflectBuilderCreator() {}

	public static ReflectBuilderCreator getInstance(String fullyQUalifiedFactoryName) {
		ReflectBuilderCreator creator = new ReflectBuilderCreator();
		try {
			creator.builderModel = new DSLBuilderModel();
			creator.factoryClass = Class.forName(fullyQUalifiedFactoryName);
			creator.modelPackage = creator.factoryClass.getPackage().getName();
			creator.builderModel.addImports(creator.modelPackage);
			creator.retrieveEClasses();
		} catch (ClassNotFoundException e) {
			System.err.println("The FactoryClass at " + fullyQUalifiedFactoryName
					+ " was not found.");
		}
		return creator;
	}
	
	private void retrieveEClasses(){
		if (this.definedEClasses == null)
			this.definedEClasses = new LinkedHashMap<String, String>();
		if (this.eclassWithMethods == null)
			this.eclassWithMethods = new LinkedHashMap<>();
		for (Method m : factoryClass.getDeclaredMethods()) {
			String methodName = m.getName();
			if (!methodName.startsWith("create"))
				continue;
			String eclassName = methodName.replaceFirst("create", "");
			String fullyQulifedName = this.modelPackage+"."+eclassName;
			try {
				Class.forName(fullyQulifedName);
				ModelClass modelClass = builderModel.new ModelClass();
				modelClass.setClassName(eclassName);
				builderModel.getClasses().put(eclassName,modelClass);
				builderModel.addImports(fullyQulifedName);
				this.retrieveSetters(eclassName,fullyQulifedName,modelClass);
				definedEClasses.put(eclassName,fullyQulifedName);
			} catch (ClassNotFoundException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	private void retrieveSetters(String eclassName, String qualifiedClass, ModelClass modelClass) throws ClassNotFoundException{
		Class eClass = Class.forName(qualifiedClass);
		Map<String, String> setterMethods = new LinkedHashMap<>();
		for (Method m : eClass.getDeclaredMethods()) {
			String methodName = m.getName();
			Class[] parameterTypes = m.getParameterTypes();
			if (!methodName.startsWith("set") || parameterTypes.length != 1)
				continue;
			for (Class paramType : parameterTypes) {
				ClassAttribute attr = builderModel.new ClassAttribute();
				String canocicalType = paramType.getCanonicalName();
				setterMethods.put(methodName, canocicalType); //TODO annotation for optional and default value
				attr.setType(canocicalType);
				attr.setAttributeName(methodName);
				modelClass.addAttribute(attr);
			}
			if(setterMethods.size() != 0)
				this.eclassWithMethods.put(eclassName, setterMethods);
		}
	}
	
	
	public void printEclassWithMethods(){
		if(this.eclassWithMethods.size() <= 0)
			return;
		for (Map.Entry<String,Map<String,String>> eClass : this.getEclassWithMethods().entrySet()) {
			System.out.println("EClass: " + eClass.getKey());
			System.out.println("Methods: ");
			if(eClass.getValue().size() <= 0){
				System.out.println("No setters!");
				continue;
			}
			for (Map.Entry<String,String> method : eClass.getValue().entrySet()) {
				System.out.println(method.getKey()+"("+method.getValue()+")");
			}
		}
	}

	public Set<String> getPrimitiveTypes() {
		return primitiveTypes;
	}

	public void setPrimitiveTypes(Set<String> primitiveTypes) {
		this.primitiveTypes = primitiveTypes;
	}

	public String getModelPackage() {
		return modelPackage;
	}

	public Class getFactoryClass() {
		return factoryClass;
	}

	public Map<String, String> getDefinedEClasses() {
		return definedEClasses;
	}

	public Map<String, Map<String, String>> getEclassWithMethods() {
		return eclassWithMethods;
	}

	public String getDslName() {
		return dslName;
	}

	public String getBuildMethodName() {
		return buildMethodName;
	}

	public ArrayList<String> getImports() {
		return imports;
	}

}
