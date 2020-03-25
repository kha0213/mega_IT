package com.tj.ex1_student;

public class Student {
	private String name;
	private int age;
	private String grade_num;
	private String class_num;
	public Student(String name, int age, String grade_num, String class_num) {
		super();
		this.name = name;
		this.age = age;
		this.grade_num = grade_num;
		this.class_num = class_num;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getGrade_num() {
		return grade_num;
	}
	public String getClass_num() {
		return class_num;
	}
	
	
}
