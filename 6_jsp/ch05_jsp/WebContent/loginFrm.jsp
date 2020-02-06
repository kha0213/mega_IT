<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{
		text-align: center;
	}
	span{
		font-weight: bold;
		color:red;
	}
</style>

</head>
<body>
<%String msg = request.getParameter("msg"); 
	if(msg!=null) {
		%>
		<script type="text/javascript">
			alert('아이디와 비번 확인');
		</script>
		<%
	}
%>
	<form action="loginChk.jsp">
	<table>
		<caption>로그인 화면</caption>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				
			</td>
		</tr>
	</table>
	</form>
</body>
</html>