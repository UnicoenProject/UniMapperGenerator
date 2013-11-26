/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Term#getRcall <em>Rcall</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Term#getBexp <em>Bexp</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Term#getKword <em>Kword</em>}</li>
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
   * Returns the value of the '<em><b>Rcall</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rcall</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rcall</em>' containment reference.
   * @see #setRcall(RuleCall)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getTerm_Rcall()
   * @model containment="true"
   * @generated
   */
  RuleCall getRcall();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Term#getRcall <em>Rcall</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rcall</em>' containment reference.
   * @see #getRcall()
   * @generated
   */
  void setRcall(RuleCall value);

  /**
   * Returns the value of the '<em><b>Bexp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bexp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bexp</em>' containment reference.
   * @see #setBexp(BracketsExp)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getTerm_Bexp()
   * @model containment="true"
   * @generated
   */
  BracketsExp getBexp();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Term#getBexp <em>Bexp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bexp</em>' containment reference.
   * @see #getBexp()
   * @generated
   */
  void setBexp(BracketsExp value);

  /**
   * Returns the value of the '<em><b>Kword</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kword</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kword</em>' containment reference.
   * @see #setKword(Keyword)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getTerm_Kword()
   * @model containment="true"
   * @generated
   */
  Keyword getKword();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Term#getKword <em>Kword</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kword</em>' containment reference.
   * @see #getKword()
   * @generated
   */
  void setKword(Keyword value);

} // Term
