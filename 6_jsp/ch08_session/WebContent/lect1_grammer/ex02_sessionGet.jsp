<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
	//특정한 session을값 가져오기
		out.print("<h1>특정한 session을값 가져오기</h1><hr>");
		String sessionName = (String)session.getAttribute("sessionName");
		Integer myNum = (Integer)session.getAttribute("myNum");
		String id = (String)session.getAttribute("id");
		out.print("<h2>sessionName : "+session.getAttribute("sessionName")+"</h2>");
		out.print("<h2>myNum : "+session.getAttribute("myNum")+"</h2>");
		out.print("<h2>id : "+session.getAttribute("id")+"</h2>");
	//모든 session List출력
		out.print("<h1>모든 session 속성들 List</h1><hr>");
		Enumeration<String> sNames = session.getAttributeNames();
		int cnt=0;
		while(sNames.hasMoreElements()){
			String temp = sNames.nextElement();
			out.print(temp+" : " +session.getAttribute(temp)+"<br>");
			cnt++;
		}
		if(cnt==0){
			out.println("session 속성이 없습니다.");
		}
	//특정한 session을을 삭제(로그아웃)
		out.print("<h1>특정한 session을을 삭제(로그아웃)</h1><hr>");
		session.removeAttribute("myNum");
	
	//모든 session List출력
		out.print("<h1>모든 session List출력</h1><hr>");
		cnt=0;
		sNames = session.getAttributeNames();
		while(sNames.hasMoreElements()){
			String temp = sNames.nextElement();
			out.print(temp+" : " +session.getAttribute(temp)+"<br>");
			cnt++;
		}
		if(cnt==0){
			out.println("session 속성이 없습니다.");
		}
	//모든 session을 삭제(로그아웃)
		out.print("<h1>모든 session을 삭제(로그아웃)</h1><hr>");
		session.invalidate(); //setAttribute 했던 모든 session 값 다 삭제.
	// session의 유효성 보기 
	out.print("<h1>session의 유효성 보기</h1><hr>");
	if(request.isRequestedSessionIdValid()){//유효한 session있니? 인데 잘 안씀
		out.print("session valid<br>");
	}else{
		out.print("session isvalid<br>");
	}
	%>
	<h2>session ID : <%=session.getId() %></h2>
	<h2>session 유효시간 : <%=session.getMaxInactiveInterval() %></h2>	
	
	
</body>
</html>