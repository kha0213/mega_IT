package com.tj.ex1_string;

import java.util.Scanner;

public class Ex05_phonenumber {
	public static void main(String[] args) {
		String[] tels = { "010-9999-9999", "010-8888-8888", "010-7777-7777","02-325-6666" };
		Scanner sc = new Scanner(System.in);
		String searchTel;
		int idx;
		do {
			System.out.println("검색하고자 하는 회원의 전화번호 뒷자리는 ? / 그만두시려면 x를 눌러주세요.");
			searchTel = sc.next();
			if(searchTel.equalsIgnoreCase("x")) {
				break;
			}
			for (idx = 0; idx < tels.length; idx++) {
				String temp = tels[idx].substring(tels[idx].lastIndexOf('-') + 1);

				if (searchTel.equals(temp)) {
					System.out.println("해당 회원의 전화번호는 " + tels[idx] + "입니다.");
					break;
				}

			}
			if (idx == tels.length) {
				System.out.println("해당 회원의 정보를 찾을 수 없습니다.");
			}
		} while (true);
		System.out.println("이용해주셔서 감사합니다.");

		sc.close();
	}//main
}