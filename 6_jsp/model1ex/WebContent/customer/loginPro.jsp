<%@page import="com.tj.model1ex.dto.CustomerDto"%>
<%@page import="com.tj.model1ex.dao.CustomerDao"%>
<%@page import="java.net.URLEncoder"%>
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
<link rel="stylesheet" href="<%=conPath %>/css/login.css">
<style type="text/css">
 p{
 	text-align: center;
 }
</style>
</head>
<body>
	<%
		String cid = request.getParameter("cid");
		String cpw = request.getParameter("cpw");
		if(cid==null || cpw==null){
			response.sendRedirect("login.jsp");
		}
		CustomerDao cDao = CustomerDao.getInstance();
		int result = cDao.loginCheck(cid, cpw);
		if(result == CustomerDao.LOGIN_FAIL){
			String msg = URLEncoder.encode("아이디/비밀번호를 잊으셨나요?", "utf-8");
			response.sendRedirect("login.jsp?msg="+msg);
		}else{
			CustomerDto dto = new CustomerDto();
			dto = cDao.getCustomer(cid);
			session.setAttribute("customer", dto);
			response.sendRedirect("../main/main.jsp");
		}
	%>
	<div id="loginForm_wrap">
	<div id="login_title">
		로그인 결과
	</div>
		<p>로그인 성공</p>
	
	
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>