<%@page import="com.tj.model1ex.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: lightyellow;
}

header {
	width: 1000px;
	margin: 0 auto;
}

header #nav ul {
	overflow: hidden;
}

header #nav ul li {
	list-style: none;
	float: right;
	padding: 10px 30px;
}

header #nav ul li a {
	text-decoration: none;
	color: #003300;
	font-weight: bold;
	font-size: 1.5em;
}
</style>
</head>
<body>
	<header>
		<div id="nav">
			<ul>
				<%
					CustomerDto dto = (CustomerDto)session.getAttribute("dto");
				%>
				<%
					if (dto == null) {//로그인 전 해더
				%>
				<li><a href="../customer/join.jsp">회원가입</a></li>
				<li><a href="<%=conPath %>/customer/login.jsp">로그인</a></li>
				<li><a href="<%=conPath %>/main/main.jsp">홈</a></li>

				<%
					} else {//로그인 이후 해더
				%>
				<li><a href="<%=conPath %>/customer/logout.jsp">로그아웃</a></li>
				<li><a href="<%=conPath %>/customer/modify.jsp">정보수정</a></li>
				<li><a href="<%=conPath %>/main/main.jsp"><%=dto.getCname()%>(<%=dto.getCid()%>)님</a></li>

				<%
					}
				%>

			</ul>
		</div>

	</header>
</body>
</html>