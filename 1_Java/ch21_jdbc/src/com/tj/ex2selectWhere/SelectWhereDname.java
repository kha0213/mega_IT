package com.tj.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Scanner sc = new Scanner(System.in);
		System.out.println("Ȯ���ϰ� ���� �μ��� �Է���");
		String dname = sc.nextLine();
		dname=dname.toUpperCase();
		
		String sql = "SELECT * FROM DEPT WHERE DNAME='"+dname+"'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				System.out.println("�Է��Ͻ� �μ� ��ȣ : "+deptno);
				System.out.println("�Է��Ͻ� �μ� �̸� : "+dname);
				System.out.println("�Է��Ͻ� �μ� ��ġ : "+loc);
			}else {
				System.out.println("��ȿ���� �ʴ� �μ��̸��Դϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"����̹� ����");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"SQL ����");
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
