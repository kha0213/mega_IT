package com.tj.ex6_file;

import java.io.*;

public class Ex01_file {
	public static void main(String[] args) {
		File file = new File("."); //������Ʈ ���� (ch18_io ����)
//		String[] fileStr = file.list();
//		for(String fileS : fileStr) {
//			System.out.println(fileS);
//		}
		File[] files = file.listFiles();
		System.out.println("������Ʈ ������ ����");
		for(File f : files) {
			if(f.getName().length()>=8)
				System.out.print(f.getName());
			else
				System.out.print(f.getName()+"\t");
			System.out.print("\t"+f.length()+"\t");
			System.out.println(f.isDirectory()? "���丮":"����");
		}
	}
}
