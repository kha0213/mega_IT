package com.tj.practice;

import java.io.*;

public class Ex02_bufferedWriter {
	public static void main(String[] args) {
		Writer writer = null;
		BufferedWriter bw = null;
		try {
			writer = new FileWriter("txtFile/gpgpgp.txt");
			bw = new BufferedWriter(writer);
			
			bw.write("ø¿¥√µµ µ∑±ÓΩ∫ ≥ª¿œµµ µ∑±ÓΩ∫");
			bw.newLine();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(bw!=null) bw.close();
				if(writer!=null) writer.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
