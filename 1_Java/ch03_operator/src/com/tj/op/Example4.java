package com.tj.op;
import java.util.*;
public class Example4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("주민등록번호 뒤의 숫자를 차례대로 입력하세요.");
		int[] num = new int[7];
		System.out.println("첫 번째 숫자를 입력하세요");
		num[0]= scanner.nextInt();
		if(num[0]<1 || num[0]>9) {
			System.out.println("1~9까지의 자연수만 입력하세요");
			System.out.println("첫 번째 숫자를 입력하세요");
			num[0]= scanner.nextInt();	
		}
		System.out.println("두 번째 숫자를 입력하세요");
		num[1]= scanner.nextInt();
		if(num[1]<1 || num[1]>9) {
			System.out.println("1~9까지의 자연수만 입력하세요");
			System.out.println("두 번째 숫자를 입력하세요");
			num[1]= scanner.nextInt();	
		}
		System.out.println("세 번째 숫자를 입력하세요");
		num[2]= scanner.nextInt();
		System.out.println("네 번째 숫자를 입력하세요");
		num[3]= scanner.nextInt();
		System.out.println("다섯 번째 숫자를 입력하세요");
		num[4]= scanner.nextInt();
		System.out.println("여섯 번째 숫자를 입력하세요");
		num[5]= scanner.nextInt();
		System.out.println("일곱 번째 숫자를 입력하세요");
		num[6]= scanner.nextInt();
		scanner.close();
		
		if(num[0]==1 || num[0]==3) {
			System.out.println("당신은 남자입니다.");			
		}
		else if(num[0]==2 || num[0]==4) {
			System.out.println("당신은 여자입니다.");
		}
		else {
			System.out.println("떼끼!!!!");
		}
	}

}
