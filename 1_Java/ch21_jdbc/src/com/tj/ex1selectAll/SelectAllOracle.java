package com.tj.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		String query= "SELECT * FROM EMP"; //������ Ȯ���ϰ� ����!!
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver); //1�ܰ� ����̺� �ε�
			conn = DriverManager.getConnection(url, user, password); //2�ܰ� DB����
			stmt = conn.createStatement(); //3�ܰ� SQL���� ������ ��ü ����
			rs = stmt.executeQuery(query); //4�ܰ� SQL�� ���� , 5�ܰ� SQL�� ��� �ޱ�(rs)
			//6�ܰ� ����� �޾� ���ϴ� ���� ����
			System.out.println("  ���\t  �̸�\t    ��å\t\t�����   \t�Ի���\t�޿�\t�󿩱�\t�μ���ȣ");
			System.out.println("----------------------------------------------");
			if(rs.next()) {//���� ����� ������ true���� 
				do {
					int empno = rs.getInt("EMPNO");
				  //int empno = rs.getInt(1); //1��° ��
					String ename = rs.getString("ENAME");
					String job = rs.getString("JOB");
					int mgr = rs.getInt("MGR");
					Date hiredate = rs.getDate("HIREDATE");
					int sal = rs.getInt("SAL");
					int comm = rs.getInt("COMM");
					int deptno = rs.getInt("DEPTNO");
					if(job!=null && job.length()<7) {
						job+="\t";
					}
					System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\n",
									   empno,ename,job,mgr,hiredate,sal,comm,deptno);
					
				}while(rs.next());
			}else {
				System.out.println("������ �����Ͱ� �����ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ���� ã������");
		} catch (SQLException e) {
			System.out.println("sql �������");
			e.printStackTrace();
		} finally {
			try { //7. ��������
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
