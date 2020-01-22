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
		txtPoint = new JTextField("가입시 포인트는 입력하지 마세요.", 20);
		imgJoin = new ImageIcon("icon/join.png");
		imgSearch = new ImageIcon("icon/search.png");
		imgOutput = new ImageIcon("icon/output.png");
		imgExit = new ImageIcon("icon/exit.png");
		btnJoin = new JButton("가입", imgJoin);
		btnSearch = new JButton("폰조회", imgSearch);
		btnOutput = new JButton("출력", imgOutput);
		btnExit = new JButton("종료", imgExit);
		textArea = new JTextArea(30, 50);
		scrollPane = new JScrollPane(textArea);
		customers = new ArrayList<Customer>();
		btnReset = new JButton("화면 초기화");
		jpMiddle = new JPanel(new FlowLayout());
		items = new Vector<String>();
		items.add("회원목록");
		combo = new JComboBox<String>(items);
		combo.setBackground(Color.orange);
		
		// 추가
		jpup.add(new JLabel("폰 번 호", (int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("이    름", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("포 인 트", (int) CENTER_ALIGNMENT));
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
				textArea.setText("이름을 입력해야 가입 돼!");
				return;
			}
			
			if (phone.indexOf('-') == -1) {
				textArea.setText("전화번호에 하이픈 - 을 입력해주세요.");
				txtName.setText("");
				txtPhone.setText("");
				return;
			}
			if (phone.indexOf('-') == phone.lastIndexOf('-')) {
				textArea.setText("하이픈 - 이 2개 필요해요~!");
				txtName.setText("");
				txtPhone.setText("");
				return;
			}
			if (phone.length() <= 11) {
				textArea.setText("전화번호가 너무 짧아!! 제대로 입력해.");
				txtName.setText("");
				txtPhone.setText("");
				return;
			}
			if (phone.length() >= 14) {
				textArea.setText("전화번호가 너무 길어!! 제대로 입력해.");
				txtName.setText("");
				txtPhone.setText("");
				return;
			}
			try {
				int phoneBack = (Integer.parseInt(phone.replaceAll("-", ""))) % 10000; //전화번호 뒤의 4자리 실험
			} catch (NumberFormatException e2) {
				textArea.setText("전화번호에 숫자와 -(하이픈)만 입력해주세요.");
			}
			if (point.length() != 0) {
				textArea.setText("포인트 칸에는 아무것도 입력하지 마세요.");
			}
			customers.add(new Customer(phone, name));
			Customer c = new Customer(phone, name);
			combo.addItem(c.toString());
			textArea.setText(c.toString() + "입력성공\r\n");
			txtName.setText("");
			txtPhone.setText("");
			txtPoint.setText("");

		} else if (e.getSource() == btnSearch) {
			textArea.setText("");
			String phone = txtPhone.getText().trim();

			boolean bSearch = false; // 못찾음

			int idxPhone = 0;
			for (idxPhone = 0; idxPhone < customers.size(); idxPhone++) {
				int lastHyphen = customers.get(idxPhone).getPhone().lastIndexOf("-");
				String number4 = customers.get(idxPhone).getPhone().substring(lastHyphen + 1);
				if (phone.equals(number4)) {
					txtName.setText(customers.get(idxPhone).getName());
					txtPhone.setText(customers.get(idxPhone).getPhone());
					txtPoint.setText(String.valueOf(customers.get(idxPhone).getPoint()));
					textArea.append("검색성공, 검색하신 회원의 정보입니다.\n");
					textArea.append(customers.get(idxPhone).toString());
					bSearch = true;
				}
			}
			int idxName = 0;
			//전화번호로 못찾은경우 이름검색
			if (bSearch == false) {
				for (idxName = 0; idxName < customers.size(); idxName++) {
					String searchName = txtName.getText().trim();
					if (searchName.equals(customers.get(idxName).getName())) {
						txtName.setText(customers.get(idxName).getName());
						txtPhone.setText(customers.get(idxName).getPhone());
						txtPoint.setText(String.valueOf(customers.get(idxName).getPoint()));
						textArea.append("검색성공, 검색하신 회원의 정보입니다.\n");
						textArea.append(customers.get(idxName).toString());
						bSearch = true;
					}
				}
			}
			if (bSearch == false) {
				textArea.setText("해당 회원을 찾을 수 없습니다.\n이름 또는 전화번호 입력 후 검색을 다시 눌러주세요");
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
			int answer = JOptionPane.showConfirmDialog(null, "진짜 종료할꺼야?");
			if(answer == 0) {
			setVisible(false);
			dispose();
			System.exit(0);
			}
		} else if (e.getSource()==btnReset) {
			textArea.setText("");
			txtName.setText("");
			txtPhone.setText("");
			txtPoint.setText("가입시 포인트는 입력하지 마세요.");
			
		} else if (e.getSource()==combo) {
			
		}

	}// 메소드 끝

	public static void main(String[] args) {
		new CustomerMain("숙제이다~~");
	}

}
