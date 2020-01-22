package com.tj.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertOracle2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";// ��Į ȣ��Ʈ�� �ص� ��
		//String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�Է��ϰ��� �ϴ� �μ���ȣ��?");
		int deptno = sc.nextInt();
		String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL);
			if(!rs.next()) { //�ߺ��� �μ���ȣ�� �ƴϸ� �߰��۾�(�μ��̸�,��ġ insert)
				System.out.println("�Է��ϰ��� �ϴ� �μ�����?");
				String dname = sc.next();
				System.out.println("�Է��ϰ��� �ϴ� �μ���ġ��");
				String loc = sc.next();
				String insertSQL = String.format("INSERT INTO DEPT VALUES (%d,'%s','%s')",deptno,dname,loc);
				int result=stmt.executeUpdate(insertSQL);
				System.out.println(result>0 ? "�μ��Է¼���" : "�μ��Է½���");
			}else {
				System.out.println("�ߺ��� �μ���ȣ�� �����մϴ�. �ٸ� �μ���ȣ �Է��ϼ���");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"Ŭ��������");
		} catch (SQLException e) {
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
