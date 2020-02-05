1<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%! int i; //선언부에 선언된 변수는 전역변수 (초기화하지 않으면 0으로 default)
	StringBuilder strBul = new StringBuilder("좋아요 ");
	private int sum(int a,int b){
		return a+b;
	}
%>
<body>
<%  int j=0;
	String str="좋아요";
	i++; j++;
	strBul.append("<span>♥</span>");
	str+=("<span>♥</span>");
	/* out.println("<h2>i(전역) = "+i+"/<h2>");
	out.println("<h2>j = "+j+"/<h2>");
	out.println("<h2>strBul(전역) = "+strBul+"</h2>");
	out.println("<h2>str = "+str+"</h2>");  */
%>
	<h2>sum(2,4)함수 결과 = <%=sum(2,4) %></h2>
	<h2>i(전역) = <%=sum(2,4) %></h2>
	<h2>j = <%=j %></h2>
	<h2>strBul(전역) = <%=strBul %></h2>
	<h2>str = <%=str %></h2>
</body>
</html>