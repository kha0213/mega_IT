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
	<h1><%=age %>살이네어린 놈아 NG야아아아아</h1>
	<button onclick="history.back()">뒤로가기</button>
</body>
</html>