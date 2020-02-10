<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:useBean id="st" class="com.tj.studentInfo.Student" scope="request" />
	<jsp:setProperty property="*" name="st" />

	<jsp:forward page="stResult.jsp"/>

	<h2>st6입니다. 페이지 이동합니다.</h2>



</body>
</html>