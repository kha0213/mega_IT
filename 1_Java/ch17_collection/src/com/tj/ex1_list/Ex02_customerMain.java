package com.tj.ex1_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02_customerMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer, name, phone, address;
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		do {
			System.out.println("회원가입을 진행하시겠습니까?(Y/N)?");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				break;
			}else if(answer.equalsIgnoreCase("Y")) {
			System.out.println("가입할 회원의 이름을 입력해주세요.");
			name = sc.next();
			System.out.println("전화번호를 입력해주세요.");
			phone = sc.next();
			sc.nextLine(); // 버퍼에 남아있는 \n을 지우는 용도
			System.out.println("주소를 입력해주세요.");
			address = sc.nextLine();
			customers.add(new Customer(name,phone,address));
			
			}else {
				System.out.println("잘못 누르셨습니다 Y나 N을 눌러주세요.");
			}
			
		}while(true);
		System.out.println(customers);
//		for(Customer c : customers) {
//			System.out.println(c);
//		}
		for(int idx=0;idx<customers.size();idx++) {
			System.out.println(customers.get(idx));
		}
		
		
		
		
		sc.close();
	}
}
