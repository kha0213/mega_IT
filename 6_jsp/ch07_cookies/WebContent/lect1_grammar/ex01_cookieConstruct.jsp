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
<%
	Cookie cookie = new Cookie("cookieName","cookieValue"); //쿠키생성
	cookie.setMaxAge(60*60); //1시간 유효한 쿠키 -1이면 브라우저를 닫을 때 까지
	response.addCookie(cookie); //response에 탑재
	
%>
	<h2>지금 막 생성된 쿠키 이름 : <%=cookie.getName() %></h2>
	<h2>지금 막 생성된 쿠키 값 : <%=cookie.getValue() %></h2>
	<hr>
	<a href="ex02_cookiesList.jsp">쿠키값들 리스트 확인</a> <br>
	<a href="ex03_thatCookie.jsp">특정 쿠키값(이름이 cookieName) 찾기</a> <br>
	<a href="ex04_cookieDel.jsp">쿠키 삭제</a> <br>

</body>
</html>