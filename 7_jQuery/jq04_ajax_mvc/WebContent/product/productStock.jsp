<%@page import="com.tj.ex.dto.ProductDto"%>
<%@page import="com.tj.ex.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
</head>

<body>


<c:if test="${empty product }">
	<span>미취급상품입니다</span>
</c:if>
<c:if test="${not empty product }">
	<span>${product.pstock }개 남았어여</span>
</c:if>






</body>
</html>