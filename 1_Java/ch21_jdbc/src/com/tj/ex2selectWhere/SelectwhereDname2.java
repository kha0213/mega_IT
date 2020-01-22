package com.tj.ex2selectWhere;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectwhereDname2 {
	public static void main(String[] args) {
		//1.����ڷκ��� �μ��̸��޾�
		//2-1 �ش�μ��̸��� �������, �μ��������(deptno,loc), �ش�μ� ���(���,�̸�,�μ���ġ)
		//2-2 �ش�μ��̸��� ������� -���ٰ� ���
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�μ��� �Է����ּ���");
		String dname = sc.nextLine();
		dname=dname.toUpperCase();
		String sql = String.format("SELECT * FROM DEPT WHERE DNAME='%s'",dname);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(!rs.next()) {
				System.out.println("�׷��μ� ���µ�!~~~ �μ��� �߸� �Է��ߴ�.");
			}else {
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				System.out.println("--------------------------------------------------");
				System.out.printf("�μ��� : %s\n�μ���ȣ : %d\n�μ���ġ : %s\n",dname,deptno,loc);
				System.out.println("--------------------------------------------------");
				rs.close();
				sql = String.format("SELECT ENAME,HIREDATE,LOC FROM EMP E,DEPT D WHERE D.DEPTNO=E.DEPTNO AND D.DEPTNO=%d",deptno);				
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String ename = rs.getString("ename");
					Date hiredate = rs.getDate("hiredate");
					System.out.printf("%s\t%TF\t%s\n",ename,hiredate,loc);
				}
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
			} catch (SQLException e) {}
		} sc.close();
	}
}
