<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");
String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<%=conPath%>/css/style.css' rel='stylesheet'>
</head>
<body>
	<% response.sendRedirect("board/list.jsp"); %>
</body>
</html>