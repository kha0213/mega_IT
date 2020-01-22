package com.tj.ex1_awt;

import java.awt.*;

public class Ex0 {
	public static void main(String[] args) {
		Frame frame = new Frame("title");
		Button btn = new Button("버튼");
		Button btn2 = new Button("그냥 버튼");
		frame.add(btn);
		frame.add(btn2);
		// frame.pack(); 최소한의 사이즈
		frame.setSize(new Dimension(300, 200));
		frame.setLocation(100, 50);
		
		frame.setVisible(true); // frame을 화면에 보이게 함
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		frame.setVisible(false); //안보이게 하고
		frame.dispose(); //자원해제
		System.exit(0); //강제종료
		
	}
}
