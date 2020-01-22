package com.tj.studentmng;
// (멤버변수)학번,이름,나이,학과 (메소드)modify(fn, 바꿀데이터) sysout(infoString())
public class Student {
	private int no;
	private String name;
	private int age;
	private String major;
	
	// Student s = new Student(201901,"아아리",20,"화학")
	
	public Student() {
		
	}//디폴트 생성자
	
	public Student(int no,String name,int age,String major) {
		this.no=no;
		this.name=name;
		this.age=age;
		this.major=major;
	}
	
	public static void line(char ch,int cnt) {
		for(int i=0;i<cnt;i++) {
			System.out.print(ch);
		}
		System.out.println();		
	}//line
	
	public String infoString() {
		return "[학번]"+no+" [이름]"+name+" [나이]"+age+" [전공]"+major;		
	}
	
	public void modify(int fn,String data) {
		switch (fn) {
		case 1: 
			no=Integer.parseInt(data);
			break;
			
		case 2: 
			name=data;
			break;
			
		case 3: 
			age=Integer.parseInt(data);
			break;
			
		case 4: 
			major=data;			
		}//switch);
		
		

	}//modify

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
		this.age = age;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	

}
