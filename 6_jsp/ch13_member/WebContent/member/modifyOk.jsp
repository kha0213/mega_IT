<%@page import="com.tj.member.MemberDao"%>
<%@page import="com.tj.member.MemberDto"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dto" class="com.tj.member.MemberDto" />
	<jsp:setProperty property="*" name="dto" />
	<%
		String tempbirth = request.getParameter("tempbirth");
		dto.setBirth(Timestamp.valueOf(tempbirth + " 00:00:00"));
		String oldPw = request.getParameter("oldPw");
		MemberDto member = ((MemberDto) session.getAttribute("member"));
		String sessionPw = null;
		if (member != null) {
			sessionPw = member.getPw();
			if (dto.getPw() == null)
				dto.setPw(oldPw);
		}
		if (oldPw.equals(sessionPw)) {
			MemberDao mDao = MemberDao.getInstance();
			int result = mDao.updateMember(dto);
			if (result == MemberDao.SUCCESS) {
				session.setAttribute("member", dto);
	%>
	<script type="text/javascript">
		alert('회원 정보수정이 완료되었습니다.');
		location.href = 'main.jsp';
	</script>
	<%
		} else if (result == MemberDao.FAIL) {
	%>
	<script>
		alert('회원정보 수정이 실패되었습니다. 정보가 깁니다.');
		location.href = 'modify.jsp';
	</script>

	<%
		}
		} else {// 현 비밀번호를 틀리게 입력한 경우 뭐라 카고 돌려보냄
	%>
	<script>
		alert('현 비밀번호가 바르지 않습니다. 확인하세요');
		history.back();
	</script>
	<%
		}
	%>
</body>
</html>