package com.tj.ex1_awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex01Myframe extends Frame {
	private Button btn,btn2;

	public Ex01Myframe(String title) {
		super(title);
		// 화면구현만 함
		//setLayout(new BorderLayout()); // 안해도 이거 ! 기본이 borderLayout(south,north,west,east,enter)중 하나
		setLayout(new FlowLayout());
		btn = new Button("버튼");
		btn2 = new Button("그냥 버튼");
		add(btn);
		add(btn2);
		setSize(new Dimension(300, 200));
		setLocation(100, 50);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}

	public Ex01Myframe() {
		this("");
	}
	// 이벤트 처리하는 메소드는 따로 있다.!

	public static void main(String[] args) {
		new Ex01Myframe("첫 예제");
	}



}
