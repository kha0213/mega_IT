<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!int num1,num2; %>
	<%
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		
		out.print("<h3>num1 = "+num1+", num2 = "+num2+"</h3>");
		out.print("<h3>num1+num2 = "+(num1+num2)+"</h3>");
		out.print("<h3>num1-num2 = "+(num1-num2)+"</h3>");
		out.print("<h3>num1*num2 = "+(num1*num2)+"</h3>");
		
		try{
		out.print("<h3>num1/num2 = "+(num1/num2)+"</h3>");			
		}catch(Exception e){
			System.out.println(e.getMessage());
			out.print("<h3>num1/num2 = 0을 나눌 순 없어요</h3>");
		}
		
		
		out.print("<h3>DONE</h3>");
	%>
	
	
	
</body>
</html>