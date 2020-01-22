package com.tj.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//1.스트림연다 2.읽는다 3.닫는다.
public class Ex02_inputStream3byte {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("D:/mega_IT/inTest.txt"); //(1).스트림 열었다.
			byte[] bs = new byte[2];
			while(true) {
				int readByteCount = is.read(bs); //(2).3byte씩 읽는다
				if(readByteCount==-1) {
					break;
				}
				for(int i=0;i<readByteCount;i++) {
					System.out.print((char)bs[i]);
				}
//				for(byte b : bs) {
//					System.out.print((char)b); //맨 마지막 읽는 것은 다를 수도 같은 수도 있어 조정 예정
//				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(is!=null) {
					is.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
