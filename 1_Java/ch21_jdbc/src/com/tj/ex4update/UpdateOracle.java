package com.tj.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";// 로칼 호스트로 해도 됨
		String user = "scott";
		String password = "tiger";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수정할 부서번호는?");
		int deptno = sc.nextInt();
		String selectSQL = "SELECT COUNT(*) count FROM DEPT WHERE DEPTNO="+deptno;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL);
			rs.next();
			int cnt = rs.getInt("count");
			if(cnt==1) {
				System.out.println("수정할 부서명은?");
				String dname = sc.next();
				System.out.println("수정할 부서위치는?");
				String loc = sc.next();
				String updateSQL = String.format("UPDATE DEPT SET DNAME='%s',LOC='%s' WHERE DEPTNO=%d",dname,loc,deptno);
				int result = stmt.executeUpdate(updateSQL);
				System.out.println(result>0 ? deptno+"번 부서번호 수정완료" : "수정실패");
			}else {
				System.out.println("그런부서 없음");
			}
			
		} catch (Exception e) {
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
