package com.tj.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Scanner sc = new Scanner(System.in);
		int deptno = 0;
		System.out.println("�Է��ϰ��� �ϴ� �μ���ȣ?");
		try {
			deptno = sc.nextInt();
		} catch (Exception e) {
			System.out.println("���ڸ� �Է���");
			return;
		}
		System.out.println("�Է��ϰ��� �ϴ� �μ���?");
		String dname = sc.next(); //space ���Ұ�
		System.out.println("�Է��ϰ��� �ϴ� �μ���ġ?");
		sc.nextLine();
		String loc = sc.next();  //space ���Ұ�
		String sql = String.format("INSERT INTO DEPT VALUES(%d,'%s','%s')",deptno,dname,loc);
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result>0?"�Է¼���":"�Է½���");
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"Ŭ��������");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"SQL����");
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		sc.close();
	}
}
