<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/login.css" rel="stylesheet">
</head>
<style>
	#mainForm_wrap{
		width:1000px; margin: 10px auto; height: 600px; 
		border: 1px solid #D4A190;
		line-height: 200px;
		text-align: center;
		font-size: 2em; color: #A47160;
	}
	
</style>
<script language="JavaScript">
function next(){location = "main.jsp";}
</script>
<body>
<%@include file="header.jsp" %>
<%
	session.invalidate();
%>
<div id='mainForm_wrap'>

<h2>
성공적으로 로그아웃 되었습니다. <br>
잠시 후 메인페이지로 이동합니다.
</h2>
</div>
<body onLoad="setTimeout('next()', 2000)">
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>