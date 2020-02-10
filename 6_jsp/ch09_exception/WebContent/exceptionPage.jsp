<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	console.log('예외메세지 : '+'<%=exception.getMessage()%>');
	console.log('예외타입 : '+'<%=exception.getClass().getName()%>');
</script>
</head>
<body>
	<h1>여기는 Error페이지입니다. 사칙연산출력해야지 0을 넣으면 안됨 </h1>
	<%
		System.out.println("예외메세지 : "+exception.getMessage());
		System.out.println("예외타입 : "+exception.getClass().getName());
	%>
</body>
</html>