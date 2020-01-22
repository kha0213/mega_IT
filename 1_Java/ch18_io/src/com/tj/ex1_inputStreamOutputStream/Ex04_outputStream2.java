package com.tj.ex1_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_outputStream2 {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os= new FileOutputStream("txtFile/outTest.txt",true); //1.스트림연다
			String str = "안녕하세요\n롱롱입니다.";
			byte[] bs = str.getBytes();
			os.write(bs);
//			for(int i=0;i<bs.length;i++) {//2.데이터쓴다
//				os.write(bs[i]);
//				System.out.print((char)bs[i]);
//			}
		} catch (FileNotFoundException e) {
			System.out.println("파일못찾음"+e.getMessage());
		} catch (IOException e) {
			System.out.println("쓰기 오류"+e.getMessage());
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
