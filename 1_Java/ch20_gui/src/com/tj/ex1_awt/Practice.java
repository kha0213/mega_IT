package com.tj.ex1_awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Practice extends Frame {
	private Panel panelUp;
	private Panel panelDown;
	private Button btnJoin,btnSearch,btnOutput,btnExit;
	private TextField textPhone,textName,textPoint;
	private Label labelPhone,labelName,labelPoint;
	private List list;
	
	
	public Practice() {
		// ������Ʈ ��ü ����
		panelUp = new Panel();
		panelUp.setLayout(new GridLayout(3, 2));
		panelDown = new Panel();
		panelDown.setLayout(new FlowLayout());
		btnJoin = new Button("����");
		btnSearch = new Button("����ȸ");
		btnOutput = new Button("���");
		btnExit = new Button("����");
		textPhone = new TextField(20);
		textName = new TextField(20);
		textPoint = new TextField(20);
		labelPhone = new Label("����ȣ", (int)RIGHT_ALIGNMENT);
		labelPhone.setBackground(Color.lightGray);
		labelName = new Label("��  ��", (int)RIGHT_ALIGNMENT);
		labelName.setBackground(Color.lightGray);
		labelPoint = new Label("����Ʈ", (int)RIGHT_ALIGNMENT);
		labelPoint.setBackground(Color.lightGray);
		list = new List();
		
		// ������ ��ġ
		panelUp.add(labelPhone);
		panelUp.add(textPhone);
		panelUp.add(labelName);
		panelUp.add(textName);
		panelUp.add(labelPoint);
		panelUp.add(textPoint);
		
		panelDown.add(btnJoin);
		panelDown.add(btnSearch);
		panelDown.add(btnOutput);
		panelDown.add(btnExit);
		
		
		
		
		add(panelUp, BorderLayout.NORTH);
		add(panelDown, BorderLayout.CENTER);
		setVisible(true);
		setSize(new Dimension(400,700));
		setLocation(300, 200);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		
		
	}
	
	
	public Practice(String title) {
		this();
		setTitle(title);
		
	}
	
	public static void main(String[] args) {
		new Practice("ȸ������");
	}
	
}
