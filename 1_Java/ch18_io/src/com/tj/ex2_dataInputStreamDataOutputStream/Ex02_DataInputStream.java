package com.tj.ex2_dataInputStreamDataOutputStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_DataInputStream {
	public static void main(String[] args) {
		InputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("txtFile/dataFile.dat");
			dis = new DataInputStream(fis); //������Ʈ���� �⺻��Ʈ���� ���� ����.
			String name = dis.readUTF(); //�� ������� �д´�.
			int grade = dis.readInt();
			double score = dis.readDouble();
			System.out.println("���Ϸ� ���� �Է¹��� ���� "+name+"\t"+grade+"\t"+score);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
