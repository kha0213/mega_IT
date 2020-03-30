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
	<h1>id : ${id }</h1>
	<h1>pw : ${pw }</h1>
</body>
</html>