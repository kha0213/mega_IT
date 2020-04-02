<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="textMail">
		<p>이름 <input type="text" name="name" required="required"></p>
		<p>메일 <input type="text" name="mailaddr" required="required"></p>
		<p><input type="submit" value="회원가입(TEXT단순 메일감)"></p>
	</form>
	<hr color="green">
	<form action="htmlMail">
		<p>이름 <input type="text" name="name" required="required"></p>
		<p>메일 <input type="text" name="mailaddr" required="required"></p>
		<p><input type="submit" value="회원가입(HTML 메일감)"></p>
	</form>
</body>
</html>