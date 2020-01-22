package com.tj.ex2_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex01 extends JFrame implements ActionListener{
	private Container contenPane;
	private JPanel jpanel;
	private JLabel jlbl;
	private JButton jbtn;
	
	public Ex01(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x버튼 클릭시 종료
		//contenPane = getContentPane();
		jpanel = (JPanel)getContentPane(); // 컨테이너를 받아와 jpanel변수에 형변환하여 넣음
		jpanel.setLayout(new FlowLayout());
		jlbl = new JLabel("즐거운 수요일");
		jbtn = new JButton("종료");
		jlbl.setPreferredSize(new Dimension(250,200));
		jbtn.setPreferredSize(new Dimension(200, 200));
		setLocation(500, 500);
		jpanel.add(jlbl);
		jpanel.add(jbtn);
		pack(); // 화면은 최소한의 사이즈
		setVisible(true);
		jbtn.addActionListener(this); //이벤트 추가할 항목
	}
	
	public Ex01() {
		this("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtn) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Ex01("나의 스윙 첫 예제");
	}
}
