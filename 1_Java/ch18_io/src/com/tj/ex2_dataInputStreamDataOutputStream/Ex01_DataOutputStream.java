package com.tj.ex2_dataInputStreamDataOutputStream;

import java.io.*;

public class Ex01_DataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null; //�⺻ ��Ʈ�� ����
		DataOutputStream dos = null; //���� ��Ʈ�� ����
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat");
			dos = new DataOutputStream(fos); //������Ʈ���� �⺻��Ʈ���� �̿��ؼ� ����.
			dos.writeUTF("ȫ�浿");
			dos.writeInt(2);
			dos.writeDouble(95.9);
		} catch (FileNotFoundException e) {
			System.out.println("���� ���� ����"+e.getMessage());
		} catch (IOException e) {
			System.out.println("���� ����"+e.getMessage());
		} finally {
			try {
				if(dos!=null) dos.close();
				if(fos!=null) fos.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
