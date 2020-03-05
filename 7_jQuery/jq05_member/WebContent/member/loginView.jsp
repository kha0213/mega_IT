<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${conPath}/css/login.css">

<script
src="https://code.jquery.com/jquery-3.4.1.js">
</script>
<script>
$(function(){
$('#loginFail').click(function(){
	window.open('${conPath}/loginSearch.do');
	
	
});
	
});

</script>

</head>
<body>
<c:if test="${not empty member }">
	<script>
		location.href='${conPath}/main.do';
	</script>
</c:if>

<%@include file="header.jsp" %>
	<div id="loginForm_wrap">
	<div id="login_title">
		로그인
	</div>
	<form action="${conPath}/login.do" method="post">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="text" id="id" name="id" required="required"></td>
		</tr>
		
		<tr>
			<th>비밀번호</th>
			<td><input type="password" id="pw" name="pw" required="required"></td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="로그인" class="loginBtn_style">
			</td>
		</tr>
		<tr>
			<td colspan="2" id="login_findIdPw">
				<c:if test="${not empty loginResultFail}">
					<p id="loginFail">${loginResultFail }</p>
				</c:if>
			
			</td>
		</tr>
		<tr>
			<td colspan="2" id="login_join">아직 회원이 아니신가요? <a href="join.jsp">회원가입</a></td>
		</tr>
	</table>
	</form>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>