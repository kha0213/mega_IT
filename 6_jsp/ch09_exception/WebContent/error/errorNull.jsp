<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> <%-- exception 내부 객체 쓰기 위함 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	console.log('예외메세지 : <%=exception.getMessage()%>');
	console.log('예외타입 : <%=exception.getClass().getName()%>');
</script>
</head>
<body>
	<h1>errorNull입니다. 공사중입니다.</h1>
	(errorNull.jsp)
</body>
</html>