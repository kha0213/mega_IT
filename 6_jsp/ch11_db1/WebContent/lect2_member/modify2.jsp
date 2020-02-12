<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='../css/style.css' rel='stylesheet'>
</head>
<body>
	<%
		if (session.getAttribute("validMember") == null) {
			response.sendRedirect("login.jsp");
		}
		if (request.getParameter("result") != null) {
	%>
	<script type="text/javascript">
		alert('현 비밀번호가 맞지 않아 수정이 불가합니다.');
	</script>
	<%
		}
		String id = (String) session.getAttribute("id");
		String name = (String) session.getAttribute("name");
		String phone1 = (String) session.getAttribute("phone1");
		String phone2 = (String) session.getAttribute("phone2");
		String phone3 = (String) session.getAttribute("phone3");
		String gender = (String) session.getAttribute("gender");
	%>
	<form action="../ModifyOk2" method="post">
		<table>
			<caption>회원정보수정</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" readonly="readonly" size="20"
					value="<%=id%>"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" required="required"
					value="<%=name%>" size="20"></td>
			</tr>
			<tr>
				<th>현 비밀번호</th>
				<td><input type="password" name="oldPw" required="required"
					size="20"></td>
			</tr>
			<tr>
				<th>새 비밀번호</th>
				<td><input type="password" name="newPw"
					placeholder="미 입력시 비밀번호 유지" size="20"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><select name="phone1">
						<option
							<%if (phone1 == null)
				out.print("selected='selected'");%>></option>
						<option
							<%if ("02".equals(phone1))
				out.print("selected='selected'");%>>02</option>
						<option
							<%if ("031".equals(phone1))
				out.print("selected='selected'");%>>031</option>
						<option
							<%if ("010".equals(phone1))
				out.print("selected='selected'");%>>010</option>
				</select> <input type="text" name="phone2" size="4" value=<%=phone2==null? "":phone2%>>
					<input type="text" name="phone3" size="4" value=<%=phone3==null? "":phone3%>></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><input type="radio" name="gender" value="m"
					<%if ("m".equals(gender)) {
				out.print("checked='checked'");
			}%>>남
					<input type="radio" name="gender" value="f"
					<%if ("f".equals(gender)) {
				out.print("checked='checked'");
			}%>>여</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정"> <input
					type="reset" value="취소"> <input type="button" value="로그아웃"
					onclick="location.href='logout.jsp'"></td>
			</tr>
		</table>
	</form>
</body>
</html>