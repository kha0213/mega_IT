package com.tj.ex4_bufferedReaderBueredWriter;

import java.io.*;

public class Ex01_bufferedReader {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("txtFile/inTest.txt");
			br = new BufferedReader(reader); //보조스트림은 기본스트림을 통해 열자
			while(true) {
				String linedata = br.readLine();
				if(linedata==null)	break; //파일이 끝일경우
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
