<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>표현식 태그 이용 &lt;%= %&gt;</h2>
	<p>산술연산 : 10+1 = <%=10+1 %></p>
	<p>산술연산 : 10/0.0 = <%=10/0.0 %></p>
	<p>관계연산 : 1>2 = <%=1>2 %></p>
	<p>관계연산 : 1 == 2 = <%=1==2 %></p>
	<p>관계연산 : 1 != 2 = <%=1!=2 %></p>
	<p>조건연산 : <%=1>2?" 1은 2보다 큽니다":"1은 2보다 크지 않습니다." %></p>
	<p>논리연산 :  (1>2) || (1&lt;2) = <%= (1>2) || (1<2)%></p>
	<p>로그인 여부 : <%=session.getAttribute("customer")==null? "로그인 전":"로그인 후" %></p>
	<p>로그인 여부 : <%=session.getAttribute("customer")!=null? "로그인 후":"로그인 전" %></p>
	<p>pageNum파라미터 여부 : <%=request.getParameter("pageNum")==null? "비었음":"안비었음" %></p>
	<p>num파라미터 값  : <%=request.getParameter("num") %></p>
	
	<h2>EL 표기법 이용 (표현식안에 쓸 수 있는 연산자는 다 사용가능) </h2>
	<p>산술연산 : 10+1 = ${10+1}</p>
	<p>산술연산 : 10/0.0 = ${10/0.0}</p>
	<p>관계연산 : 1>2 = ${1>2}</p>
	<p>관계연산 : 1==2 = ${1 eq 2}</p>
	<p>관계연산 : 1!=2 = ${1 != 2}</p>
	<p>조건연산 : ${1>2?" 1은 2보다 큽니다":"1은 2보다 크지 않습니다."  }</p>
	<p>논리연산 :  (1>2) || (1&lt;2) = ${ (1>2) || (1<2)}</p>
	<p>로그인 여부 : ${empty sessionScope.customer ? "로그인 전":"로그인 후" }</p> <!-- seesionScope는 생략가능 -->
	<p>로그인 여부 : ${not empty customer ? "로그인 후":"로그인 전" }</p>
	<p>pageNum파라미터 여부 : ${empty param.pageNum ? "비었음":"안비었음"}</p>
	<p>num파라미터 값  : ${param.num.toUpperCase() }</p> <!-- 해당 파라미터가 없어도 예외 발생 안 함 -->
</body>
</html>