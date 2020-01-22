package com.tj.ex1_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_outputStream2 {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os= new FileOutputStream("txtFile/outTest.txt",true); //1.��Ʈ������
			String str = "�ȳ��ϼ���\n�շ��Դϴ�.";
			byte[] bs = str.getBytes();
			os.write(bs);
//			for(int i=0;i<bs.length;i++) {//2.�����;���
//				os.write(bs[i]);
//				System.out.print((char)bs[i]);
//			}
		} catch (FileNotFoundException e) {
			System.out.println("���ϸ�ã��"+e.getMessage());
		} catch (IOException e) {
			System.out.println("���� ����"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(os!=null) {
					os.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
