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
<style type="text/css">
a {
	font-size: 2em;
	color: red;
}
</style>
</head>
<body>
	<h1>특정 쿠키삭제</h1>
	<%
		// 특정쿠키 (쿠키이름이 cookieName인 쿠키) 삭제 : 0초짜리 같은 이름의 쿠키를 만들어 덮어 씌운다.
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie c : cookies){
				String cName = c.getName();
				if(cName.equals("cookieName")){
					Cookie cookie = new Cookie("cookieName", "xx");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					out.print("<h3>쿠키삭제성공</h3>");
				}
				
			}
		}
	%>







	<hr>

	<a href="ex01_cookieConstruct.jsp">쿠키생성</a>
	<br>
	<a href="ex02_cookiesList.jsp">쿠키값들 리스트 확인</a>
	<br>
	<a href="ex03_thatCookie.jsp">특정 쿠키값(이름이 cookieName) 찾기</a>
	<br>
	<a href="ex04_cookieDel.jsp">쿠키 삭제</a>
	<br>
</body>
</html>