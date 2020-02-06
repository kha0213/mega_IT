<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동전이 있는 곳을 맞춰봐</title>
<style type="text/css">
	table{
		width: 300px;
		margin: 100px auto;
	}
	td{
		text-align: center;
	}
	tr:first-child td{
		color:red;
		font-weight: bold;
	}
	tr td{
		font-weight: bold;
	}
	button {
		width:100px;
		background-color: lightblue;
	}
	p{
		font-size: 1.5em;
	}
</style>

</head>
<body>
	<%
		int su = request.getParameter("su").charAt(0)-'0';
		int com = (int)(Math.random()*3)+1;
		String msg="";
		if(su!=com){
			msg = "<p>Wrong! Try Again!<br><br>("+su+"은(는) 아니고 정답은 "+com+")";
			msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect("08_yaba.jsp?msg="+msg);
		}
	%>
		<table>
		<tr><td>
		<p>정답입니다</p>
		</td></tr>
		<tr><td>
		<p>동전이 있던 곳은 <%=com %></p>
		</td></tr>
		<tr><td>
		<button onclick="location.href='08_yaba.jsp'">다시 도전</button>
		</td></tr>
		</table>

</body>
</html>