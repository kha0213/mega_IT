package com.tj.dto;

import java.sql.Timestamp;

public class BoardDto {
	private int num;
	private String writer;
	private String subject;
	private String content;
	private String email;
	private int hit;
	private String pw;
	private int ref;
	private int re_step;
	private int re_level;
	private String ip;
	private Timestamp rdate;
	public BoardDto() {
		super();
	}

	public BoardDto(int num, String writer, String subject, String content, String email, int hit, String pw, int ref,
			int re_step, int re_level, String ip, Timestamp rdate) {
		super();
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.email = email;
		this.hit = hit;
		this.pw = pw;
		this.ref = ref;
		this.re_step = re_step;
		this.re_level = re_level;
		this.ip = ip;
		this.rdate = rdate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Timestamp getRdate() {
		return rdate;
	}
	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "BoardDto [num=" + num + ", writer=" + writer + ", subject=" + subject + ", content=" + content
				+ ", email=" + email + ", hit=" + hit + ", pw=" + pw + ", ref=" + ref + ", re_step=" + re_step
				+ ", re_level=" + re_level + ", ip=" + ip + ", rdate=" + rdate + "]";
	}
}
