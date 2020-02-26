<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<c:if test="${joinResult==1 }">
		<script>alert('회원가입이 완료되었습니다.')</script>
	</c:if>
	<c:if test="${joinResult==0 }">
		<script>alert('회원가입이 실패되었습니다.')</script>
	</c:if>


	<div class="container">
		<table class="table">
			<thead class="text-center">
				<tr class="text-center"><td colspan="7"><h3>회원정보</h3></td></tr>
				<tr>
				<th>ID</th>
				<th>PW</th>
				<th>이름</th>
				<th>메일</th>
				<th>생일</th>
				<th>가입일</th>
				<th>주소</th>
				</tr>
			</thead>
		
			<tbody class="text-center">
			<c:if test="${empty memberList || memberList.size() eq 0 }">
				<tr><td colspan="7">가입한 회원이 없습니다.</td></tr>			
			</c:if>
			<c:if test="${memberList.size() ne 0 }">
				<c:forEach var="member" items="${memberList }">
					<tr>
					<td>${member.id }</td>
					<td><c:forEach begin="0" end="${member.pw.length() }" step="1">*</c:forEach>
					</td>
					<td>${member.name }</td>
					<td>${member.email }</td>
					<td><fmt:formatDate value="${member.birth }" pattern="MM월 dd일"/></td>
					<td><fmt:formatDate value="${member.rdate }" pattern="yy년 MM월 dd일(E)"/></td>
					<td>${member.address }</td>
					</tr>				
				</c:forEach>
			</c:if>
			<tr>
			<td colspan="7">
	<button onclick="location.href='${conPath}/memberJoinView.do'" class="btn btn-outline-primary btn-lg btn-block float-right">회원가입</button>
			
			</td>
			</tr>
			</tbody>
		
		</table>		
	
	</div>



<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>