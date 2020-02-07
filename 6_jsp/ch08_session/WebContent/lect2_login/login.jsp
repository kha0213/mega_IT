<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	String conPath = request.getContextPath();
	if (session.getAttribute("name") != null) {
		response.sendRedirect("welcome.jsp");
	}

	String msg = request.getParameter("msg");
	if (msg != null) {
%>
<script type="text/javascript">
	alert("<%=msg%>");
</script>
<%
	}
%>

<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<form action="loginOk.jsp" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" autofocus="autofocus" required="required"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="pw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>
</body>
</html>