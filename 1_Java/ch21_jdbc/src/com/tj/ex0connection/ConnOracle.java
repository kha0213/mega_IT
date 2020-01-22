package com.tj.ex0connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection conn = null;
		try {
			Class.forName(driver); //1.����̹� �ε��Ѵ�
			conn = DriverManager.getConnection(url, user, password); //2.�����ͺ��̽��� ����
			System.out.println("������ ���̽� ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"����̹� �� ã��");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"DB���� ����");
		} finally {
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage()+"�ݱ� ����");
			}
		}
	}
}
