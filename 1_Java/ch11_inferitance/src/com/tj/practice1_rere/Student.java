package com.tj.practice1_rere;

public class Student {
	private int no;
	private int count;
	private int number;
	private String name;
	private String major;
	private String tel;
	
	public Student(int number,String name,String major,String tel) {
		this.number=number;
		this.name=name;
		this.major=major;
		this.tel=tel;
		no=++count;
	}
	
	public String infoString() {
		return "학번은 "+number+" 이름은 "+name+" 전공은 "+major+" 전화번호는 "+tel;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	

}
