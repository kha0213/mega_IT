package com.tj.ex6preparedstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementDelete {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		// 부서번호를 입력받아 있는 부서번호면 수정작업 없는 부서번호면 없다고 출력
		// select(stmt) -> delete(pstmt객체)

		Scanner sc = new Scanner(System.in);
		System.out.println("수정 할 부서번호 입력해");
		int deptno = sc.nextInt();
		String seleteSQL ="SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		String updateSQL ="UPDATE DEPT SET DNAME=?,LOC=? WHERE DEPTNO=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(seleteSQL);
			if(rs.next()) {
				System.out.println(deptno+"번 부서 수정모드입니다.");
				System.out.println("수정 할 부서명은?");
				String dname = sc.next();
				System.out.println("수정 할 부서위치는?");
				String loc = sc.next();
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result>0? deptno+"번 부서 수정완료":"엥 에러?");
			}else {
				System.out.println("해당 부서번호가 없음");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
