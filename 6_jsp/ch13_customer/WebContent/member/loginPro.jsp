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
		if(id!=null && id.equals("aaa") && "111".equals(pw)){
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			session.setAttribute("name", "영롱");
			response.sendRedirect("main.jsp");
		}else{
			String msg = "아이디와 패스워드를 입력해주세요";
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