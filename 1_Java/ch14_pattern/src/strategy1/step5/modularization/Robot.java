package strategy1.step5.modularization;

import strategy1.step4.inter.IFly;
import strategy1.step4.inter.IKnife;
import strategy1.step4.inter.IMissile;

public class Robot {
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public void actiongWalk() {
		System.out.println("���� �� �ִ�.");
	}
	public void actionRun() {
		System.out.println("�� �� �ֽ��ϴ�.");
	}
	public void shape() {
		System.out.println(getClass().getName()+"�Դϴ�. ������ �� �ٸ� ���� �Ӹ��� �ֽ��ϴ�.");
	}
	

	public void actionFly() {
		fly.fly();
	}


	public void actionMissile() {
		missile.missile();
	}


	public void actionKnife() {
		knife.knife();
	}

	
	
	public void setFly(IFly fly) {
		this.fly = fly;
	}

	public void setMissile(IMissile missile) {
		this.missile = missile;
	}

	public void setKnife(IKnife knife) {
		this.knife = knife;
	}

}
