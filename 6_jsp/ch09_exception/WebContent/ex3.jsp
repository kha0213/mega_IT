<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="x.jsp">없는 파일 클릭하면 400error</a>
	
	<% 
	//String nullpoint = request.getParameter("xx").toLowerCase();  //NullPointException
	// Integer.parseInt("x");  //NumberFormatException
	int[] arr = {10,20,30};
	for(int i=0;i<100;i++){
		out.print(arr[i]);
	}
	%>
	
	
</body>
</html>