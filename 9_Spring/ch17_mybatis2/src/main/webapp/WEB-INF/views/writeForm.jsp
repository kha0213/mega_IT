<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
		function chk(){
			if(!frm.empno.value){
				alert('사번을 입력 후 중복체크하세요');
				frm.empno.focus();
			}else{
				var mgr = frm.mgr.options[frm.mgr.selectedIndex].value;
				location.href = 'confirmNo.do?empno='+frm.empno.value+'&mgr='+mgr;
			}
		}
	</script>
  
  <script>
  $( function() {
    $( "#datepicker" ).datepicker(
    		{	dateFormat : 'yy-mm-dd',
					monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
					showMonthAfterYear : true,
					yearSuffix : '년', // "2018년 7월"
					showOtherMonths : true, // 다른 달도 화면에 출력
					dayNamesMin : ['일','월','화','수','목','금','토']
    		}
    );
  } );
  </script>
</head>
<body>
	<form action="write.do" method="post" name="frm">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		
		<table>
			<caption>회원가입</caption>
			<tr><th>사번</th>
					<td><input type="number" name="empno" required="required"
						maxlength="4" value="${param.empno }" style="width:110px;">
						<input type="button" value="중복확인" onclick="chk()"><br>
						<c:if test="${msg!=null }">${msg }</c:if>
				</td>
			</tr>
			<tr><th>이름</th>
					<td><input type="text" name="ename" required="required"></td>
			</tr>
			<tr><th>업무</th>
					<td><input type="text" name="job" required="required"></td>
			</tr>
			<tr><th>관리자사번</th>
					<td><select name="mgr" class="width-90">
				<c:forEach items="${managerList }" var="manager">
				<option value="${manager.empno }">${manager.empno } - ${manager.ename } </option>
				</c:forEach>
			</select></td>
			</tr>
			<tr><th>입사일</th>
					<td><input type="text" name="temphiredate" required="required" id="datepicker"></td>
			</tr>
			<tr><th>급여</th>
					<td><input type="number" name="sal" required="required"></td>
			</tr>
			<tr><th>상여</th>
					<td><input type="number" name="comm" required="required"></td>
			</tr>
			<tr><th>부서코드</th>
					<td><select name="deptno" class="width-90">
				<c:forEach items="${deptList }" var="dept">
				<option value="${dept.deptno }">${dept.deptno }-${dept.dname }-${dept.loc }</option>
				</c:forEach>
			</select></td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="직원등록"></td></tr>
		</table>
	</form>
</body>
</html>