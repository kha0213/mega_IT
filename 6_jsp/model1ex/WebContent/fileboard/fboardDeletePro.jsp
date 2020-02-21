<%@page import="com.tj.model1ex.dto.FileBoardDto"%>
<%@page import="com.tj.model1ex.dao.FileBoardDao"%>
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
<link href='<%=conPath%>/css/style2.css' rel='stylesheet'>
</head>
<body>
	<%
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		String fpw = request.getParameter("fpw");
		FileBoardDao fDao = FileBoardDao.getInstance();
		int result = fDao.deleteFileBoard(fnum, fpw);
		if(result==FileBoardDao.SUCCESS){%>
			<script type="text/javascript">
				alert('<%=fnum%>번 글 삭제성공');
				location.href='fboardList.jsp';
			</script>
		<%}else{%>
			<script type="text/javascript">
				alert('<%=fnum%>번 글 삭제실패 비밀번호를 확인하세요');
				history.back();
			</script>
		<%}%>
</body>
</html>