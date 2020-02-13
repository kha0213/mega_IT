/**
 * join_frm.id.value 3글자 이상, join_frm, 이름, 메일
 */
function infoConfirm() {
	if(join_frm.id.value.length<3){
		alert('아이디는 3글자 이상 입력하세요.')
		join_frm.id.focus();
		return;
	}
	if(!join_frm.pw.value){
		alert('비밀번호는 필수 입력 사항입니다.');
		join_frm.pw.focus();
		return;
	}
	if(join_frm.pw.value!=join_frm.pwChk.value){
		alert('비밀번호가 서로 달라요.');
		join_frm.pw.value='';
		join_frm.pwChk.value='';
		join_frm.pw.focus();
		return;
	}
	if(!join_frm.name.value){
		alert('이름은 필수입력 사항입니다.');
		join_frm.name.focus();
		return;
	}
	if(join_frm.email.value.length!=0 && (
			join_frm.email.value.indexOf('@')<=0 ||
			join_frm.email.value.lastIndexOf('@')==join_frm.email.value.length-1 ||
			join_frm.email.value.lastIndexOf('@') > join_frm.email.value.lastIndexOf('.')
	)){
		alert('email형식이 올바르지 않습니다.');
		join_frm.email.focus();
		return;
	}
	
	if(!join_frm.tempbirth.value){
		alert('생년월일은 필수입력 사항입니다.');
		join_frm.tempbirth.focus();
		return;
	}
	
	join_frm.submit(); //강제로 submit 이벤트 발생
}