package com.tj.ex4_lunch;

public class Child1 extends LunchMenu {

	public Child1(int rice, int bulgogi, int soup, int banana, int milk, int almond) {
		super(rice, bulgogi, soup, banana, milk, almond);
		setStr("Child1�� �Ĵ� : ");
	}

	@Override
	public int calculate() {
		//��+�Ұ��+��+�ٳ���+�Ƹ��(���� ������)
		return getRice()+getBulgogi()+getSoup()+getBanana()+getAlmond();
	}

}
