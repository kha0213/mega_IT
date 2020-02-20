<%@page import="java.sql.Date"%>
<%@page import="com.tj.model1ex.dao.CustomerDao"%>
<%@page import="com.tj.model1ex.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	CustomerDto c = new CustomerDto();
	CustomerDao cDao = CustomerDao.getInstance();
for(int i=0;i<100;i++){
	c.setCid("aa"+i);
	c.setCpw("111");
	if(i%2==0){
	c.setCname("롱롱이"+i);
	c.setCgender("m");
	}else{
		c.setCname("펭수"+i);
		c.setCgender("f");
	}
	c.setCtel("010-"+i+"77"+"9999");
	c.setCemail(i+"yaya@gmail.com");
	c.setCaddress("서울시");
	c.setCbirth(Date.valueOf("1901-03-"+(i%20+10)));
	cDao.insertCustomer(c);	
}
	response.sendRedirect("../main/main.jsp");


%>
</body>
</html>