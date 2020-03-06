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

<script
src="https://code.jquery.com/jquery-3.4.1.js">
</script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$(function(){
			$('input[name=mId]').keyup(function(){
				
				$.ajax({
					url : '${conPath}/memberloginCheck.do',
					dataType : 'html',
					data : "mId="+$('input[name=mId]').val(),
					success : function(data){
						$('#idConfirm').html(data);
					}
				})
			});
		
			$('input[name=mPwChk]').keyup(function(){
				var mId = $('input[name=mPw]').val();
				var mIdChk = $('input[name=mPwChk]').val();
				if(mId == mIdChk){
					$('#pwConfirm').html('비밀번호가 서로 같습니다.');
				}else{
					$('#pwConfirm').html('비밀번호가 서로 다릅니다.');
				}
			});
		
			$('form').submit(function(){
				if($('#idConfirm').html().trim() == "중복된 아이디입니다."){
					alert('ID를 확인하세요');
					$('input[name=mId]').focus();
					return false;
				}
				if($('#pwConfirm').html().trim() == "비밀번호가 서로 다릅니다."){
					alert('비밀번호를 확인하세요');
					$('input[name=mPwChk]').focus();
					return false;
				}
			});
			
			$( "#datepicker" ).datepicker({
		    	dateFormat : 'yy/mm/dd' ,
		    	monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		    	showMonthAfterYear : true,
		    	yearSuffix : '년',
		    	showOtherMonths : true,
		    	dayNamesMin:['일','월','화','수','목','금','토'],
		    	changeMonth: true,
		        changeYear: true
		       
		    });
			
		
});
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<form action="${conPath }/join.do" method="post" enctype="multipart/form-data">
		<table>
			<caption>회원가입</caption>
			<tr><th>아이디</th>
					<td><input type="text" name="mId" required="required">
					<div id="idConfirm"></div>
					</td>
			</tr>
			<tr><th>비밀번호</th>
					<td><input type="password" name="mPw" required="required"></td>
			</tr>
			<tr><th>비밀번호확인</th>
					<td><input type="password" name="mPwChk" required="required">
					<div id="pwConfirm"></div></td>
			</tr>
			<tr><th>이름</th>
					<td><input type="text" name="mName" required="required"></td>
			</tr>
			<tr><th>메일</th><td><input type="email" name="mEmail"></td></tr>
			<tr><th>사진</th><td><input type="file" name="mPhoto"></td></tr>
			<tr><th>생년월일</th><td><input type="text" name="mBirth" id="datepicker"></td></tr>
			<tr><th>주소</th><td><input type="text" name="mAddress"></td></tr>
			<tr><td colspan="2">
						<input type="submit" value="회원가입" class="btn">
						<input type="button" value="로그인" class="btn"
								onclick="location.href='${conPath}/loginView.do'">
		</table>
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>















