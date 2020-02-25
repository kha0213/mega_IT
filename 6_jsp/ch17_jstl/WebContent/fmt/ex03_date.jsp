<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		Date nowDateSql = new Date(System.currentTimeMillis());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		java.util.Date nowDateUtil = new java.util.Date();
	%>
	<c:set var="nowDate" value="<%=nowDateSql %>"></c:set>
	<c:set var="timestamp" value="<%=timestamp %>"></c:set>
	<c:set var="nowDateUtil" value="<%=nowDateUtil %>"></c:set>
	nowDate date short <fmt:formatDate value="${nowDate }" type="date" dateStyle="short"/><br>
	nowDate date medium <fmt:formatDate value="${nowDate }" type="date" dateStyle="medium"/><br>
	nowDate date long <fmt:formatDate value="${nowDate }" type="date" dateStyle="long"/><br>
	nowDate date full <fmt:formatDate value="${nowDate }" type="date" dateStyle="full"/><br>
	nowDate time short <fmt:formatDate value="${nowDate }" type="time" timeStyle="short"/><br>
	nowDate time medium <fmt:formatDate value="${nowDate }" type="time" timeStyle="medium"/><br>
	nowDate time long <fmt:formatDate value="${nowDate }" type="time" timeStyle="long"/><br>
	nowDate time full <fmt:formatDate value="${nowDate }" type="time" timeStyle="full"/><br>
	nowDate <fmt:formatDate value="${nowDate }" type="both" dateStyle="long" timeStyle="medium"/><br>
	
	
	
</body>
</html>