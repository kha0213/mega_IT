<%@page import="com.tj.model1ex.dto.FileBoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.model1ex.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	FileBoardDao fDao = FileBoardDao.getInstance();
	ArrayList<FileBoardDto> dtos = 	fDao.listFileBoard(2, 3);
	for(FileBoardDto dto : dtos){
		out.print(dto.toString());
		out.print("<br>");	
	}
	out.print("<hr>");
	out.print(fDao.getFileBoardTotCnt());
	out.print("<hr>");	
	FileBoardDto dto = new FileBoardDto();

%>
</body>
</html>