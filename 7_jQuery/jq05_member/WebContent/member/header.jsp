<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	header{
		width:1000px;
		margin: 10px auto;
	}
	
	header #nav ul{
		overflow:hidden;
	}
	header #nav ul li{
		list-style: none;
		float:right;
		padding: 10px;
	}
	header #nav ul li a {
		text-decoration: none;
		color:black;
	}

</style>
</head>
<body>
	<header>
		<div id="nav">
			<ul>
			<c:if test="${empty member }">
			<li><a href="join.jsp">회원가입</a></li>
		<li><a href="login.jsp">로그인</a></li>
		<li><a href="main.jsp">홈</a></li>
			
			</c:if>
			<c:if test="${not empty member }">
			<li><a href="logout.jsp">로그아웃</a></li>
		<li><a href="modify.jsp">정보수정</a></li>
		<li><a href="mypage.jsp">${member.name }(${member.id })님</a></li>
			</c:if>

				
			</ul>
		</div>

	</header>
</body>
</html>