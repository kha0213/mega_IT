<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ch05_jsp/css/login.css">
<style type="text/css">
 p{
 	text-align: center;
 }
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");	
	String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(!id.equals("aaa") || !pw.equals("111")){
			String msg = "아이디/비밀번호를 잊으셨나요?";
			msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect("login.jsp?msg="+msg);
		}
	%>



	<div id="loginForm_wrap">
	<div id="login_title">
		로그인 결과
	</div>
		<p>로그인 성공</p>
	
	
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>