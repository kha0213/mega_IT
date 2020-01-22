package com.tj.ex4_bufferedReaderBueredWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Ex02_keyboard {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		Reader reader = null; //�⺻ ��Ʈ������
		BufferedReader br = null; //���� ��Ʈ������
		System.out.print("�о�� ���� �̸��� �Է��ϼ���.");
		try {
			String filename = keyboard.readLine(); //���� �̸� �Է�
			File file = new File(filename); // �Էµ� �����̸����� ���ϰ�ü
			if(file.exists()) {
				reader = new FileReader(file); //�⺻��Ʈ�� ����.
				br = new BufferedReader(reader);
				while(true) {
					String linedata = br.readLine();
					if(linedata==null) break;
					System.out.println(linedata);
				}
			}else {
				System.out.println("�Է��Ͻ� ������ �������� �ʾ� ���� �� ���� �̶���~!!!");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(br!=null) br.close();
				if(reader!=null) reader.close();
				if(keyboard!=null) keyboard.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
