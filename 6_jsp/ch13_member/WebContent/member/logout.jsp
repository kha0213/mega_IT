<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<%=conPath%>/css/style.css' rel='stylesheet'>
</head>
<body>
	<%
		session.invalidate();
	%>
	<h2>로그아웃이 성공적으로 되었습니다. 잠시 후 메인페이지로 이동합니다.</h2>
	<script type="text/javascript">
		setTimeout(function() {
			location.href = 'main.jsp';
		}, 2000);
	</script>

</body>
</html>