<%@page import="java.sql.Statement"%>
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
</head>
<body>
	<%
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String job = request.getParameter("job");
		String sql = "SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB=?";

		
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, job);
			rs = pstmt.executeQuery();
			%>
			<table>
				<tr>
					<th>사번</th>
					<th>이름</th>
					<th>직업</th>
					<th>부서번호</th>
				</tr>		
			<%
			if(rs.next()){
				do{
					int empno = rs.getInt("EMPNO");
					String ename = rs.getString("ENAME");
					int deptno = rs.getInt("DEPTNO");
					
					
					out.println("<tr><td>"+empno+"</td>");
					out.println("<td>"+ename+"</td>");
					out.println("<td>"+job+"</td>");
					out.println("<td>"+deptno+"</td></tr>");
				}while(rs.next());
			}else{
				out.println("<tr><td colspan='4'>해당직업의 사원은 없습니다.</td></tr>");
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