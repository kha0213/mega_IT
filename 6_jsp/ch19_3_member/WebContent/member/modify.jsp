<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form action="${conPath }/modify.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="dbmPhoto" value="${member.mPhoto }">
		<table class="table text-center table-bordered">
  <thead>
    <tr>
      <th scope="col" colspan="3">회원 가입</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">아이디</th>
      <td><input type="text" name="mId" readonly="readonly" class="form-control" value="${member.mId }"></td>
      <td rowspan="4"><img alt="사진" src="${conPath }/img/${member.mPhoto }"></td>
    </tr>
    <tr>
      <th scope="row">비밀번호</th>
      <td><input type="password" name="mPw" required="required" class="form-control"></td>
    </tr>
    <tr>
      <th scope="row">이름</th>
      <td><input type="text" name="mName" required="required" class="form-control"
      	value="${member.mPw }"></td>
    </tr>
    <tr>
      <th scope="row">메일</th>
      <td><input type="text" name="mEmail" class="form-control"
      value="${member.mEmail }"></td>
    </tr>
    <tr>
      <th scope="row">사진</th>
      <td colspan="2"><input type="file" name="mPhoto" class="form-control"></td>
    </tr>
     <tr>
      <th scope="row">생년월일</th>
      <td colspan="2"><input type="date" name="mBirth" class="form-control"
      value="${member.mBirth }"></td>
    </tr>
    <tr>
      <th scope="row">주소</th>
      <td colspan="2"><input type="text" name="mAddress" class="form-control"
      value="${member.mAddress }"></td>
    </tr>
    <tr>
    	<td scope="row" colspan="3">
    		<input type="submit" value="정보수정" class="btn btn-outline-success">
    		<input type="reset" value="초기화" class="btn btn-outline-danger">
    		<input type="button" value="뒤로가기" class="btn btn-outline-primary" onclick='history.back()'>
    	</td>
    </tr>
   
  </tbody>
</table>
	</form>
	</div>



<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>