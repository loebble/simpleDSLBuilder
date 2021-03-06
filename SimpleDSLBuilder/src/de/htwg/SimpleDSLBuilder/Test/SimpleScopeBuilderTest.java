package de.htwg.SimpleDSLBuilder.Test;

import static de.htwg.SimpleDSLBuilder.Model.DSLModels.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Map;

import org.antlr.v4.parse.ScopeParser;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.StringRenderer;

import de.htwg.SimpleDSLBuilder.Creator.SimpleScopeBuildPatternCreator;
import de.htwg.user.Address;
import de.htwg.user.User;

public class SimpleScopeBuilderTest {

	public static void main(String[] args) {
		
		final String projectPath = Paths.get(".").toAbsolutePath().normalize().toString();
		File templateDirecorty = new File(projectPath+"/templates");
		if(!templateDirecorty.exists()){
			System.out.println("doesn't exist");
			templateDirecorty.mkdirs();
		} else System.out.println("exists "+templateDirecorty.getAbsolutePath());
		STGroup group = new STGroupFile(templateDirecorty+"/SimpleScopeBuilderTemplate.stg");
		group.registerRenderer(String.class, new StringRenderer());
		ST simpleBT = group.getInstanceOf("BuilderTemplate");
		SimpleScopeBuildPatternCreator builder = SimpleScopeBuildPatternCreator.getInstance(userSimpleScopeDescription);
		String targetPackage = "de.htwg.generated.builderSimpleScope";
		simpleBT.add("packageName",targetPackage);
		simpleBT.add("builder",builder);
		String res = simpleBT.render();
		System.out.println(res);
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
	
}
