package de.htwg.SimpleDSLBuilder.Test;

import static de.htwg.SimpleDSLBuilder.Model.DSLModels.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import de.htwg.SimpleDSLBuilder.Creator.MultiParamBuildPatternCreator;

public class BlochBuilderTest {
	
	public static void main(String[] args) {
		MultiParamBuildPatternCreator builder = createUserModel();
		final String projectPath = Paths.get(".").toAbsolutePath().normalize().toString();
		File templateDirecorty = new File(projectPath+"/templates");
		if(!templateDirecorty.exists()){
			System.out.println("doesn't exist");
			templateDirecorty.mkdirs();
		} else System.out.println("exists "+templateDirecorty.getAbsolutePath());
		STGroup group = new STGroupFile(templateDirecorty+"/BlochBuilderTemplate.stg");
		ST simpleBT = group.getInstanceOf("BuilderTemplate");
		String targetPackage = "de.htwg.generated.builderBloch";
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
			PrintWriter writer = new PrintWriter(pathForDSL+"\\"+builder.getDslName()+".java");
			writer.print(res);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
