package com.tj.practice2;

public class Staff extends Person {
	private String department;
	public Staff(String id, String name,String department) {
		super(id, name);
		this.department=department;
	}
	@Override
	public String infoString() {
		return super.infoString()+" (ºÎ¼­) "+department;
	}


}
