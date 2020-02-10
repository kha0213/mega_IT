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
	<jsp:setProperty property="studentNum" name="st"
		value="<%=request.getParameter(\"studentNum\")%>" />
	<jsp:setProperty property="name" name="st"
		value="<%=request.getParameter(\"name\")%>" />
	<jsp:setProperty property="grade" name="st"
		value="<%=Integer.parseInt(request.getParameter(\"grade\"))%>" />
	<jsp:setProperty property="className" name="st"
		value="<%=request.getParameter(\"className\").charAt(0)%>" />
	<jsp:setProperty property="score" name="st"
		value="<%=Integer.parseInt(request.getParameter(\"score\"))%>" />

	<jsp:forward page="stResult.jsp"/>

	<h2>st4입니다. 페이지 이동합니다.</h2>



</body>
</html>