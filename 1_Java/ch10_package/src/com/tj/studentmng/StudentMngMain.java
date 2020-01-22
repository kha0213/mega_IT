package com.tj.studentmng;
import java.util.Scanner;

public class StudentMngMain {
	public static void main(String[] args) {
		Student[] students = {new Student(201901,"�շ�",31,"ȭ��"),
							  new Student(201902,"����",25,"�濵"),
							  new Student(201903,"ȫ�浿",23,"����"),
							  new Student(201904,"������",20,"�İ�"),
							  new Student(201905,"���̿�",25,"����"),
		};
		Scanner sc = new Scanner(System.in);
		
		int no;
		int idx; //�˻��� �й��� ����Ű�� index
		int fn; // ��ɹ�ȣ 1:�й� 2:�̸� 3:���� 4:����
		String data; //�ٲ� �����Ͱ� �Էµ� ����
		
		
		for(Student s : students) {
			s.setAge(s.getAge()+1);
			
		}
		for(Student s : students) {
			System.out.println(s.infoString());
		}
		//�ٲٰ� ���� �л��� �й� �ް� 1. �й��� ���� ��� 2. ��ȿ���� �ʴ� �й��� ���
		while(true) {
			System.out.print("�ٲ� �л��� �й���?(�� ���Ḧ ���ϸ� 0�� �Է��ϼ���.)");
			no = sc.nextInt();
			if(no==0) 
				break;
			//�й� ��ȸ, ��ɹ�ȣ �ް�, ��˻�// �ٲ� ������ �ް� ����
			
			for(idx=0;idx<students.length;idx++) {
				if(students[idx].getNo()==no) {
					break; // ã��. idx��° �ִ� students[idx]�� ������ ����
				}
			}
			if(idx==students.length) {
				System.out.println("��ȿ���� ���� �й��� �Է��ϼ̽��ϴ�.");
				continue;
			}//while
			//��ɹ�ȣ �ް� 1. 1~4 fn�Է��Ұ�� 2. ��ȿ���� ���� fn�� ���
			
			System.out.print("1:�й�����, 2:�̸�����, 3:���̼���, 4:���������Դϴ�. ���ϴ� ��ɹ�ȣ�� �Է��ϼ���.");
			
			while(true) {
			fn=sc.nextInt();
				if(fn>4||fn<1) {
					System.out.println("��ȿ���� ���� ��ɹ�ȣ�Դϴ�.");
					continue;
				}//if
				else {
					break;
				}
			}
		
			
			System.out.println("�ٲ� �����ʹ�?");
			data = sc.next(); //String �Է�(white space �������� String)
			//���� �� ������ ��� - ���� - ���� �� ������ ���
			System.out.println("���� �� :"+students[idx].infoString());
			students[idx].modify(fn, data); //����
			System.out.println("���� �� :"+students[idx].infoString());
		}//while
		System.out.println("�ȳ��� ������. ���� �����ʹ� ������ ���ƿ�.");
		for(Student s : students) {
			System.out.println(s.infoString());
		}
		
	}//main
}
