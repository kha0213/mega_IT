package com.tj.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Scanner sc = new Scanner(System.in);
		int deptno = 0;
		System.out.println("입력하고자 하는 부서번호?");
		try {
			deptno = sc.nextInt();
		} catch (Exception e) {
			System.out.println("숫자만 입력해");
			return;
		}
		System.out.println("입력하고자 하는 부서명?");
		String dname = sc.next(); //space 사용불가
		System.out.println("입력하고자 하는 부서위치?");
		sc.nextLine();
		String loc = sc.next();  //space 사용불가
		String sql = String.format("INSERT INTO DEPT VALUES(%d,'%s','%s')",deptno,dname,loc);
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result>0?"입력성공":"입력실패");
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"클래스오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"SQL오류");
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		sc.close();
	}
}
