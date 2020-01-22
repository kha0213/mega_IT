package com.tj.ex1_student;

public class Student_main {
	public static void main(String[] args) {
		Student[] student = new Student[5];
		student[0] = new Student("정우성", 90, 90, 90);
		student[1] = new Student("김하늘", 81, 90, 90);
		student[2] = new Student("황정민", 91, 90, 90);
		student[3] = new Student("강동원", 80, 90, 90);
		student[4] = new Student("유아인", 70, 90, 90);
		
		line(); // ■■■■■
		int[] tot = new int[5];
		double[] avg = new double[5];
				
		String[] title = {"이름","국어","영어","수학","총점","평균"};
		
		System.out.println("\t\t성적표");
		line('-',50); // ------- 50개
		for(String t : title) {
			System.out.print("\t"+t);
		}
		System.out.println();
		line('-',50);
		//for()
		for(Student s : student) {
			//
			//	s.print();
			System.out.println(s.infoString());
			tot[0] += s.getKor();
			tot[1] += s.getEng();
			tot[2] += s.getMat();
			tot[3] += s.getTot();
			tot[4] += s.getAvg();
		}//학생들꺼
		for(int i=0;i<avg.length;i++) {
			avg[i]=(tot[i]/student.length);
		}
				
		line('-',50);
		
		System.out.print("\t총점");
		for(int t : tot) {
			System.out.print("\t"+t);
		}
		System.out.println();
		
		System.out.print("\t평균");
		
		for(double t : avg) {
			System.out.print("\t"+t);
		}
		System.out.println();
		
		
		
		
		
		
		
		
		
		line(); // ■■■■■
		

		
		
		
		
	}//main
	
	private static void line() {
		for(int i=0 ; i<65 ; i++) {
			System.out.print('■');
		}
		System.out.println();			
	}
	
	private static void line(char ch, int cnt) {
		System.out.print("\t");
		for(int i=0; i<cnt; i++) {
			System.out.print(ch);
		}
		System.out.println(); //개행
	}//line
	


}
