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
	<jsp:setProperty property="studentNum" name="st" param="studentNum" />
	<jsp:setProperty property="name" name="st" param="name" />
	<jsp:setProperty property="grade" name="st" param="grade" />
	<jsp:setProperty property="className" name="st" param="className" />
	<jsp:setProperty property="score" name="st" param="score" />
	<jsp:forward page="stResult.jsp"/>
	<h2>st5입니다. 페이지 이동합니다.</h2>
</body>
</html>