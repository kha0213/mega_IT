package com.tj.ex1_awt;

import java.awt.*;

public class Ex0 {
	public static void main(String[] args) {
		Frame frame = new Frame("title");
		Button btn = new Button("��ư");
		Button btn2 = new Button("�׳� ��ư");
		frame.add(btn);
		frame.add(btn2);
		// frame.pack(); �ּ����� ������
		frame.setSize(new Dimension(300, 200));
		frame.setLocation(100, 50);
		
		frame.setVisible(true); // frame�� ȭ�鿡 ���̰� ��
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		frame.setVisible(false); //�Ⱥ��̰� �ϰ�
		frame.dispose(); //�ڿ�����
		System.exit(0); //��������
		
	}
}
