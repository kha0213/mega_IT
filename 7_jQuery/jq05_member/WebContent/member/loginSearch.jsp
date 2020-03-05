<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
src="https://code.jquery.com/jquery-3.4.1.js">
</script>
<script>
$(function(){
$('#search').click(function(){
	

	var name = $('#name').val();
	var email = $('#email').val();
	$.ajax({
		url : '../loginSearch.do',
		dataType : 'html',
		data : 'name=' + name+'&email='+email,
		success : function(item, status) {
			$('#id').val(item.id);
			$('#pw').val(item.pw);
		}
	});
	
	}
	
);
	
});

</script>
</head>
<body>


<table>
	<caption>비밀번호 찾기</caption>
	<tr>
	 	<td>이름: <input type="text" id="name"></td>
	 	<td>이메일: <input type="text" id="email"></td>
	</tr>
	<tr>
		<td colspan="2"><button id="search">찾기</button></td>
	</tr>
	<tr>
	 	<td>당신의 아이디: <input type="text" id="id" readonly="readonly"></td>
	 	<td>당신의 비번: <input type="text" id="pw" readonly="readonly"></td>
	</tr>
</table>

</body>
</html>