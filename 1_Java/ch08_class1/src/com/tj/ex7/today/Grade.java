package com.tj.ex7.today;

public class Grade {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	int sum=kor+eng+mat;
	double average=(kor+eng+mat)/3.0;
	
	
	public Grade() {
		
	}//Grade
	public Grade(String name,int kor,int eng,int mat) {
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.mat=mat;
	//System.out.printf("이름: %s 국어점수: %d점 영어점수: %d점 국어점수: %d점\n",name,kor,eng,mat);	
	}//Grade
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public void print() {
		System.out.printf("%s   %d    %d    %d    %d    %.2f\n",name,kor,eng,mat,sum,average);
		
	}
	

}//class
