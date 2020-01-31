<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h1{
		color:red;
	}
</style>
<script type="text/javascript">
	window.onload = function(){
		alert('Hello World');
	}
</script>
</head>
<body>
	<h1>Hello, World</h1>
	<%
	int total = 0;
	for(int cnt=1;cnt<=100;cnt++){
		total += cnt;
	}	
	%>
	<h2>1부터 100까지 더한 값은? <%=total %>입니다.</h2>
</body>
</html>