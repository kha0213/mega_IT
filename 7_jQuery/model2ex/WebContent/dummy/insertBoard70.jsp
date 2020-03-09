
<%@page import="com.tj.ex.dao.FileboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<%
		FileboardDao bDao = FileboardDao.getInstance();
		for(int i=0;i<200;i++){
		bDao.insertBoard("aaa", "title"+i, "content"+i,"ddd", "ippppi");
		}
	
	%>	
	
	</div>



</body>
</html>