<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"></script>

</head>
<body>
	<p class="text-right font-red">"현재 총 ${cnt }명"</p>
	<table>
	<caption class="font-size-up">결과는 다음과 같습니다.</caption>
	<tr><th>이 름:</th><td>${student.name }</td></tr>
	<tr><th>국 어:</th><td>${student.kor }</td></tr>
	<tr><th>영 어:</th><td>${student.eng }</td></tr>
	<tr><th>수 학:</th><td>${student.mat }</td></tr>
	<tr><th>총 점:</th><td>${student.sum }</td></tr>
	<tr><th>평 균:</th><td>${student.avg }</td></tr>
	<tr><td colspan="2" class="text-center"><input type="button" value="뒤로가기" onclick="history.back()">
	<input type="button" value="다시입력" onclick="location.href='inputForm.do'">
	</td></tr>
	</table>
</body>
</html>