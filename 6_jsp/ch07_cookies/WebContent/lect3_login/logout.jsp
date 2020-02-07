<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	

<%
	Cookie[] cs = request.getCookies();
	if(cs!=null){

		for(Cookie c : cs){
			if(c.getName().equals("id")){
				c.setMaxAge(0);
				response.addCookie(c);
			}else if(c.getName().equals("name")){
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
	}
	response.sendRedirect("welcome.jsp");
%>

	<p>
		<button onclick="location.href='login.jsp'">로그인</button>
		<button onclick="location.href='cookieslist.jsp'">쿠키확인</button>
	
	</p>

</body>
</html>