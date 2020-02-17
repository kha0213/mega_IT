<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<link rel="stylesheet" href="../css/join.css">

<script>
	window.onload = function() {
		var go = document.getElementsByTagName('form')[0];
		go.onsubmit = function() {
			if (go.pw.value != go.pwChk.value) {
				alert('비밀번호가 서로 다릅니다.');
				go.pw.focus();
				return false;
			}
			if (!go.gender[0].checked && !go.gender[1].checked) {
				alert('성별을 선택해주세요');
				return false;
			}

		};
	};
</script>
</head>
<body>
	<%@include file="header.jsp"%>
	<div id="joinForm_wrap">
		<form action="joinPro.jsp" method="post">
			<div id="join_title">
				<h2>회원가입</h2>
			</div>
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" required="required"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pw" required="required"></td>
				</tr>
				<tr>
					<th>비밀번호확인</th>
					<td><input type="password" name="pwChk" required="required"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" required="required"></td>
				</tr>
				<tr>
					<th>전화</th>
					<td><input type="text" name="tel" required="required"
						value="010"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="date" name="birth"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><input type="radio" name="gender" value="man">남자 <input
						type="radio" name="gender" value="woman">여자</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="가입하기"> <input
						type="reset" value="다시하기"> <input type="button"
						value="로그인" onclick="location.href='login.jsp'"></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>