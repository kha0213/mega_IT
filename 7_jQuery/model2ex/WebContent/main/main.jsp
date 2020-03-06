<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#content_form {
		width: 800px; height:500px; line-height:500px;
		margin: 0 auto; text-align: center; font-size: 3em;
	}
</style>
</head>
<body>
	<c:if test="${not empty errorMsg }">
		<script>
		alert('${errorMsg }');
		history.back();
		</script>
	</c:if>
	<c:if test="${not empty loginResult }">
		<script>
		alert('${loginResult }');
		</script>
	</c:if>
	<c:if test="${not empty logoutResult }">
		<script>
		alert('${logoutResult }');
		</script>
	</c:if>
	<c:if test="${not empty modifyResult }">
		<script>
		alert('${modifyResult }');
		</script>
	</c:if>


	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		main
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>