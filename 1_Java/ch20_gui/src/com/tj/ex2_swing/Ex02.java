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
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x���� �� ����
		containpane = getContentPane();
		containpane.setLayout(new FlowLayout());
		jlbl = new JLabel("Label");
		jbtn = new JButton("Button");
		jtxt = new JTextField(20);
		items = new Vector<String>(); //�޺��ڽ��� �� �׸�� Vector
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("WOW");
		jcom = new JComboBox<String>(items); //�޺��ڽ� ���� �� Vector�� �̿��ؼ� �׸���� �߰�
//		jcom = new JComboBox<String>(item); // �޺��ڽ� ������ String�迭�� �̿��ؼ� �׸��߰�
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
		jlbl.setPreferredSize(new Dimension(50,50)); //������Ʈ���� ������ ����
		jbtn.setPreferredSize(new Dimension(100,50));
		jtxt.setPreferredSize(new Dimension(300,50));
		jcom.setPreferredSize(new Dimension(100,50));
		jchk.setPreferredSize(new Dimension(100,50));
		jlblBlank.setPreferredSize(new Dimension(200,50));
		jbtnExit.setPreferredSize(new Dimension(100,50));
		
		setVisible(true);
		pack();
		setLocation(300, 400);
		// �̺�Ʈ ������ �߰��� ������Ʈ��
		jbtn.addActionListener(this);
		jcom.addActionListener(this);
		jchk.addActionListener(this);
		jbtnExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtn) {
			//�ؽ�Ʈ�ʵ��� ���� jcom�׸� �߰��ϰ� jlblBlank ���� ��Ÿ����
			String str = jtxt.getText().trim();
			if(!str.equals("")) {
				jcom.addItem(str);
				jlblBlank.setText(str);
				jtxt.setText("");
			}else {
				jtxt.setText("");
			}
		}else if(e.getSource()==jcom) {
			//jcom�� ���õ� �׸��� jlblBlank�� ��Ÿ����
			jlblBlank.setText(jcom.getSelectedItem().toString());
		}else if(e.getSource()==jchk) {
			// checked�Ǹ� jlblBlank�� check �ƴٰ�, unChecked �Ǹ� �� �ƴٰ� ���ϱ�.
			if(jchk.isSelected()) {// true�� üũ��
				jlblBlank.setText("üũ�ڽ� üũ��");
			}else {
				jlblBlank.setText("üũ�ڽ��� üũ Ǯ����");
			}
		}else if(e.getSource()==jbtnExit) {
			int answer = JOptionPane.showConfirmDialog(null, "��¥ �����Ҳ���?");
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
