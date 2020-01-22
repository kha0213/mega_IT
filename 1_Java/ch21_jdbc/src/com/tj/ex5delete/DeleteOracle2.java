package com.tj.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteOracle2 {
	public static void main(String[] args) {
		//1.������ �μ���ȣ �Է¹޽��ϴ�.
		//2-1 �����ϴ� �μ���ȣ�� ��� : ��¥�������� ���? (Y/N)
		//2-2 �������� �ʴ� �μ���ȣ�� ��� : �������� �ʴ� �μ���ȣ�Դϴ�.
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";// ��Į ȣ��Ʈ�� �ص� ��
		String user = "scott";
		String password = "tiger";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �μ���ȣ �Է��ϼ���.");
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
				System.out.println(deptno+"�� �μ� ��¥ �����Ҳ���? (Y/N)");
				String answer = sc.next();
				if(answer.equalsIgnoreCase("Y")) {
					int result = stmt.executeUpdate(deleteSQL);
					System.out.println(deptno+"�� �μ� �����Ϸ�");
				}else if(answer.equalsIgnoreCase("N")){
					System.out.println("���� ���Ҳ�~ ���α׷�����");
				}else {
					System.out.println("Y��N�� �Է��ؾ��� �ٺ���");
				}
			}else {
				System.out.println("�׷� �μ���ȣ�� ����~");
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
