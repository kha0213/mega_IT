<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
  
<script>






	$(function(){
		IMP.init("imp70203497"); 
		
		
		
		$('#click').click(function(){
			IMP.certification({ // param
			    merchant_uid: 'merchant_' + new Date().getTime()
			  }, function (rsp) { // callback
			    if (rsp.success) {
			      alert('인증성공');
			    } else {
			    	alert('인증실패');
			    }
			  });
		});
		
		
		
		
		
		
		
		
		$('form').submit(function(){
			var kor = $('input[name="kor"]').val();
			var eng = $('input[name="eng"]').val();
			var mat = $('input[name="mat"]').val();
			if($('input[name="name"]').val().length<1){
				alert('이름을 1글자 이상 입력하세요');
				return false;
			}else if(kor<1 || kor>100){
				alert('국어점수를 1과 100사이의 정수로 입력하세요');
				return false;
			}else if(eng<1 || eng>100){
				alert('영어점수를 1과 100사이의 정수로 입력하세요');
				return false;
			}else if(mat<1 || mat>100){
				alert('수학점수를 1과 100사이의 정수로  입력하세요');
				return false;
			}
			
		});
	});	
</script>
</head>
<body>
	<h1><button id="click">클릭</button></h1>
	<p class="text-right font-red">"현재 총 ${cnt }명"</p>
	<form action="${conPath }/input.do" method="get">
	<table>
	<caption>개인 정보 입력</caption>
	<tr><th>이 름:</th><td><input type="text" name="name"></td></tr>
	<tr><th>국 어:</th><td><input type="number" name="kor"></td></tr>
	<tr><th>영 어:</th><td><input type="number" name="eng"></td></tr>
	<tr><th>수 학:</th><td><input type="number" name="mat"></td></tr>
	<tr><td colspan="2" class="text-center"><input type="submit" value="입 력"></td></tr>
	</table>
	</form>
</body>
</html>