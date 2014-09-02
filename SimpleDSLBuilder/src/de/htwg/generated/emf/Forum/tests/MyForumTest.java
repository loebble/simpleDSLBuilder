/**
 */
package de.htwg.generated.emf.Forum.tests;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.htwg.generated.emf.Forum.Address;
import de.htwg.generated.emf.Forum.ForumFactory;
import de.htwg.generated.emf.Forum.ForumPackage;
import de.htwg.generated.emf.Forum.User;

/**
 * <!-- begin-user-doc -->
 * A sample utility for the '<em><b>Forum</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class MyForumTest {
	/**
	 * <!-- begin-user-doc -->
	 * Load all the argument file paths or URIs as instances of the model.
	 * <!-- end-user-doc -->
	 * @param args the file paths or URIs.
	 * @generated
	 */
	public static void main(String[] args) {
		User user = ForumFactory.eINSTANCE.createUser();
		Address address = ForumFactory.eINSTANCE.createAddress();
		address.setHouseNumber(-2);
		address.setStreet("Zasiusstraﬂe");
		user.setAddress(address);
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(user);
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			printDiagnostic(diagnostic, "");
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * Prints diagnostics with indentation.
	 * <!-- end-user-doc -->
	 * @param diagnostic the diagnostic to print.
	 * @param indent the indentation for printing.
	 * @generated
	 */
	protected static void printDiagnostic(Diagnostic diagnostic, String indent) {
		System.out.print(indent);
		System.out.println(diagnostic.getMessage());
		for (Diagnostic child : diagnostic.getChildren()) {
			printDiagnostic(child, indent + "  ");
		}
	}

} //ForumExample
