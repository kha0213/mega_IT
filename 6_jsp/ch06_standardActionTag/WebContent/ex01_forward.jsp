<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ex01_forward.jsp파일입니다.</h1>
	
	<%-- <%response.sendRedirect("ex02_forward.jsp"); %> --%>
	
	<jsp:forward page="ex02_forward.jsp"></jsp:forward>
	<!-- 열자마자 닫으면 />로 합칠수도 있음  얜 URL이 안바뀐다아아아아아-->
	
</body>
</html>