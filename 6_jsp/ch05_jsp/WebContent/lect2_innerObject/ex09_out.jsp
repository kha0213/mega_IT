<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="8kb" autoFlush="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>버퍼의 크기 : <%=out.getBufferSize() %></h2>
	<h2>TEST</h2>
	<h2>버퍼 남은 크기 : <%=out.getRemaining() %></h2>
	<%	
		int i=0;
		while(i<10000){
			out.print("<h2>Test "+i+"남은버퍼 : "+out.getRemaining()+"</h2>");
			i++;
		}
	
	%>
	<h2>버퍼 남은 크기 : <%=out.getRemaining() %></h2>
</body>
</html>