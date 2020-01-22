package com.tj.ex5_library;

import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) throws Exception {
		String borrower;
		String bTitle;
		int fn;
		int bookIdx;
		Scanner sc = new Scanner(System.in);
		BookLib[] book = { new BookLib("192-35", "이것이자바다", "신용성"), new BookLib("190-24", "자바", "롱롱이"),
				new BookLib("152-39", "동그랑땡", "백주부"), new BookLib("100-00", "로또_그것이 알고싶다", "당첨기원"),
				new BookLib("890-01", "ssd", "남궁성"), new BookLib("890-02", "mit", "김진성"),
				new BookLib("890-03", "lalala", "베르나르베르베르"), new BookLib("890-04", "java", "신용성"),
				new BookLib("890-05", "html", "라라블라") };

		all: while (true) {
			System.out.println("-----------------------------------------------------");
			System.out.println("0:책 정보 조회     1:대출     2:반납\n종료를 원하시면 아무키나 눌러주세요.");
			System.out.println("-----------------------------------------------------");
			try {
				fn = sc.nextInt();
			} catch (Exception e) {
				System.out.println("시스템을 종료합니다. 안녕히계세요.");
				break;
			} // catch
			switch (fn) {
			case 0:
				System.out.println("책 정보 조회입니다.");
				for (BookLib b : book) {
					System.out.println(b);
				}
				break;

			case 1:
				System.out.println("책 대여 시스템입니다. 대출하실 책의 이름을 입력해주세요.");
				bTitle = sc.next();
				for (bookIdx = 0; bookIdx < book.length; bookIdx++) {
					if (book[bookIdx].getBookTitle().equals(bTitle)) {// 책 찾음
						break;
					}
				} // for
				if (bookIdx == book.length) {
					System.out.println("현재 보유하지 않은 도서입니다.");

				} else {
					System.out.println("책 대여 신청입니다. 빌리는 분의 성함을 입력하여 주십시오.");
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
				System.out.println("책 반납 시스템입니다. 반납하실 책의 이름을 입력해주세요.");
				bTitle = sc.next();
				for (bookIdx = 0; bookIdx < book.length; bookIdx++) {
					if (book[bookIdx].getBookTitle().equals(bTitle)) {
						break; // 찾음
					}
				}
				if (bookIdx == book.length) {// 못찾음
					System.out.println(bTitle + "책은 도서관 보유책이 아닙니다.");
				} else {
					try {
						book[bookIdx].checkIn();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break; // case 2

			default:
				System.out.println("시스템을 종료합니다. 안녕히계세요.");
				break all;
			}// switch
		} // while
	}// main
}
