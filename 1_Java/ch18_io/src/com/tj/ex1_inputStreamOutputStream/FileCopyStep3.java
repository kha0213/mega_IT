package com.tj.ex1_inputStreamOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
// �Է� ��Ʈ��, ��½�Ʈ�� �� �� ����. ���� ������ �״�� write�Ѵ�. ���� ������// �Է½�Ʈ���� ��½�Ʈ���� �ݴ´�.
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyStep3 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		File file = new File("txtFile/IU.jpg");
		
		try {
//			is=new FileInputStream("txtFile/IU.jpg") ;
			is=new FileInputStream(file) ;
			os=new FileOutputStream("txtFile/IU_copy.jpg");
			int cnt=0;
			byte[] bs = new byte[(int)file.length()];
			while(true) {
				cnt++;
				int readByteCount=is.read(bs);// �а�
				if(readByteCount==-1) break;
				os.write(bs,0,readByteCount); //����
			}
			System.out.println("���� ī�� �Ϸ� while�� ������ Ƚ��"+cnt);
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
