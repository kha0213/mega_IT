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
	<h1>ModelAttribute를 통해 cnt,list</h1>
	<h2>cnt: ${cnt }</h2>
	<h2>list: ${list }</h2>
	<h1>result4 : 개인정보</h1>
	<h2>이름 : ${member_dto.name }</h2>
	<h2>아디 : ${member_dto.id }</h2>
	<h2>비번 : ${member_dto.pw }</h2>
	<h2>나이 : ${member_dto.age }</h2>
	<h2>메일 : ${member_dto.email }</h2>
	<h2>주소 : ${member_dto.address }</h2>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conPath}/'">처음부터 다시 시작</button>
</body>
</html>