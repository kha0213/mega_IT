package com.tj.ex7_homework;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainTest {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Writer writer = null;
		Reader reader = null;
		Date date = null;
		String answer = null, name, phoneNumber, birthday, address;
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");

		try {
			while (true) {
				System.out.println(
						"고객 등록 프로그램입니다. 안내에 따라 이름,전화번호, 생일, 주소를 입력하세요.\n계속하시려면 아무 키나 눌러주세요.(종료를 원하시면 n키를 눌러주세요.)");
				answer = keyboard.readLine();
				if (answer.equalsIgnoreCase("n")) {
					System.out.println("시스템을 종료합니다.");
					break;
				}
				System.out.println("고객 이름 입력해주세요.");
				name = keyboard.readLine();
				System.out.println("고객 전화번호 입력해주세요.(-으로 구분해주세요.)");
				phoneNumber = keyboard.readLine();
				System.out.println("고객 생일을 입력해주세요.(-으로 구분해주세요. ex. 12-03)");
				birthday = keyboard.readLine();
				date = new Date();
				if (sdf.format(date).equals(birthday)) {
					System.out.println("축하해요. 오늘 생일이시네요.");
				}
				System.out.println("고객 주소를 입력해주세요.");
				address = keyboard.readLine();
				customers.add(new Customer(name, phoneNumber, birthday, address));
				System.out.println("고객등록이 완료되었습니다.");

			} // while
			System.out.println("고객 총 정보입니다.");
			writer = new FileWriter("src/com/tj/ex7_homework/customer.txt");
			for (Customer c : customers) {
				System.out.println(c);
				writer.write(c.toString() + "\r\n");
			}
			System.out.println("이하 " + customers.size() + "명 가입");
			writer.write("이하 " + customers.size() + "명 가입\r\n");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (keyboard != null)	keyboard.close();
				if (reader != null)		reader.close();
				if (writer != null)		writer.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}
}
