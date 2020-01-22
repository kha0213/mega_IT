package com.tj.practice;

import java.io.*;

public class Ex_bufferedReader {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("src/com/tj/ex7_homework/customer.txt");
			br = new BufferedReader(reader);
			while(true) {
				String linedata = br.readLine();
				if(linedata==null) break;
				System.out.println(linedata);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(br!=null)br.close();
				if(reader!=null)reader.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
