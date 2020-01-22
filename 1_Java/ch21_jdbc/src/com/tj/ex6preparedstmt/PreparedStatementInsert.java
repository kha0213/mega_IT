package com.tj.ex6preparedstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementInsert {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";// ��Į ȣ��Ʈ�� �ص� ��
		String user = "scott";
		String password = "tiger";
		
		String sql="INSERT INTO DEPT VALUES (?,?,?)"; //''�� ���� ?�� �Ѵ�.
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("�Է��� �μ���ȣ");
		int deptno = sc.nextInt();
		System.out.println("�Է��� �μ��̸�");
		String dname = sc.next();
		System.out.println("�μ���ġ��?");
		String loc = sc.next();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql); //SQL������ ��ü ����
			pstmt.setInt(1, deptno); //SQL�� ù��° ? ä���
			pstmt.setString(2, dname); //SQL�� �ι�° ? ä���
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();
			System.out.println(result>0?"����":"����");
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
