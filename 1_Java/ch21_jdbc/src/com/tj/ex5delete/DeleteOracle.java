package com.tj.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";// 로칼 호스트로 해도 됨
		String user = "scott";
		String password = "tiger";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("지울 부서번호 입력하세요.");
		int deptno = sc.nextInt();
		String deleteSQL = "DELETE FROM DEPT WHERE DEPTNO="+deptno;
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(deleteSQL);
			System.out.println(result>0?deptno+"번 부서 삭제완료":"삭제할 부서 없음");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
			sc.close();
		}
	}
}
