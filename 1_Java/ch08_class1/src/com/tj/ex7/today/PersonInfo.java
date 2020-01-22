package com.tj.ex7.today;

public class PersonInfo {
	private String name;
	private int age;
	private String gender;
	
	public PersonInfo() {
		System.out.println("안녕하세요.\n 이름, 나이, 성별을 입력해주세요.");
	}
	public PersonInfo(String name, int age, String gender) {
		this.name=name;
		this.age=age;
		this.gender=gender;
		System.out.printf("안녕하세요.\n이름 : %s, 나이 : %d살, 성별 : %s로 입력되었습니다.\n",name,age,gender);
	}
	public void print() {
		System.out.printf("이름 : %s\t",name);
		System.out.printf("나이 : %d살\t",age);
		System.out.printf("성별 : %s\n",gender);
		
	}
		
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(0<=age && age<=100) {
			this.age = age;
		}
		else if(100<age && age<=140) {
			this.age=age;
			System.out.println("100살이 넘었어요? 정말?");
		}
		else {
			System.out.println("떼끼!! 다시 나이 설정 하세요.");
		}
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		if(gender.equals("남자") || gender.equals("man") || gender.equals("Man") || gender.equals("남성")) {
		this.gender = "남자";
		}
		else if(gender.equals("여자") || gender.equals("woman") || gender.equals("Woman") || gender.equals("여성")) {
		this.gender = "여자";
		}
		else {
			System.out.println("잘못입력하셨습니다. 남자 또는 여자로 입력해주세요.");
		}
	}

}
