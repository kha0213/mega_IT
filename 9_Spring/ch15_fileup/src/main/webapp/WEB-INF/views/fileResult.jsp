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
	<h1>파일 업로드 결과 ${fileResult }</h1>
	<h1>파일1 ${fileNames[0] }</h1>
	<h1>파일2 ${fileNames[1] }</h1>
	<h1>파일3 ${fileNames[2] }</h1>
	<img src="${conPath }/upload/${fileNames[0] }" alt="파일1">
	<img src="${conPath }/upload/${fileNames[1] }" alt="파일2">
	<img src="${conPath }/upload/${fileNames[2] }" alt="파일3">
</body>
</html>