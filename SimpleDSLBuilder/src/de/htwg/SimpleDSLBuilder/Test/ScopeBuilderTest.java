package de.htwg.SimpleDSLBuilder.Test;

import static de.htwg.SimpleDSLBuilder.Model.DSLModels.userScopeDescription;
import static de.htwg.generated.User.UserBuilder.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.StringRenderer;

import de.htwg.SimpleDSLBuilder.Creator.ScopeBuildPatternCreator;
import de.htwg.user.Address;
import de.htwg.user.User;

public class ScopeBuilderTest {

	public static void main(String[] args) {
		
		final String projectPath = Paths.get(".").toAbsolutePath().normalize().toString();
		File templateDirecorty = new File(projectPath+"/templates");
		if(!templateDirecorty.exists()){
			System.out.println("doesn't exist");
			templateDirecorty.mkdirs();
		} else System.out.println("exists "+templateDirecorty.getAbsolutePath());
		STGroup group = new STGroupFile(templateDirecorty+"/ScopeBuilderTemplate.stg");
		group.registerRenderer(String.class, new StringRenderer());
		ST simpleBT = group.getInstanceOf("BuilderTemplate");
		ScopeBuildPatternCreator builder = ScopeBuildPatternCreator.getInstance(userScopeDescription);
		String targetPackage = "de.htwg.generated.User";
		simpleBT.add("packageName",targetPackage);
		simpleBT.add("builder",builder);
		String res = simpleBT.render();
//		System.out.println(res);
//		printStringMap(builder.getOptionalMethods());
//		System.out.println(builder.getEntryPointMethod());
//		printNextMethods(builder.getNextOptionalMethods());
		printNextMethods(builder.getNextMethods());
		try {
			String packagePath = targetPackage.replace(".", "\\");
			String pathForDSL = projectPath+"\\src\\"+packagePath;
			File targetDirectory = new File(pathForDSL);
			if(!targetDirectory.exists()){
				targetDirectory.mkdirs();
			}
			PrintWriter writer = new PrintWriter(pathForDSL+"\\"+builder.getDslName()+"Builder.java");
			writer.print(res);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	static void printStringMap(Map<String,String> chains){
		for (Map.Entry<String,String> entry : chains.entrySet())
        {
        	String methodName= (String) entry.getKey();
        	String paramType= (String) entry.getValue();
        	System.out.print(methodName +"-"+ paramType );
        }
	}
	
	static void printNextMethods(Map<String, List<String>> nextMethods){
		for (Map.Entry<String, List<String>> entry : nextMethods.entrySet())
        {
        	String methodName= (String) entry.getKey();
        	List<String> nextOnes= (List<String>) entry.getValue();
        	System.out.println(methodName +" nextOnes:");
        	for (String next : nextOnes) {
				System.out.print(next + " ");
			}
        	System.out.println();
        }
	}
}
