package com.tj.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteOracle2 {
	public static void main(String[] args) {
		//1.삭제할 부서번호 입력받습니다.
		//2-1 존재하는 부서번호일 경우 : 진짜삭제할지 물어봄? (Y/N)
		//2-2 존재하지 않는 부서번호일 경우 : 존재하지 않는 부서번호입니다.
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";// 로칼 호스트로 해도 됨
		String user = "scott";
		String password = "tiger";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 부서번호 입력하세요.");
		int deptno = sc.nextInt();
		String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		
		String deleteSQL = "DELETE FROM DEPT WHERE DEPTNO="+deptno;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL);
			if(rs.next()) {
				System.out.println(deptno+"번 부서 진짜 삭제할꺼야? (Y/N)");
				String answer = sc.next();
				if(answer.equalsIgnoreCase("Y")) {
					int result = stmt.executeUpdate(deleteSQL);
					System.out.println(deptno+"번 부서 삭제완료");
				}else if(answer.equalsIgnoreCase("N")){
					System.out.println("삭제 안할께~ 프로그램종료");
				}else {
					System.out.println("Y나N을 입력해야지 바보야");
				}
			}else {
				System.out.println("그런 부서번호는 없어~");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
			sc.close();
		}
	}
}
