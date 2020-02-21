<%@page import="com.tj.model1ex.dto.FileBoardDto"%>
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
	FileBoardDto dto = new FileBoardDto();
	for(int i=0;i<70;i++){
		dto.setCid("aaa");
		dto.setFsubject(i+"번 제목");
		dto.setFcontent(i+"번 내용");
		if(i%4==0){
		dto.setFfilename("a.pptx");
		}else{
			dto.setFfilename(null);
		}
		dto.setFpw("111");
		dto.setFip(i+"번째 test");
		fDao.insertFileBoard(dto);
	}
	response.sendRedirect("fboardList.jsp");
%>
</body>
</html>