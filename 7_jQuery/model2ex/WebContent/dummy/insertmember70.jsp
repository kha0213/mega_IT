<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="com.tj.ex.dto.MemberDto"%>
<%@page import="com.tj.ex.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

MemberDao mDao = MemberDao.getInstance();
for(int i=0;i<70;i++){
	String mId="id"+i;
	String mPw="pw"+i;
	String mName="name"+i;
	String mEmail="email"+i;
	String mPhoto="photo"+i;
	Date mBirth = null;
	String mAddress="address"+i;
	Timestamp mRdate = null;
	MemberDto member = new MemberDto(mId,mPw,mName,mEmail,mPhoto,mBirth,mAddress,mRdate);
	mDao.joinMember(member);
	
}



%>
</body>
</html>