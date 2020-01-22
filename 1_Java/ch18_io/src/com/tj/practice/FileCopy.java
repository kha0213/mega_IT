package com.tj.practice;

import java.io.*;
import java.io.FileOutputStream;

public class FileCopy {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		File file = new File("txtFile/IU.jpg");
		try {
			is = new FileInputStream(file);
			os = new FileOutputStream("txtFile/IUU.jpg");
			
			byte[] bs = new byte[(int)file.length()];
			
			while(true) {
				int i=is.read(bs);
				if(i==-1) break;
				os.write(bs, 0, i);
			}
			System.out.println("카피완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(os!=null)os.close();
				if(is!=null)is.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
				
	}
}
