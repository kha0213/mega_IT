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
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
	%>
	<jsp:useBean id="dto" class="com.tj.dto.BoardDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		dto.setIp(request.getRemoteAddr());
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.updateBoard(dto);
		if(result==BoardDao.SUCCESS){%>
			<script type="text/javascript">
				alert('글 수정 성공');
				location.href='content.jsp?num=<%=dto.getNum()%>&pageNum=<%=pageNum%>';
			</script>
			
		<%}else{%>
			<script type="text/javascript">
				alert('글 수정 실패');
				location.href='list.jsp?pageNum=<%=pageNum%>';
			</script>
		<%}
	%>
</body>
</html>