package com.tj.ex1_awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex03LogIn extends Frame {
	private Button btn;
	private Panel panel;
	private Label lbl1,lbl2;
	private TextField txtId,txtPw;
	
	public Ex03LogIn(String title) {
		super(title);
		panel = new Panel();
		panel.setLayout(new GridLayout(2, 2));
		lbl1 = new Label("��    ��    ��");
		lbl2 = new Label("��  ��  ��  ȣ");
		txtId = new TextField("ID", 20);
		txtPw = new TextField(20);
		txtPw.setEchoChar('��');
		btn = new Button("�α���");
		panel.add(new Label("��    ��    ��", (int)(CENTER_ALIGNMENT)));
		panel.add(txtId);
		panel.add(new Label("��  ��  ��  ȣ", (int)(CENTER_ALIGNMENT)));
		panel.add(txtPw);
		add(panel, BorderLayout.NORTH);
		add(btn, BorderLayout.SOUTH);
		setVisible(true);
		setSize(new Dimension(400,200));
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
			
		});
		
		
		
		
		
	}
	public Ex03LogIn() {
	}
	
	public static void main(String[] args) {
		new Ex03LogIn("�α��� ȭ��") {
			
		};
	}
	
	
	
	
	
}
