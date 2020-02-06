<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동전이 있는 곳을 맞춰봐</title>
<style type="text/css">
	form{
		width:300px;
		margin: 100px auto;
	}
	input {
		padding: 20px;
		margin: 10px;
	}
	p{
		color: red;
		font-weight: bold;
		text-align: center;
		font-size: 1.5em;
	}
	input[type='submit']{
		width: 100px;
		background-color: lightblue;
		font-size: 1.5em;
	}

</style>
</head>
<body>
	<form action="08_yabaCertification.jsp">
	<table>
		<tr>
			<td>
				<input type="submit" value="1번" name="su">
			</td>
			<td>
				<input type="submit" value="2번" name="su">
			</td>
			<td>
				<input type="submit" value="3번" name="su">
			</td>
		</tr>
		<tr>
		<td colspan="3">
		<%
		String msg = request.getParameter("msg");
		if(msg!=null){
			out.print(msg);
		}else{
			%><br><br><br><%
		}
		%>	
		</td>
		</tr>
	</table>
	</form>
</body>
</html>