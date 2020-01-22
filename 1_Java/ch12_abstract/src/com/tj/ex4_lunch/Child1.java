package com.tj.ex4_lunch;

public class Child1 extends LunchMenu {

	public Child1(int rice, int bulgogi, int soup, int banana, int milk, int almond) {
		super(rice, bulgogi, soup, banana, milk, almond);
		setStr("Child1형 식대 : ");
	}

	@Override
	public int calculate() {
		//밥+불고기+국+바나나+아몬드(우유 못먹음)
		return getRice()+getBulgogi()+getSoup()+getBanana()+getAlmond();
	}

}
