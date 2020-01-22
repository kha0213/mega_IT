package com.tj.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//파일입력(inTest.txt) -> 1. 스트림을 연다. 2. 읽는다. 3.파일을 닫는다.
public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("D:/mega_IT/intest.txt"); //1.스트림을 연다.
			while(true) {
				int i = is.read(); //2.읽는다(1 byte)
				if(i == -1) {
					break; //i가 -1이면 파일의 끝
				}
				System.out.print((char)i+"의 아스키코드값");
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 못 찾아을 때 예외 "+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(is!=null) is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} 
	}
}
