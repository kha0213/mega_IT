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
</head>
<body>
	<div class="container">
	<form action="${conPath }/Breply.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="fId" value="${replyView.fId }">
	<input type="hidden" name="fGroup" value="${replyView.fGroup }">
	<input type="hidden" name="fStep" value="${replyView.fStep }">
	<input type="hidden" name="fIndent" value="${replyView.fIndent }">
	<input type="hidden" name="pageNum" value="${param.pageNum }">
	<input type="hidden" name="mId" value="${member.mId }">
		<table class="table table-dark table-hover text-center">
  <thead>
    <tr>
      <th colspan="2">${replyView.fId }번 글의 답글쓰기</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">작성자</th>
      <td scope="col"><input type="text" name="mName" readonly="readonly" value="${member.mName }" class="form-control"
      ></td>
    </tr>
    <tr>
      <th scope="row">글제목</th>
      <td scope="col"><input type="text" name="fTitle" required="required" class="form-control"
      value="${replyView.fTitle }의 답글"></td>
    </tr>
    <tr>
      <th scope="row">본문</th>
      <td scope="col"><textarea rows="5" cols="20" name="fContent" class="form-control"></textarea></td>
    </tr>
    <tr>
      <th scope="row">파일</th>
      <td scope="col"><input type="file" name="fFileName" class="form-control"></td>
    </tr>
  </tbody>
  <tfoot>
  	<tr>
  		<td colspan="2" class="text-center">
  		<input type="submit" value="답글쓰기" class="btn btn-primary">
  		<input type="reset" value="초기화" class="btn btn-success">
  		<input type="button" value="뒤로가기" class="btn btn-warning" onclick="history.back()">
  		<input type="button" value="목록" class="btn btn-info" onclick="location.href='${conPath}/boardsList.do?pageNum=${param.pageNum }'">
  		</td>
  	</tr>
  </tfoot>
</table>
	</form>
	</div>



<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>