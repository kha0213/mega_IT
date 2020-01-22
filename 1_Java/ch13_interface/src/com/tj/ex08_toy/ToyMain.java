package com.tj.ex08_toy;

public class ToyMain {
	public static void main(String[] args) {
		PoohToy pooh1 = new PoohToy();
		IMoveArmLeg pooh2 = new PoohToy();
		IToy pooh3 = new PoohToy();
		
//		MazingerToy mazingerToy1 = new MazingerToy();
//		IMoveArmLeg mazingerToy2 = new MazingerToy();
//		IMissile mazingerToy3 = new MazingerToy();
//		IToy mazingerToy4 = new MazingerToy();
//		
//		AirplaneToy airplane1 = new AirplaneToy();
		
		pooh1.canMoveArmLeg();
		pooh2.canMoveArmLeg();
		((PoohToy)pooh3).canMoveArmLeg();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		IToy pooh = new PoohToy();
		IToy mazinger = new MazingerToy();
		IToy airplane = new AirplaneToy();
		
		
		
		IToy[] toy = {pooh,mazinger,airplane};
		for(IToy t : toy) {
			System.out.println(t.getClass().getName());
			
			
		}
		
	}

}
