<%@page import="java.sql.Date"%>
<%@page import="com.tj.model1ex.dao.CustomerDao"%>
<%@page import="java.io.PrintWriter"%>
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
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:useBean id="dto" class="com.tj.model1ex.dto.CustomerDto" />
	<jsp:setProperty property="*" name="dto" />


	<%
		String tempbirth = request.getParameter("tempbirth");
		Date cbirth = Date.valueOf(tempbirth);
		dto.setCbirth(cbirth);
		CustomerDao cDao = CustomerDao.getInstance();
		int result = cDao.confirmId(dto.getCid());
		if (result == CustomerDao.CUSTOMER_EXISTENT) {
	%>
	<script>
		alert('같은 아이디가 존재합니다.');
		location.href = 'join.jsp';
	</script>
	<%
		}
		result = cDao.insertCustomer(dto);
		if (result == CustomerDao.FAIL) {
	%>
	<script>
		alert('회원가입 실패하였습니다. 너무 긴 데이터는 가입불가합니다. 다시 가입해주세요');
		location.href = 'join.jsp';
	</script>
	<%
		}
		session.setAttribute("cid", dto.getCid());
	%>
	<script>
		alert('회원가입 감사합니다. 로그인 이후에 서비스 이용하세요');
		location.href = 'login.jsp';
	</script>
</body>
</html>