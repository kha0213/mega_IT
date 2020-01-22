package com.tj.ex2_map;

import java.util.*;

import com.tj.ex1_list.Customer;

public class Ex02_customerMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer, name, phone, address;
		
		HashMap<String, Customer> customers = new HashMap<String, Customer>();
		
		
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
			customers.put(phone, new Customer(name,phone,address));
			
			}else {
				System.out.println("잘못 누르셨습니다 Y나 N을 눌러주세요.");
			}
			
		}while(true);
		
		Iterator<String> iterator = customers.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(customers.get(key));
		}
		sc.close();
	}
}
