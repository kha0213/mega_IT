package com.tj.ex2_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ex02 extends JFrame implements ActionListener{
	private Container containpane;
	private JLabel jlbl;
	private JButton jbtn;
	private JTextField jtxt;
	private JComboBox<String> jcom;
	private Vector<String> items;
	private String[] item = {"A","B","C"};
	private JCheckBox jchk;
	private JLabel jlblBlank;
	private JButton jbtnExit;
	private ImageIcon img;

	
	public Ex02() {
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x누를 시 종료
		containpane = getContentPane();
		containpane.setLayout(new FlowLayout());
		jlbl = new JLabel("Label");
		jbtn = new JButton("Button");
		jtxt = new JTextField(20);
		items = new Vector<String>(); //콤보박스에 들어갈 항목들 Vector
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("WOW");
		jcom = new JComboBox<String>(items); //콤보박스 생성 시 Vector을 이용해서 항목까지 추가
//		jcom = new JComboBox<String>(item); // 콤보박스 생성시 String배열을 이용해서 항목추가
		jchk = new JCheckBox("checkBok");
		jlblBlank = new JLabel();
		jbtnExit = new JButton("EXIT");
		containpane.add(jlbl);
		containpane.add(jbtn);
		containpane.add(jtxt);
		containpane.add(jcom);
		containpane.add(jchk);
		containpane.add(jlblBlank);
		containpane.add(jbtnExit);
		jlbl.setPreferredSize(new Dimension(50,50)); //콤포넌트들의 사이즈 조정
		jbtn.setPreferredSize(new Dimension(100,50));
		jtxt.setPreferredSize(new Dimension(300,50));
		jcom.setPreferredSize(new Dimension(100,50));
		jchk.setPreferredSize(new Dimension(100,50));
		jlblBlank.setPreferredSize(new Dimension(200,50));
		jbtnExit.setPreferredSize(new Dimension(100,50));
		
		setVisible(true);
		pack();
		setLocation(300, 400);
		// 이벤트 리스너 추가될 컴포넌트들
		jbtn.addActionListener(this);
		jcom.addActionListener(this);
		jchk.addActionListener(this);
		jbtnExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtn) {
			//텍스트필드의 값을 jcom항목에 추가하고 jlblBlank 에도 나타나게
			String str = jtxt.getText().trim();
			if(!str.equals("")) {
				jcom.addItem(str);
				jlblBlank.setText(str);
				jtxt.setText("");
			}else {
				jtxt.setText("");
			}
		}else if(e.getSource()==jcom) {
			//jcom의 선택된 항목을 jlblBlank에 나타나게
			jlblBlank.setText(jcom.getSelectedItem().toString());
		}else if(e.getSource()==jchk) {
			// checked되면 jlblBlank에 check 됐다고, unChecked 되면 안 됐다고 말하기.
			if(jchk.isSelected()) {// true면 체크됨
				jlblBlank.setText("체크박스 체크함");
			}else {
				jlblBlank.setText("체크박스의 체크 풀었음");
			}
		}else if(e.getSource()==jbtnExit) {
			int answer = JOptionPane.showConfirmDialog(null, "진짜 종료할꺼야?");
			if(answer == 0) {
			setVisible(false);
			dispose();
			System.exit(0);
			}
		}
		
	}
	public static void main(String[] args) {
		new Ex02();
	}
	
	
}
