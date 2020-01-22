package com.tj.ex05_actor;

public class MainClass {

	public static void main(String[] args) {
		Actor park = new Actor("¹Úº¸°Ë");
		park.outFire();
		park.saveMan();
		park.makeSpaghetti();
		park.makePizza();
		park.canCatchCrimianl();
		park.canSearch();
		
		FireFighter firePark = park;
		firePark.outFire();
		firePark.saveMan();
//		firePark.makeSpaghetti();
//		firePark.makePizza();
//		firePark.canCatchCrimianl();
//		firePark.canSearch();
		
		Chef chefPark = park;
//		chefPark.outFire();
//		chefPark.saveMan();
		chefPark.makeSpaghetti();
		chefPark.makePizza();
//		chefPark.canCatchCrimianl();
//		chefPark.canSearch();
		
	}//main

}
