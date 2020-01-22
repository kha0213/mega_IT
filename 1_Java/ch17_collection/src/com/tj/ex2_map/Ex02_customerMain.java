package com.tj.ex2_map;

import java.util.*;

import com.tj.ex1_list.Customer;

public class Ex02_customerMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer, name, phone, address;
		
		HashMap<String, Customer> customers = new HashMap<String, Customer>();
		
		
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
			customers.put(phone, new Customer(name,phone,address));
			
			}else {
				System.out.println("�߸� �����̽��ϴ� Y�� N�� �����ּ���.");
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
