package com.tj.ex0connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver"; // 8.0
		//String driver = "com.mysql.jdbc.Driver"; //5.0
		String url = "jdbc:mysql://127.0.0.1:3306/kimdb?serverTimezone=UTC";
		String user = "root";
		String password = "mysql";
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("MySQL 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 못 찾음");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결 오류");
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println("닫기오류");
				e.printStackTrace();
			}
		}
		
		
	}
}
