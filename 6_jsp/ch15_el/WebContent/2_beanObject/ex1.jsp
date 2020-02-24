<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="com.tj.ex.MemberInfo" scope="page"/>
	<!-- member가 pageScope안에 들어왔다. -->
	<jsp:setProperty property="*" name="member"/>
	<h2>bean 태그를 이용한 정보 출력</h2>
	<h3>이름 <jsp:getProperty property="name" name="member"/></h3>
	<h3>ID <jsp:getProperty property="id" name="member"/></h3>
	<h3>PW <jsp:getProperty property="pw" name="member"/></h3>
	<hr>
	<h2>getter를 이용한 정보 출력</h2>
	<h3>이름 : <%=member.getName() %></h3>
	<h3>ID : <%=member.getId()%></h3>
	<h3>PW : <%=member.getPw() %></h3>
	<hr>
	<h2>el 표기법을 이용한 정보 출력</h2>
	<h3>이름 : ${member.name }</h3>
	<h3>ID : ${member.id }</h3>
	<h3>PW : ${member.pw }</h3>



</body>
</html>