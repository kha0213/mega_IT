package com.tj.ex1_awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex02MyFrame extends Frame implements ActionListener{
	private Label lbl1;
	private Button btnExit;
	// 생성자 화면구성
	//이벤트 처리 -클릭시 뭐해라
	public Ex02MyFrame(String name) {
		super(name);
		setLayout(new FlowLayout());
//		setLayout(new GridLayout(1,2)); //1행 2열짜리 그리드 레이아웃
		lbl1 = new Label("즐거운 화요일");
		btnExit = new Button("종료");
		lbl1.setPreferredSize(new Dimension(250, 200));
		btnExit.setPreferredSize(new Dimension(200, 200));
		setSize(new Dimension(500,300));
		add(lbl1);
		add(btnExit);
		setVisible(true);
		setBackground(Color.cyan);
		btnExit.addActionListener(this); // 이벤트 처리할 개요.
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}
	public Ex02MyFrame(){
		this("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	
	public static void main(String[] args) {
		new Ex02MyFrame("나의 예제") {};
	}
	
	
	

}
