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
	<h1>특정 쿠키값(이름이 cookieName)찾기</h1>
	<%
		Cookie[] cookies = request.getCookies();
		boolean b = false;
		if(cookies!=null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("cookieName")){
					String value = cookie.getValue();
					out.print("<h2>찾고자 하는 쿠키 이름 : "+cookie.getName()+"/ 쿠키값 : "+value+"</h2>");
					b = true;
					break;
				}
				
			}
			if(!b){
				out.print("<h1>찾는 쿠키가 없어요</h1>");
			}
		}else{
			out.print("<h1>생성된 쿠키가 없어요</h1>");
			
		}
	%>

<hr>
	
	<a href="ex01_cookieConstruct.jsp">쿠키생성</a> <br>
	<a href="ex02_cookiesList.jsp">쿠키값들 리스트 확인</a> <br>
	<a href="ex03_thatCookie.jsp">특정 쿠키값(이름이 cookieName) 찾기</a> <br>
	<a href="ex04_cookieDel.jsp">쿠키 삭제</a> <br>
</body>
</html>