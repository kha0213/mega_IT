/**
 * 
 */

function infoConfirm(){
	if(modify_frm.pw.value!=modify_frm.pwChk.value){
		alert('새 비밀번호를 확인하세요');
		modify_frm.pw.value='';
		modify_frm.pwChk.value='';
		modify_frm.pw.focus();
		return;
	}
	modify_frm.submit();
}