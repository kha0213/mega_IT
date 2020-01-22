package com.tj.ex4_lunch;

public abstract class LunchMenu {
	private int rice;
	private int bulgogi;
	private int soup;
	private int banana;
	private int milk;
	private int almond;
	private String str;
	
	public LunchMenu(int rice, int bulgogi, int soup, int banana, int milk, int almond) {
		this.rice = rice;
		this.bulgogi = bulgogi;
		this.soup = soup;
		this.banana = banana;
		this.milk = milk;
		this.almond = almond;
	}
	public abstract int calculate();
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public int getRice() {
		return rice;
	}
	public int getBulgogi() {
		return bulgogi;
	}
	public int getSoup() {
		return soup;
	}
	public int getBanana() {
		return banana;
	}
	public int getMilk() {
		return milk;
	}
	public int getAlmond() {
		return almond;
	}
	

}
