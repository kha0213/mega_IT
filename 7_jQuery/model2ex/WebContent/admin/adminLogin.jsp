<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${conPath }/css/style.css">
<style>
	#content_form {
		width: 800px; height:500px; 
		margin: 0 auto; text-align: center; font-size: 1em;
	}
</style>
</head>
<body>
	
		<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<form action="${conPath }/adminlogin.do" method="post">
		<h5>관리자모드 로그인</h5>
		<table>
			<tr>
				<th><small>admin ID</small></th>
				<td> <input type="text" name="aId" required="required"></td>
			</tr>
			<tr>
				<th><small>PW</small></th>
				<td> <input type="password" name="aPw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="로그인">
			</tr>
		
		</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>