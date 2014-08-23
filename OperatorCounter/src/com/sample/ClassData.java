package com.sample;

public class ClassData {
	private String className;
	private String superClass;

	public ClassData(String cn, String sc) {
		setClassName(cn);
		setSuperClass(sc);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSuperClass() {
		return superClass;
	}

	public void setSuperClass(String superClass) {
		this.superClass = superClass;
	}
}
