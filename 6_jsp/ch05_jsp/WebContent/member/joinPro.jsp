<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
	String hiddenParam = request.getParameter("hiddenParam");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = "";
	for (int i = 0; i < request.getParameter("pw").length(); i++) {
		pw += "*";
	}
	String birth = request.getParameter("birth");
	Timestamp birth2 = Timestamp.valueOf(request.getParameter("birth")+" 00:00:00");
	String hobbyStr = "";
	String[] hobby = null;
	if (request.getParameterValues("hobby") != null) {
		hobby = request.getParameterValues("hobby");
		for (int i = 0; i < hobby.length; i++) {
			if (i != hobby.length - 1) {
				hobbyStr += hobby[i] + ", ";
			} else {
				hobbyStr += hobby[i];
			}
		}
	} else {
		hobbyStr = "취미없음";
	}
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	String mailSendStr = "";
	String[] mailSend = null;
	if (request.getParameterValues("mailSend") != null) {
		mailSend = request.getParameterValues("mailSend");
		for (int i = 0; i < mailSend.length; i++) {
			if (i != mailSend.length - 1) {
				mailSendStr += mailSend[i] + ", ";
			} else {
				mailSendStr += mailSend[i];
			}
		}
	} else {
		mailSendStr = "모두 거부";
	}
%>
<html>
<head>
<style>
#wrap {
	padding: 20px;
	border: 1px solid #D4A190;
}

h2 {
	color: #D4A190;
	text-align: center;
}

tr {
	text-align: left;
}
</style>
</head>
<body>
	<div id="wrap">
		<div>
			<h2>회원가입정보</h2>
			<hr color='#D4A190'>
		</div>
		<table>
			<tr>
				<th>hiddenParam : <%=hiddenParam%></th>
			</tr>
			<tr>
				<th>이름 : <%=name%></th>
			</tr>
			<tr>
				<th>아이디 : <%=id%></th>
			</tr>
			<tr>
				<th>비번 : <%=pw%></th>
			</tr>
			<tr>
				<th>생년월일 : <%=birth%></th>
			</tr>
			<tr>
				<th>생년월일2 : <%=birth2%></th>
			</tr>
			<tr>
				<th>취미 : <%=hobbyStr%></th>
			</tr>
			<tr>
				<th>성별 : <%=gender%></th>
			</tr>
			<tr>
				<th>이메일 : <%=email%></th>
			</tr>
			<tr>
				<th>메일수신동의 : <%=mailSendStr%></th>
			</tr>
		</table>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>