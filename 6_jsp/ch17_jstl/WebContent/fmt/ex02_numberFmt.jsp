<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="num" value="12345678.87897" ></c:set>
	<p>첫번째 수는 세자리마다 , <br> 두번째 수는 소수점 2자리까지(소수점 한자리까지만 있는 경우 한자리만 출력) <br>
	세번째 수는 소수점 2자리까지(반드시, 소수점 한자리까지만 있는 경우 뒤에 0)
	</p>
	<p>num : ${num }</p>
	<p>첫번째 : <fmt:formatNumber value="${num }" groupingUsed="true"></fmt:formatNumber> </p>
	<p>두번째 : <fmt:formatNumber value="${num }" pattern="#,###.##"></fmt:formatNumber> </p>
	<p>세번째 : <fmt:formatNumber value="${num }" pattern="#,###.00"></fmt:formatNumber> </p>
</body>
</html>