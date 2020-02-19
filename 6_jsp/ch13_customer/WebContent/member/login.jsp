<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/login.css">
</head>
<body>
<%
	if(session.getAttribute("name")!=null){
		response.sendRedirect("main.jsp");		
	}
%>
<%@include file="header.jsp" %>
	<div id="loginForm_wrap">
	<div id="login_title">
		로그인
	</div>
	<form action="loginPro.jsp" method="post">
	<table>
		
		
		<tr>
			<th>아이디</th>
			<td><input type="text" id="id" name="id" value="<% String userId = (String)session.getAttribute("id");
			if(userId !=null){
				out.print(userId);
			}
			%>"></td>
		</tr>
		
		<tr>
			<th>비밀번호</th>
			<td><input type="password" id="pw" name="pw"></td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="로그인" class="loginBtn_style">
			</td>
		</tr>
		<tr>
			<td colspan="2" id="login_findIdPw">
				<%
					String msg = request.getParameter("msg");
					if(msg!=null){
						out.print(msg);
					}
				
				%>
			
			</td>
		</tr>
		<tr>
			<td colspan="2" id="login_join">아직 회원이 아니신가요? <a href="join.jsp">회원가입</a></td>
		</tr>
	</table>
	</form>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>