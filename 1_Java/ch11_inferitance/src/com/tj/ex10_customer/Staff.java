package com.tj.ex10_customer;

public class Staff extends Person {
	private String hiredate; // �Ի���
	private String department; //�μ�
	//Staff s = new Staff("ȫ�浿","999-9999","2010-11-25","�����")
	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
		System.out.println("������ "+name+"�� �Ի��� "+hiredate+"�Դϴ�.");
	}
	@Override
	public String infoString() {
		return super.infoString()+" [�μ�]"+hiredate;
	}
	

}
