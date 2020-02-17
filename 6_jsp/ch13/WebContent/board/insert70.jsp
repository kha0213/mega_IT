<%@page import="com.tj.dto.BoardDto"%>
<%@page import="com.tj.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");
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
	BoardDto dto = new BoardDto();
	BoardDao bDao = BoardDao.getInstance();
	for(int i=1;i<=70;i++){
		dto.setWriter("롱롱이_"+i);
		dto.setSubject("제목_"+i);
		dto.setContent("내용_"+i);
		dto.setEmail("email_"+i);
		dto.setPw(String.valueOf(i));
		dto.setIp("192.168.20.11");
		bDao.insertBoard(dto);
	}
	response.sendRedirect("list.jsp");
%>
</body>
</html>