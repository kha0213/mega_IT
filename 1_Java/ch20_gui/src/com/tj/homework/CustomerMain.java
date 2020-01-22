package com.tj.homework;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.*;

public class CustomerMain extends JFrame implements ActionListener {
	private Container containPane;
	private JPanel jpup;
	private JPanel jpdown;
	private JTextField txtPhone;
	private JTextField txtName;
	private JTextField txtPoint;
	private ImageIcon imgJoin, imgSearch, imgOutput, imgExit;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private ArrayList<Customer> customers;
	private JButton btnReset;
	private JPanel jpMiddle;
	private JComboBox<String> combo;
	private Vector<String> items;

	public CustomerMain(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		containPane = getContentPane();
		containPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel(new FlowLayout());
		txtPhone = new JTextField(20);
		txtName = new JTextField(20);
		txtPoint = new JTextField("���Խ� ����Ʈ�� �Է����� ������.", 20);
		imgJoin = new ImageIcon("icon/join.png");
		imgSearch = new ImageIcon("icon/search.png");
		imgOutput = new ImageIcon("icon/output.png");
		imgExit = new ImageIcon("icon/exit.png");
		btnJoin = new JButton("����", imgJoin);
		btnSearch = new JButton("����ȸ", imgSearch);
		btnOutput = new JButton("���", imgOutput);
		btnExit = new JButton("����", imgExit);
		textArea = new JTextArea(30, 50);
		scrollPane = new JScrollPane(textArea);
		customers = new ArrayList<Customer>();
		btnReset = new JButton("ȭ�� �ʱ�ȭ");
		jpMiddle = new JPanel(new FlowLayout());
		items = new Vector<String>();
		items.add("ȸ�����");
		combo = new JComboBox<String>(items);
		combo.setBackground(Color.orange);
		
		// �߰�
		jpup.add(new JLabel("�� �� ȣ", (int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("��    ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("�� �� Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(txtPoint);
		jpdown.add(btnJoin);
		jpdown.add(btnSearch);
		jpdown.add(btnOutput);
		jpdown.add(btnExit);
		jpMiddle.add(combo);
		jpMiddle.add(btnReset);
		containPane.add(jpup);
		containPane.add(jpMiddle);
		containPane.add(jpdown);
		containPane.add(scrollPane);

		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
		btnReset.addActionListener(this);
		combo.addActionListener(this);
		

		setVisible(true);
		setBounds(100, 100, 600, 1000);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnJoin) {
			String name = txtName.getText().trim();
			String phone = txtPhone.getText().trim(); // 010-2456-5485
			String point = txtPoint.getText().trim();
			if(name.length()==0) {
				textArea.setText("�̸��� �Է��ؾ� ���� ��!");
				return;
			}
			
			if (phone.indexOf('-') == -1) {
				textArea.setText("��ȭ��ȣ�� ������ - �� �Է����ּ���.");
				txtName.setText("");
				txtPhone.setText("");
				return;
			}
			if (phone.indexOf('-') == phone.lastIndexOf('-')) {
				textArea.setText("������ - �� 2�� �ʿ��ؿ�~!");
				txtName.setText("");
				txtPhone.setText("");
				return;
			}
			if (phone.length() <= 11) {
				textArea.setText("��ȭ��ȣ�� �ʹ� ª��!! ����� �Է���.");
				txtName.setText("");
				txtPhone.setText("");
				return;
			}
			if (phone.length() >= 14) {
				textArea.setText("��ȭ��ȣ�� �ʹ� ���!! ����� �Է���.");
				txtName.setText("");
				txtPhone.setText("");
				return;
			}
			try {
				int phoneBack = (Integer.parseInt(phone.replaceAll("-", ""))) % 10000; //��ȭ��ȣ ���� 4�ڸ� ����
			} catch (NumberFormatException e2) {
				textArea.setText("��ȭ��ȣ�� ���ڿ� -(������)�� �Է����ּ���.");
			}
			if (point.length() != 0) {
				textArea.setText("����Ʈ ĭ���� �ƹ��͵� �Է����� ������.");
			}
			customers.add(new Customer(phone, name));
			Customer c = new Customer(phone, name);
			combo.addItem(c.toString());
			textArea.setText(c.toString() + "�Է¼���\r\n");
			txtName.setText("");
			txtPhone.setText("");
			txtPoint.setText("");

		} else if (e.getSource() == btnSearch) {
			textArea.setText("");
			String phone = txtPhone.getText().trim();

			boolean bSearch = false; // ��ã��

			int idxPhone = 0;
			for (idxPhone = 0; idxPhone < customers.size(); idxPhone++) {
				int lastHyphen = customers.get(idxPhone).getPhone().lastIndexOf("-");
				String number4 = customers.get(idxPhone).getPhone().substring(lastHyphen + 1);
				if (phone.equals(number4)) {
					txtName.setText(customers.get(idxPhone).getName());
					txtPhone.setText(customers.get(idxPhone).getPhone());
					txtPoint.setText(String.valueOf(customers.get(idxPhone).getPoint()));
					textArea.append("�˻�����, �˻��Ͻ� ȸ���� �����Դϴ�.\n");
					textArea.append(customers.get(idxPhone).toString());
					bSearch = true;
				}
			}
			int idxName = 0;
			//��ȭ��ȣ�� ��ã����� �̸��˻�
			if (bSearch == false) {
				for (idxName = 0; idxName < customers.size(); idxName++) {
					String searchName = txtName.getText().trim();
					if (searchName.equals(customers.get(idxName).getName())) {
						txtName.setText(customers.get(idxName).getName());
						txtPhone.setText(customers.get(idxName).getPhone());
						txtPoint.setText(String.valueOf(customers.get(idxName).getPoint()));
						textArea.append("�˻�����, �˻��Ͻ� ȸ���� �����Դϴ�.\n");
						textArea.append(customers.get(idxName).toString());
						bSearch = true;
					}
				}
			}
			if (bSearch == false) {
				textArea.setText("�ش� ȸ���� ã�� �� �����ϴ�.\n�̸� �Ǵ� ��ȭ��ȣ �Է� �� �˻��� �ٽ� �����ּ���");
			}

		} else if (e.getSource() == btnOutput) {
			textArea.setText("");
			Writer writer = null;
			try {
				writer = new FileWriter("icon/homework1218.txt");
				for (Customer c : customers) {
					System.out.println(c);
					textArea.append(c.toString());
					writer.write(c.toString());
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					if (writer != null)
						writer.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		} else if (e.getSource() == btnExit) {
			int answer = JOptionPane.showConfirmDialog(null, "��¥ �����Ҳ���?");
			if(answer == 0) {
			setVisible(false);
			dispose();
			System.exit(0);
			}
		} else if (e.getSource()==btnReset) {
			textArea.setText("");
			txtName.setText("");
			txtPhone.setText("");
			txtPoint.setText("���Խ� ����Ʈ�� �Է����� ������.");
			
		} else if (e.getSource()==combo) {
			
		}

	}// �޼ҵ� ��

	public static void main(String[] args) {
		new CustomerMain("�����̴�~~");
	}

}
