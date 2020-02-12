<%@page import="com.tj.dao.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='../css/style.css' rel='stylesheet'>
</head>
<body>
<jsp:useBean id="dto" class="com.tj.dto.FriendDto" scope="page"/>
<jsp:setProperty property="*" name="dto"/>
<%
	FriendDao friendDao = FriendDao.getInstance();
	int result = friendDao.insertFriend(dto);
	response.sendRedirect("friendInputList.jsp?add="+(result>0?"success":"fail"));
%>
	
</body>
</html>