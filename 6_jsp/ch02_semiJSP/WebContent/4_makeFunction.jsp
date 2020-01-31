<%-- 지시자 <%@ ~ %> : 페이지의 속성 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 스크립트릿 <% ~ %> : 자바 코드 --%>
	<!-- HTML주석 -->
	<%
	//자바주석
	/*자바여러 줄 
	주석*/
	long result = power(2, 3);
	%>
	<p>2의 3승은 <%=result %></p>
	<p>9의 19승은 <%=power(9, 19) %></p>
	<%! private long power(int a, int b){
		long temp = 1;
		for(int i=1;i<=b;i++){
			temp *= a;
		}
		return temp;
	}
	%>
	<%-- 표현식 <%= ~ %>: 자바코드에서 실행한 결과를 포함한 식 --%>
	<%-- 선언부 <%! ~ %> : 함수 및 변수 선언 --%>
</body>
</html>