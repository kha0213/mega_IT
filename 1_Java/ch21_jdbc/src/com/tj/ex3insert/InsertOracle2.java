package com.tj.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertOracle2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";// 로칼 호스트로 해도 됨
		//String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("입력하고자 하는 부서번호는?");
		int deptno = sc.nextInt();
		String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL);
			if(!rs.next()) { //중복된 부서번호가 아니면 추가작업(부서이름,위치 insert)
				System.out.println("입력하고자 하는 부서명은?");
				String dname = sc.next();
				System.out.println("입력하고자 하는 부서위치는");
				String loc = sc.next();
				String insertSQL = String.format("INSERT INTO DEPT VALUES (%d,'%s','%s')",deptno,dname,loc);
				int result=stmt.executeUpdate(insertSQL);
				System.out.println(result>0 ? "부서입력성공" : "부서입력실패");
			}else {
				System.out.println("중복된 부서번호가 존재합니다. 다른 부서번호 입력하세요");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"클래스오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
				sc.close();
			} catch (SQLException e) {}
		}
		
		
	}
}
