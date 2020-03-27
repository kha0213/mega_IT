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
</head>
<body>
	<h2>main폴더의 main.jsp입니다</h2>
	<h2><span onclick="history.back()">뒤로가기</span></h2>
	<img src="${conPath }/img/gogo.jfif" alt="이미지">
</body>
</html>