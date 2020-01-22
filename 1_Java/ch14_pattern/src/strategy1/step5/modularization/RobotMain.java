package strategy1.step5.modularization;

import strategy1.step4.inter.FlyHigh;

public class RobotMain {
	public static void main(String[] args) {
		Robot[] robots = {new SuperRobot(),new StandardRobot(), new LowRobot()};
		
		System.out.println("�䱸���� ���� ��");	
		
		for(Robot r : robots) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~");
			r.shape();
			r.actiongWalk();
			r.actionRun();
			r.actionFly();
			r.actionKnife();
			r.actionMissile();
		}
		System.out.println("�䱸���� ���� ��");
		robots[0].setFly(new FlyHigh());
		
		for(Robot r : robots) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~");
			r.shape();
			r.actiongWalk();
			r.actionRun();
			r.actionFly();
			r.actionKnife();
			r.actionMissile();
		}
	}

}
