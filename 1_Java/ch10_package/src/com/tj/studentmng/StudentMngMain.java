package com.tj.studentmng;
import java.util.Scanner;

public class StudentMngMain {
	public static void main(String[] args) {
		Student[] students = {new Student(201901,"롱롱",31,"화학"),
							  new Student(201902,"영롱",25,"경영"),
							  new Student(201903,"홍길동",23,"수학"),
							  new Student(201904,"남나리",20,"컴공"),
							  new Student(201905,"하이요",25,"영어"),
		};
		Scanner sc = new Scanner(System.in);
		
		int no;
		int idx; //검색한 학번이 가르키는 index
		int fn; // 기능번호 1:학번 2:이름 3:나이 4:전공
		String data; //바꿀 데이터가 입력될 변수
		
		
		for(Student s : students) {
			s.setAge(s.getAge()+1);
			
		}
		for(Student s : students) {
			System.out.println(s.infoString());
		}
		//바꾸고 싶은 학생의 학번 받고 1. 학번이 있을 경우 2. 유효하지 않는 학번일 경우
		while(true) {
			System.out.print("바꿀 학생의 학번은?(단 종료를 원하면 0을 입력하세요.)");
			no = sc.nextInt();
			if(no==0) 
				break;
			//학번 조회, 기능번호 받고, 재검색// 바꿀 데이터 받고 수정
			
			for(idx=0;idx<students.length;idx++) {
				if(students[idx].getNo()==no) {
					break; // 찾음. idx번째 있는 students[idx]를 수정할 예정
				}
			}
			if(idx==students.length) {
				System.out.println("유효하지 않은 학번을 입력하셨습니다.");
				continue;
			}//while
			//기능번호 받고 1. 1~4 fn입력할경우 2. 유효하지 않은 fn일 경우
			
			System.out.print("1:학번수정, 2:이름수정, 3:나이수정, 4:전공수정입니다. 원하는 기능번호를 입력하세요.");
			
			while(true) {
			fn=sc.nextInt();
				if(fn>4||fn<1) {
					System.out.println("유효하지 않은 기능번호입니다.");
					continue;
				}//if
				else {
					break;
				}
			}
		
			
			System.out.println("바꿀 데이터는?");
			data = sc.next(); //String 입력(white space 전까지의 String)
			//수정 전 데이터 출력 - 수정 - 수정 후 데이터 출력
			System.out.println("수정 전 :"+students[idx].infoString());
			students[idx].modify(fn, data); //수정
			System.out.println("수정 후 :"+students[idx].infoString());
		}//while
		System.out.println("안녕히 가세요. 최종 데이터는 다음과 같아요.");
		for(Student s : students) {
			System.out.println(s.infoString());
		}
		
	}//main
}
