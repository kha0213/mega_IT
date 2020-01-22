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
		// �μ���ȣ�� �Է¹޾� �ִ� �μ���ȣ�� �����۾� ���� �μ���ȣ�� ���ٰ� ���
		// select(stmt) -> delete(pstmt��ü)

		Scanner sc = new Scanner(System.in);
		System.out.println("���� �� �μ���ȣ �Է���");
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
				System.out.println(deptno+"�� �μ� ��������Դϴ�.");
				System.out.println("���� �� �μ�����?");
				String dname = sc.next();
				System.out.println("���� �� �μ���ġ��?");
				String loc = sc.next();
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result>0? deptno+"�� �μ� �����Ϸ�":"�� ����?");
			}else {
				System.out.println("�ش� �μ���ȣ�� ����");
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
