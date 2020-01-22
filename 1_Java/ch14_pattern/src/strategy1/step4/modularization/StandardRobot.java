package strategy1.step4.modularization;

import strategy1.step4.inter.*;

public class StandardRobot extends Robot {
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public StandardRobot() {
		setFly(new FlyNo()); //fly = new FlyNo();
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
	}

	@Override
	public void actionFly() {
		fly.fly();
	}

	@Override
	public void actionMissile() {
		missile.missile();
	}

	@Override
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
