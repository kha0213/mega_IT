package com.tj.ex;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.member.MemberDao;
import com.tj.member.MemberDto;

public class JoinMemberService implements Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDto member = new MemberDto();
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setBirth(Timestamp.valueOf(request.getParameter("tempbirth")+" 00:12:34"));
		member.setAddress(request.getParameter("address"));
		MemberDao mDao = MemberDao.getInstance();
		request.setAttribute("joinResult", mDao.insertMember(member));
		
	}

}
