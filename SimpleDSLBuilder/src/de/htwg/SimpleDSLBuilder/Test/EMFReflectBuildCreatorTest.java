package de.htwg.SimpleDSLBuilder.Test;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.htwg.SimpleDSLBuilder.Creator.DSLBuilderModel;
import de.htwg.SimpleDSLBuilder.Creator.EMFReflectBuilderCreator;
import de.htwg.SimpleDSLBuilder.Creator.ReflectBuilderCreator;
import de.htwg.generated.emf.Forum.ForumPackage;

public class EMFReflectBuildCreatorTest {

	public static void main(String[] args) {
		ForumPackage forumPackage = ForumPackage.eINSTANCE;
		EMFReflectBuilderCreator creator = EMFReflectBuilderCreator.getInstance(forumPackage);
		DSLBuilderModel builderModel = creator.getBuilderModel();
		System.out.println(builderModel);
		System.out.println();
		System.out.println(builderModel.printOrder());
//		creator.printEclassWithMethods();
	}
	
	/**
	 * Retrieves the EClassifier of name from a package in a given Namespace-URI.
	 * Please make sure the EPackage Classifier are registered in EPackage.Registry
	 * 
	 * @param nsURI globally unique Namespase-URI
	 * @param name the name of the classifier
	 * @return EClassifier object if found or null if none where found
	 */
//	public static EClassifier retrieveEClassifier(String nsURI, String name){
//		EPackage ePackage = getEPackage(nsURI);
//		return ePackage == null ? null : ePackage.getEClassifier(name);
//	}
	
//	public static void printAllEntries (String nsURI){
//		for (Entry entry : EPackage.Registry.INSTANCE.entrySet()) {
//			System.out.println(entry.getKey() + " " +entry.getValue()+ " " +entry.getClass());	
//		}
//	}
	
	public static <T extends EPackage> EPackage getEPackage(T spezializedPackage){
		EPackage eP = (EPackage) spezializedPackage;
		return eP;
	}
	
	public static void printEPackage(EPackage ePackage){//TODO refactor or reference to book
		for (Iterator iter = ePackage.getEClassifiers().iterator(); iter.hasNext();) {
			EClassifier classifier = (EClassifier) iter.next();
			System.out.println(classifier.getName());
			System.out.print("  ");
			if (classifier instanceof EClass) {
				EClass eClass = (EClass) classifier;
				for (Iterator ai = eClass.getEAttributes().iterator(); ai.hasNext();) {
					EAttribute attribute = (EAttribute) ai.next();
					System.out.print(attribute.getName() + ":"+ attribute.getEAttributeType().getInstanceClassName()+"  ");
				}
				if(!eClass.getEAttributes().isEmpty() &&
						!eClass.getEReferences().isEmpty()){
					System.out.println();
					System.out.print("  ");
							
				}
				for (Iterator ri = eClass.getEReferences().iterator();ri.hasNext();){
					EReference reference = (EReference) ri.next();
					System.out.print(reference.getName() + ":" +reference.getEType().getInstanceTypeName());
				}
			}
			else if (classifier instanceof EEnum){
				EEnum eEnum = (EEnum)classifier;
				for (Iterator ei = eEnum.getELiterals().iterator();ei.hasNext();){
					EEnumLiteral literal = (EEnumLiteral) ei.next();
					System.out.print(literal.getName() + " ");
				}
			}
			else if (classifier instanceof EDataType) {
				EDataType eDataType = (EDataType)classifier;
				System.out.print(eDataType.getInstanceClassName() +":"+eDataType.getInstanceTypeName());
			}
			System.out.println();
		}
	}
	
	

}
