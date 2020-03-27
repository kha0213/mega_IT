package com.tj.homework;

public class EnvInfo {
	private String ipNum;
	private String portNum;
	private String userId;
	private String userPw;
	public String getIpNum() {
		return ipNum;
	}
	public void setIpNum(String ipNum) {
		this.ipNum = ipNum;
	}
	public String getPortNum() {
		return portNum;
	}
	public void setPortNum(String portNum) {
		this.portNum = portNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	@Override
	public String toString() {
		return "EnvInfo [ipNum=" + ipNum + ", portNum=" + portNum + ", userId=" + userId + ", userPw=" + userPw + "]";
	}
	
	
}
