<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<%
	String driver="oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "scott";
	String password = "tiger";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql="SELECT * FROM EMP";
	try{
	Class.forName(driver);
	conn = DriverManager.getConnection(url, user, password);
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	out.print("<table>");
	out.println("<tr><th>사번</th><th>이름</th><th>입사일</th><th>부서번호</th></tr>");
	if(rs.next()){
		do{
			int empno = rs.getInt("EMPNO");
			String ename = rs.getString("ENAME");
			Timestamp hiredate = rs.getTimestamp("HIREDATE");
			Date hireD = rs.getDate("HIREDATE");
			int deptno = rs.getInt("DEPTNO");
			out.println("<tr><td>"+empno+"</td><td>"+ename+"</td><td>"+hireD+"</td><td>"+deptno+"</td></tr>");
		}while(rs.next());
	}else{
		out.print("<tr><td colsapn='4'>사원이 없습니다.</td></tr>");
	}
	
	out.print("</table>");
	
	}catch(Exception e){
		
	}finally{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
	
	
	%>
</body>
</html>