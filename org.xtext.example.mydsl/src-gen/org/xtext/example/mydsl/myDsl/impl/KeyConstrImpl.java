/**
 */
package org.xtext.example.mydsl.myDsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.example.mydsl.myDsl.KeyConstr;
import org.xtext.example.mydsl.myDsl.MyDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key Constr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.KeyConstrImpl#getSChar <em>SChar</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.KeyConstrImpl#getEChar <em>EChar</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KeyConstrImpl extends MinimalEObjectImpl.Container implements KeyConstr
{
  /**
   * The default value of the '{@link #getSChar() <em>SChar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSChar()
   * @generated
   * @ordered
   */
  protected static final String SCHAR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSChar() <em>SChar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSChar()
   * @generated
   * @ordered
   */
  protected String sChar = SCHAR_EDEFAULT;

  /**
   * The default value of the '{@link #getEChar() <em>EChar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEChar()
   * @generated
   * @ordered
   */
  protected static final String ECHAR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEChar() <em>EChar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEChar()
   * @generated
   * @ordered
   */
  protected String eChar = ECHAR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected KeyConstrImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MyDslPackage.Literals.KEY_CONSTR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSChar()
  {
    return sChar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSChar(String newSChar)
  {
    String oldSChar = sChar;
    sChar = newSChar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.KEY_CONSTR__SCHAR, oldSChar, sChar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEChar()
  {
    return eChar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEChar(String newEChar)
  {
    String oldEChar = eChar;
    eChar = newEChar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.KEY_CONSTR__ECHAR, oldEChar, eChar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MyDslPackage.KEY_CONSTR__SCHAR:
        return getSChar();
      case MyDslPackage.KEY_CONSTR__ECHAR:
        return getEChar();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MyDslPackage.KEY_CONSTR__SCHAR:
        setSChar((String)newValue);
        return;
      case MyDslPackage.KEY_CONSTR__ECHAR:
        setEChar((String)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.KEY_CONSTR__SCHAR:
        setSChar(SCHAR_EDEFAULT);
        return;
      case MyDslPackage.KEY_CONSTR__ECHAR:
        setEChar(ECHAR_EDEFAULT);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.KEY_CONSTR__SCHAR:
        return SCHAR_EDEFAULT == null ? sChar != null : !SCHAR_EDEFAULT.equals(sChar);
      case MyDslPackage.KEY_CONSTR__ECHAR:
        return ECHAR_EDEFAULT == null ? eChar != null : !ECHAR_EDEFAULT.equals(eChar);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (SChar: ");
    result.append(sChar);
    result.append(", EChar: ");
    result.append(eChar);
    result.append(')');
    return result.toString();
  }

} //KeyConstrImpl
