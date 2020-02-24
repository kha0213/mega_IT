<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<c:set var="visitNum" value="${param.visitNum }"></c:set>
		<c:if test="${visitNum eq 0 }">
			<h2>첫 방문 감사합니다.</h2>
		</c:if>	
		<c:if test="${visitNum eq 1 }">
			<h2>두번째 방문 감사합니다.</h2>
		</c:if>	
		<c:if test="${visitNum<5 && visitNum>=0 }">
			<h2>몇 번 오셨군요. 감사합니다.</h2>
		</c:if>	
		<c:if test="${visitNum>=5 }">
			<h2>자주 오셔서 감사합니다.</h2>
		</c:if>	
		<c:if test="${visitNum<0 }">
			<h2>음수를 입력하다니 바보니?</h2>
		</c:if>	
		
	</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>