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
		
		String query= "SELECT * FROM EMP"; //무조건 확인하고 넣자!!
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver); //1단계 드라이브 로드
			conn = DriverManager.getConnection(url, user, password); //2단계 DB연결
			stmt = conn.createStatement(); //3단계 SQL문을 전송할 객체 생성
			rs = stmt.executeQuery(query); //4단계 SQL을 전송 , 5단계 SQL문 결과 받기(rs)
			//6단계 결과를 받아 원하는 로직 수행
			System.out.println("  사번\t  이름\t    직책\t\t상사사번   \t입사일\t급여\t상여금\t부서번호");
			System.out.println("----------------------------------------------");
			if(rs.next()) {//나올 결과가 있으면 true리턴 
				do {
					int empno = rs.getInt("EMPNO");
				  //int empno = rs.getInt(1); //1번째 열
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
				System.out.println("전송할 데이터가 없습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 찾지못함");
		} catch (SQLException e) {
			System.out.println("sql 연결오류");
			e.printStackTrace();
		} finally {
			try { //7. 연결해제
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
