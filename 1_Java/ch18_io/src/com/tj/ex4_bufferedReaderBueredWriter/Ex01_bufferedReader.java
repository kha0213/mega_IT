package com.tj.ex4_bufferedReaderBueredWriter;

import java.io.*;

public class Ex01_bufferedReader {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("txtFile/inTest.txt");
			br = new BufferedReader(reader); //������Ʈ���� �⺻��Ʈ���� ���� ����
			while(true) {
				String linedata = br.readLine();
				if(linedata==null)	break; //������ ���ϰ��
				System.out.println(linedata);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(br!=null) br.close();
				if(reader!=null) reader.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
