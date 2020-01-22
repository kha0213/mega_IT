package com.tj.ex0connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection conn = null;
		try {
			Class.forName(driver); //1.드라이버 로드한다
			conn = DriverManager.getConnection(url, user, password); //2.데이터베이스와 연결
			System.out.println("데이터 베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"드라이버 못 찾음");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"DB연결 오류");
		} finally {
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage()+"닫기 오류");
			}
		}
	}
}
