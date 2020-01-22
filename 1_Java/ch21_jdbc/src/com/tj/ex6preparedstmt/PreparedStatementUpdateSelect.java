package com.tj.ex6preparedstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementUpdateSelect {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		//부서번호를 입력받아 있는 부서번호이면 수정작업(부서이름,부서위치를 받아 수정)
		//부서번호가 없는 부서번호이면 없다고 출력
		String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=?";
		String updateSQL = "UPDATE DEPT SET DNAME=?,LOC=? WHERE DEPTNO=?";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 부서번호를 입력하세요.");
		int deptno = sc.nextInt();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt("CNT");
			if(cnt==1) {
				System.out.println(deptno+"번 부서 수정입니다. 부서명 입력하세요");
				String dname = sc.next().toUpperCase();
				System.out.println("부서위치 입력하세요");
				String loc = sc.next().toUpperCase();
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result>0?deptno+"번 부서 \t부서명 :"+dname+"\t부서위치 : "+loc+"로 수정완료하였습니다.":"오류가 있네");
				
			}else {
				System.out.println("없는 부서번호입니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				sc.close();
			} catch (SQLException e) {}
		}
		
		
		
		
	}
}
