package com.tj.ex5_printwriter;

import java.io.*;
import java.util.*;

public class Ex01 {
	public static void main(String[] args) {
//		OutputStream os = null;//1byte 기본스트림
//		Writer writer = null;//2byte 기본스트림
		PrintWriter printWriter = null;//보조 스트림
		
		try {
//			os = new FileOutputStream("txtFile/outTest.txt",true);
//			writer = new FileWriter("txtFile/outTest.txt",true);
			printWriter = new PrintWriter("txtFile/outTest.txt"); //보조스트림
			
			System.out.println("안녕하세요\n반갑습니다.");
			printWriter.println("안녕하세요\r\n반갑습니다.");
			System.out.printf("%5s %3d %3d %5.1f\n", "홍길동",100,100,100.0);
			printWriter.printf("%5s %3d %3d %5.1f\n", "홍길동",100,100,100.0);
			System.out.printf("%5s %3d %3d %5.1f\n", "마길동",90,95,99.5);
			printWriter.printf("%5s %3d %3d %5.1f\n", "마길동",90,95,99.5);
			System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초",new Date());
			printWriter.printf("%1$tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초",new Date());
			
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
