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
						"�� ��� ���α׷��Դϴ�. �ȳ��� ���� �̸�,��ȭ��ȣ, ����, �ּҸ� �Է��ϼ���.\n����Ͻ÷��� �ƹ� Ű�� �����ּ���.(���Ḧ ���Ͻø� nŰ�� �����ּ���.)");
				answer = keyboard.readLine();
				if (answer.equalsIgnoreCase("n")) {
					System.out.println("�ý����� �����մϴ�.");
					break;
				}
				System.out.println("�� �̸� �Է����ּ���.");
				name = keyboard.readLine();
				System.out.println("�� ��ȭ��ȣ �Է����ּ���.(-���� �������ּ���.)");
				phoneNumber = keyboard.readLine();
				System.out.println("�� ������ �Է����ּ���.(-���� �������ּ���. ex. 12-03)");
				birthday = keyboard.readLine();
				date = new Date();
				if (sdf.format(date).equals(birthday)) {
					System.out.println("�����ؿ�. ���� �����̽ó׿�.");
				}
				System.out.println("�� �ּҸ� �Է����ּ���.");
				address = keyboard.readLine();
				customers.add(new Customer(name, phoneNumber, birthday, address));
				System.out.println("������� �Ϸ�Ǿ����ϴ�.");

			} // while
			System.out.println("�� �� �����Դϴ�.");
			writer = new FileWriter("src/com/tj/ex7_homework/customer.txt");
			for (Customer c : customers) {
				System.out.println(c);
				writer.write(c.toString() + "\r\n");
			}
			System.out.println("���� " + customers.size() + "�� ����");
			writer.write("���� " + customers.size() + "�� ����\r\n");
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
