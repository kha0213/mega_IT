<%@page import="com.tj.ex.dto.ProductDto"%>
<%@page import="com.tj.ex.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<%
	String pname = request.getParameter("pname");
	ProductDao pDao = ProductDao.getInstance();
	ProductDto product = pDao.getProduct(pname);
	if(product==null){
		out.print("미취급 상품");
	}else{
		out.print(product.getPstock()+"개 재고");
	}


%>





</body>
</html>