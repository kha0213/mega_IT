<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String birthday = request.getParameter("date");
	String[] hobby= request.getParameterValues("hobby");
	String hobbyStr ="";
	if(hobby!=null){
		for(int i=0;i<hobby.length;i++){
			hobbyStr += hobby[i]+" ";
		}
	}else{
		hobbyStr="취미 없음";
	}
	String gender = request.getParameter("gender");
	
	
	
	
	session.setAttribute("id", id);
	session.setAttribute("pw", pw);
	session.setAttribute("name", name);
	
	
	
	
	if(id!=null){
		response.sendRedirect("login.jsp");
	}
	%>
	
</body>
</html>