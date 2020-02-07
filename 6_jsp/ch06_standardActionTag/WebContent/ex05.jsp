<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> <!-- ex04_param_forward.jsp?ex04=xxx -->
	<%String id = request.getParameter("id"); %>
	<%String pw = request.getParameter("pw"); %>
	<h1>ex05파일입니다.</h1>
	<h2>ex04것 : <%=request.getParameter("ex04") %></h2>
	<h2>id : <%=id %></h2>
	<h2>pw : <%=pw %></h2>
</body>
</html>