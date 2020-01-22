package com.tj.ex5_car;
// LowGradeCar car1 = new LowGradeCar("����","����Ÿ�̾�",2000,"�Ŀ��ڵ�")
public abstract class Car {
	private String color;
	private String tire;
	private int displacement;
	private String handle;
	
	public Car(String color, String tire, int displacement, String handle) {
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}
	
	public abstract void getSpec();
// getters & setters �߰�
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTire() {
		return tire;
	}

	public void setTire(String tire) {
		this.tire = tire;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}
	
	
}
