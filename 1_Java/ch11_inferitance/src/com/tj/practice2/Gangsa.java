package com.tj.practice2;

public class Gangsa extends Person {
	private String subject;

	public Gangsa(String id, String name,String subject) {
		super(id, name);
		this.subject=subject;
	}
	@Override
	public String infoString() {
		return super.infoString()+" (°ú¸ñ) "+subject;
	}

}
