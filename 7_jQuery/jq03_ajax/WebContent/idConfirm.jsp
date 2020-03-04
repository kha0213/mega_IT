<%@page import="com.tj.ex.dao.Member_dao"%>
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
	String mId = request.getParameter("mId");
	String x = request.getParameter("x");
	Member_dao mDao = Member_dao.getInstance();
	int result = mDao.mIdConfirm(mId);
	if(result == Member_dao.EXISTENT ){
		out.print(mId+"는 중복된 아이디"+x);
	}else{
		out.print(mId+"는 사용가능한 ID입니다"+x);
	}

%>



</body>
</html>