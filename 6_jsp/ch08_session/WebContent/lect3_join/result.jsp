<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
<%
	String msg = request.getParameter("msg");
	if(msg==null){
		response.sendRedirect("join.jsp");
	}else if(msg.equals("success")){%>
		<h1>가입이 완료되었습니다</h1>
		<hr>
		
	<%}else{%>
		<h1>가입되지 않았습니다.</h1>
		<a href="join.jsp">회원가입으로</a>
	<%}
%>
	<button onclick="location.href='../lect2_login/login.jsp'">로그인</button>
</body>
</html>