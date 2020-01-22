package com.tj.ex2_dataInputStreamDataOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class ProductMain {
	public static void main(String[] args) {
		// 1단계. x를 입력할때까지 재고입력(물건명,가격,재고수량)받아 파일에 저장
		Scanner sc = new Scanner(System.in);
		OutputStream fos = null;
		DataOutputStream dos = null;
		String answer;
		try {
			fos = new FileOutputStream("txtFile/product.dat", true);
			dos = new DataOutputStream(fos);
			do {
				System.out.println("재고가 더 있나요?(중단을 원하면 x, 계속을 원하면 아무키나 눌러주세요.)");
				answer=sc.next();
				if(answer.equalsIgnoreCase("x"))
					break;
				System.out.println("입력할 재고의 물건명은 ? ");
				dos.writeUTF(sc.next());
				System.out.println("입력할 재고의 가격은 ? ");
				dos.writeInt(sc.nextInt());
				System.out.println("입력할 재고의 수량은 ? ");
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
