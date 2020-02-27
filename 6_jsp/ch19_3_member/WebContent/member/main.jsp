<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<c:if test="${not empty errorMsg }">
		<script>
			alert('${errorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty modifyResult }">
		<script>
			alert('${modifyResult}');
		</script>
	</c:if>
	
	<div class="container p-5">
	<c:if test="${empty member }"> <!-- 로그인 전 -->
		<h2 class="text-center">로그인 상태가 아닙니다.</h2>
		<hr>
		<div class="text-center col">
		<button onclick="location.href='${conPath}/loginView.do'" class="btn btn-primary">로그인</button>
		<button onclick="location.href='${conPath}/joinView.do'" class="btn btn-success">회원가입</button>
		<button onclick="location.href='${conPath}/allView.do'" class="btn btn-warning">전체회원보기</button>
		</div>
	</c:if>
	<c:if test="${not empty member }"> <!-- 로그인 후 -->
		<h2 class="text-center">${member.mName }(${member.mId })님 어서오세요</h2>
		<hr>
		<div class="text-center col">
		<button onclick="location.href='${conPath}/modifyView.do'" class="btn btn-primary">정보수정</button>
		<button onclick="location.href='${conPath}/logout.do'" class="btn btn-success">로그아웃</button>
		<button onclick="location.href='${conPath}/allView.do'" class="btn btn-warning">전체회원보기</button>
		</div>
	</c:if>
	
	</div>



<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>