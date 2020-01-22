package com.tj.ex2_swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.*;

public class Ex03 extends JFrame implements ActionListener{
	private Container containPane;
	private JPanel jpup;
	private JPanel jpdown;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAge;
	private ImageIcon imgBell, imgWrite;
	private JButton btnInput;
	private JButton btnOutput;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private HashMap<String, Person> person;
	
	
	
	public Ex03(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		containPane = getContentPane();
		containPane.setLayout(new FlowLayout()); //��ü �������� FlowLayout
		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel(new FlowLayout());
		txtName = new JTextField(15);
		txtPhone = new JTextField(15);
		txtAge = new JTextField(15);
		imgBell = new ImageIcon("icon/naruto.png");
		btnInput = new JButton("�Է�",imgBell);
		imgWrite = new ImageIcon("icon/goku.png");
		btnOutput = new JButton("���",imgWrite);
		textArea = new JTextArea(10,30);
		scrollPane = new JScrollPane(textArea);
		person = new HashMap<String, Person>();
		
		jpup.add(new JLabel("��  ��", (int)CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("��  ȭ",(int)CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("��  ��",(int)CENTER_ALIGNMENT));
		jpup.add(txtAge);
		jpdown.add(btnInput);
		jpdown.add(btnOutput);
		containPane.add(jpup);
		containPane.add(jpdown);
		containPane.add(scrollPane);
		
		btnInput.addActionListener(this);
		btnOutput.addActionListener(this);
		
		
		setVisible(true);
//		setSize(new Dimension(200, 400));
		setBounds(100, 100, 400, 400);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnInput) {
			String name = txtName.getText().trim();
			String phone = txtPhone.getText().trim();
			int age=0;
			try {
				age=Integer.parseInt(txtAge.getText().trim());
			} catch (NumberFormatException excep) {
				textArea.setText("������ Ÿ���� ��ȿ���� �ʾ� �Է� ����");
				return;
			}
			if(name.equals("") || phone.equals("")) {
				textArea.setText("�̸��� ��ȭ��ȣ�� �Է����� �ʾ� �Է� ����");
				return;
			}
			if(age>150 || age<0) {
				textArea.setText("��ȿ���� �ʴ� ���̴� �Է� ����");
				return;
			}
			//person(hashmap)�� ���� phone�� �ִ��� �˻�
			int idx=0; //phone �˻�
			Iterator<String> iterater = person.keySet().iterator();
			
			while(iterater.hasNext()) {
				String tempPhone = iterater.next();
				if(tempPhone.equals(phone)) {
					break;
				}
				idx++;
			}
			if(idx<person.size()) {
				textArea.setText("�ߺ��� ��ȭ��ȣ�� �־ �Է� ����");
				return;
			}
			Person p = new Person(name, phone, age);
			person.put(phone, new Person(name, phone, age));
			textArea.setText(p.toString()+"�Է¼���\r\n");
			txtName.setText("");
			txtPhone.setText("");
			txtAge.setText("");
			
		}else if(e.getSource()==btnOutput) {
			Writer writer = null;
			Iterator<String> iterater = person.keySet().iterator();
			try {
				writer = new FileWriter("icon/person.txt");
				textArea.setText("");
				while(iterater.hasNext()) {
					String key = iterater.next();
					Person p = person.get(key);
					System.out.println(p);//�ܼ����
					textArea.append(p.toString()); //textArea�� ���
					writer.write(p.toString());
				}
				System.out.println(person.size()+"�� �Է�");
				textArea.append(person.size()+"�� �Է�");
				writer.write(person.size()+"�� �Է�");
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					if(writer!=null)writer.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}//btnOutput
	}
	
	public static void main(String[] args) {
		new Ex03("����");
	}
	
}
