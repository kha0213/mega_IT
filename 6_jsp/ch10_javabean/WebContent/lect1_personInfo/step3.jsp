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
	<jsp:useBean class="com.tj.personinfo.PersonInfo" id="pi"
		scope="page"/>
	<%--PersonInfo pi = new PersonInfo(); --%>
	<jsp:setProperty property="name" name="pi" value="<%=request.getParameter(\"name\") %>"/>
	<jsp:setProperty property="age" name="pi" value="<%=Integer.parseInt(request.getParameter(\"age\")) %>"/>
	<jsp:setProperty property="gender" name="pi" value="<%=request.getParameter(\"gender\").charAt(0) %>"/>
	<jsp:setProperty property="address" name="pi" value="<%=request.getParameter(\"address\") %>"/>
<h2>Step 3</h2>
<h2>입력된 개인정보</h2>
	<p>이름 : <jsp:getProperty property="name" name="pi"/></p>
	<p>나이 : <jsp:getProperty property="age" name="pi"/></p>
	<p>성별 : <jsp:getProperty property="gender" name="pi"/></p>
	<p>주소 : <jsp:getProperty property="address" name="pi"/></p>
</body>
</html>