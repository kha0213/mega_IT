<%@page import="java.sql.Date"%>
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
<link rel="stylesheet" href="../css/style.css">
<style>
	h2{
		text-align: center;
		color:blue;
	}
	p{
	text-align: center;
	}
</style>
</head>
<body>
	<form action="">
		
			
			<h2>
				부서번호
				<input type="text" name="deptno">
				
				<input type="submit" value="검색">
			</h2>
			<p>(그냥 검색하시면 전체가 검색됩니다.)</p>
			<br>
	
	</form>
	<%
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMP WHERE DEPTNO LIKE '%'||?";
	%>
	<%
		String deptno="";
		if(request.getParameter("deptno")!=null){
			deptno = request.getParameter("deptno");
		}
	%>
	<%
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, deptno);
		rs = pstmt.executeQuery();
		
		%>
		<table>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>직책</th>
				<th>상사사번</th>
				<th>입사일</th>
				<th>급여</th>
				<th>상여</th>
				<th>부서번호</th>
			</tr>		
		<%
		if(rs.next()){
			do{
				int empno = rs.getInt("EMPNO");
				String ename = rs.getString("ENAME");
				String job = rs.getString("JOB");
				int mgr = rs.getInt("MGR");
				Date hiredate = rs.getDate("HIREDATE");
				int sal = rs.getInt("SAL");
				int comm = rs.getInt("COMM");
				deptno = rs.getString("DEPTNO");
				out.println("<tr><td>"+empno+"</td>");
				out.println("<td>"+ename+"</td>");
				out.println("<td>"+job+"</td>");
				out.println("<td>"+mgr+"</td>");
				out.println("<td>"+hiredate+"</td>");
				out.println("<td>"+sal+"</td>");
				out.println("<td>"+comm+"</td>");
				out.println("<td>"+deptno+"</td></tr>");
			}while(rs.next());
		}else{
			out.print("<tr><td colspan='8'>해당 부서번호("+deptno+")의 사원은 없습니다.</td></tr>");
		}
		%>
		</table>
		<%
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
	%>
</body>
</html>