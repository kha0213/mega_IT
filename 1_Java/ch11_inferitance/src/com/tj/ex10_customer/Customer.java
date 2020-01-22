package com.tj.ex10_customer;

import com.tj.cons.Constant;

public class Customer extends Person {
	private String add;
	private int sum; // ���Ŵ����ݾ�
	private int point; //����Ʈ(������ �� 5%�� ����)
	private String date; //�����
	private boolean vip; //true�� vip
	
	
	
	public Customer(String name, String tel,String add,String date) {
		super(name, tel); //�ݵ�� super���� ������ ȣ���� ù��° ���ο� �´�
		this.add=add;
		this.date=date;
		sum=0; //���ο� ���� ���Ŵ����ݾ� 0��
		point = 1000; //�����ϸ� ù�� 1000����Ʈ ����
		vip=false; //���ο� ���� �Ϲݰ����� �з�
		System.out.println(name+"�� ȸ������ ���ϵ帳�ϴ�. ����Ʈ "+point+"�� ������ �帮�ڽ��ϴ�.");

	}
	public void buy(int price) {
		sum += price;
		int tempPoint = (int)(price*Constant.RATE);
		point += (int)(price*Constant.RATE);
		System.out.println(getName()+"�� �����մϴ� ���ŷ� ����Ʈ"+tempPoint+"���� �����Ǿ� �� ����Ʈ "+point+"���� �Ǿ����ϴ�.");
		if(sum>1000000 && vip==false) {
			vip = true; //�����ݾ��� 100���� �ʰ��� vip��
			
		}//if
	}//buy
	@Override
	public String infoString() {
		return super.infoString()+" [�ּ�]"+add+" [����Ʈ]"+point;
	}
	

}
