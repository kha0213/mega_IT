package com.tj.ex2selectWhere;

import java.sql.*;
import java.util.Scanner;

public class SelectWhereDeptno {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("����� ���ϴ� �μ���ȣ��?");
		int deptno;
		try {
				deptno = sc.nextInt();
		} catch (Exception e) {
			System.out.println("���ڸ� �Է��ϼ���.");
			return;
		}
		
		String query = "SELECT * FROM EMP WHERE DEPTNO="+deptno;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					int deptnum = rs.getInt("deptno");
					System.out.println(empno+"\t"+ename+"\t"+deptnum);
					
				}while(rs.next());
			}else {
				System.out.println("�ش� �μ���ȣ ����� �����ϴ�.");
			}
			
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
			}
		}
		
	}
}
