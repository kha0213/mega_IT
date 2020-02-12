<%@page import="com.tj.dto.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='../css/style.css' rel='stylesheet'>

<script type="text/javascript">
	function chk(){
		var name = frm.name.value;
		var tel = frm.tel.value;
		location.href='friendInputList.jsp?name='+name+'&tel='+tel;
	}

</script>

</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		if(name==null) name="";
		String tel = request.getParameter("tel");
		if(tel==null) tel="";
	%>
	<form action="friendInputListPro.jsp" name='frm'>
		<table>

			<tr>
				<th>친구이름</th>
				<td><input type="text" name="name" required="required" value="<%=name%>"></td>
				<th>전화</th>
				<td><input type="text" name="tel" required="required" value="<%=tel%>"></td>
				<td><input type="submit" value="추가" ></td>
			 	<td><input type="button" value="검색" onclick="chk()"></td> 
			</tr>
		</table>
	</form>
	
	<%
	if(request.getParameter("add") == null){
	}
	else if (request.getParameter("add").equals("success")) {
	%>
	<script>
		alert('친구추가 성공');
	</script>
	<%
		}else{%>
			<script>
		alert('친구추가 실패');
	</script>
		<%}
	%>

	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화</th>
		</tr>
		<%
			FriendDao friendDao = FriendDao.getInstance();
			ArrayList<FriendDto> dtos = friendDao.selectChoose(name, tel);
			for (FriendDto dto : dtos) {
		%>
		<tr>
			<td><%=dto.getNo()%></td>
			<td><%=dto.getName()%></td>
			<td><%=dto.getTel()%></td>
		</tr>
		<%
			} //for
		%>
	</table>


</body>
</html>