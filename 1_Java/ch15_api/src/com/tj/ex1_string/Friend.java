package com.tj.ex1_string;

public class Friend {
	private String name;
	private String tel;
	private String birth;
	public Friend(String name, String tel, String birth) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
		
	public String infoString() {
		return "[�̸�]" + name + " [��ȭ]" + tel + " [����]" + birth;
	}


	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getBirth() {
		return birth;
	}
	
	
}
