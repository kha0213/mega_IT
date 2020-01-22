package com.tj.ex5_printwriter;

import java.io.*;
import java.util.*;

public class Ex01 {
	public static void main(String[] args) {
//		OutputStream os = null;//1byte �⺻��Ʈ��
//		Writer writer = null;//2byte �⺻��Ʈ��
		PrintWriter printWriter = null;//���� ��Ʈ��
		
		try {
//			os = new FileOutputStream("txtFile/outTest.txt",true);
//			writer = new FileWriter("txtFile/outTest.txt",true);
			printWriter = new PrintWriter("txtFile/outTest.txt"); //������Ʈ��
			
			System.out.println("�ȳ��ϼ���\n�ݰ����ϴ�.");
			printWriter.println("�ȳ��ϼ���\r\n�ݰ����ϴ�.");
			System.out.printf("%5s %3d %3d %5.1f\n", "ȫ�浿",100,100,100.0);
			printWriter.printf("%5s %3d %3d %5.1f\n", "ȫ�浿",100,100,100.0);
			System.out.printf("%5s %3d %3d %5.1f\n", "���浿",90,95,99.5);
			printWriter.printf("%5s %3d %3d %5.1f\n", "���浿",90,95,99.5);
			System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$tH�� %1$tM�� %1$tS��",new Date());
			printWriter.printf("%1$tY�� %1$tm�� %1$td�� %1$tH�� %1$tM�� %1$tS��",new Date());
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}  finally {
			try {
				printWriter.close();
//				if(writer!=null) writer.close();
//				if(os!=null)os.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
