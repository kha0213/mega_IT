package com.tj.ex04_acor;

public class MainClass {
	public static void main(String[] args) {
		IAcor[] models = {new AModel(), new BModel(), new CModel()};
		for(IAcor s : models) {
			s.dmbReceive();
			s.lte();
			s.tvremoteControl();
			System.out.println("--------------------");
		}
		
	}//main

}
