package com.tj.ex3_set;

public class Student {
	private String name;
	private int grade;
	public Student(String name, int grade) {
		super();
		this.name = name;
		this.grade = grade;
	}
	@Override
	public String toString() {
		return name + " : "+grade;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null&&obj instanceof Student) {
			String thisStr = this.toString();
			String objStr = obj.toString();
			return thisStr.equals(objStr);
		}
		else {
		return false;
		}
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
}
