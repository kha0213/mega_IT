<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="com.tj.personinfo.PersonInfo" id="pi" scope="request"/>
<jsp:setProperty property="name" name="pi" param="name"/>
<jsp:setProperty property="age" name="pi" param="age"/>
<jsp:setProperty property="gender" name="pi" param="gender"/>
<jsp:setProperty property="address" name="pi" param="address"/>
<jsp:forward page="piView.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>