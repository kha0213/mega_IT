package com.tj.ex4_object;

public class Customer {
	private String phone; //010-9999-9999
	private String name;
	private int point;
	private int sum;
	private String birth; //01-01
	private boolean vip; //false == �Ϲݰ�
	//Customer c = new Customer("010-9999-9999","�շ���","12-19");
	
	public Customer(String phone, String name, String birth) {
		super();
		this.phone = phone;
		this.name = name;
		this.birth = birth;
		point = 1000;
		sum = 0;
		vip = false;
		System.out.println(name+"ȸ���� ���� ����帳�ϴ�. ����Ʈ ��1000���� �����.");
	}
	
	@Override
	public String toString() {
		return name+"("+phone+") ���� ����Ʈ : "+point+"�� �������űݾ� : "+sum+"��";
	}
	
	
	
	
}
