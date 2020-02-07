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
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	
	session.setAttribute("id", id);
	session.setAttribute("pw", pw);
	session.setAttribute("name", name);
	%>
	


	<h1 style="color:red"><%=name %>님 약관에 동의하십니까?</h1>
	<hr>
	<ol>
	<li>회원정보는 웹사이트의 운영을 위해서만 사용됩니다.</li>
	<li>웹사이트의 정상적인 운영을 방해하는 회원은 등급이 상승합니다.</li>
	</ol>
	<hr>
	<fieldset>
		<legend>약관 동의</legend>
		<form action="joinOk.jsp">
        <%--<input type="hidden" name="id" value="<%=id %>"> --%>		
		<input type="radio" name="agree" value="y" >동의
		<input type="radio" name="agree" value="n" checked="checked">거부
		<input type="submit" value="확인">
	</form>
	</fieldset>
</body>
</html>