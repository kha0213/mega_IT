package com.tj.ex2_dataInputStreamDataOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class ProductMain {
	public static void main(String[] args) {
		// 1�ܰ�. x�� �Է��Ҷ����� ����Է�(���Ǹ�,����,������)�޾� ���Ͽ� ����
		Scanner sc = new Scanner(System.in);
		OutputStream fos = null;
		DataOutputStream dos = null;
		String answer;
		try {
			fos = new FileOutputStream("txtFile/product.dat", true);
			dos = new DataOutputStream(fos);
			do {
				System.out.println("��� �� �ֳ���?(�ߴ��� ���ϸ� x, ����� ���ϸ� �ƹ�Ű�� �����ּ���.)");
				answer=sc.next();
				if(answer.equalsIgnoreCase("x"))
					break;
				System.out.println("�Է��� ����� ���Ǹ��� ? ");
				dos.writeUTF(sc.next());
				System.out.println("�Է��� ����� ������ ? ");
				dos.writeInt(sc.nextInt());
				System.out.println("�Է��� ����� ������ ? ");
				dos.writeInt(sc.nextInt());
				
			}while(true);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(dos!=null) dos.close();
				if(fos!=null) fos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		sc.close();
	}//main
}
