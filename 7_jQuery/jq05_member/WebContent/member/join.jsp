<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='../css/join.css' rel='stylesheet'>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	$(function() {
		$('#id').keyup(function() {
			$.ajax({
				url : '../joinIdConfirm.do',
				dataType : 'html',
				data : 'id=' + $('#id').val(),
				success : function(data, status) {
					$('#idConfirm').html(data);
				}
			});
		});

		$('#pwChk').keyup(function() {
			if ($(this).val() == $('#pw').val()) {
				$('#pwConfirm').html('비밀번호가 일치해요');
			} else {
				$('#pwConfirm').html('비밀번호가 일치하지 않아요');
			}
		});

		$('#email').keyup(function() {
			$.ajax({
				url : '../joinEmailConfirm.do',
				dataType : 'html',
				data : 'email=' + $('#email').val(),
				success : function(data, status) {
					$('#emailConfirm').html(data);
				}
			});
		});

		$('#frm').submit(function() {
			if ($('#idConfirm').html().trim() == "중복된 ID입니다.") {
				alert('아이디를 확인하세요');
				$('#idConfirm').focus();
				return false;
			}
			if ($('#pwConfirm').html().trim() == "비밀번호가 일치하지 않아요") {
				alert('비밀번호를 확인하세요');
				$('#pwConfirm').focus();
				return false;
			}
			if ($('#emailConfirm').html().trim() == "중복된 email입니다.") {
				alert('email을 확인하세요');
				$('#emailConfirm').focus();
				return false;
			}
		}//function
		);

		$("#datepicker").datepicker(
				{
					dateFormat : 'yy-mm-dd',
					maxDate : 0,
					changeMonth : true,
					changeYear : true,
					firstDay : 0,
					showOtherMonths : true,
					monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ],
					
					dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
					dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ]
				});
	});
</script>
</head>
<body>
	<div id="joinForm_wrap">
		<form action="../join.do" method="post" id="frm">
			<div id="join_title">회원가입</div>
			<table>
				<tr>
					<th><label for="id">아이디</label></th>
					<td><input type="text" name="id" id="id" class="id"><br>
						<span id="idConfirm"></span></td>
				</tr>
				<tr>
					<th><label for="pw">비밀번호</label></th>
					<td><input type="password" name="pw" id="pw" class="pw"></td>
				</tr>
				<tr>
					<th><label for="pwChk">비밀번호확인</label></th>
					<td><input type="password" name="pwChk" id="pwChk"
						class="pwChk"> <br> <span id="pwConfirm"></span></td>
				</tr>
				<tr>
					<th><label for="name">이름</label></th>
					<td><input type="text" name="name" id="name" class="name"></td>
				</tr>
				<tr>
					<th><label for="birth">생년월일</label></th>
					<td><input type="text" name="birth" id="datepicker"
						class="birth"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><input type="radio" name="gender" value="m"
						checked="checked" id="m"><label for="m">남자</label> <input
						type="radio" name="gender" value="f" id="f"><label for="f">여자</label>
					</td>
				</tr>
				<tr>
					<th><label for="email">이메일</label></th>
					<td><input type="email" name="email" id="email" class="email">
						<br> <span id="emailConfirm"></span></td>
				</tr>
				<tr>
					<th><label for="tel">전화번호</label></th>
					<td><input type="tel" name="phone" id="phone" class="phone">
					</td>
				</tr>
				<tr>
					<th><label for="address">주소</label></th>
					<td><input type="text" name="address" id="address"
						class="address"></td>
				</tr>
				<tr>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="가입하기"
						class="joinBtn_style" id="submit"> <input type="reset"
						value="다시하기" class="joinBtn_style"> <input type="button"
						value="로그인" class="joinBtn_style"
						onclick="location.href='../loginView.do'"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>