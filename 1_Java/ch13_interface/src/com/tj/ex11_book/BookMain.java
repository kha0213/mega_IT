package com.tj.ex11_book;

import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		Book[] books = {new Book("890-01","ssd","남궁성"),
					new Book("890-02", "mit", "김진성"),
					new Book("890-03", "lalala", "베르나르베르베르"),
					new Book("890-04","java","신용성"),
					new Book("890-05","html","라라블라")};
		Scanner sc = new Scanner(System.in);
		String bTitle;
		String borrower;
		String checkOutDate;
		int idx; //대출이나 반납을 처리할 책의 index
		int fn;
		
		for(Book book : books) {
			book.printState();
		}
		do{
			System.out.println("1.책 대출  2.책 반납 0.종료");
			fn = sc.nextInt();
			switch (fn) {
			case 1: System.out.println("책 대출 시스템입니다. 대출하실 책의 이름을 입력해주세요.");
			//대출처리 1. 책이름 입력 2.책검색 3.책상태확인 4. 대출자입력 5.대출일입력 6.대출처리
				bTitle = sc.next(); //white-space앞까지의 스트링받음
				for(idx=0;idx<books.length;idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {//책 찾음
						break;
					//idx<book.length 경우는 찾았다. idx==book.length 경우는 못 찾았다
					}
				}//for	
					if(idx==books.length) {
						System.out.println("현재 보유하지 않은 도서입니다.");
					}else {
						if(books[idx].isBookState()==Book.BOOK_STATE_BORROWED) {
							System.out.println("현재 대출중인 도서입니다.");
						}else {
							System.out.println("대출자는 ?");
							borrower=sc.next();
							System.out.println("빌리는 날짜를 입력해주세요.");
							checkOutDate=sc.next();
							books[idx].checkOut(borrower, checkOutDate);							
						}
						
					}//else					
				
				System.out.println(books[idx].getBookTitle());
				
					
				//대출처리
				break;
			case 2: System.out.println("책 반납 시스템입니다. 반납하실 책의 이름을 입력해주세요.");
				//반납 1.책 이름 2.책 검색 3.반납처리 
				System.out.println("반납할 책 이름을 입력해주세요.");
				bTitle=sc.next();
				for(idx=0;idx<books.length;idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {
						break; //찾음
					}
				}//for
					
				if(idx==books.length) {
					System.out.println(bTitle+"책은 도서관 보유책이 아닙니다.");
				}else {
					books[idx].checkIn();
				}
					
				
				
				break;
			case 0 :
				break;
			default:
				System.out.println("유효하지 않은 기능번호입니다. 다시 입력해주세요.");
				break;			
			}
					
		}while(fn!=0);
				
		for(Book book : books) {
			book.printState();
		}
		
		System.out.println("안녕히가세요.");
		sc.close();
		
		
		
		
	}//main
}
