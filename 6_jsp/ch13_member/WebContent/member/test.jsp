<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.tj.member.MemberDto"%>
<%@page import="com.tj.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<%=conPath %>/css/style.css' rel='stylesheet'>
</head>
<body>
	<h1>테스트 페이지</h1>
	<%
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.confirmId("TID");
		// 1 테스트
		out.print("<h2>1.confirmId테스트 : ");
		if(result==MemberDao.MEMBER_EXISTENT){
			out.println("TID는 중복된 ID</h2>");
		}else{
			out.println(">TID는 없는 ID</h2>");			
		}
		// 2 테스트
		out.print("<hr><h2>2.insertMember테스트 : ");
		MemberDto dto = new MemberDto("TID2","111","테스트",null,Timestamp.valueOf("2020-01-17 12:20:00"),
				null,"서울시 종로구");
		result = mDao.insertMember(dto);
		out.println(result==MemberDao.SUCCESS?"회원가입 성공"+dto.toString():"회원가입 실패");
		out.println("</h2><hr>");
		// 3 테스트
		out.println("<h2>3.loginCheck테스트 </h2>");
		out.println("<p>1. 아이디 없는경우 TIDDD,111</p>");
		result = mDao.loginCheck("TIDDD", "111");
		if(result == MemberDao.LOGIN_SUCCESS){
			out.println("<p>로그인성공</p>");
		}else if(result == MemberDao.LOGIN_FAIL_ID){
			out.println("<p>아이디 없음</p>");
		}else if(result == MemberDao.LOGIN_FAIL_PW){
			out.println("<p>비밀번호 없음</p>");
		}
		out.println("<p>2. 비밀번호 틀린 경우 TID,111</p>");
		result = mDao.loginCheck("TID", "111");
		if(result == MemberDao.LOGIN_SUCCESS){
			out.println("<p>로그인성공</p>");
		}else if(result == MemberDao.LOGIN_FAIL_ID){
			out.println("<p>아이디 없음</p>");
		}else if(result == MemberDao.LOGIN_FAIL_PW){
			out.println("<p>비밀번호 없음</p>");
		}
		out.println("<p>3. 로그인 성공 TID,xxx</p>");
		result = mDao.loginCheck("TID", "xxx");
		if(result == MemberDao.LOGIN_SUCCESS){
			out.println("<p>로그인성공</p>");
		}else if(result == MemberDao.LOGIN_FAIL_ID){
			out.println("<p>아이디 없음</p>");
		}else if(result == MemberDao.LOGIN_FAIL_PW){
			out.println("<p>비밀번호 없음</p>");
		}
		
		// 4 테스트
		out.print("<hr><h2>4.getMember테스트 : ");	
		dto = mDao.getMember("TID");
		out.print("TID인 사람의 정보 : "+dto+"<hr>");
		
		// 5 테스트
		out.print("5. 회원정보 수정하기 TID회원 정보 수정");
		dto = new MemberDto("TID","xxx","xxx","xxx",Timestamp.valueOf("1990-02-13 12:21:00"),null,"xxx");
		result = mDao.updateMember(dto);
		if(result == MemberDao.SUCCESS){
			out.print("성공 수정 후 데이터 : "+mDao.getMember("TID"));
		}else{
			out.print(" 실패 : "+dto);
		}
		
		
		
		
		
	%>
</body>
</html>