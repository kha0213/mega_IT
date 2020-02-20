<%@page import="com.tj.model1ex.dao.CustomerDao"%>
<%@page import="java.sql.Date"%>
<%@page import="com.tj.model1ex.dto.CustomerDto"%>
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
<jsp:useBean id="dto" class="com.tj.model1ex.dto.CustomerDto"/>
<jsp:setProperty property="*" name="dto"/>
<%
	String userPw = ((CustomerDto)session.getAttribute("customer")).getCpw();
	String preCpw = request.getParameter("preCpw");
	String tempbirth = request.getParameter("tempbirth");
	if(!userPw.equals(preCpw)){%>
		<script>
			alert('현재 비밀번호를 잘못 입력하셨습니다.');
			location.href='modify.jsp';
		</script>
	<%}
	String newCpw = request.getParameter("newCpw");
	if(newCpw.equals("")) newCpw=preCpw;
	dto.setCpw(newCpw);
	dto.setCbirth(Date.valueOf(tempbirth));
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.updateCustomer(dto);
	if(result == CustomerDao.SUCCESS){
		session.setAttribute("customer", dto);
	%>
		<script>
			alert('정보수정 완료되었습니다.');
			location.href='../main/main.jsp';
		</script>
	<%}else{%>
		<script>
			alert('정보수정 실패되었습니다. 너무 긴 데이터로 수정불가합니다. 다시 수정해주세요');
			history.back();
		</script>
		
	<%}
	
%>




</body>
</html>