<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
<jsp:useBean id="pi" class="com.tj.personinfo.PersonInfo" scope="request"/>

<h2>View</h2>
<h2>입력된 개인정보</h2>
	<p>이름 : <jsp:getProperty property="name" name="pi"/></p>
	<p>나이 : <jsp:getProperty property="age" name="pi"/></p>
	<p>성별 : <jsp:getProperty property="gender" name="pi"/></p>
	<p>주소 : <jsp:getProperty property="address" name="pi"/></p>
</body>
</html>