package com.tj.ex1_student;
// 정우성 90 80 70 240 80.0
public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	
	// Student s = new Student("정우성",90,80,70);
	
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor+eng+mat;
		avg = tot/3.0;		
	}
	
	//s.print(); -> 정우성 90 80 70 240 80.0 출력 (많이 안쓰임)
	//System.out.println(s.infoString()); (많이 쓰임임임)
	
	
	public void print() {
	//	System.out.println("\t"+name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+avg);
		System.out.printf("\t %s \t %d \t %d \t &d \t %d \t %.1f\n",name,kor,eng,mat,tot,avg);
	}
	public String infoString() {
	//	String result = "\t"+name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+avg;
		String result = String.format("\t%s \t%d \t%d \t%d \t%d \t%.1f", name,kor,eng,mat,tot,avg);
		
		return result;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMat() {
		return mat;
	}

	public int getTot() {
		return tot;
	}

	public double getAvg() {
		return avg;
	}


	
	
	

}
