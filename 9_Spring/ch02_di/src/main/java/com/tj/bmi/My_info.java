package com.tj.bmi;

import java.util.ArrayList;

public class My_info {
	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobbies;
	private BMI_calculator bmical;
	private void bmi_calculator() {
		bmical.bmi_cal(weight, height);
	}
	public void get_info() {
		System.out.println("이름 : "+name);
		System.out.println("키 : "+height);
		System.out.println("몸무게 : "+weight);
		for(String a: hobbies) {
			System.out.println("취미 : "+a);
		}
		bmi_calculator();
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}
	public void setBmical(BMI_calculator bmical) {
		this.bmical = bmical;
	}
	
	
}
