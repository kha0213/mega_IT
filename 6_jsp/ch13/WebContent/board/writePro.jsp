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
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String pageNum = request.getParameter("pageNum");
%>
	<jsp:useBean id="dto" class="com.tj.dto.BoardDto" scope="request"/>
	<jsp:setProperty property="*" name="dto" />
<%
	dto.setIp(request.getRemoteAddr());
	BoardDao bDao = BoardDao.getInstance();
	int result=0;
	if(dto.getNum()==0){
		result =bDao.insertBoard(dto);
	}else{
		result = bDao.reply(dto);
	}
	if(result==BoardDao.SUCCESS){%>
	<script type="text/javascript">
		alert('글쓰기 완료');
		location.href='list.jsp?pageNum=<%=pageNum%>';
	</script>
	<%}else{%>
	<script type="text/javascript">
		alert('글쓰기 실패');
		history.back();
	</script>	
	<%}
%>
</body>
</html>