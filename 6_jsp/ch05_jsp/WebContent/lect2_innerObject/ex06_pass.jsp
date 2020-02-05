<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%int age = Integer.parseInt(request.getParameter("age")); %>
	<h1><%=age %>살이시네요 성인인증 통과</h1>
	<button onclick="history.go(-1)">뒤로가기</button>
</body>
</html>