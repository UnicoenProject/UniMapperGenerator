/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Model#getGram <em>Gram</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Model#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Gram</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Gram</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Gram</em>' containment reference.
   * @see #setGram(Grammar)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getModel_Gram()
   * @model containment="true"
   * @generated
   */
  Grammar getGram();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Model#getGram <em>Gram</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Gram</em>' containment reference.
   * @see #getGram()
   * @generated
   */
  void setGram(Grammar value);

  /**
   * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.Rule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rules</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getModel_Rules()
   * @model containment="true"
   * @generated
   */
  EList<Rule> getRules();

} // Model
