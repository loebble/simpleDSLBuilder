package de.htwg.SimpleDSLBuilder.Creator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**-
 * Defines Meta Model
 * 
 * Given Language/Model Description has to be in REGEX_PATTERN valid form
 * 
 *
 */
public class ScopeBuildPatternCreator {
	public static final String REGEX_PATTERN= "dslName=\\w+\\.ep=\\w+(\\.o?m=\\w+:\\w+\\{\\w+(\\s?\\,\\s?\\w+\\??)*\\})+\\.imp=\\{(\\w+(\\.)?)+(\\s?\\,\\s? (\\w+(\\.)?)+)*\\}\\.build=\\w+";
	private static final String NO_MATCH = "Given String does not match BuildPatternCreator Regex Pattern: \n" +REGEX_PATTERN;
	private static final String WRONG_DECLARATION = "Method not declared correctly";
	
	public static final String DSL_NAME = "dslName=\\w+";
	public static final String ENTRY_POINT = "\\.ep=\\w+";
	public static final String METHODS = "\\.o?m=\\w+:\\w+\\{\\w+(\\s?\\,\\s?\\w+\\??)*\\}";
	public static final String PARAMETER_TYPE = ":\\w+\\{";
	public static final String METHOD_NAME = "=\\w+:";
	public static final String NEXT_SCOPES = "\\{\\w+(\\s?\\,\\s?\\w+\\??)*\\}";
	public static final String SINGLE_SCOPE = "\\w+\\??";
	public static final String OPTIONAL_METHODS = "\\w+\\?";
	public static final String MANDATORY_METHODS = "\\.m=\\w+:\\w+\\{\\w+(\\s?\\,\\s?\\w+\\??)*\\}";
	public static final String BUILD = "\\.build=\\w+";
	public static final String IMPORT = "\\.imp=\\{(\\w+(\\.)?)+(\\s?\\,\\s? (\\w+(\\.)?)+)*\\}";
	public static final String IMPORT_PARAMETER = "(\\w+(\\.)?)+";
	
	private static final Pattern NAME_PATTERN = Pattern.compile(DSL_NAME, Pattern.CASE_INSENSITIVE);
	private static final Pattern EP_PATTERN = Pattern.compile(ENTRY_POINT, Pattern.CASE_INSENSITIVE);
	private static final Pattern METHOD_PATTERN= Pattern.compile(METHODS, Pattern.CASE_INSENSITIVE);
	private static final Pattern METHOD_NAME_PATTERN= Pattern.compile(METHOD_NAME, Pattern.CASE_INSENSITIVE);
	private static final Pattern MANDATORY_METHODS_PATTERN= Pattern.compile(MANDATORY_METHODS, Pattern.CASE_INSENSITIVE);
	private static final Pattern OPTIONAL_METHODS_PATTERN= Pattern.compile(OPTIONAL_METHODS, Pattern.CASE_INSENSITIVE);
	private static final Pattern PARAMETER_TYPE_PATTERN= Pattern.compile(PARAMETER_TYPE, Pattern.CASE_INSENSITIVE);
	private static final Pattern NEXT_SCOPES_PATTERN= Pattern.compile(NEXT_SCOPES, Pattern.CASE_INSENSITIVE);
	private static final Pattern SINGLE_SCOPE_PATTERN= Pattern.compile(SINGLE_SCOPE, Pattern.CASE_INSENSITIVE);
	private static final Pattern BUILD_PATTERN = Pattern.compile(BUILD, Pattern.CASE_INSENSITIVE);
	private static final Pattern IMPORT_PATTERN = Pattern.compile(IMPORT, Pattern.CASE_INSENSITIVE);
	private static final Pattern IMPORT_PARAMETER_PATTERN = Pattern.compile(IMPORT_PARAMETER, Pattern.CASE_INSENSITIVE);
	
	private String  languageDescr;
	private Matcher nameMatcher;
	private Matcher epMatcher;
	private Matcher methodMatcher;
	private Matcher mandatoryMethodMatcher;
	private Matcher optionalMethodMatcher;
	private Matcher nextScopesMatcher;
	private Matcher nextSingleScopeMatcher;
	private Matcher buildMatcher;
	private Matcher methodNameMatcher;
	private Matcher importMatcher;
	private Matcher importParameterMatcher;
	
	private String dslName;
	private String entryPointMethod;
	private List<String> methodDeclarations;
	private Map<String,String> chainMethods;
	private List<String> optionalMethods;
	private Map<String,String> mandatoryMethods;
	private Map<String,List<String>> nextMethods;
	private Map<String,List<String>> nextOptionalMethods;
	private String buildMethodName;
	private List<String> imports;
	
	private ScopeBuildPatternCreator(){}
	
	public static ScopeBuildPatternCreator getInstance(String languageDescr){
		if(!languageDescr.matches(REGEX_PATTERN)){
			throw new IllegalArgumentException(NO_MATCH);
		}
		ScopeBuildPatternCreator creator = new ScopeBuildPatternCreator();
		creator.languageDescr = languageDescr;
		creator.nameMatcher = NAME_PATTERN.matcher(creator.languageDescr);
		creator.epMatcher = EP_PATTERN.matcher(creator.languageDescr);
		creator.methodMatcher = METHOD_PATTERN.matcher(creator.languageDescr);
		creator.buildMatcher = BUILD_PATTERN.matcher(creator.languageDescr);
		creator.importMatcher = IMPORT_PATTERN.matcher(creator.languageDescr);
		creator.optionalMethodMatcher = OPTIONAL_METHODS_PATTERN.matcher(creator.languageDescr);
		creator.mandatoryMethodMatcher = MANDATORY_METHODS_PATTERN.matcher(creator.languageDescr);
		creator.methodDeclarations = new ArrayList<String>();
		return creator;
	}
	
	public String getDslName(){
		if(this.dslName == null && this.nameMatcher.find()){
			String found = nameMatcher.group();
			this.dslName = found.substring(8);
		}
		return this.dslName;
	}
	
	public String getEntryPointMethod(){
		if(this.entryPointMethod == null && this.epMatcher.find()){
			String found = epMatcher.group();
			this.entryPointMethod = found.substring(4);
		}
		return this.entryPointMethod;
	}
	
	public Map<String,String> getMandatoryMethods() {
		if(this.mandatoryMethods == null){
			this.mandatoryMethods = new LinkedHashMap<String,String>();
			while(this.mandatoryMethodMatcher.find())
				putMethodInMap(mandatoryMethodMatcher.group(), this.mandatoryMethods);
		}
		return this.mandatoryMethods;
	}
	
	public List<String> getOptionalMethods() {
		if(this.optionalMethods == null){
			this.optionalMethods = new ArrayList<>();
			while(this.optionalMethodMatcher.find()){
				String tmp = optionalMethodMatcher.group();
				String optionalMeth = tmp.substring(0,tmp.length()-1);
				if(!this.optionalMethods.contains(optionalMeth))
					this.optionalMethods.add(optionalMeth);
			}
		}
		return this.optionalMethods;
	}
	
	/**
	 * 
	 * @return ordered java.util.Map containing methodname parametersType. 
	 */
	public Map<String,String> getChainMethods(){
		if(this.chainMethods == null){
			this.chainMethods = new LinkedHashMap<String,String>();
			while(this.methodMatcher.find()){
				String methodDecl = methodMatcher.group();
				putMethodInMap(methodDecl, this.chainMethods);
				this.methodDeclarations.add(methodDecl);
			}
		}
		return this.chainMethods;
	}
	
	public Map<String, List<String>> getNextMethods() {
		if(this.chainMethods == null)
			this.getChainMethods();
		if(this.nextMethods == null){
			this.nextMethods = new LinkedHashMap<>();
			setNextMethods(methodDeclarations, false, this.nextMethods);
		}
		return this.nextMethods;
	}
	
	public Map<String, List<String>> getNextOptionalMethods() {
		if(this.nextMethods == null)
			this.getNextMethods();
		if(this.nextOptionalMethods == null){
			this.nextOptionalMethods = new LinkedHashMap<>();
			setNextMethods(methodDeclarations, true, this.nextOptionalMethods);
		}
		return this.nextOptionalMethods;
	}
	
	private void setNextMethods(List<String> methods, boolean optional, Map<String,List<String>> map) {
		int methodsCount = methods.size();
		if(methodsCount == 0) //TODO change if empty brackets are possible
			return;
		for (String methodDecl: methods) {
			int i = 0;
			this.methodNameMatcher = METHOD_NAME_PATTERN.matcher(methodDecl);
			this.methodNameMatcher.find();
			String methodName = this.methodNameMatcher.group();
			methodName = methodName.substring(1,methodName.length()-1);
			this.nextScopesMatcher = NEXT_SCOPES_PATTERN.matcher(methodDecl);
			if(this.nextScopesMatcher.find()){
				String nextScopes = this.nextScopesMatcher.group();
				this.nextSingleScopeMatcher = SINGLE_SCOPE_PATTERN.matcher(nextScopes);
				List<String> scopes = new ArrayList<>();
				while(this.nextSingleScopeMatcher.find()){
					String nextScopeName = this.nextSingleScopeMatcher.group();
					if(optional && !nextScopeName.endsWith("?"))
						continue; //Skip if only optional is required
					else if(!optional && nextScopeName.endsWith("?"))
						continue;
					else scopes.add(nextScopeName);
				}
				if(scopes.size()>0)
					map.put(methodName, scopes);
			}
		}
	}

	public String getBuildMethodName(){
		if(this.buildMethodName == null && this.buildMatcher.find()){
			String found = buildMatcher.group();
			buildMethodName = found.substring(7);
		}
		return this.buildMethodName;
	}
	
	public List<String> getImports(){
		if(this.imports == null && this.importMatcher.find()){
			imports = new ArrayList<>();
			String importString = importMatcher.group().substring(4);
			//initialize importParameterMatcher with found imports
			this.importParameterMatcher = IMPORT_PARAMETER_PATTERN.matcher(importString);
			while(this.importParameterMatcher.find()){
				String toImport = importParameterMatcher.group();
				if(!toImport.equals(""))
					imports.add(toImport);
			}
		}
		return imports;
	}
	
	private void putMethodInMap(String methodDesc, Map<String,String> methodMap){
		String methodName = "";
		String type = "";
		//initialize parameter Matcher with found method description
		this.methodNameMatcher = METHOD_NAME_PATTERN.matcher(methodDesc);
		if(this.methodNameMatcher.find()){
			String tmpName = methodNameMatcher.group();
			methodName = tmpName.substring(1, tmpName.length()-1);
		}
		Matcher parameterTypeMatcher = PARAMETER_TYPE_PATTERN.matcher(methodDesc);
		if(parameterTypeMatcher.find()){
			String tmpType = parameterTypeMatcher.group();
			type = tmpType.substring(1, tmpType.length()-1);
		}
		if(methodName.equals("") || type.equals(""))
			throw new IllegalArgumentException(WRONG_DECLARATION);
		methodMap.put(methodName,type);
	}
	
}
