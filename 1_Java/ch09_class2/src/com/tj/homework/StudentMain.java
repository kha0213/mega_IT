package com.tj.homework;

//객체배열을 이용한 확장 for문 이용 출력 infoString
public class StudentMain {
	public static void main(String[] args) {
		Student[] student = new Student[5];
		student[0] = new Student("정우성", 90, 80, 95);
		student[1] = new Student("김하늘", 100, 80, 95);
		student[2] = new Student("황정민", 95, 80, 90);
		student[3] = new Student("강동원", 95, 90, 99);
		student[4] = new Student("유아인", 90, 90, 90);

		Student.line('■', 55);

		System.out.println("\t\t\t성 적 표");
		Student.line('-', 55);
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
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
		System.out.print("\t총점");
		for (int a : total) {
			System.out.print("\t" + a);
		}
		System.out.println();
		System.out.print("\t평균");
		for (int a : avg) {
			System.out.print("\t" + a);
		}
		System.out.println();
		Student.line('■', 55);

	}// main
}
