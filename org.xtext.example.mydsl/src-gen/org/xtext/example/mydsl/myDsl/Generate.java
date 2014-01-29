/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Generate#getGenetool <em>Genetool</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getGenerate()
 * @model
 * @generated
 */
public interface Generate extends EObject
{
  /**
   * Returns the value of the '<em><b>Genetool</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Genetool</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Genetool</em>' attribute.
   * @see #setGenetool(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getGenerate_Genetool()
   * @model
   * @generated
   */
  String getGenetool();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Generate#getGenetool <em>Genetool</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Genetool</em>' attribute.
   * @see #getGenetool()
   * @generated
   */
  void setGenetool(String value);

} // Generate
