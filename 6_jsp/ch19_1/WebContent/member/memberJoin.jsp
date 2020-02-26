<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<!-- <link href='../css/style.css' rel='stylesheet'> -->
</head>
<script src="${conPath }/js/join.js">
</script>

<body style="padding:30px">
	<div class="container">
	<form action="${conPath }/memberJoin.do" method="post" name="join_frm">
	<table class="table table-dark table-bordered table-striped table-hover">
	<thead class="thead-dark">
    <tr>
      <th colspan="2" class="text-center"><h2 class="display-6">회원가입</h2></th>
    </tr>
  </thead>
  <tbody class="text-center">
	<tr>
	<th>아이디</th><td><input type="text" name="id" class="form-control" ></td>
	</tr>
	<tr>
	<th>비밀번호</th><td><input type="password" name="pw" class="form-control"></td>
	</tr>
	<tr>
	<th>비밀번호확인</th><td><input type="password" name="pwChk" class="form-control"></td>
	</tr>
	<tr>
	<th>이름</th><td><input type="text" name="name" class="form-control"></td>
	</tr>
	<tr>
	<th>메일주소</th><td><input type="email" name="email" class="form-control"></td>
	</tr>
	<tr>
	<th>생년월일</th><td><input type="date" name="tempbirth" class="form-control"></td>
	</tr>
	<tr>
	<th>주소</th><td><input type="text" name="address" class="form-control"></td>
	</tr>
	<tr>
	<td colspan="2"><input type="button" value="회원가입" onclick="infoConfirm()" class="btn btn-primary">
	<input type="reset" value="취소" class="btn btn-secondary">
	<input type="button" value="로그인" onclick="location.href='login.jsp'" class="btn btn-info"></td>
	</tr>
	</tbody>
	</table>
	</form>
	</div>
</body>
</html>