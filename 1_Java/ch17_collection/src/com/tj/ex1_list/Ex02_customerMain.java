package com.tj.ex1_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02_customerMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer, name, phone, address;
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		do {
			System.out.println("ȸ�������� �����Ͻðڽ��ϱ�?(Y/N)?");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				break;
			}else if(answer.equalsIgnoreCase("Y")) {
			System.out.println("������ ȸ���� �̸��� �Է����ּ���.");
			name = sc.next();
			System.out.println("��ȭ��ȣ�� �Է����ּ���.");
			phone = sc.next();
			sc.nextLine(); // ���ۿ� �����ִ� \n�� ����� �뵵
			System.out.println("�ּҸ� �Է����ּ���.");
			address = sc.nextLine();
			customers.add(new Customer(name,phone,address));
			
			}else {
				System.out.println("�߸� �����̽��ϴ� Y�� N�� �����ּ���.");
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
