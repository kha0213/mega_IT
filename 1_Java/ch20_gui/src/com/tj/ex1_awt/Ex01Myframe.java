package com.tj.ex1_awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex01Myframe extends Frame {
	private Button btn,btn2;

	public Ex01Myframe(String title) {
		super(title);
		// ȭ�鱸���� ��
		//setLayout(new BorderLayout()); // ���ص� �̰� ! �⺻�� borderLayout(south,north,west,east,enter)�� �ϳ�
		setLayout(new FlowLayout());
		btn = new Button("��ư");
		btn2 = new Button("�׳� ��ư");
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
	// �̺�Ʈ ó���ϴ� �޼ҵ�� ���� �ִ�.!

	public static void main(String[] args) {
		new Ex01Myframe("ù ����");
	}



}
