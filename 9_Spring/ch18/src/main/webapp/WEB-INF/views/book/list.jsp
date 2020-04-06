<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
	$(document).ready(function(){



	});

</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<table>
			<caption> 도서 </caption>
			<tr>
			<c:forEach var="book" items="${list }">
				<td>
					${book.btitle }<br>
					<a href="${conPath }/book.do?method=detail&bnum=${book.bnum}&pageNum=${param.pageNum}">
					<img src="${conPath }/bookImgFileUpload/${book.bimg1}"></a><br>
					${book.bwriter } 著 <br>
					출판일 : ${book.brdate }
				</td>
			</c:forEach>
			</tr>
		</table>	
		<div class="paging">
				<c:if test="${paging.startPage ne 1 }">
					<a href="book.do?method=list&pageNum=${paging.startPage-1 }">[ 이 전 ]</a>
				</c:if>
			<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
				<c:if test="${i eq param.pageNum }">
					<b>[ ${i } ]</b>			
				</c:if>
				<c:if test="${i ne param.pageNum }">
					<a href="book.do?method=list&pageNum=${i }">[ ${i } ]</a>			
				</c:if>	
				
				
			</c:forEach>
				<c:if test="${paging.endPage ne paging.pageCnt }">
					<a href="book.do?method=list&pageNum=${param.endPage+1 }">[ 다 음 ]</a>
				</c:if>
		
		</div>	
	
	
	
	
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>