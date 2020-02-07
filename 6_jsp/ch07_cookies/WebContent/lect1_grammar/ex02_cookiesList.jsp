<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a{
		font-size: 2em;
		color: red;
	}

</style>
</head>
<body>
	<h1>쿠키들 리스트</h1>
	<%
		Cookie[] cookies = request.getCookies();
		for(int idx=0;idx<cookies.length;idx++){
			String name = cookies[idx].getName();
			String value = cookies[idx].getValue();
			out.print("<h2>"+idx+"번째 쿠키이름 : "+name+" 쿠키값 : "+value+"</h2><br>");
		}
	
	%>
	<hr>
	
	<a href="ex01_cookieConstruct.jsp">쿠키생성</a> <br>
	<a href="ex02_cookiesList.jsp">쿠키값들 리스트 확인</a> <br>
	<a href="ex03_thatCookie.jsp">특정 쿠키값(이름이 cookieName) 찾기</a> <br>
	<a href="ex04_cookieDel.jsp">쿠키 삭제</a> <br>
</body>
</html>