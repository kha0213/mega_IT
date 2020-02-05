<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>요청주소 : <%=request.getRemoteAddr() %> ♥</h2>
	<h2>context path : <%=request.getContextPath() %> ♥</h2>
	<h2>요청방식 : <%=request.getMethod() %></h2>
	<h2>세션 : <%=request.getSession() %> - 로그인처리 ♥</h2>
	<h2>해당 프로토콜 : <%=request.getProtocol() %></h2>
	<h2>요청 URL : <%=request.getRequestURL()%></h2>
	<h2>요청 URI : <%=request.getRequestURI()%> ♥</h2>
	<h2>서버이름 : <%=request.getServerName()%></h2>
	<h2>서버포트 : <%=request.getServerPort()%></h2>
</body>
</html>