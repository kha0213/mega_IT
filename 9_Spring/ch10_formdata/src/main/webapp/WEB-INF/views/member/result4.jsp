<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
	<h1>result4 : 개인정보</h1>
	<h2>이름 : ${member.name }</h2>
	<h2>아디 : ${member.id }</h2>
	<h2>비번 : ${member.pw }</h2>
	<h2>나이 : ${member.age }</h2>
	<h2>메일 : ${member.email }</h2>
	<h2>주소 : ${member.address }</h2>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conPath}/'">처음부터 다시 시작</button>
</body>
</html>