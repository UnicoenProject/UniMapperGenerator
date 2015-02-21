package com.sample;

import java.util.ArrayList;
import java.util.List;

public class ClassList {
	List<ClassData> classList;

	public ClassList() {
		classList = new ArrayList<ClassData>();
	}

	public void showClassList() {
		for (ClassData cd : classList)
			System.out.println(cd);
	}

	public void add(ClassData data) {
		classList.add(data);
	}
}
