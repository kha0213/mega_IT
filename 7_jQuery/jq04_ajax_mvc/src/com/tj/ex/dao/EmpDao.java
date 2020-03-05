package com.tj.ex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.ex.dto.Emp;

public class EmpDao {
	private static EmpDao instance = new EmpDao();

	private EmpDao() {

	}

	public static EmpDao getInstance() {
		return instance;
	}

	private Connection getConnection() throws SQLException {

		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	
	public ArrayList<Emp> getEmpList(String ename,String job){
		ArrayList<Emp> emps = new ArrayList<Emp>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT *FROM EMP WHERE ENAME LIKE '%'||?||'%' AND JOB LIKE '%'||?||'%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			pstmt.setString(2, job);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int empno = rs.getInt("empno");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				emps.add(new Emp(empno, rs.getString("ename"), rs.getString("job"), mgr, hiredate, sal, comm, deptno));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn !=null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return emps;
	}
	public ArrayList<Emp> getEmpList(Emp emp){
		String ename = emp.getEname();
		String job = emp.getJob();
		return getEmpList(ename, job);
	}
}
