package de.htwg.SimpleDSLBuilder.Creator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**-
 * Defines Meta Model
 *
 * Use for Model Description String valid to REGEX_PATTERN regular Expression
 * 
 * Form: dslName=<someName>.ep=<DSLEntryPointMethodName>.m=<chainMethodName>(<JavaMethodParameters>).imp=(<imports>).build=<buildMethodName>;
 *
 */
public class MultiParamBuildPatternCreator {
	public static final String REGEX_PATTERN= "dslName=\\w+\\.ep=\\w+(\\.m=\\w+\\(\\w+\\s\\w+(\\s?\\,\\s?\\w+\\s\\w+)*\\))+(\\.imp=\\((\\w+(\\.)?)+(\\s?\\,\\s? (\\w+(\\.)?)+)*\\))?\\.build=\\w+";
	public static final String DSL_NAME = "dslName=\\w+";
	public static final String ENTRY_POINT = "\\.ep=\\w+";
	public static final String METHODS = "\\.m=\\w+\\(\\w+\\s\\w+(\\s?\\,\\s?\\w+\\s\\w+)*\\)";
	public static final String METHOD_NAME = "\\w+\\(";
	public static final String PARAMETER = "\\w+\\s\\w+";
	public static final String PARAMETER_NAME = "\\s\\w+";
	public static final String PARAMETER_TYPE = "\\w+\\s";
	public static final String BUILD = "\\.build=\\w+";
	public static final String IMPORT = "\\.imp=\\((\\w+(\\.)?)+(\\s?\\,\\s? (\\w+(\\.)?)+)*\\)";
	public static final String IMPORT_PARAMETER = "(\\w+(\\.)?)+";
	private static final String NO_MATCH = "Given String does not match BuildPatternCreator Regex Pattern: \n" +REGEX_PATTERN;
	private static final Pattern NAME_PATTERN = Pattern.compile(DSL_NAME, Pattern.CASE_INSENSITIVE);
	private static final Pattern EP_PATTERN = Pattern.compile(ENTRY_POINT, Pattern.CASE_INSENSITIVE);
	private static final Pattern METHOD_PATTERN= Pattern.compile(METHODS, Pattern.CASE_INSENSITIVE);
	private static final Pattern METHOD_NAME_PATTERN= Pattern.compile(METHOD_NAME, Pattern.CASE_INSENSITIVE);
	private static final Pattern PARAMETER_PATTERN = Pattern.compile(PARAMETER, Pattern.CASE_INSENSITIVE);
	private static final Pattern PARAMETER_NAME_PATTERN= Pattern.compile(PARAMETER_NAME, Pattern.CASE_INSENSITIVE);
	private static final Pattern PARAMETER_TYPE_PATTERN= Pattern.compile(PARAMETER_TYPE, Pattern.CASE_INSENSITIVE);
	private static final Pattern BUILD_PATTERN = Pattern.compile(BUILD, Pattern.CASE_INSENSITIVE);
	private static final Pattern IMPORT_PATTERN = Pattern.compile(IMPORT, Pattern.CASE_INSENSITIVE);
	private static final Pattern IMPORT_PARAMETER_PATTERN = Pattern.compile(IMPORT_PARAMETER, Pattern.CASE_INSENSITIVE);
	
	private String  languageDescr;
	private Matcher nameMatcher;
	private Matcher epMatcher;
	private Matcher methodMatcher;
	private Matcher buildMatcher;
	private Matcher methodNameMatcher;
	private Matcher parameterMatcher;
	private Matcher importMatcher;
	private Matcher importParameterMatcher;
	
	private String dslName;
	private String entryPointMethod;
	private Map<String,Map<String,String>> chainMethods;
	private String buildMethodName;
	private ArrayList<String> imports;
	
	private MultiParamBuildPatternCreator(){}
	
	public static MultiParamBuildPatternCreator getInstance(String languageDescr){
		if(!languageDescr.matches(REGEX_PATTERN)){
			throw new IllegalArgumentException(NO_MATCH);
		}
		MultiParamBuildPatternCreator creator = new MultiParamBuildPatternCreator();
		creator.languageDescr = languageDescr;
		creator.nameMatcher = NAME_PATTERN.matcher(creator.languageDescr);
		creator.epMatcher = EP_PATTERN.matcher(creator.languageDescr);
		creator.methodMatcher = METHOD_PATTERN.matcher(creator.languageDescr);
		creator.buildMatcher = BUILD_PATTERN.matcher(creator.languageDescr);
		creator.methodNameMatcher = METHOD_NAME_PATTERN.matcher(creator.languageDescr);
		creator.importMatcher = IMPORT_PATTERN.matcher(creator.languageDescr);
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
			String method = epMatcher.group().substring(4);
			this.entryPointMethod = method;
		}
		return this.entryPointMethod;
	}
	
	/**
	 * 
	 * @return ordered java.util.Map containing methodname and corresponding methodparameters, which are also hold in a map. 
	 * Form: Map<methodName,Map<parameterType,parameterName>>.
	 */
	public Map<String,Map<String,String>> getChainMethods(){
		if(this.chainMethods != null)
			return this.chainMethods;
		this.chainMethods = new LinkedHashMap<String,Map<String,String>>();
		while(this.methodMatcher.find()){
			Map<String,String> parameters= new LinkedHashMap<>();
			String methodName = "";
			String parameterName = "";
			String parameterType = "";
			//initialize parameter Matcher with found method declaration
			this.parameterMatcher = PARAMETER_PATTERN.matcher(methodMatcher.group());
			if(this.methodNameMatcher.find()){
				String tmp = methodNameMatcher.group();
				methodName = tmp.substring(0, tmp.length()-1);
			}
			while(this.parameterMatcher.find()){
				String parameterCombination = parameterMatcher.group();
				Matcher parameterNameMatcher = PARAMETER_NAME_PATTERN.matcher(parameterCombination);
				Matcher parameterTypeMatcher = PARAMETER_TYPE_PATTERN.matcher(parameterCombination);
				if(parameterNameMatcher.find())
					parameterName = parameterNameMatcher.group().substring(1);
				if(parameterTypeMatcher.find())
					parameterType = parameterTypeMatcher.group().substring(0, parameterTypeMatcher.group().length()-1);
				parameters.put(parameterName, parameterType);
			}
			this.chainMethods.put(methodName,parameters);
		}
		return chainMethods;
	}

	public String getBuildMethodName(){
		if(this.buildMethodName == null && this.buildMatcher.find()){
			String found = buildMatcher.group();
			buildMethodName = found.substring(7);
		}
		return this.buildMethodName;
	}
	
	public ArrayList<String> getImports(){
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
	

}
