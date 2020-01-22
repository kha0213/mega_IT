package com.tj.ex5_library;

import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) throws Exception {
		String borrower;
		String bTitle;
		int fn;
		int bookIdx;
		Scanner sc = new Scanner(System.in);
		BookLib[] book = { new BookLib("192-35", "�̰����ڹٴ�", "�ſ뼺"), new BookLib("190-24", "�ڹ�", "�շ���"),
				new BookLib("152-39", "���׶���", "���ֺ�"), new BookLib("100-00", "�ζ�_�װ��� �˰�ʹ�", "��÷���"),
				new BookLib("890-01", "ssd", "���ü�"), new BookLib("890-02", "mit", "������"),
				new BookLib("890-03", "lalala", "����������������"), new BookLib("890-04", "java", "�ſ뼺"),
				new BookLib("890-05", "html", "�����") };

		all: while (true) {
			System.out.println("-----------------------------------------------------");
			System.out.println("0:å ���� ��ȸ     1:����     2:�ݳ�\n���Ḧ ���Ͻø� �ƹ�Ű�� �����ּ���.");
			System.out.println("-----------------------------------------------------");
			try {
				fn = sc.nextInt();
			} catch (Exception e) {
				System.out.println("�ý����� �����մϴ�. �ȳ����輼��.");
				break;
			} // catch
			switch (fn) {
			case 0:
				System.out.println("å ���� ��ȸ�Դϴ�.");
				for (BookLib b : book) {
					System.out.println(b);
				}
				break;

			case 1:
				System.out.println("å �뿩 �ý����Դϴ�. �����Ͻ� å�� �̸��� �Է����ּ���.");
				bTitle = sc.next();
				for (bookIdx = 0; bookIdx < book.length; bookIdx++) {
					if (book[bookIdx].getBookTitle().equals(bTitle)) {// å ã��
						break;
					}
				} // for
				if (bookIdx == book.length) {
					System.out.println("���� �������� ���� �����Դϴ�.");

				} else {
					System.out.println("å �뿩 ��û�Դϴ�. ������ ���� ������ �Է��Ͽ� �ֽʽÿ�.");
					borrower = sc.next();
					try {
						book[bookIdx].checkOut(borrower);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println(book[bookIdx]);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
				} // else
				break; // case 1

			case 2:
				System.out.println("å �ݳ� �ý����Դϴ�. �ݳ��Ͻ� å�� �̸��� �Է����ּ���.");
				bTitle = sc.next();
				for (bookIdx = 0; bookIdx < book.length; bookIdx++) {
					if (book[bookIdx].getBookTitle().equals(bTitle)) {
						break; // ã��
					}
				}
				if (bookIdx == book.length) {// ��ã��
					System.out.println(bTitle + "å�� ������ ����å�� �ƴմϴ�.");
				} else {
					try {
						book[bookIdx].checkIn();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break; // case 2

			default:
				System.out.println("�ý����� �����մϴ�. �ȳ����輼��.");
				break all;
			}// switch
		} // while
	}// main
}
