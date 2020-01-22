package strategy1.step4.modularization;

import strategy1.step4.inter.*;

public class SuperRobot extends Robot {
	private IFly fly;
	private IMissile missile ;
	private IKnife knife = new KnifeLazer();
	
	public SuperRobot() {
		setFly(new FlyYes()); //fly = new FlyYes();
		setKnife(new KnifeLazer()); //knife = new KnifeLazer();	
		setMissile(new MissileYes()); //missile = new MissileYes();
		
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
	public void setKnife(IKnife knife) {
		this.knife = knife;
	}
	public void setMissile(IMissile missile) {
		this.missile = missile;
	}

}
