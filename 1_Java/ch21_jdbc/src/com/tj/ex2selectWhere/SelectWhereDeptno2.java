package com.tj.ex2selectWhere;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDeptno2 {
	// 1.사용자에세 부서번호 물어보고 
	// 2-1 해당부서번호가 있으면 해당부서이름,해당부서위치 출력 후 해당부서 사원을 출력 
	// 2-2 없으면 부서번호가 올바르지 않다고하라
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";

		Scanner sc = new Scanner(System.in);
		System.out.println("출력을 원하는 부서번호는?");
		int deptno;
		try {
			deptno = sc.nextInt();
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요.");
			return;
		}

		String query1 = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		String query2 = "SELECT * FROM EMP WHERE DEPTNO=" + deptno;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query1);
			if (rs.next()) {
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno+"번 부서 이름은 "+dname+"이고 근무지역은 "+loc+"입니다.");
				System.out.println("-----------------------------------------");
				System.out.println("근무하는 직원 명단");
				System.out.println("-----------------------------------------");
				
				rs.close();
				rs = stmt.executeQuery(query2);
				if (rs.next()) {
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						Date hiredate = rs.getDate("hiredate");
						System.out.println(empno+"\t"+ename+"\t"+hiredate);

					} while (rs.next());
				} else {
					System.out.println(deptno+"번 부서번호 사원은 아무도 없습니다.");
				}
			} else {
				System.out.println("그런 부서번호는 없어 임마");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}

	}
}
