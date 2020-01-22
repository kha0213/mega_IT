package com.tj.ex1_inputStreamOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
// 입력 스트림, 출력스트림 둘 다 연다. 읽은 데이터 그대로 write한다. 파일 끝까지// 입력스트림과 출력스트림을 닫는다.
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyStep1 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is=new FileInputStream("txtFile/IU.jpg") ;
			os=new FileOutputStream("txtFile/IU_copy.jpg");
			int cnt=0;
			byte[] bs=new byte[1024];
			while(true) {
				cnt++;
				int readByteCount=is.read(bs);// 1024byte씩 읽고
				if(readByteCount==-1) break;
				os.write(bs,0,readByteCount); //bs배열에 0index부터 readByteCount 바이트만큼 써라
			}
			System.out.println("파일 카피 완료 while문 실행한 횟수"+cnt);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
				
		
		
	}
}
