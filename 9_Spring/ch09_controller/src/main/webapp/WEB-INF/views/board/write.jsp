<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"></script>
  <link rel="stylesheet" href="${conPath }/css/style.css">  
</head>
<body>
	<h1>write View입니다.</h1>
		<h1>멤버아디 ${member.id } 멤버pw ${member.pw }</h1>
	<hr>
	<h1><span onclick="history.back()">뒤로가기</span></h1>
</body>
</html>