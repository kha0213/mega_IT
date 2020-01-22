package com.tj.practice;
import java.util.Scanner;
public class Today_main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Student[] stu = {new Student(1901,"롱롱이",30,"화학과"),
						new Student(1902,"영롱이",32,"물리학과"),
						new Student(1903,"초롱이",34,"수학과"),
						new Student(1904,"다롱이",35,"컴공과"),
		};
		
		for(Student s : stu) {
			System.out.println(s.infoString());
		}
		
		int you,idx,fn;
		String data;
		
		all : while(true) {
			System.out.println("학사관리 시스템입니다. 학번을 입력해주세요.");
			System.out.println("만약 종료를 원하시면 0을 입력해주세요.");
			you = sc.nextInt();
			if(you==0) {
				break;
			}
			for(idx=0;idx<stu.length;idx++) {
				if(you==stu[idx].getNo()) {
					System.out.println(stu[idx].getName()+"님 안녕하세요.");
					break;
				}//if
			}//for
			if(idx==stu.length) {
				System.out.println("유효하지 않은 값을 입력하였습니다.");
				continue;				
			}//if
			while(true) {
				System.out.println("수정시스템입니다.");
				System.out.println("1은 번호변경 2는 이름변경 3은 나이변경 4는 학과변경. 뒤로가기는 0을 입력해주세요.");
				fn=sc.nextInt();
				if(fn==0) {
					continue all;
				}
				else if(fn<0 || fn>4) {
					System.out.println("유효하지 않은 값을 입력하셨습니다. 다시 입력해주세요.");
					continue;
				}
				else {
					break;
				}
				
			}//whlie 수정시스템
			System.out.println("바꿀 데이터를 입력해주세요.");
			data=sc.next();
			
			stu[idx].modify(fn, data);
			System.out.println("수정되었습니다. 수정 결과는 "+stu[idx].infoString());
			continue;
			
			
			
		}//while
		System.out.println("최종 데이터는 아래와 같습니다.");
		for(Student s : stu) {
			System.out.println(s.infoString());
		}
		
		System.out.println("안녕히 가세요.");
	}//main

}
