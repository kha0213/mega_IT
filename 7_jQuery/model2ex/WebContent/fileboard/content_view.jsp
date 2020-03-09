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

<c:if test="${not empty modifyResult }">
<script>
	alert('${modifyResult}');
</script>
</c:if>


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
      <td>${content_view.fId }</td>
    </tr>
    <tr>
      <th scope="row">작성자이름</th>
      <td>${content_view.mName }</td>
    </tr>
   <tr>
      <th scope="row">제목</th>
      <td>${content_view.fTitle }</td>
    </tr>
    <tr>
      <th scope="row">본문</th>
      <td><pre>${content_view.fContent }</pre></td>
    </tr>
    <tr>
      <th scope="row">작성일</th>
      <td><fmt:formatDate value="${content_view.fRdate }" type="both" dateStyle="full" timeStyle="long"/> </td>
    </tr>
    <tr>
      <th scope="row">조회수</th>
      <td><fmt:formatNumber value="${content_view.fHit }" groupingUsed="true"/> </td>
    </tr>
    <tr>
      <th scope="row">IP</th>
      <td>${content_view.fIp }</td>
    </tr>
    <tr>
      <th scope="row">업로드 파일 img</th>
      <td><img src="fileboardUp/${content_view.fFileName }" alt="uploadFile">
      </td>
    </tr>
  </tbody>
   <tfoot>
    <tr>
      <th scope="col" colspan="2" class="text-center">
      
      <c:if test="${content_view.mName eq member.mName }">
      	<button type="button" class="btn btn-lg btn-outline-primary" 
      	onclick="location.href='${conPath}/Bmodify_view.do?fId=${content_view.fId }&pageNum=${param.pageNum }'">수정</button>
      </c:if>
      	
		<button type="button" class="btn btn-lg btn-outline-info"
		onclick="location.href='${conPath}/list.do?fId=${content_view.fId }&pageNum=${param.pageNum }'">목록</button>
		
      <c:if test="${not empty member || not empty admin }">
      <button type="button" class="btn btn-lg btn-outline-success"
		onclick="location.href='${conPath}/Breply_view.do?fId=${content_view.fId }&pageNum=${param.pageNum }'">답변</button>
      </c:if>
      <c:if test="${content_view.mName eq member.mName || not empty admin}">
		<button type="button" class="btn btn-lg btn-outline-danger"
		onclick="location.href='${conPath}/Bdelete.do?fId=${content_view.fId }&pageNum=${param.pageNum }'">삭제</button>
	 </c:if>
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