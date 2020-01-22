package com.tj.homework;

//��ü�迭�� �̿��� Ȯ�� for�� �̿� ��� infoString
public class StudentMain {
	public static void main(String[] args) {
		Student[] student = new Student[5];
		student[0] = new Student("���켺", 90, 80, 95);
		student[1] = new Student("���ϴ�", 100, 80, 95);
		student[2] = new Student("Ȳ����", 95, 80, 90);
		student[3] = new Student("������", 95, 90, 99);
		student[4] = new Student("������", 90, 90, 90);

		Student.line('��', 55);

		System.out.println("\t\t\t�� �� ǥ");
		Student.line('-', 55);
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		Student.line('-', 55);
		for (Student a : student) {
			System.out.println(a.infoString());
		}
		Student.line('-', 55);

		int[] total = new int[5];
		int[] avg = new int[5];

		for (int idx = 0; idx < student.length; idx++) {
			total[0] += student[idx].getKor();
			total[1] += student[idx].getEng();
			total[2] += student[idx].getMat();
			total[3] += student[idx].getTot();
			total[4] += student[idx].getAvg();
		}
		
		
		for (int i = 0; i < student.length; i++) {
			avg[i] = total[i] / student.length;
		}
		System.out.print("\t����");
		for (int a : total) {
			System.out.print("\t" + a);
		}
		System.out.println();
		System.out.print("\t���");
		for (int a : avg) {
			System.out.print("\t" + a);
		}
		System.out.println();
		Student.line('��', 55);

	}// main
}
