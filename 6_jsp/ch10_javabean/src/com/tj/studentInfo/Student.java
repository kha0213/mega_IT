package com.tj.studentInfo;

public class Student {
	private String studentNum;
	private String name;
	private int grade;
	private char className;
	private int score;
	
	public Student() {
		super();
	}
	public Student(String studentNum, String name, int grade, char className, int score) {
		super();
		this.studentNum = studentNum;
		this.name = name;
		this.grade = grade;
		this.className = className;
		this.score = score;
	}

	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public char getClassName() {
		return className;
	}
	public void setClassName(char className) {
		this.className = className;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [studentNum=" + studentNum + ", name=" + name + ", grade=" + grade + ", className=" + className
				+ ", score=" + score + "]";
	}
	
	
}
