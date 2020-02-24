<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<style type="text/css">
	body{
		padding: 20px;
	}
</style>
</head>
<body>
<form action="">
	 <div class="form-group">
    <label>ID</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="id" aria-describedby="emailHelp">
    <small id="emailHelp" class="form-text text-muted">공부 열심히 해봐요</small>
  </div>
  <div class="form-group">
    <label>입력할 횟수</label>
    <input type="number" class="form-control" id="exampleInputPassword1" name="su">
  </div>
   <button type="submit" class="btn btn-primary">입력</button>
</form>
<c:forEach var="i" begin="1" end="${param.su }">
	<p>${i }번째 : ${param.id }님 안녕하세요</p>
</c:forEach>





<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>