<%@page import="com.sun.javafx.binding.StringFormatter"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
<%!
	String driver="oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String driverMysql = "com.mtsql.jdbc.Driver";
	String urlMysql = "jdbc:mysql://127.0.0.1:3306/kimdb";
	String user = "scott";
	String password = "tiger";
	String userMysql = "root";
	String passwordMysql = "mysql";
	Connection conn;
	Statement stmt;
	ResultSet rs;
%>
<%
	String sql = "SELECT * FROM EMP";
	

	//1단계 : 드라이버 로드
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			int empno = rs.getInt("EMPNO");
			String ename = rs.getString("ENAME");
			String job = rs.getString("JOB");
			int mgr = rs.getInt("MGR");
			Date hiredate = rs.getDate("HIREDATE");
			Timestamp hireTime = rs.getTimestamp("HIREDATE");
			int sal = rs.getInt("SAL");
			int comm = rs.getInt("COMM");
			int deptno = rs.getInt("DEPTNO");
			out.println("<h5>"+empno+"(사번)\t"+ename+"(이름)\t"+job+"(직책)\t"+
					mgr+"(상사사번)\t"+hiredate+"(입사일)\t" +sal+"(급여)\t"+
					comm+"(상여)\t"+deptno+"(부서번호)</h5>"
);
		}
		
	}catch(Exception e){
		System.out.println("에러메세지 : "+e.getMessage());
		
	}finally{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
	}
	
	
	
	
	
	
	
%>
</body>
</html>