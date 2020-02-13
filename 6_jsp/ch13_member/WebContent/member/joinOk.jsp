<%@page import="com.tj.member.MemberDao"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String conPath = request.getContextPath();
%>
<jsp:useBean id="dto" class="com.tj.member.MemberDto" />
<jsp:setProperty property="*" name="dto" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<%=conPath%>/css/style.css' rel='stylesheet'>
</head>
<body>
	<%
		String tempbirth = request.getParameter("tempbirth");
		dto.setBirth(Timestamp.valueOf(tempbirth + " 00:00:00"));
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.confirmId(dto.getId());
		if (result == MemberDao.MEMBER_NONEXISTENT) {
			result = mDao.insertMember(dto);
			if(result == MemberDao.SUCCESS){
				session.setAttribute("id", dto.getId());%>
				<script type="text/javascript">
					alert('회원가입 감사합니다. 로그인 이후에 서비스를 이용하세요.');
					location.href='login.jsp';
				</script>
				
			<%}else{%>
				<script type="text/javascript">
					alert('회원가입 실패되었습니다. 미안한데 뭐가 잘못되었는지는 몰라 너가 알아서 해봥');
					location.href='join.jsp';
				</script>
			<%}
			
			
		} else {
	%>
	<script type="text/javascript">
		alert('중복된 아이디야 다른아이디 쓰지 않겠니?');
		history.back();
	</script>
	<%
		}
	%>
</body>
</html>