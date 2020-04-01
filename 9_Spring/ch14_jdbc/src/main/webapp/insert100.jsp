<%@page import="com.tj.ch14.dto.BoardDto"%>
<%@page import="com.tj.ch14.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
	$(document).ready(function(){



	});

</script>
</head>
<body>
	<%
		BoardDao bDao = BoardDao.getInstance();
		BoardDto bDto = new BoardDto();
		for(int i=0;i<200;i++){
			bDto.setBname("홍길동"+i);
			bDto.setBtitle("제목"+i);
			bDto.setBcontent("본문 내용 "+i);
			bDto.setBip("192.168.20.31");
			bDao.write(bDto);
		}
	
	%>
</body>
</html>