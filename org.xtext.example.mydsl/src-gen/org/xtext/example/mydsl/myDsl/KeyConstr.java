/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Constr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.KeyConstr#getKWord <em>KWord</em>}</li>
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
   * Returns the value of the '<em><b>KWord</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.Keyword}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>KWord</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>KWord</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getKeyConstr_KWord()
   * @model containment="true"
   * @generated
   */
  EList<Keyword> getKWord();

} // KeyConstr
