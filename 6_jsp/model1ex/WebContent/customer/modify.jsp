<%@page import="com.tj.model1ex.dto.CustomerDto"%>
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
<link href='<%=conPath%>/css/join.css' rel='stylesheet'>
</head>
<body>
	<%
		CustomerDto dto = (CustomerDto)session.getAttribute("customer");
		if((CustomerDto)session.getAttribute("customer")==null) response.sendRedirect("../main/main.jsp");
		
	
	%>
	<jsp:include page="../main/header.jsp"/>
	<div id="joinForm_wrap">
		<form action="modifyOk.jsp" method="post" >
			<div id="join_title">정보수정</div>
			
			<table>
				<tr>
					<th><label for="cid">아이디</label></th>
					<td><input type="text" name="cid" id="cid" readonly="readonly"
					value=<%=dto.getCid() %>></td>
				</tr>
				<tr>
					<th><label for="cpw">현비밀번호</label></th>
					<td><input type="password" name="preCpw" id="cpw"
						required="required"></td>
				</tr>
				<tr>
					<th><label for="cpwChk">새비밀번호확인</label></th>
					<td><input type="password" name="newCpw" id="cpwChk"></td>
				</tr>
				<tr>
					<th><label for="cname">이름</label></th>
					<td><input type="text" name="cname" id="cname"
						required="required" value="<%=dto.getCname()%>"></td>
				</tr>
				<tr>
					<th><label for="ctel">전화</label></th>
					<td><input type="tel" name="ctel" id="ctel"
						required="required" value="<%=dto.getCtel()%>"></td>
				</tr>
				<tr>
					<th><label for="cemail">이메일</label></th>
					<td><input type="email" name="cemail" id="cemail" value="<%=dto.getCemail()==null?"":dto.getCemail()%>"></td>
				</tr>
				<tr>
					<th><label for="caddress">주소</label></th>
					<td><input type="text" name="caddress" id="caddress" value="<%=dto.getCaddress()==null?"":dto.getCaddress()%>"></td>
				</tr>
				<tr>
					<th><label for="cbirth">생년월일</label></th>
					<td><input type="date" name="tempbirth" id="cbirth"
						required="required" value=<%=dto.getCbirth() %>></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><input type="radio" name="cgender" value="m"
						<%if(dto.getCgender().equals("m")){%>
						checked="checked" 
					<%}%>
						 id="m"><label for="m">남자</label> <input
						type="radio" name="cgender" value="f" id="f"
					<%if(dto.getCgender().equals("f")){%>
						checked="checked" 
					<%}%>
						><label
						for="f">여자</label></td>
				</tr>
				<tr>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정하기"
						class="joinBtn_style"> <input type="reset" value="다시하기"
						class="joinBtn_style"> <input type="button" value="이전으로"
						class="joinBtn_style" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>

	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>