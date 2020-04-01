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
</head>
<body>
	<form action="${conPath }/input.do" method="post">
		<p>이름 : <input type="text" name="name" value="${student.name }"></p>
		<p>ID :	<input type="number" name="id" placeholder="아이디는 자연수" value='
		<c:if test="${student.id!=0 }">${student.id }</c:if>'></p>
		<p><input type="submit" value="입력"></p>
	</form>
	<h4 style="color: red">${error_msg }</h4>
</body>
</html>