<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function chk(){
		if(isNaN(Number(frm.su1.value)) || isNaN(Number(frm.su2.value))){
			alert('구구단은 숫자만 입력해라');
			frm.su1.value="";
			frm.su2.value="";
			return false;
		}else if(Number(frm.su1.value)>=Number(frm.su2.value)){
			alert('앞에가 숫자 더 작은거 입력해라잉');
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<h1>원하는 구구단 수를 입력하세요</h1>
	<form action="6_gugudanOut.jsp" method="get" name="frm" onsubmit="return chk()">
		<p>단 수 : <input type="text" name="su1" required="required">
		~단 수 <input type="text" name="su2" required="required">단까지
		</p>
		<p><input type="submit" value="구구단 출력"></p>
	</form>
</body>
</html>