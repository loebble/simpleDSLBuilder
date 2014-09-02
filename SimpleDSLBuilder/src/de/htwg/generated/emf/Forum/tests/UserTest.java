/**
 */
package de.htwg.generated.emf.Forum.tests;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.omg.PortableInterceptor.SUCCESSFUL;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import de.htwg.generated.emf.Forum.Address;
import de.htwg.generated.emf.Forum.ForumFactory;
import de.htwg.generated.emf.Forum.User;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.htwg.generated.emf.Forum.User#hasAddress(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has Address</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class UserTest extends TestCase {

	/**
	 * The fixture for this User test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected User fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(UserTest.class);
	}

	/**
	 * Constructs a new User test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this User test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(User fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this User test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected User getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ForumFactory.eINSTANCE.createUser());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link de.htwg.generated.emf.Forum.User#hasAddress(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has Address</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.htwg.generated.emf.Forum.User#hasAddress(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testHasAddress__DiagnosticChain_Map() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}
	
	public void testUserHasAddress() {
		User user = ForumFactory.eINSTANCE.createUser();
		Address address = ForumFactory.eINSTANCE.createAddress();
		address.setHouseNumber(-2);
		address.setStreet("Zasiusstraﬂe");
		user.setAddress(address);
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(user);
		boolean valid = diagnostic.getSeverity() == Diagnostic.OK; 
		if (!valid){
			printDiagnostic(diagnostic, "");
		}
		assertTrue(valid);
	}
	
	protected static void printDiagnostic(Diagnostic diagnostic, String indent) {
		System.out.print(indent);
		System.out.println(diagnostic.getMessage());
		for (Diagnostic child : diagnostic.getChildren()) {
			printDiagnostic(child, indent + "  ");
		}
	}

} //UserTest
