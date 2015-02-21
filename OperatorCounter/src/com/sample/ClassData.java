package com.sample;

import java.util.ArrayList;
import java.util.List;

public class ClassData {
	private String className;
	private String superClass;
	private String packageName;
	private List<Method> methods = new ArrayList<Method>();

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

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String toString() {
		String result = "";
		String line = System.getProperty("line.separator");
		result += "class " + packageName + "." + className + " extends "
				+ superClass + " :";
		for (Method method : methods) {
			result += line + "  function: " + method.getType() + " "
					+ method.getName();
		}
		return result;
	}

	public void addMethod(String type, String name) {
		methods.add(new Method(type, name));
	}

	private class Method {
		private String name;
		private String type;
		private int complexity;

		private Method(String type, String name) {
			setType(type);
			setName(name);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public int getComplexity() {
			return complexity;
		}

		public void setComplexity(int complexity) {
			this.complexity = complexity;
		}
	}
}
