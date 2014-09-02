/**
 */
package de.htwg.generated.emf.Forum;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Address</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.htwg.generated.emf.Forum.Address#getStreet <em>Street</em>}</li>
 *   <li>{@link de.htwg.generated.emf.Forum.Address#getHouseNumber <em>House Number</em>}</li>
 *   <li>{@link de.htwg.generated.emf.Forum.Address#getZipCode <em>Zip Code</em>}</li>
 *   <li>{@link de.htwg.generated.emf.Forum.Address#getAdditional <em>Additional</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.htwg.generated.emf.Forum.ForumPackage#getAddress()
 * @model annotation="Ecore constraints='NonNegativeValue ValidHouseNumber'"
 * @generated
 */
public interface Address extends EObject {
	/**
	 * Returns the value of the '<em><b>Street</b></em>' attribute.
	 * The default value is <code>"null"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Street</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Street</em>' attribute.
	 * @see #setStreet(String)
	 * @see de.htwg.generated.emf.Forum.ForumPackage#getAddress_Street()
	 * @model default="null" required="true"
	 * @generated
	 */
	String getStreet();

	/**
	 * Sets the value of the '{@link de.htwg.generated.emf.Forum.Address#getStreet <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Street</em>' attribute.
	 * @see #getStreet()
	 * @generated
	 */
	void setStreet(String value);

	/**
	 * Returns the value of the '<em><b>House Number</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>House Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>House Number</em>' attribute.
	 * @see #setHouseNumber(int)
	 * @see de.htwg.generated.emf.Forum.ForumPackage#getAddress_HouseNumber()
	 * @model default="0" unique="false" required="true"
	 * @generated
	 */
	int getHouseNumber();

	/**
	 * Sets the value of the '{@link de.htwg.generated.emf.Forum.Address#getHouseNumber <em>House Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>House Number</em>' attribute.
	 * @see #getHouseNumber()
	 * @generated
	 */
	void setHouseNumber(int value);

	/**
	 * Returns the value of the '<em><b>Zip Code</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zip Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zip Code</em>' attribute.
	 * @see #setZipCode(int)
	 * @see de.htwg.generated.emf.Forum.ForumPackage#getAddress_ZipCode()
	 * @model default="0" unique="false" required="true"
	 * @generated
	 */
	int getZipCode();

	/**
	 * Sets the value of the '{@link de.htwg.generated.emf.Forum.Address#getZipCode <em>Zip Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zip Code</em>' attribute.
	 * @see #getZipCode()
	 * @generated
	 */
	void setZipCode(int value);

	/**
	 * Returns the value of the '<em><b>Additional</b></em>' attribute.
	 * The default value is <code>"null"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additional</em>' attribute.
	 * @see #setAdditional(String)
	 * @see de.htwg.generated.emf.Forum.ForumPackage#getAddress_Additional()
	 * @model default="null" unique="false"
	 * @generated
	 */
	String getAdditional();

	/**
	 * Sets the value of the '{@link de.htwg.generated.emf.Forum.Address#getAdditional <em>Additional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Additional</em>' attribute.
	 * @see #getAdditional()
	 * @generated
	 */
	void setAdditional(String value);

} // Address
