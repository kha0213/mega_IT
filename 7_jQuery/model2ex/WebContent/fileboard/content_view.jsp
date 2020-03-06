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
<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<table class="table table-bordered table-hover">
  <thead>
    <tr>
      <th scope="col" colspan="2" class="text-center">글 상세보기</th>
    </tr>
  </thead>
  <tbody>
  	<tr>
      <th scope="row">글번호</th>
      <td>${content_view.bid }</td>
    </tr>
    <tr>
      <th scope="row">작성자이름</th>
      <td>${content_view.bname }</td>
    </tr>
   <tr>
      <th scope="row">제목</th>
      <td>${content_view.btitle }</td>
    </tr>
    <tr>
      <th scope="row">본문</th>
      <td><pre>${content_view.bcontent }</pre></td>
    </tr>
    <tr>
      <th scope="row">작성일</th>
      <td><fmt:formatDate value="${content_view.bdate }" type="both" dateStyle="full" timeStyle="long"/> </td>
    </tr>
    <tr>
      <th scope="row">조회수</th>
      <td><fmt:formatNumber value="${content_view.bhit }" groupingUsed="true"/> </td>
    </tr>
    <tr>
      <th scope="row">IP</th>
      <td>${content_view.bip }</td>
    </tr>
  </tbody>
   <tfoot>
    <tr>
      <th scope="col" colspan="2" class="text-center">
      	<button type="button" class="btn btn-lg btn-outline-primary" 
      	onclick="location.href='${conPath}/modify_view.do?bid=${param.bid }&pageNum=${param.pageNum }'">수정</button>
		<button type="button" class="btn btn-lg btn-outline-info"
		onclick="location.href='${conPath}/boardsList.do?bid=${param.bid }&pageNum=${param.pageNum }'">목록</button>
		<button type="button" class="btn btn-lg btn-outline-success"
		onclick="location.href='${conPath}/reply_view.do?bid=${param.bid }&pageNum=${param.pageNum }'">답변</button>
		<button type="button" class="btn btn-lg btn-outline-danger"
		onclick="location.href='${conPath}/delete.do?bid=${param.bid }&pageNum=${param.pageNum }'">삭제</button>
      </th>
    </tr>
  </tfoot>
</table>
	
	</div>
<jsp:include page="../main/footer.jsp"/>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>