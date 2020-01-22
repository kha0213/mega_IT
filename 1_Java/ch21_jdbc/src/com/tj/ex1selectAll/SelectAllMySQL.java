package com.tj.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver"; // 8.0
		String url = "jdbc:mysql://127.0.0.1:3306/kimdb?serverTimezone=UTC";
		String user = "root";
		String password = "mysql";
		
		String quary = "SELECT * FROM PERSONAL";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement(); //SQL���۰�ü
			rs = stmt.executeQuery(quary); //4. SQL ����, SQL����ޱ�
			System.out.println("���\t�̸�\t��å\t\t�����\t�Ի���\t\t�޿�\t��\t�μ���ȣ");
			System.out.println("------------------------------------------------------");
			while(rs.next()) {
				int pno = rs.getInt("pno");
				String pname = rs.getString("pname");
				String job = rs.getString("job");
				job += job.length()<8 ? "\t" : "";
				
				int manager = rs.getInt("manager");
				Date startdate = rs.getDate("startdate");
				int pay = rs.getInt("pay");
				int bonus = rs.getInt("bonus");
				int dno = rs.getInt("dno");
				
				
				System.out.println(pno+"\t"+pname+"\t"+job+"\t"+manager+"\t"+startdate+"\t"+pay+"\t"+bonus+"\t"+dno);
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ���� ��ã��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB���� ����");
			e.printStackTrace();
		} finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
