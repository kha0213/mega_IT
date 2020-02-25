<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"></c:set>
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

</style>
<%-- <link href="${conPath }/css/style.css" rel="stylesheet"> --%>
</head>.
<body style="padding: 30px">
	<div class="container">
		<form class="form-inline" action="${conPath }/Ex11_empList" method="post">
			<table class="table table-dark table-hover">
				<thead>
					<tr class="bg-primary">
						<td colspan="8" class="text-center">
							<div class="form-row align-items-center">
								<div class="col">
									<strong>이름</strong>
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="search name" name="ename" value="${param.ename.toUpperCase() }">
								</div>
								<div class="col">
									<strong>직업</strong>
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="search job" name="job" value="${param.job.toUpperCase() }">
								</div>
								<div class="col">
									<button type="submit" class="btn btn-secondary">검색</button>
								</div>
							</div>
						</td>
					</tr>
					<tr class="text-center">
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
					<c:if test="${empty emps || emps.size() eq 0 }">
						<tr class="text-center">
							<td colspan="8">검색된 사원이 없습니다. 전체사원은 빈 칸에 검색을 눌러주세요</td>
						</tr>
					</c:if>
					<c:if test="${emps.size() != 0 }">
						<c:forEach var="emp" items="${emps}">
							<tr class="text-center">
								<td>${emp.empno }</td>
								<td>${emp.ename }</td>
								<td>${emp.job }</td>
								<td>${emp.mgr }</td>
								<td><fmt:formatDate value="${emp.hiredate }" type="both" dateStyle="long" timeStyle="medium"  /></td>
								<td>${emp.sal }</td>
								<td>${emp.comm }</td>
								<td>${emp.deptno }</td>
							</tr>
						</c:forEach>
					</c:if>


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