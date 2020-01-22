package com.tj.ex1_string;

import java.util.Scanner;

public class Ex_HomeworkTel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String phoneNum;
		while (true) {
			System.out.println("번호를 입력하세요(-하이픈 포함)\n여러 정보를 출력해드려요~ 그만두시려면 x를 입력하세요.");
			phoneNum = sc.next();
			if (phoneNum.equalsIgnoreCase("x")) {
				System.out.println("시스템을 종료합니다. 안녕히 계세요.");
				break;
			}
			
			if(phoneNum.indexOf('-')==-1) {
				System.out.println("하이픈 - 을 입력해주세요.");
				continue;
			}
			if(phoneNum.indexOf('-')==phoneNum.lastIndexOf('-')) {
				System.out.println("하이픈 - 이 2개 필요해요~!");
				continue;
			}
			if(phoneNum.length()<=11) {
				System.out.println("전화번호가 너무 짧아!! 제대로 입력해.");
				continue;
			}
			if(phoneNum.length()>=14) {
				System.out.println("전화번호가 너무 길어!! 제대로 입력해.");
				continue;
			}
			
			
			System.out.println("입력한 전화번호: " + phoneNum + " 입니다.");
			System.out.print("짝수번째 문자열: ");
			for (int i = 0; i < phoneNum.length(); i++) {
				if (i % 2 != 0) {
					System.out.print(phoneNum.charAt(i));
				} else {
					System.out.print(" ");
				}
			}
			System.out.println(" 입니다.");
			System.out.print("문자를 거꾸로: ");
			for (int i = phoneNum.length() - 1; i >= 0; i--) {
				System.out.print(phoneNum.charAt(i));
			} // for
			System.out.println(" 입니다.");
			System.out.println("전화번호 앞자리는: " + phoneNum.substring(0, phoneNum.indexOf('-')));
			System.out.println("전화번호 뒷자리는: " + phoneNum.substring(phoneNum.lastIndexOf('-') + 1));
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		sc.close();

	}

}
