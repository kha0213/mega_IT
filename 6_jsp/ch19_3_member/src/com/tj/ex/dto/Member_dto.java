package com.tj.ex.dto;

import java.sql.Date;

public class Member_dto {
	private String mId;
	private String mPw;
	private String mName;
	private String mEmail;
	private String mPhoto;
	private Date mBirth;
	private String mAddress;
	private Date mRdate;

	public Member_dto() {
		super();
	}

	public Member_dto(String mId, String mPw, String mName, String mEmail, String mPhoto, Date mBirth, String mAddress,
			Date mRdate) {
		super();
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.mEmail = mEmail;
		this.mPhoto = mPhoto;
		this.mBirth = mBirth;
		this.mAddress = mAddress;
		this.mRdate = mRdate;
	}

	@Override
	public String toString() {
		return "Member_dto [mId=" + mId + ", mPw=" + mPw + ", mName=" + mName + ", mEmail=" + mEmail + ", mPhoto="
				+ mPhoto + ", mBirth=" + mBirth + ", mAddress=" + mAddress + ", mRdate=" + mRdate + "]";
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPw() {
		return mPw;
	}

	public void setmPw(String mPw) {
		this.mPw = mPw;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getmPhoto() {
		return mPhoto;
	}

	public void setmPhoto(String mPhoto) {
		this.mPhoto = mPhoto;
	}

	public Date getmBirth() {
		return mBirth;
	}

	public void setmBirth(Date mBirth) {
		this.mBirth = mBirth;
	}

	public String getmAddress() {
		return mAddress;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public Date getmRdate() {
		return mRdate;
	}

	public void setmRdate(Date mRdate) {
		this.mRdate = mRdate;
	}

}
