package com.tj.ex4_object;

public class Person {
	private String juminNo; //9001112055011;
	
	public Person(String juminNO) {
		this.juminNo = juminNO;
	}
	@Override
	public String toString() {
		return "ÁÖ¹Î¹øÈ£ : "+juminNo;
	}


	@Override
	public boolean equals(Object obj) {
		// p1.equals(p2)  p1->this, p2->obj
		if(obj!=null && obj instanceof Person) {
			return this.juminNo == ((Person)obj).juminNo;
		}
		else {
			return false;
		}
	}
	public String getJuminNo() {
		return juminNo;
	}
	public void setJuminNo(String juminNo) {
		this.juminNo = juminNo;
	}
	
	
}
