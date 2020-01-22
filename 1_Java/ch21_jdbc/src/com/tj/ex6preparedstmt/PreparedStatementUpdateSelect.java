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
		
		//�μ���ȣ�� �Է¹޾� �ִ� �μ���ȣ�̸� �����۾�(�μ��̸�,�μ���ġ�� �޾� ����)
		//�μ���ȣ�� ���� �μ���ȣ�̸� ���ٰ� ���
		String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=?";
		String updateSQL = "UPDATE DEPT SET DNAME=?,LOC=? WHERE DEPTNO=?";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �μ���ȣ�� �Է��ϼ���.");
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
				System.out.println(deptno+"�� �μ� �����Դϴ�. �μ��� �Է��ϼ���");
				String dname = sc.next().toUpperCase();
				System.out.println("�μ���ġ �Է��ϼ���");
				String loc = sc.next().toUpperCase();
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result>0?deptno+"�� �μ� \t�μ��� :"+dname+"\t�μ���ġ : "+loc+"�� �����Ϸ��Ͽ����ϴ�.":"������ �ֳ�");
				
			}else {
				System.out.println("���� �μ���ȣ�Դϴ�.");
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
