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
		System.out.println("확인하고 싶은 부서명 입력해");
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
				System.out.println("입력하신 부서 번호 : "+deptno);
				System.out.println("입력하신 부서 이름 : "+dname);
				System.out.println("입력하신 부서 위치 : "+loc);
			}else {
				System.out.println("유효하지 않는 부서이름입니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"드라이버 오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"SQL 오류");
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
