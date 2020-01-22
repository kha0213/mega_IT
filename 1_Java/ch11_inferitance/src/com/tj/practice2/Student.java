package com.tj.practice2;

public class Student extends Person {
	private String ban;

	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban=ban;
	}
	@Override
	public String infoString() {
		return super.infoString()+" (¹Ý) "+ban;
	}
	

}
