<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{
		text-align: center;
	}
</style>
</head>
<body>

	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String msg; 
		if (!id.equals("aaa") || !pw.equals("111")) {
			response.sendRedirect("loginFrm.jsp?msg=no"); 
		}
	%>
	<table>
		<caption>결과 화면</caption>
		<tr>
			<td colspan="2" rowspan="5">
				<p>아이디는 <%=id%>이고<br>
				비밀번호는 <%=pw%>입니다.</p>
				<p>반갑습니다.</p>
			</td>	
		</tr>
	</table>
</body>
</html>