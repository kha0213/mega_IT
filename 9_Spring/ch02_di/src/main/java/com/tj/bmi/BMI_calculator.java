package com.tj.bmi;

public class BMI_calculator {
	private double low_weight; //저체중기준 bmi
	private double normal; //정상 bmi
	private double over_weight; // 과체중
	private double obesity; //비만
	
	public void bmi_cal(double weight, double height) {
		double result = weight / Math.pow(height/100, 2);
		if(result>obesity) {
			System.out.println("비만입니다.");
		}else if(result>over_weight) {
			System.out.println("과체중입니다.");
		}else if(result>normal) {
			System.out.println("정상입니다.");
		}else if(result>low_weight){
			System.out.println("저체중입니다.");
		}else {
			System.out.println("심각한 저체중입니다.");
		}
	}

	public void setLow_weight(double low_weight) {
		this.low_weight = low_weight;
	}

	public void setNormal(double normal) {
		this.normal = normal;
	}

	public void setOver_weight(double over_weight) {
		this.over_weight = over_weight;
	}

	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
	
}
