package com.tj.practice;
import java.util.Scanner;
public class Today_main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Student[] stu = {new Student(1901,"�շ���",30,"ȭ�а�"),
						new Student(1902,"������",32,"�����а�"),
						new Student(1903,"�ʷ���",34,"���а�"),
						new Student(1904,"�ٷ���",35,"�İ���"),
		};
		
		for(Student s : stu) {
			System.out.println(s.infoString());
		}
		
		int you,idx,fn;
		String data;
		
		all : while(true) {
			System.out.println("�л���� �ý����Դϴ�. �й��� �Է����ּ���.");
			System.out.println("���� ���Ḧ ���Ͻø� 0�� �Է����ּ���.");
			you = sc.nextInt();
			if(you==0) {
				break;
			}
			for(idx=0;idx<stu.length;idx++) {
				if(you==stu[idx].getNo()) {
					System.out.println(stu[idx].getName()+"�� �ȳ��ϼ���.");
					break;
				}//if
			}//for
			if(idx==stu.length) {
				System.out.println("��ȿ���� ���� ���� �Է��Ͽ����ϴ�.");
				continue;				
			}//if
			while(true) {
				System.out.println("�����ý����Դϴ�.");
				System.out.println("1�� ��ȣ���� 2�� �̸����� 3�� ���̺��� 4�� �а�����. �ڷΰ���� 0�� �Է����ּ���.");
				fn=sc.nextInt();
				if(fn==0) {
					continue all;
				}
				else if(fn<0 || fn>4) {
					System.out.println("��ȿ���� ���� ���� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
					continue;
				}
				else {
					break;
				}
				
			}//whlie �����ý���
			System.out.println("�ٲ� �����͸� �Է����ּ���.");
			data=sc.next();
			
			stu[idx].modify(fn, data);
			System.out.println("�����Ǿ����ϴ�. ���� ����� "+stu[idx].infoString());
			continue;
			
			
			
		}//while
		System.out.println("���� �����ʹ� �Ʒ��� �����ϴ�.");
		for(Student s : stu) {
			System.out.println(s.infoString());
		}
		
		System.out.println("�ȳ��� ������.");
	}//main

}
