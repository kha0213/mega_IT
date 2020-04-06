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
	<div id="content">
	<jsp:include page="../main/header.jsp"/>
	<table>	
		<caption>${book.bnum }번 책 상세보기</caption>
		<tr>
			<th>책 제목</th>
			<td>${book.btitle }</td>
		</tr>
		<tr>
			<th>책 저자</th>
			<td>${book.bwriter}</td>
		</tr>
		<tr>
			<th>책 등록일</th>
			<td><fmt:formatDate value="${book.brdate }" pattern="yyyy년MM월dd일(E요일)"/></td>
		</tr>
		<tr>
			<th>책 이미지1</th>
			<td><img src="${conPath }/bookImgFileUpload/${book.bimg1}" alt="책 이미지1" /></td>
		</tr>
		<tr>
			<th>책 이미지2</th>
			<td><img src="${conPath }/bookImgFileUpload/${book.bimg2}" alt="책 이미지2" /></td>
		</tr>
		<tr>
			<th>책 설명</th>
			<td>${book.binfo }</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location.href='book.do?method=modify&pageNum=${param.pageNum}">책 수정</button>
				<button onclick="location.href='book.do?method=list&pageNum=${param.pageNum}'">목록</button>
			</td>
		</tr>
	</table>
	<jsp:include page="../main/footer.jsp"/>
	</div>
</body>
</html>