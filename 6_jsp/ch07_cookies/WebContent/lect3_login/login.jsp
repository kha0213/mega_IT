<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="<%=conPath %>/css/style.css">
    <style type="text/css">
    	p{
    		text-align: center;
    		color: red;
    		font-size: 3em;
    	}
    
    </style>
</head>
<%
	Cookie[] cs = request.getCookies();
if(cs!=null){
	for(Cookie c : cs){
		if(c.getName().equals("id")){
			response.sendRedirect("welcome.jsp");
		}
	}
}

%>
<body>
	<jsp:include page="header.jsp"/>
    <form action="loginOk.jsp" method="post">
    	
        <table>
        	<caption>로그인</caption>
            <tr>
                <th>아이디</th>
                <td><input type="text" name="id" autofocus="autofocus"></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name="pw"></td>
            </tr>
            <tr>
                <td> </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="로그인">
                </td>
            </tr>
        </table>
    </form>
    <br>
   <%
   String msg = request.getParameter("msg");
   if(msg!=null){
	   out.println("<p>아이디와 비밀번호가 유효하지 않습니다.</p>");
   }
   
   
   %>
</body>

</html>