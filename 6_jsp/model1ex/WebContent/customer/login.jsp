<%@page import="com.tj.model1ex.dto.CustomerDto"%>
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
<link rel="stylesheet" href="../css/login.css">
</head>
<body>
	<%
		String cid = (String)session.getAttribute("cid");
		if ((CustomerDto)session.getAttribute("dto") != null) {
			response.sendRedirect("../main/main.jsp");
		}
	%>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="loginForm_wrap">
		<div id="login_title">로그인</div>
		<form action="loginPro.jsp" method="post">
			<table>


				<tr>
					<th>아이디</th>
					<td><input type="text" id="cid" name="cid"
						value="<%=cid==null?"":cid%>"></td>
				</tr>

				<tr>
					<th>비밀번호</th>
					<td><input type="password" id="cpw" name="cpw"></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="로그인"
						class="loginBtn_style"></td>
				</tr>
				<tr>
					<td colspan="2" id="login_findIdPw">
						<%
							String msg = request.getParameter("msg");
							if (msg != null) {
								out.print(msg);
							}
						%>

					</td>
				</tr>
				<tr>
					<td colspan="2" id="login_join">아직 회원이 아니신가요? <a
						href="join.jsp">회원가입</a></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>