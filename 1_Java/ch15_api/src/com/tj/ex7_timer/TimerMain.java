package com.tj.ex7_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true); //프로그램 종료시 timer는 메모리에 상주하지 않음.
		TimerTask task1 = new TimerTaskEx1();
		TimerTask task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000);
		timer.schedule(task2, 1000, 500);
		Thread.sleep(11000);
		System.out.println("끝");
	}
}
