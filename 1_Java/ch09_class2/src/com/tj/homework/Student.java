package com.tj.homework;

public class Student {
	private static int count;
	private int number;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;

	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot / 3.0;
		number = ++count;

	}

	public String infoString() {
		return String.format("%d\t%s\t%d\t%d\t%d\t%d\t%.1f", number,name,kor,eng,mat,tot,avg);
	}

	public static void line(char wo, int wa) {
		for (int i = 0; i < wa; i++) {
			System.out.print(wo);
		}
		System.out.println();
	}// line

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Student.count = count;
	}

	public int getNumber() {
		return number;
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
