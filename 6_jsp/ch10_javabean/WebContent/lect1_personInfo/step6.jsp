<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="com.tj.personinfo.PersonInfo" id="pi" scope="request"/>
<jsp:setProperty property="*" name="pi"/>
<%-- property 랑 param이랑 다 같아야 한다. --%>
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