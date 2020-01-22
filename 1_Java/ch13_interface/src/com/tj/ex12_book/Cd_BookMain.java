package com.tj.ex12_book;

import java.util.Scanner;

public class Cd_BookMain {
	public static void main(String[] args) {
		BookLib[] books = { new BookLib("890-01", "ssd", "남궁성"), new BookLib("890-02", "mit", "김진성"),
				new BookLib("890-03", "lalala", "베르나르베르베르"), new BookLib("890-04", "java", "신용성"),
				new BookLib("890-05", "html", "라라블라") };
		CDLib[] cds = {new CDLib("cd01", "java"), new CDLib("cd02", "라그나로크"), new CDLib("cd03","백종원요리")};
		Scanner sc = new Scanner(System.in);
		String bTitle;
		String cdTitle;
		String borrower;
		String checkOutDate;
		int bookIdx; // 대출이나 반납을 처리할 책의 index
		int cdIdx;
		int fn;

		System.out.println("책 정보입니다.");
		for (BookLib book : books) {
			book.printState();
		}
		System.out.println("CD정보입니다.");
		for(CDLib cd : cds) {
			cd.printState();
		}
		do {
			System.out.println("1.책 대여 | 2.책 반납 | 3.책 정보 | 4.CD대여 | 5.CD반납 | 0.종료");
			fn = sc.nextInt();
			switch (fn) {
			case 1:
				System.out.println("책 대여 시스템입니다. 대출하실 책의 이름을 입력해주세요.");
				// 대출처리 1. 책이름 입력 2.책검색 3.책상태확인 4. 대출자입력 5.대출일입력 6.대출처리
				bTitle = sc.next(); // white-space앞까지의 스트링받음
				for (bookIdx = 0; bookIdx < books.length; bookIdx++) {
					if (books[bookIdx].getBookTitle().equals(bTitle)) {// 책 찾음
						break;
						// idx<book.length 경우는 찾았다. idx==book.length 경우는 못 찾았다
					}
				} // for
				if (bookIdx == books.length) {
					System.out.println("현재 보유하지 않은 도서입니다.");

				} else {
					if (books[bookIdx].isBookState() == BookLib.STATE_BORROWED) {
						System.out.println("현재 대출중인 도서입니다.");
					} else {
						System.out.println("책 빌리는 분의 성함을 입력하여 주십시오.");
						borrower = sc.next();
						System.out.println("빌리는 날짜를 입력해주세요.");
						checkOutDate = sc.next();
						System.out.println(borrower + "님이 " + books[bookIdx].getBookTitle() + " 책 대여 승인되었습니다.");
						books[bookIdx].checkOut(borrower, checkOutDate);
					}
				} // else

				// 대출처리
				break;
			case 2:
				System.out.println("책 반납 시스템입니다. 반납하실 책의 이름을 입력해주세요.");
				// 반납 1.책 이름 2.책 검색 3.반납처리
				bTitle = sc.next();
				for (bookIdx = 0; bookIdx < books.length; bookIdx++) {
					if (books[bookIdx].getBookTitle().equals(bTitle)) {
						break; // 찾음
					}
				} // for

				if (bookIdx == books.length) {//못찾음
					System.out.println(bTitle + "책은 도서관 보유책이 아닙니다.");
				} else {
					
					books[bookIdx].checkIn();
				}
				break;
			case 3:
				System.out.println("책 조회 시스템입니다. 조회하실 책의 이름을 입력해주세요.");
				bTitle = sc.next();
				for (bookIdx = 0; bookIdx < books.length; bookIdx++) {
					if (books[bookIdx].getBookTitle().equals(bTitle)) {
						break; // 찾음
					}
				} // for
				if (bookIdx == books.length) {
					System.out.println(bTitle + "책은 도서관 보유책이 아닙니다.");
				} else {
					books[bookIdx].printState();
				}
				break;
			case 4:
				System.out.println("CD대여 시스템입니다. 대여하실 CD의 이름을 입력해주세요.");
				cdTitle = sc.next();
				for(cdIdx=0;cdIdx<cds.length;cdIdx++) {
					if(cds[cdIdx].getCdTitle().equals(cdTitle)) {
						break;
					}
				}//for
				if(cdIdx==cds.length) {
					System.out.println(cdTitle+"CD는 도서관이 보유하고 있지 않습니다.");
				}else {
					if(cds[cdIdx].isState()==CDLib.STATE_NOMAL) {
						System.out.println("CD빌리시는 분의 성함을 입력하여 주십시오.");
						borrower = sc.next();
						System.out.println("빌리는 날짜를 입력해주세요.");
						checkOutDate = sc.next();
	//					System.out.println(borrower+"님 "+cds[cdIdx].getCdTitle()+" CD 대여 승인 되었습니다. 대여 기간은 2주입니다. 반납기한을 꼭 지켜주세요.");
						cds[cdIdx].checkOut(borrower, checkOutDate);
					}//if
					else {
						System.out.println("CD가 대출중입니다.");
					}
				}//else
				break;
				
			case 5:
				System.out.println("CD 반납 시스템입니다. 반납하실 CD의 이름을 입력해주세요.");
				cdTitle = sc.next();
				for (cdIdx = 0; cdIdx < cds.length; cdIdx++) {
					if (cds[cdIdx].getCdTitle().equals(cdTitle)) {
						break; // 찾음
					}
				} // for

				if (cdIdx == cds.length) {
					System.out.println(cdTitle + "CD는 이미 도서관에 있습니다.");
				} else {
					System.out.println(cdTitle + "CD 반납 처리되었습니다.");
					cds[cdIdx].checkIn();
				}
				
				
			case 0:
				break;
			default:
				System.out.println("유효하지 않은 기능번호입니다. 다시 입력해주세요.");
				break;
			}

		} while (fn != 0);

		for (BookLib book : books) {
			book.printState();
		}
		for(CDLib cd : cds) {
			cd.printState();
		}

		System.out.println("안녕히가세요.");
		sc.close();

	}// main
}
