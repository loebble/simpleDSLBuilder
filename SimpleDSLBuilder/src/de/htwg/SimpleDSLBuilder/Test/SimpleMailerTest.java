package de.htwg.SimpleDSLBuilder.Test;

import static de.htwg.SimpleDSLBuilder.Model.DSLModels.createSimpleBuilderModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Map;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.StringRenderer;

import de.htwg.SimpleDSLBuilder.Creator.SimpleBuildPatternCreator;

public class SimpleMailerTest {

	public static void main(String[] args) {
		
		final String projectPath = Paths.get(".").toAbsolutePath().normalize().toString();
		File templateDirecorty = new File(projectPath+"/templates");
		if(!templateDirecorty.exists()){
			System.out.println("doesn't exist");
			templateDirecorty.mkdirs();
		} else System.out.println("exists "+templateDirecorty.getAbsolutePath());
		STGroup group = new STGroupFile(templateDirecorty+"/SimpleBuilderTemplate.stg");
		group.registerRenderer(String.class, new StringRenderer());
		ST simpleBT = group.getInstanceOf("BuilderTemplate");
		SimpleBuildPatternCreator builder = createSimpleBuilderModel();
		String targetPackage = "de.htwg.generated.builderSimple";
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
			System.out.println(pathForDSL); 
			PrintWriter writer = new PrintWriter(pathForDSL+"\\"+builder.getDslName()+"Builder.java");
			writer.print(res);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void printChainMethods(Map<String,String> chains){
		for (Map.Entry<String,String> entry : chains.entrySet())
        {
        	String methodName= (String) entry.getKey();
        	String paramType= (String) entry.getValue();
        	System.out.print(methodName +"-"+ paramType );
        }
	}
}
