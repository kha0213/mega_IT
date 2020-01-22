package strategy1.step2;

public class RobotMain {
	public static void main(String[] args) {
		Robot[] robots = {new SuperRobot(), new StandardRobot(), new LowRobot()};
		for(Robot robot : robots) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			robot.shape();
			robot.actiongWalk();
			robot.actionRun();
			if(robot instanceof SuperRobot) {
				((SuperRobot)robot).actionFly();
				((SuperRobot)robot).actionMissile();
				((SuperRobot)robot).actionKnife();		
			}
			else if(robot instanceof StandardRobot) {
				((StandardRobot)robot).actionFly();
				((StandardRobot)robot).actionMissile();
				((StandardRobot)robot).actionKnife();
			}
			else if(robot instanceof LowRobot){
				((LowRobot)robot).actionFly();
				((LowRobot)robot).actionMissile();
				((LowRobot)robot).actionKnife();
			}
//			if(robot instanceof SuperRobot) {
//				((SuperRobot)robot).actionMissile();
//				
//			}
//			else if(robot instanceof StandardRobot) {
//				((StandardRobot)robot).actionMissile();
//				
//			}
//			else if(robot instanceof LowRobot){
//				((LowRobot)robot).actionMissile();
//			}
//			if(robot instanceof SuperRobot) {
//				((SuperRobot)robot).actionKnife();
//				
//			}
//			else if(robot instanceof StandardRobot) {
//				((StandardRobot)robot).actionKnife();
//				
//			}
//			else if(robot instanceof LowRobot){
//				((LowRobot)robot).actionKnife();
//			}
//			
		}// for
		
		

	}// main
}
