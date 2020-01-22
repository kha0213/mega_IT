package com.tj.ex6_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ex02 {
	public static void main(String[] args)  {
		File file = new File("txtFile/a.txt");
		System.out.println(file.exists()? "�����ϴ� ����":"�������� �ʴ� ����");
		try {
			System.out.println("������: "+file.getAbsolutePath());
			System.out.println("ǥ�ذ��: "+file.getCanonicalPath());
			Date thatTime = new Date(file.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
			System.out.println("���� ������: "+sdf.format(thatTime));
			System.out.printf("%1$ty-%1$tm-%1$td(%1$ta) %1$tl : %1$tM : %1$tS", thatTime);
			System.out.println("���� ũ�� : "+file.length());
			System.out.println("�б� �Ӽ� : "+file.canRead());
			System.out.println("���� �Ӽ� : "+file.canWrite());
			System.out.println("���� �Ӽ� : "+file.isHidden());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
