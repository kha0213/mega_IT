<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");
String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#content_form {
	width: 1000px;
	margin: 0px auto;
	height: 600px;
	text-align: center;
	color: #003300;
	padding-top:100px;
}
</style>
<link href='../css/style2.css' rel='stylesheet'>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="content_form">
	<%String fnum =request.getParameter("fnum"); 
		String pageNum = request.getParameter("pageNum");
	%>
	<table>
		<caption><%=fnum %>번 글삭제</caption>
		<tr><td>
		<fieldset>
			<legend>삭제하기 위한 암호 입력</legend>
			<form action="fboardDeletePro.jsp" method="post">
				<input type="hidden" name="pageNum" value="<%=pageNum%>">
				<input type="hidden" name="fnum" value="<%=fnum%>">
				<p>암호 <input type="password" name="fpw" required="required" class="btn"></p>
				<p><input type="submit" value="삭제" class="btn">
					<input type="reset" value="삭제취소" class="btn" onclick="history.back()"></p>
			</form>
		</fieldset>
	</table>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>