/**
 */
package de.htwg.generated.emf.Forum;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.htwg.generated.emf.Forum.User#getFirstName <em>First Name</em>}</li>
 *   <li>{@link de.htwg.generated.emf.Forum.User#getLastName <em>Last Name</em>}</li>
 *   <li>{@link de.htwg.generated.emf.Forum.User#getEmail <em>Email</em>}</li>
 *   <li>{@link de.htwg.generated.emf.Forum.User#getAddress <em>Address</em>}</li>
 *   <li>{@link de.htwg.generated.emf.Forum.User#getPhone <em>Phone</em>}</li>
 *   <li>{@link de.htwg.generated.emf.Forum.User#getAge <em>Age</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.htwg.generated.emf.Forum.ForumPackage#getUser()
 * @model
 * @generated
 */
public interface User extends EObject {
	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * The default value is <code>"null"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see de.htwg.generated.emf.Forum.ForumPackage#getUser_FirstName()
	 * @model default="null" required="true"
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link de.htwg.generated.emf.Forum.User#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute.
	 * The default value is <code>"null"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see de.htwg.generated.emf.Forum.ForumPackage#getUser_LastName()
	 * @model default="null" required="true" transient="true"
	 * @generated
	 */
	String getLastName();

	/**
	 * Sets the value of the '{@link de.htwg.generated.emf.Forum.User#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value);

	/**
	 * Returns the value of the '<em><b>Email</b></em>' attribute.
	 * The default value is <code>"null"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Email</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Email</em>' attribute.
	 * @see #setEmail(String)
	 * @see de.htwg.generated.emf.Forum.ForumPackage#getUser_Email()
	 * @model default="null" required="true" transient="true"
	 * @generated
	 */
	String getEmail();

	/**
	 * Sets the value of the '{@link de.htwg.generated.emf.Forum.User#getEmail <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email</em>' attribute.
	 * @see #getEmail()
	 * @generated
	 */
	void setEmail(String value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' reference.
	 * @see #setAddress(Address)
	 * @see de.htwg.generated.emf.Forum.ForumPackage#getUser_Address()
	 * @model required="true"
	 * @generated
	 */
	Address getAddress();

	/**
	 * Sets the value of the '{@link de.htwg.generated.emf.Forum.User#getAddress <em>Address</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' reference.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(Address value);

	/**
	 * Returns the value of the '<em><b>Phone</b></em>' attribute.
	 * The default value is <code>"null"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phone</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phone</em>' attribute.
	 * @see #setPhone(String)
	 * @see de.htwg.generated.emf.Forum.ForumPackage#getUser_Phone()
	 * @model default="null" transient="true"
	 * @generated
	 */
	String getPhone();

	/**
	 * Sets the value of the '{@link de.htwg.generated.emf.Forum.User#getPhone <em>Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phone</em>' attribute.
	 * @see #getPhone()
	 * @generated
	 */
	void setPhone(String value);

	/**
	 * Returns the value of the '<em><b>Age</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Age</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age</em>' attribute.
	 * @see #setAge(int)
	 * @see de.htwg.generated.emf.Forum.ForumPackage#getUser_Age()
	 * @model default="0" transient="true" ordered="false"
	 * @generated
	 */
	int getAge();

	/**
	 * Sets the value of the '{@link de.htwg.generated.emf.Forum.User#getAge <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Age</em>' attribute.
	 * @see #getAge()
	 * @generated
	 */
	void setAge(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasAddress(DiagnosticChain chain, Map<Object, Object> map);

} // User
