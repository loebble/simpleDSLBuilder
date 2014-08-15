/**
 */
package de.htwg.generated.emf.EMFUser.impl;

import de.htwg.generated.emf.EMFUser.Address;
import de.htwg.generated.emf.EMFUser.EMFUserPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Address</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.htwg.generated.emf.EMFUser.impl.AddressImpl#getStreet <em>Street</em>}</li>
 *   <li>{@link de.htwg.generated.emf.EMFUser.impl.AddressImpl#getHouseNumber <em>House Number</em>}</li>
 *   <li>{@link de.htwg.generated.emf.EMFUser.impl.AddressImpl#getZipCode <em>Zip Code</em>}</li>
 *   <li>{@link de.htwg.generated.emf.EMFUser.impl.AddressImpl#getAdditional <em>Additional</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AddressImpl extends MinimalEObjectImpl.Container implements Address {
	/**
	 * The default value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreet()
	 * @generated
	 * @ordered
	 */
	protected static final String STREET_EDEFAULT = "null";

	/**
	 * The cached value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreet()
	 * @generated
	 * @ordered
	 */
	protected String street = STREET_EDEFAULT;

	/**
	 * The default value of the '{@link #getHouseNumber() <em>House Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHouseNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int HOUSE_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHouseNumber() <em>House Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHouseNumber()
	 * @generated
	 * @ordered
	 */
	protected int houseNumber = HOUSE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getZipCode() <em>Zip Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZipCode()
	 * @generated
	 * @ordered
	 */
	protected static final int ZIP_CODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getZipCode() <em>Zip Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZipCode()
	 * @generated
	 * @ordered
	 */
	protected int zipCode = ZIP_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdditional() <em>Additional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditional()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDITIONAL_EDEFAULT = "null";

	/**
	 * The cached value of the '{@link #getAdditional() <em>Additional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditional()
	 * @generated
	 * @ordered
	 */
	protected String additional = ADDITIONAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddressImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMFUserPackage.Literals.ADDRESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStreet(String newStreet) {
		String oldStreet = street;
		street = newStreet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMFUserPackage.ADDRESS__STREET, oldStreet, street));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHouseNumber() {
		return houseNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHouseNumber(int newHouseNumber) {
		int oldHouseNumber = houseNumber;
		houseNumber = newHouseNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMFUserPackage.ADDRESS__HOUSE_NUMBER, oldHouseNumber, houseNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZipCode(int newZipCode) {
		int oldZipCode = zipCode;
		zipCode = newZipCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMFUserPackage.ADDRESS__ZIP_CODE, oldZipCode, zipCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdditional() {
		return additional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdditional(String newAdditional) {
		String oldAdditional = additional;
		additional = newAdditional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMFUserPackage.ADDRESS__ADDITIONAL, oldAdditional, additional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EMFUserPackage.ADDRESS__STREET:
				return getStreet();
			case EMFUserPackage.ADDRESS__HOUSE_NUMBER:
				return getHouseNumber();
			case EMFUserPackage.ADDRESS__ZIP_CODE:
				return getZipCode();
			case EMFUserPackage.ADDRESS__ADDITIONAL:
				return getAdditional();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EMFUserPackage.ADDRESS__STREET:
				setStreet((String)newValue);
				return;
			case EMFUserPackage.ADDRESS__HOUSE_NUMBER:
				setHouseNumber((Integer)newValue);
				return;
			case EMFUserPackage.ADDRESS__ZIP_CODE:
				setZipCode((Integer)newValue);
				return;
			case EMFUserPackage.ADDRESS__ADDITIONAL:
				setAdditional((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EMFUserPackage.ADDRESS__STREET:
				setStreet(STREET_EDEFAULT);
				return;
			case EMFUserPackage.ADDRESS__HOUSE_NUMBER:
				setHouseNumber(HOUSE_NUMBER_EDEFAULT);
				return;
			case EMFUserPackage.ADDRESS__ZIP_CODE:
				setZipCode(ZIP_CODE_EDEFAULT);
				return;
			case EMFUserPackage.ADDRESS__ADDITIONAL:
				setAdditional(ADDITIONAL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EMFUserPackage.ADDRESS__STREET:
				return STREET_EDEFAULT == null ? street != null : !STREET_EDEFAULT.equals(street);
			case EMFUserPackage.ADDRESS__HOUSE_NUMBER:
				return houseNumber != HOUSE_NUMBER_EDEFAULT;
			case EMFUserPackage.ADDRESS__ZIP_CODE:
				return zipCode != ZIP_CODE_EDEFAULT;
			case EMFUserPackage.ADDRESS__ADDITIONAL:
				return ADDITIONAL_EDEFAULT == null ? additional != null : !ADDITIONAL_EDEFAULT.equals(additional);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (street: ");
		result.append(street);
		result.append(", houseNumber: ");
		result.append(houseNumber);
		result.append(", zipCode: ");
		result.append(zipCode);
		result.append(", additional: ");
		result.append(additional);
		result.append(')');
		return result.toString();
	}

} //AddressImpl
