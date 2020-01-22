package com.tj.ex11_book;

import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		Book[] books = {new Book("890-01","ssd","���ü�"),
					new Book("890-02", "mit", "������"),
					new Book("890-03", "lalala", "����������������"),
					new Book("890-04","java","�ſ뼺"),
					new Book("890-05","html","�����")};
		Scanner sc = new Scanner(System.in);
		String bTitle;
		String borrower;
		String checkOutDate;
		int idx; //�����̳� �ݳ��� ó���� å�� index
		int fn;
		
		for(Book book : books) {
			book.printState();
		}
		do{
			System.out.println("1.å ����  2.å �ݳ� 0.����");
			fn = sc.nextInt();
			switch (fn) {
			case 1: System.out.println("å ���� �ý����Դϴ�. �����Ͻ� å�� �̸��� �Է����ּ���.");
			//����ó�� 1. å�̸� �Է� 2.å�˻� 3.å����Ȯ�� 4. �������Է� 5.�������Է� 6.����ó��
				bTitle = sc.next(); //white-space�ձ����� ��Ʈ������
				for(idx=0;idx<books.length;idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {//å ã��
						break;
					//idx<book.length ���� ã�Ҵ�. idx==book.length ���� �� ã�Ҵ�
					}
				}//for	
					if(idx==books.length) {
						System.out.println("���� �������� ���� �����Դϴ�.");
					}else {
						if(books[idx].isBookState()==Book.BOOK_STATE_BORROWED) {
							System.out.println("���� �������� �����Դϴ�.");
						}else {
							System.out.println("�����ڴ� ?");
							borrower=sc.next();
							System.out.println("������ ��¥�� �Է����ּ���.");
							checkOutDate=sc.next();
							books[idx].checkOut(borrower, checkOutDate);							
						}
						
					}//else					
				
				System.out.println(books[idx].getBookTitle());
				
					
				//����ó��
				break;
			case 2: System.out.println("å �ݳ� �ý����Դϴ�. �ݳ��Ͻ� å�� �̸��� �Է����ּ���.");
				//�ݳ� 1.å �̸� 2.å �˻� 3.�ݳ�ó�� 
				System.out.println("�ݳ��� å �̸��� �Է����ּ���.");
				bTitle=sc.next();
				for(idx=0;idx<books.length;idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {
						break; //ã��
					}
				}//for
					
				if(idx==books.length) {
					System.out.println(bTitle+"å�� ������ ����å�� �ƴմϴ�.");
				}else {
					books[idx].checkIn();
				}
					
				
				
				break;
			case 0 :
				break;
			default:
				System.out.println("��ȿ���� ���� ��ɹ�ȣ�Դϴ�. �ٽ� �Է����ּ���.");
				break;			
			}
					
		}while(fn!=0);
				
		for(Book book : books) {
			book.printState();
		}
		
		System.out.println("�ȳ���������.");
		sc.close();
		
		
		
		
	}//main
}
