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

<link href="${conPath }/css/style.css" rel="stylesheet"> 
<script
src="https://code.jquery.com/jquery-3.4.1.js">
</script>
<script>


</script>
</head>
<body>
	
	<c:if test="${not empty writeResult }">
		<script>
			alert(${writeResult});
		</script>
	</c:if>
	
	<c:if test="${not empty modifyResult }">
		<script>
			alert('${modifyResult}');
		</script>
	</c:if>

	<c:if test="${not empty deleteResult}">
		<script>
			alert('${deleteResult}');
		</script>
	</c:if>

	<c:if test="${not empty replyResult}">
		<script>
			alert('${replyResult}');
		</script>
	</c:if>

	<jsp:include page="../main/header.jsp"/>

	<div id="content_form">
		<table>
			<thead>
				<tr>
					<th>게시판입니다.</th>
				</tr>
			</thead>
			<c:if test="${not empty member }">
			<tbody>
				<tr>
					<th><h5>
							<a href="${conPath }/write_view.do">~~~글쓰기~~~</a>
						</h5></th>
				</tr>
			</tbody>
			</c:if>
			
		</table>

		<table>
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
						<td colspan="6">작성한 글이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${boardsList.size() ne 0 }">
					<c:forEach var="board" items="${boardsList }">
					<tr onclick="location.href='${conPath }/content_view.do?fId=${board.fId }&pageNum=${pageNum }'">
						<td>${board.fId }</td>
					
						<td>${board.mName }</td>
					
						<td style="text-align: left;">
						<c:forEach var="i" begin="1" end="${board.fIndent }">
							&nbsp; &nbsp; &nbsp;
								<c:if test="${i eq board.fIndent }">
									┖
								</c:if>					
						</c:forEach>
						${board.fTitle }
						
						</td>
					
						<td>${board.fIp }</td>
					
						<td>${board.fRdate }</td>
					
						<td>${board.fHit }</td>
					</tr>
					</c:forEach>
				</c:if>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">
						<c:if test="${startPage ne 1}">
							<a href="${conPath }/list.do?pageNum=${startPage-1}">[ 이전 ]</a>
						</c:if>
						<c:forEach var="i" begin="${startPage }" end="${endPage }">
							<c:if test="${i ne pageNum }">
							<a href="${conPath }/list.do?pageNum=${i}">[ ${i } ]</a>
							</c:if>
							<c:if test="${i eq pageNum }">
							<b style="color:red">[ ${i } ]</b>
							</c:if>
						</c:forEach>
						
						
						<c:if test="${endPage ne pageCnt}">
							<a href="${conPath }/list.do?pageNum=${endPage+1}">[ 다음 ]</a>
						</c:if>
					</td>
				</tr>
			
			
			</tfoot>
		
		</table>
	
	
	
</div>

		<jsp:include page="../main/footer.jsp"/>
</body>
</html>