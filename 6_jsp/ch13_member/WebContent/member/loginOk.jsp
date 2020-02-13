<%@page import="com.tj.member.MemberDto"%>
<%@page import="com.tj.member.MemberDao"%>
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
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDao mDao = MemberDao.getInstance();
	int result = mDao.loginCheck(id, pw);
	if(result == MemberDao.LOGIN_SUCCESS){
		MemberDto member = mDao.getMember(id);
		session.setAttribute("member", member);
		response.sendRedirect("main.jsp");
	}else if(result == MemberDao.LOGIN_FAIL_PW){%>
		<script>
			alert('비밀번호를 확인하세요');
			history.back();
		</script>
	<%}else if(result == MemberDao.LOGIN_FAIL_ID){%>
		<script>
			alert('존재하지 않는 아이디입니다.');
			history.back();
		</script>
	<%}%>
</body>
</html>