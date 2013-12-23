/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grammar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Grammar#getGname <em>Gname</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getGrammar()
 * @model
 * @generated
 */
public interface Grammar extends EObject
{
  /**
   * Returns the value of the '<em><b>Gname</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Gname</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Gname</em>' attribute.
   * @see #setGname(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getGrammar_Gname()
   * @model
   * @generated
   */
  String getGname();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Grammar#getGname <em>Gname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Gname</em>' attribute.
   * @see #getGname()
   * @generated
   */
  void setGname(String value);

} // Grammar
