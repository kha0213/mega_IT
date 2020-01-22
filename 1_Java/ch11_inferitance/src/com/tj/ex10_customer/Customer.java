package com.tj.ex10_customer;

import com.tj.cons.Constant;

public class Customer extends Person {
	private String add;
	private int sum; // 구매누적금액
	private int point; //포인트(구매할 때 5%씩 적립)
	private String date; //기념일
	private boolean vip; //true면 vip
	
	
	
	public Customer(String name, String tel,String add,String date) {
		super(name, tel); //반드시 super단의 생성자 호출은 첫번째 라인에 온다
		this.add=add;
		this.date=date;
		sum=0; //새로운 고객은 구매누적금액 0원
		point = 1000; //가입하면 첫고객 1000포인트 지급
		vip=false; //새로운 고객은 일반고객으로 분류
		System.out.println(name+"님 회원가입 축하드립니다. 포인트 "+point+"점 선물로 드리겠습니다.");

	}
	public void buy(int price) {
		sum += price;
		int tempPoint = (int)(price*Constant.RATE);
		point += (int)(price*Constant.RATE);
		System.out.println(getName()+"님 감사합니다 구매로 포인트"+tempPoint+"점이 적립되어 총 포인트 "+point+"점이 되었습니다.");
		if(sum>1000000 && vip==false) {
			vip = true; //누적금액이 100만원 초과시 vip로
			
		}//if
	}//buy
	@Override
	public String infoString() {
		return super.infoString()+" [주소]"+add+" [포인트]"+point;
	}
	

}
