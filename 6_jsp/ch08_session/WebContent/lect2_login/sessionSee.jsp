<%@page import="java.util.Enumeration"%>
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
<jsp:include page="header.jsp"/>
	<h1>세션보기다아아아</h1>
	<%
		Enumeration<String> sAttNames = session.getAttributeNames();
		int cnt=0;
		while(sAttNames.hasMoreElements()){
			cnt++;
			String temp = sAttNames.nextElement();
			out.print(cnt+"번쨰"+temp+" : "+session.getAttribute(temp).toString()+"<br>");
		}
		if(cnt==0){
			out.print("<h2>세션이 하나도 없쪙</h2>");
		}
	%>
	<button onclick="history.go(-1)">이전페이지</button>
	<button onclick="location.href='login.jsp'">로그인</button>
	<button onclick="location.href='logout.jsp'">로그아웃</button>
	
</body>
</html>