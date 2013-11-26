/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grammar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Grammar#getRules <em>Rules</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Grammar#getGram <em>Gram</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getGrammar()
 * @model
 * @generated
 */
public interface Grammar extends Model
{
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
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getGrammar_Rules()
   * @model containment="true"
   * @generated
   */
  EList<Rule> getRules();

  /**
   * Returns the value of the '<em><b>Gram</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Gram</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Gram</em>' attribute.
   * @see #setGram(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getGrammar_Gram()
   * @model
   * @generated
   */
  String getGram();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Grammar#getGram <em>Gram</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Gram</em>' attribute.
   * @see #getGram()
   * @generated
   */
  void setGram(String value);

} // Grammar
