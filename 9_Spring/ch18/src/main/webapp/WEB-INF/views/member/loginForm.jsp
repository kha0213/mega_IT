<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${conPath }/css/style.css" rel="stylesheet">
<style>
	#content {
		width: 800px; height:350px;
		margin: 50px auto;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<form action="${conPath }/member.do?method=login" method="post">
		<table>
			<tr><td>아이디</td><td><input type="text" name="mid" id="mid" value="${mid }">
			</td></tr>
			<tr><td>비밀번호</td><td><input type="password" name="mpw"></td></tr>
			<tr><td colspan="2">
				<input type="submit" value="로그인">
			</td></tr>
		</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>