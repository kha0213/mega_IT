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
<%-- <link href="${conPath }/css/style.css" rel="stylesheet"> --%>
</head>
<body>
	<c:set var="SUCCESS" value="1" />
	<c:set var="FAIL" value="0" />
	<c:if test="${writeResult eq SUCCESS }">
		<script>
			alert('글쓰기 성공하였습니다.');
		</script>
	</c:if>
	<c:if test="${writeResult eq FAIL }">
		<script>
			alert('글쓰기 실패하였습니다.');
		</script>
	</c:if>
	<c:if test="${modifyResult eq SUCCESS }">
		<script>
			alert('글수정 성공하였습니다.');
		</script>
	</c:if>
	<c:if test="${modifyResult eq FAIL }">
		<script>
			alert('글수정 실패하였습니다.');
		</script>
	</c:if>
	<c:if test="${deleteResult eq SUCCESS }">
		<script>
			alert('글삭제 성공하였습니다.');
		</script>
	</c:if>
	<c:if test="${deleteResult eq FAIL }">
		<script>
			alert('글삭제 실패하였습니다.');
		</script>
	</c:if>
	<c:if test="${replyResult eq SUCCESS }">
		<script>
			alert('답변글 쓰기 성공하였습니다.');
		</script>
	</c:if>
	<c:if test="${replyResult eq FAIL }">
		<script>
			alert('답변글 쓰기 실패하였습니다.');
		</script>
	</c:if>


	<div class="container-fluid">
		<table class="table table-info table-hover text-center">
			<thead>
				<tr class="text-center">
					<th scope="col">게시판입니다.</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th><h2>
							<a href="${conPath }/write_view.do" class="text-secondary">~~~글쓰기~~~</a>
						</h2></th>
				</tr>
			</tbody>
		</table>

		<table class="table table-dark table-hover text-center table-striped">
			<thead>
				<tr>
					<th scope="col">글번호</th>
					<th scope="col">작성자</th>
					<th scope="col">제목</th>
					<th scope="col">IP</th>
					<th scope="col">작성일</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${boardsList.size() eq 0 }">
					<tr>
						<th colspan="6">해당 페이지의 글이 없습니다.</th>
					</tr>
				</c:if>
				<c:if test="${boardsList.size() ne 0 }">
					<c:forEach items="${boardsList}" var="board">
						<tr>
							<td scope="col">${board.bid }</td>
							<td scope="col">${board.bname }</td>
							<td scope="col" class="text-left">
								<c:forEach var="i" begin="1" end="${board.bindent }">
									&nbsp; &nbsp; &nbsp;
									<c:if test="${i eq board.bindent }">
										┖
									</c:if>
								</c:forEach> 
								<a href="${conPath }/content_view.do?bid=${board.bid}&pageNum=${pageNum}" class="text-danger">
								${board.btitle }
								</a>
							</td>
							<td scope="col">${board.bip }</td>
							<td scope="col"><fmt:formatDate value="${board.bdate }" pattern="yyyy년MM월dd일(E)"/></td>
							<td scope="col">${board.bhit }</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	
	<div class="row justify-content-md-center">
		<c:if test="${startPage>BLOCKSIZE }">
			<a href="${conPath }/boardsList.do?pageNum=${startPage-1}"> [이전] &nbsp; </a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
				<b>&nbsp;[${i }]&nbsp;</b>
			</c:if>
			<c:if test="${i ne pageNum }">
				<a href="${conPath }/boardsList.do?pageNum=${i}">&nbsp;[${i }]&nbsp;</a>
			</c:if>
		</c:forEach>
		
		<c:if test="${endPage ne pageCnt }">
			<a href="${conPath }/boardsList.do?pageNum=${endPage+1}"> &nbsp; [다음]</a>
		</c:if>
	</div>
</div>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>