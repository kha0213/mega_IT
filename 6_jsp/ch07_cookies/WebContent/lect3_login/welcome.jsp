<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<%
	String id=null,name=null;
	%>


	<% 
		Cookie[] cs = request.getCookies();
		if (cs != null) {
			for (int i = 0; i < cs.length; i++) {
				if (cs[i].getName().equals("id")) {
					id = cs[i].getValue();
					
				} else if (cs[i].getName().equals("name")) {
					name = cs[i].getValue();
				}
			} //로그인 성공이라면 id(aaa), name(롱롱이) /로그인 전이면 id(null), name(null)
		}
		if (id == null) {
	%>
	<h1>손님 어서오세요. 로그인 해주세요</h1>
	<p>
		<button onclick="location.href='login.jsp'">로그인</button>
		<button onclick="location.href='cookieslist.jsp'">쿠키들 확인</button>
	</p>
	<%
		} else { // 로그인 이후 화면
	%>
		<h1><%=name %>님 (<%=id %>)어서오세요.</h1>
	<p>
		<button onclick="location.href='logout.jsp'">로그아웃</button>
		<button onclick="location.href='cookieslist.jsp'">쿠키들 확인</button>
	</p>	
			
			
		<%}
	%>


</body>
</html>