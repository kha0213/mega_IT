<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<% String conPath = request.getContextPath(); %>
<link rel="stylesheet" href="<%=conPath %>/css/ex3.css">
</head>
<body> <!-- ch05_jsp (context root) /ch05_jsp (context path)     거의같다. / 차이-->
	<h2>context path : <%=conPath %></h2>
	<hr>
	<a href="../index.jsp">INDEX.JSP</a>
	<hr>
	<a href="<%=conPath %>/index.jsp">INDEX.JSP</a>
	<hr>
	<button onclick="location.href='<%=conPath %>/Ex3'">Ex3 servlet</button>
</body>
</html>