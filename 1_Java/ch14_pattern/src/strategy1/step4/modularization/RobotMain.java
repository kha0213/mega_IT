package strategy1.step4.modularization;

public class RobotMain {
	public static void main(String[] args) {
		Robot[] robots = {new SuperRobot(),new StandardRobot(), new LowRobot()};
		
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
