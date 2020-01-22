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
		//1.사용자로부터 부서이름받아
		//2-1 해당부서이름이 있을경우, 부서정보출력(deptno,loc), 해당부서 사원(사번,이름,부서위치)
		//2-2 해당부서이름이 없을경우 -없다고 출력
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("부서명 입력해주세요");
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
				System.out.println("그런부서 없는데!~~~ 부서명 잘못 입력했다.");
			}else {
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				System.out.println("--------------------------------------------------");
				System.out.printf("부서명 : %s\n부서번호 : %d\n부서위치 : %s\n",dname,deptno,loc);
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
