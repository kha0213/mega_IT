package com.tj.ch18.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.tj.ch18.dao.MemberDao;
import com.tj.ch18.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	
	@Override
	public int idConfirm(String mid) {
		return memberDao.idConfirm(mid);
	}
	
	@Override
	public String loginCheck(String mid,String mpw,HttpSession httpSession) {
		Member dbMember = getMember(mid);
		String result = "";
		if(dbMember == null) {
			result = "없는 ID입니다.";
		}else if(mpw.equals(dbMember.getMpw())) {
			httpSession.setAttribute("member", dbMember);
			result = "[로그인 성공]";
		}else {
			result = "[로그인 실패] 아이디와 패스워드를 확인하세요";
		}
		return result;
	}

	@Override
	public int joinMember(final Member member,HttpSession httpSession) {
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = 
					"  <h1>"+member.getMname()+"님의 회원가입을 축하드립니다</h1>"+
					"  <div>" + 
					"    <div>" + 
					"      아무개 싸이트에서만 쓰실 수 있는 쿠폰을 드립니다\n\n" + 
					"      <hr color=\"red\"/>" + 
					"    </div>" + 
					"    <div>" + 
					"      <p style=\"color:blue;\" >파란색 글씨부분</p>" + 
					"      <p style=\"color:red;\">빨간색 글씨부분</p>" + 
					"    </div>" + 
					"  </div>" + 
					"    <div>" + 
					"      <img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20170315064553027.png\" />\n" + 
					"    </div>" + 
					"    <div style=\"font-weight: blod; font-size: 1.2em;\">아무개 사이트 일동</div>\n" + 
					"    <div style=\"color:red;\">서울시 종로구 몰라17길 51 어떤빌딩 8층</div>";

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(member.getMmail()));
				mimeMessage.setFrom(new InternetAddress("hybrid0506@gmail.com"));
				mimeMessage.setSubject(member.getMname()+"("+member.getMid()+")<b>님 회원가입 감사합니다(html)</b>");
				mimeMessage.setText(content, "utf-8", "html");
			}
		};
		mailSender.send(message);
		httpSession.setAttribute("mid", member.getMid());
		return memberDao.joinMember(member);
	}

	@Override
	public Member getMember(String mid) {
		return memberDao.getMember(mid);
	}

	@Override
	public int modifyMember(Member member, HttpSession httpSession) {
		int result = memberDao.modifyMember(member); 
		if(result == 1) {
			httpSession.setAttribute("member", member);
		}
		return result;
	}

}
