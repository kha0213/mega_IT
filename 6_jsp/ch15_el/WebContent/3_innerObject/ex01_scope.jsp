<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container">

 <form action="ex02_scope.jsp">
 	<p>이름 <input type="text" name="name"></p>
 	<p>ID <input type="text" name="id"></p>
 	<p>PW <input type="password" name="pw"></p>
 	<p><input type="submit"></p>
 </form>
 </div>
 <%
 	pageContext.setAttribute("pageName", "pageValue");
 	request.setAttribute("requestName", "requestValue");
 	session.setAttribute("sessionName", "sessionValue");
 	application.setAttribute("applicationName", "applicationValue");
 	
 	//forward 할 객체 생성
	RequestDispatcher dispatcher = request.getRequestDispatcher("ex02_scope.jsp?name=hong&id=aaa&pw=11");
 	dispatcher.forward(request, response);
 	
 %>
 
<%--  <jsp:forward page="ex02_scope.jsp">
 	<jsp:param value="홍길동" name="name"/>
 	<jsp:param value="aaa" name="id"/>
 	<jsp:param value="111" name="pw"/>
 	</jsp:forward> --%>
 
 <h3>페이지내  attribute : <%=pageContext.getAttribute("pageName") %></h3>
 <h3>request내  attribute : <%=request.getAttribute("requestName") %></h3>
 <h3>세션내  attribute : <%=session.getAttribute("sessionName") %></h3>
 <h3>application내  attribute : <%=application.getAttribute("applicationName") %></h3>
 <hr>
 
 <h3>페이지내  attribute : ${pageScope.pageName }</h3>
 <h3>request내  attribute : ${requestScope.requestName }</h3>
 <h3>session내  attribute : ${sessionScope.sessionName }</h3>
 <h3>application내  attribute : ${applicationScope.applicationName }</h3>
 <hr>
 
 <h3>페이지내  attribute : ${pageName }</h3>
 <h3>request내  attribute : ${requestName }</h3>
 <h3>session내  attribute : ${sessionName }</h3>
 <h3>application내  attribute : ${applicationName }</h3>











<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>