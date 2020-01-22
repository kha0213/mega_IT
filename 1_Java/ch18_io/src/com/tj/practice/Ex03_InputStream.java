package com.tj.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex03_InputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			byte[] b = new byte[10];
			is = new FileInputStream("txtFile/a.txt");
			while(true) {
				int i = is.read(b);
				if(i==-1) break;
				
				
				for(int j=0;j<i;j++)
				System.out.print((char)b[j]);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(is!=null) is.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
