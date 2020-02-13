<%@page import="java.sql.Timestamp"%>
<%@page import="com.tj.member.MemberDto"%>
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
<link href='<%=conPath %>/css/style.css' rel='stylesheet'>
</head>
<body>
<%  MemberDto member = ((MemberDto)session.getAttribute("member"));
	if(member==null){
		response.sendRedirect("login.jsp");
	}
	String id = member.getId();
	String name = member.getName();
	String email = member.getEmail()==null?"":member.getEmail();
	Timestamp birth = member.getBirth();
	String address = member.getAddress()==null?"":member.getAddress();



%>


	<form action="modifyOk.jsp" method="post" name="join_frm">
		<table>
			<caption>정보수정</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" value="<%=id%>" readonly="readonly"></td>
			</tr>
			<tr>
				<th>현비밀번호</th>
				<td><input type="password" name="oldPw"></td>
			</tr>
			<tr>
				<th>새비밀번호</th>
				<td><input type="password" name="pw" placeholder="미입력시 비밀번호 유지"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="<%=name%>"></td>
			</tr>
			<tr>
				<th>메일주소</th>
				<td><input type="email" name="email" value="<%=email%>"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="tempbirth" value="<%=birth.toString().substring(0, 10)%>"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" value="<%=address%>"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="정보수정"
					onclick="infoConfirm()"> <input type="reset" value="취소">
					<input type="button" value="로그아웃"
					onclick="location.href='logout.jsp'"></td>
			</tr>
		</table>
	</form>
</body>
</html>