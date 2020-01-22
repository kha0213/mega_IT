package com.tj.ex3_writerReader;

import java.io.*;

public class Ex01_reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("txtFile/inTest.txt"); //1.��Ʈ�� ����
			while(true) {
				int i = reader.read(); //2.�д´�(2byte�� �д´�)
				if(i==-1) break;
				System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(reader!=null) reader.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
