package com.tj.ex4_bufferedReaderBueredWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Ex02_keyboard {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		Reader reader = null; //기본 스트림변수
		BufferedReader br = null; //보조 스트림변수
		System.out.print("읽어올 파일 이름을 입력하세요.");
		try {
			String filename = keyboard.readLine(); //파일 이름 입력
			File file = new File(filename); // 입력된 파일이름으로 파일객체
			if(file.exists()) {
				reader = new FileReader(file); //기본스트림 연다.
				br = new BufferedReader(reader);
				while(true) {
					String linedata = br.readLine();
					if(linedata==null) break;
					System.out.println(linedata);
				}
			}else {
				System.out.println("입력하신 파일은 존재하지 않아 읽을 수 없어 이때끼~!!!");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(br!=null) br.close();
				if(reader!=null) reader.close();
				if(keyboard!=null) keyboard.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
