<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<div align="center">
		<hr width="500" color="green">
		<h2>파일 업로드</h2>
		<hr width="500" color="green">
	</div>
	<form action="${conPath }/fileUpLoad" method="post" enctype="multipart/form-data">
		<p>첨부파일1 : <input type="file" name="file1"></p>
		<p>첨부파일2 : <input type="file" name="file2"></p>
		<p>첨부파일3 : <input type="file" name="file3"></p>
		<p><input type="submit" value="입력"></p>
	</form>
</body>
</html>