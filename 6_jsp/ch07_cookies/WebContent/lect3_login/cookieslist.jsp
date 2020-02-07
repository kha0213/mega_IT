<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				out.print("<h2>쿠키이름 : [" + c.getName() + "] 쿠키값 : [" + c.getValue() + "]</h2>");
			}
	%>
	<%
		}else{
			out.print("<h2>존재하는 쿠키가 없습니다.</h2>");
		}
		
	%>
	<br>
	<button onclick="history.go(-1)">이전페이지</button>
	<button onclick="location.href='welcome.jsp'">welcome페이지</button>
	<button onclick="location.href='login.jsp'">login페이지</button>
	
</body>
</html>