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
	<%
	String id = (String)session.getAttribute("id");
	String name = (String)session.getAttribute("name");
	%>
	<%
	if(name!=null){//로그인상태%>
		<h1><%=name %>님 방가방가 님 아디 <%=id %></h1>
		<button onclick="location.href='logout.jsp'">로그아웃</button>
		<%
	}else{//비로그인 상태%>
		<h1>welcom인데 로그인 안함</h1>
		<button onclick="location.href='login.jsp'">로그인</button>
	<%}
	%>
		<button onclick="location.href='sessionSee.jsp'">세션들어다보기</button>
	
</body>
</html>