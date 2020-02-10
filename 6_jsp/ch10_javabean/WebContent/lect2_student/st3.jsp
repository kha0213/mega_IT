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
<jsp:useBean id="st" class="com.tj.studentInfo.Student" scope="request"/>
<jsp:setProperty property="studentNum" name="st" value="<%=request.getParameter(\"studentNum\") %>"/>
<jsp:setProperty property="name" name="st" value="<%=request.getParameter(\"name\") %>"/>
<jsp:setProperty property="grade" name="st" value="<%=Integer.parseInt(request.getParameter(\"grade\")) %>"/>
<jsp:setProperty property="className" name="st" value="<%=request.getParameter(\"className\").charAt(0) %>"/>
<jsp:setProperty property="score" name="st" value="<%=Integer.parseInt(request.getParameter(\"score\")) %>"/>

<h2>st3입니다.</h2>
<p>학번 : <jsp:getProperty property="studentNum" name="st"/></p>
<p>이름 : <jsp:getProperty property="name" name="st"/></p>
<p>등급 : <jsp:getProperty property="grade" name="st"/></p>
<p>반이름 : <jsp:getProperty property="className" name="st"/></p>
<p>점수 : <jsp:getProperty property="score" name="st"/></p>



</body>
</html>