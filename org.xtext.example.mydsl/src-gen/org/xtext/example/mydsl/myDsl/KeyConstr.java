/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Constr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.KeyConstr#getSChar <em>SChar</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.KeyConstr#getEChar <em>EChar</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getKeyConstr()
 * @model
 * @generated
 */
public interface KeyConstr extends EObject
{
  /**
   * Returns the value of the '<em><b>SChar</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>SChar</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>SChar</em>' attribute.
   * @see #setSChar(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getKeyConstr_SChar()
   * @model
   * @generated
   */
  String getSChar();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.KeyConstr#getSChar <em>SChar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>SChar</em>' attribute.
   * @see #getSChar()
   * @generated
   */
  void setSChar(String value);

  /**
   * Returns the value of the '<em><b>EChar</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>EChar</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>EChar</em>' attribute.
   * @see #setEChar(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getKeyConstr_EChar()
   * @model
   * @generated
   */
  String getEChar();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.KeyConstr#getEChar <em>EChar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>EChar</em>' attribute.
   * @see #getEChar()
   * @generated
   */
  void setEChar(String value);

} // KeyConstr
