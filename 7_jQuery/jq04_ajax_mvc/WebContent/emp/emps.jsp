<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		width: 90%; margin: 10px auto;
	}
	th{
		background-color: black; color:white; padding: 10px;
	}
	td{
		text-align: center;
		background-color: #AAFFFF;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>사번</th>
			<th>사원명</th>
			<th>직책</th>
			<th>상사사번</th>
			<th>입사일</th>
			<th>급여</th>
			<th>상여</th>
			<th>부서번호</th>
		</tr>
		<c:forEach var="emp" items="${emps }">
		<tr>
			<td>${emp.empno }</td>
			<td>${emp.ename }</td>
			<td>${emp.job }</td>
			<td>${emp.mgr }</td>
			<td><fmt:formatDate value="${emp.hiredate }" pattern="yyyy년 MM월 dd일 (E)"/></td>
			<td><fmt:formatNumber value="${emp.sal }" groupingUsed="true"/></td>
			<td>${emp.comm }</td>
			<td>${emp.deptno }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="8">총 인원 ${emps.size() }명입니다.</td>
		</tr>
	</table>
</body>
</html>