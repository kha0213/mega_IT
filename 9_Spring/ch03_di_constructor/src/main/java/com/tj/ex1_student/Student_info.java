package com.tj.ex1_student;

public class Student_info {
	private Student student;
	
	public Student_info(Student student) {
		super();
		this.student = student;
	}

	public void print() {
		if(student!=null) {
			System.out.println("이름 : "+student.getName());
			System.out.println("나이 : "+student.getAge()+"살");
			System.out.println("학년 : "+student.getGrade_num());
			System.out.println("반 : "+student.getClass_num()+"반");
			System.out.println("----------------------------------------------");
		}else {
			System.out.println("학생 정보가 참조되지 않았습니다.");
		}
	}

	public Student getStudent() {
		return student;
	}
	
	
	
}
