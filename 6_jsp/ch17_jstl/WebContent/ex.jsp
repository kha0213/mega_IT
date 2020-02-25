<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<style>
	td{
		text-align: center;
	}

</style>
</head>
<body style="padding: 30px">
	<div class="container">
		<form class="form-inline">
			<table class="table table-dark">
				<thead>
					<tr>
						<td colspan="8">
							<div class="form-row align-items-center">
								<div class="col"><strong>이름</strong></div>
								
								<div class="col">
									<input type="text" class="form-control" placeholder="이름">
								</div>
								<div class="col"><strong>직업</strong></div>
								<div class="col">
									<input type="text" class="form-control" placeholder="직업">
								</div>
								<div class="col">
								 <button type="submit" class="btn btn-secondary">검색</button>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="col">사번</th>
						<th scope="col">이름</th>
						<th scope="col">직책</th>
						<th scope="col">상사</th>
						<th scope="col">입사</th>
						<th scope="col">급여</th>
						<th scope="col">상여</th>
						<th scope="col">부서</th>
						<!-- 8 -->
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>Mark</td>
						<td>Otto</td>
						<td>@mdo</td>
						<td>@mdo</td>
						<td>@mdo</td>
						<td>@mdo</td>
						<td>@mdo</td>
					</tr>
					
				</tbody>
			</table>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>