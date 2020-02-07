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
	<%
		String name = (String)session.getAttribute("name");
		if(name!=null){
		session.removeAttribute("id");
		session.removeAttribute("name");
		// session.invalidate(); 한번해 해도 OK
		out.print("<h2>로그아웃 되었습니다.(모든세션을 삭제했어여)</h2>");
		}else{
			out.print("<h2>로그인 상태가 아니얌~</h2>");
		}
	%>
	
	<button onclick="location.href='login.jsp'">로그인</button>
	<button onclick="location.href='sessionSee.jsp'">세션 들어다 보기</button>
</body>
</html>