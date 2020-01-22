package com.tj.ex05_actor;

public class Actor implements Chef, PoliceMan, FireFighter {
	private String name;
	public Actor(String name) {
		this.name=name;
	}
	@Override
	public void outFire() {
		System.out.println("���� ����");
	}

	@Override
	public void saveMan() {
		System.out.println("����� ���Ѵ�.");
	}

	@Override
	public void canCatchCrimianl() {
		System.out.println("������ ��´�");
	}

	@Override
	public void canSearch() {
		System.out.println("������ ã�´�.");
	}

	@Override
	public void makePizza() {
		System.out.println("���ڸ� ���� �� �ִ�.");
	}

	@Override
	public void makeSpaghetti() {
		System.out.println("���İ�Ƽ�� ���� �� �ִ�");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
