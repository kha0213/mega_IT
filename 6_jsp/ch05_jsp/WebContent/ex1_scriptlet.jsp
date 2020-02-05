<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int i=0;
	while(i<10){
		i++;
		out.print("<p>2 * "+i+"="+2*i+"</p>");
	}
%>
</body>
</html>