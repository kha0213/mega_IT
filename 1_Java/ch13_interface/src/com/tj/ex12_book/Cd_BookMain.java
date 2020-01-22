package com.tj.ex12_book;

import java.util.Scanner;

public class Cd_BookMain {
	public static void main(String[] args) {
		BookLib[] books = { new BookLib("890-01", "ssd", "���ü�"), new BookLib("890-02", "mit", "������"),
				new BookLib("890-03", "lalala", "����������������"), new BookLib("890-04", "java", "�ſ뼺"),
				new BookLib("890-05", "html", "�����") };
		CDLib[] cds = {new CDLib("cd01", "java"), new CDLib("cd02", "��׳���ũ"), new CDLib("cd03","�������丮")};
		Scanner sc = new Scanner(System.in);
		String bTitle;
		String cdTitle;
		String borrower;
		String checkOutDate;
		int bookIdx; // �����̳� �ݳ��� ó���� å�� index
		int cdIdx;
		int fn;

		System.out.println("å �����Դϴ�.");
		for (BookLib book : books) {
			book.printState();
		}
		System.out.println("CD�����Դϴ�.");
		for(CDLib cd : cds) {
			cd.printState();
		}
		do {
			System.out.println("1.å �뿩 | 2.å �ݳ� | 3.å ���� | 4.CD�뿩 | 5.CD�ݳ� | 0.����");
			fn = sc.nextInt();
			switch (fn) {
			case 1:
				System.out.println("å �뿩 �ý����Դϴ�. �����Ͻ� å�� �̸��� �Է����ּ���.");
				// ����ó�� 1. å�̸� �Է� 2.å�˻� 3.å����Ȯ�� 4. �������Է� 5.�������Է� 6.����ó��
				bTitle = sc.next(); // white-space�ձ����� ��Ʈ������
				for (bookIdx = 0; bookIdx < books.length; bookIdx++) {
					if (books[bookIdx].getBookTitle().equals(bTitle)) {// å ã��
						break;
						// idx<book.length ���� ã�Ҵ�. idx==book.length ���� �� ã�Ҵ�
					}
				} // for
				if (bookIdx == books.length) {
					System.out.println("���� �������� ���� �����Դϴ�.");

				} else {
					if (books[bookIdx].isBookState() == BookLib.STATE_BORROWED) {
						System.out.println("���� �������� �����Դϴ�.");
					} else {
						System.out.println("å ������ ���� ������ �Է��Ͽ� �ֽʽÿ�.");
						borrower = sc.next();
						System.out.println("������ ��¥�� �Է����ּ���.");
						checkOutDate = sc.next();
						System.out.println(borrower + "���� " + books[bookIdx].getBookTitle() + " å �뿩 ���εǾ����ϴ�.");
						books[bookIdx].checkOut(borrower, checkOutDate);
					}
				} // else

				// ����ó��
				break;
			case 2:
				System.out.println("å �ݳ� �ý����Դϴ�. �ݳ��Ͻ� å�� �̸��� �Է����ּ���.");
				// �ݳ� 1.å �̸� 2.å �˻� 3.�ݳ�ó��
				bTitle = sc.next();
				for (bookIdx = 0; bookIdx < books.length; bookIdx++) {
					if (books[bookIdx].getBookTitle().equals(bTitle)) {
						break; // ã��
					}
				} // for

				if (bookIdx == books.length) {//��ã��
					System.out.println(bTitle + "å�� ������ ����å�� �ƴմϴ�.");
				} else {
					
					books[bookIdx].checkIn();
				}
				break;
			case 3:
				System.out.println("å ��ȸ �ý����Դϴ�. ��ȸ�Ͻ� å�� �̸��� �Է����ּ���.");
				bTitle = sc.next();
				for (bookIdx = 0; bookIdx < books.length; bookIdx++) {
					if (books[bookIdx].getBookTitle().equals(bTitle)) {
						break; // ã��
					}
				} // for
				if (bookIdx == books.length) {
					System.out.println(bTitle + "å�� ������ ����å�� �ƴմϴ�.");
				} else {
					books[bookIdx].printState();
				}
				break;
			case 4:
				System.out.println("CD�뿩 �ý����Դϴ�. �뿩�Ͻ� CD�� �̸��� �Է����ּ���.");
				cdTitle = sc.next();
				for(cdIdx=0;cdIdx<cds.length;cdIdx++) {
					if(cds[cdIdx].getCdTitle().equals(cdTitle)) {
						break;
					}
				}//for
				if(cdIdx==cds.length) {
					System.out.println(cdTitle+"CD�� �������� �����ϰ� ���� �ʽ��ϴ�.");
				}else {
					if(cds[cdIdx].isState()==CDLib.STATE_NOMAL) {
						System.out.println("CD�����ô� ���� ������ �Է��Ͽ� �ֽʽÿ�.");
						borrower = sc.next();
						System.out.println("������ ��¥�� �Է����ּ���.");
						checkOutDate = sc.next();
	//					System.out.println(borrower+"�� "+cds[cdIdx].getCdTitle()+" CD �뿩 ���� �Ǿ����ϴ�. �뿩 �Ⱓ�� 2���Դϴ�. �ݳ������� �� �����ּ���.");
						cds[cdIdx].checkOut(borrower, checkOutDate);
					}//if
					else {
						System.out.println("CD�� �������Դϴ�.");
					}
				}//else
				break;
				
			case 5:
				System.out.println("CD �ݳ� �ý����Դϴ�. �ݳ��Ͻ� CD�� �̸��� �Է����ּ���.");
				cdTitle = sc.next();
				for (cdIdx = 0; cdIdx < cds.length; cdIdx++) {
					if (cds[cdIdx].getCdTitle().equals(cdTitle)) {
						break; // ã��
					}
				} // for

				if (cdIdx == cds.length) {
					System.out.println(cdTitle + "CD�� �̹� �������� �ֽ��ϴ�.");
				} else {
					System.out.println(cdTitle + "CD �ݳ� ó���Ǿ����ϴ�.");
					cds[cdIdx].checkIn();
				}
				
				
			case 0:
				break;
			default:
				System.out.println("��ȿ���� ���� ��ɹ�ȣ�Դϴ�. �ٽ� �Է����ּ���.");
				break;
			}

		} while (fn != 0);

		for (BookLib book : books) {
			book.printState();
		}
		for(CDLib cd : cds) {
			cd.printState();
		}

		System.out.println("�ȳ���������.");
		sc.close();

	}// main
}
