<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${conPath }/css/style.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
	<h1>board/view.jsp페이지입니다.</h1>
	<hr>
	<h2><span onclick="history.back()">메인페이지로 가기</span></h2>
</body>
</html>