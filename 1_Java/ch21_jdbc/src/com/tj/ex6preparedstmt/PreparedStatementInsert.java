package com.tj.ex6preparedstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementInsert {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";// 로칼 호스트로 해도 됨
		String user = "scott";
		String password = "tiger";
		
		String sql="INSERT INTO DEPT VALUES (?,?,?)"; //''도 없이 ?로 한다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("입력할 부서번호");
		int deptno = sc.nextInt();
		System.out.println("입력할 부서이름");
		String dname = sc.next();
		System.out.println("부서위치는?");
		String loc = sc.next();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql); //SQL전송할 객체 생성
			pstmt.setInt(1, deptno); //SQL에 첫번째 ? 채우기
			pstmt.setString(2, dname); //SQL에 두번째 ? 채우기
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();
			System.out.println(result>0?"성공":"실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		} sc.close();
	}
}
