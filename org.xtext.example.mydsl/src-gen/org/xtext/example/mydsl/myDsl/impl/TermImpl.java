/**
 */
package org.xtext.example.mydsl.myDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.example.mydsl.myDsl.BracketsExp;
import org.xtext.example.mydsl.myDsl.Keyword;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.RuleCall;
import org.xtext.example.mydsl.myDsl.Term;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.TermImpl#getRcall <em>Rcall</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.TermImpl#getBexp <em>Bexp</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.TermImpl#getKword <em>Kword</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TermImpl extends MinimalEObjectImpl.Container implements Term
{
  /**
   * The cached value of the '{@link #getRcall() <em>Rcall</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRcall()
   * @generated
   * @ordered
   */
  protected RuleCall rcall;

  /**
   * The cached value of the '{@link #getBexp() <em>Bexp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBexp()
   * @generated
   * @ordered
   */
  protected BracketsExp bexp;

  /**
   * The cached value of the '{@link #getKword() <em>Kword</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKword()
   * @generated
   * @ordered
   */
  protected Keyword kword;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TermImpl()
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
    return MyDslPackage.Literals.TERM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleCall getRcall()
  {
    return rcall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRcall(RuleCall newRcall, NotificationChain msgs)
  {
    RuleCall oldRcall = rcall;
    rcall = newRcall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.TERM__RCALL, oldRcall, newRcall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRcall(RuleCall newRcall)
  {
    if (newRcall != rcall)
    {
      NotificationChain msgs = null;
      if (rcall != null)
        msgs = ((InternalEObject)rcall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.TERM__RCALL, null, msgs);
      if (newRcall != null)
        msgs = ((InternalEObject)newRcall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.TERM__RCALL, null, msgs);
      msgs = basicSetRcall(newRcall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.TERM__RCALL, newRcall, newRcall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BracketsExp getBexp()
  {
    return bexp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBexp(BracketsExp newBexp, NotificationChain msgs)
  {
    BracketsExp oldBexp = bexp;
    bexp = newBexp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.TERM__BEXP, oldBexp, newBexp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBexp(BracketsExp newBexp)
  {
    if (newBexp != bexp)
    {
      NotificationChain msgs = null;
      if (bexp != null)
        msgs = ((InternalEObject)bexp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.TERM__BEXP, null, msgs);
      if (newBexp != null)
        msgs = ((InternalEObject)newBexp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.TERM__BEXP, null, msgs);
      msgs = basicSetBexp(newBexp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.TERM__BEXP, newBexp, newBexp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Keyword getKword()
  {
    return kword;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetKword(Keyword newKword, NotificationChain msgs)
  {
    Keyword oldKword = kword;
    kword = newKword;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.TERM__KWORD, oldKword, newKword);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKword(Keyword newKword)
  {
    if (newKword != kword)
    {
      NotificationChain msgs = null;
      if (kword != null)
        msgs = ((InternalEObject)kword).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.TERM__KWORD, null, msgs);
      if (newKword != null)
        msgs = ((InternalEObject)newKword).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.TERM__KWORD, null, msgs);
      msgs = basicSetKword(newKword, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.TERM__KWORD, newKword, newKword));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MyDslPackage.TERM__RCALL:
        return basicSetRcall(null, msgs);
      case MyDslPackage.TERM__BEXP:
        return basicSetBexp(null, msgs);
      case MyDslPackage.TERM__KWORD:
        return basicSetKword(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case MyDslPackage.TERM__RCALL:
        return getRcall();
      case MyDslPackage.TERM__BEXP:
        return getBexp();
      case MyDslPackage.TERM__KWORD:
        return getKword();
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
      case MyDslPackage.TERM__RCALL:
        setRcall((RuleCall)newValue);
        return;
      case MyDslPackage.TERM__BEXP:
        setBexp((BracketsExp)newValue);
        return;
      case MyDslPackage.TERM__KWORD:
        setKword((Keyword)newValue);
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
      case MyDslPackage.TERM__RCALL:
        setRcall((RuleCall)null);
        return;
      case MyDslPackage.TERM__BEXP:
        setBexp((BracketsExp)null);
        return;
      case MyDslPackage.TERM__KWORD:
        setKword((Keyword)null);
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
      case MyDslPackage.TERM__RCALL:
        return rcall != null;
      case MyDslPackage.TERM__BEXP:
        return bexp != null;
      case MyDslPackage.TERM__KWORD:
        return kword != null;
    }
    return super.eIsSet(featureID);
  }

} //TermImpl
