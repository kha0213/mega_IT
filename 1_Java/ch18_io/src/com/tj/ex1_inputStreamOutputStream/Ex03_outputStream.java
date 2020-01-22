package com.tj.ex1_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex03_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os= new FileOutputStream("D:/mega_IT/outTest.txt"); //1.��Ʈ������
			byte[] bs = {'H','e','l','l','o',',','j','a','v','a','\r','\n','H'};
			for(int i=0;i<bs.length;i++) {//2.�����;���
				os.write(bs[i]);
				System.out.print((char)bs[i]);
			}
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
