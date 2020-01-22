package com.tj.ex13_robot;
// RobotOrder order = new RobotOrder();
// SingRobot r = new SingRobot();
// DanceRobot d = new DanceRobot();
// order.action(r);
// order.action(d);
public class RobotOrder {
	public void action(Robot robot) {
		if(robot instanceof SingRobot) {
			((SingRobot)robot).sing();
		}else if(robot instanceof DrawRobot) {
			DrawRobot r = (DrawRobot)robot;
			r.draw();
		}else if(robot instanceof DanceRobot) {
			DanceRobot a = (DanceRobot)robot;
			a.dance();
		}else {
			System.out.println("확장된 로봇이면 구현이 필요합니다.");
		}
	}

}
