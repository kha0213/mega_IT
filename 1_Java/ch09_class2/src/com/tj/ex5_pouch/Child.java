package com.tj.ex5_pouch;

public class Child {
	//MomPouch momPouch=new MomPouch();
	private String name;
	public Child(String name) {
		this.name=name;
	}
	public void takeMoney(int money) {
		if(MomPouch.money>=money) {
			MomPouch.money-=money;
			System.out.println(name+"가 "+money+"원 받아가서 엄마지갑에 "+MomPouch.money+"원 남음");
		}else {
			System.out.println(name+"가 돈 못받음. 엄마 지갑에 돈이 모자라서");
		}
	}
}
