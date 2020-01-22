package com.tj.ex4_lunch;

public class Child2 extends LunchMenu {

	public Child2(int rice, int bulgogi, int soup, int banana, int milk, int almond) {
		super(rice, bulgogi, soup, banana, milk, almond);
		setStr("Child2Çü ½Ä´ë : ");
	}

	@Override
	public int calculate() {
		return getRice()+getBulgogi()+getSoup()+getMilk();
	}


}
