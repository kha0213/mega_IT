package com.tj.ex4_bufferedReaderBueredWriter;

import java.io.*;

public class Ex03_keyboard {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("저장할 파일 이름은?");
		Writer writer = null;
		try {
			String fileName = keyboard.readLine();
			writer = new FileWriter(fileName);
			while(true) {
				System.out.println("파일 내용 입력하세요.(더이상 내용이 없을 때 x 입력");
				String content = keyboard.readLine();
				if(content.equalsIgnoreCase("x")) break;
				writer.write(content);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(writer!=null) writer.close();
				if(keyboard!=null) keyboard.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
