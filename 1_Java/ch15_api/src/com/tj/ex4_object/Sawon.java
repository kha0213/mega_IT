package com.tj.ex4_object;

public class Sawon {
	private String no;
	private String name;
	public Sawon(String no, String name) {
		this.no = no;
		this.name = name;
	}
	@Override
	public String toString() {
		return "[���] " + no + " [�̸�] " + name;
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
}
