<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript"
		src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
		charset="utf-8"></script>
<script>
	$(document).ready(function(){



	});

</script>



</head>
<body>
<div id="naver_id_login"></div>
<script type="text/javascript">
		var clientId = "LsBPexGeKhecQjzWoxFD";
		var callbackUrl = "http://localhost:8181/Team_PJ_Funding/main/mainCallBack.jsp";
		var naver_id_login = new naver_id_login(clientId, callbackUrl);
		var state = naver_id_login.getUniqState();
		naver_id_login.setButton("white", 3, 40);
		naver_id_login.setDomain("localhost:8181/main/main.jsp");
		naver_id_login.setState(state);
		naver_id_login.setPopup();
		naver_id_login.init_naver_id_login();
</script>
<h1>main</h1>
</body>
</html>