/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Term#getKConstr <em>KConstr</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Term#getRCall <em>RCall</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getTerm()
 * @model
 * @generated
 */
public interface Term extends EObject
{
  /**
   * Returns the value of the '<em><b>KConstr</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.KeyConstr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>KConstr</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>KConstr</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getTerm_KConstr()
   * @model containment="true"
   * @generated
   */
  EList<KeyConstr> getKConstr();

  /**
   * Returns the value of the '<em><b>RCall</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.RuleCall}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>RCall</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>RCall</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getTerm_RCall()
   * @model containment="true"
   * @generated
   */
  EList<RuleCall> getRCall();

} // Term
