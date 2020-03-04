package com.tj.ex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.ex.dto.Member_dto;

public class Member_dao {

	public static final int EXISTENT = 0;
	public static final int NOTEXISTENT = 1; // 회원가입 진행
	public static final int LOGIN_FAIL = 0;
	public static final int LOGIN_SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;

	private Member_dao() {

	}

	private static Member_dao instance;

	public static Member_dao getInstance() {
		if (instance == null)
			instance = new Member_dao();
		return instance;
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}

	// !!!!! 회원 목록 array
	public ArrayList<Member_dto> getListMember(int startRow, int endRow) {
		ArrayList<Member_dto> members = new ArrayList<Member_dto>();
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE DESC) A)"
				+ "    WHERE RN BETWEEN ? AND ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String mId = rs.getString("mId");
				String mPw = rs.getString("mPw");
				String mName = rs.getString("mName");
				String mEmail = rs.getString("mEmail");
				String mPhoto = rs.getString("mPhoto");
				Date mBirth = rs.getDate("mBirth");
				String mAddress = rs.getString("mAddress");
				Date mRdate = rs.getDate("mRdate");
				members.add(new Member_dto(mId, mPw, mName, mEmail, mPhoto, mBirth, mAddress, mRdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return members;
	}

	// 글 수정
	public int modifyMember(String mPw, String mName, String mEmail, String mPhoto, Date mBirth, String mAddress,
			String mId) {
		int result = FAIL;
		String sql = "UPDATE mvc_member SET MPW=?, MNAME=?,MEMAIL=?, MPHOTO=?,MBIRTH=?,MADDRESS=? WHERE MID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mPw);
			pstmt.setString(2, mName);
			pstmt.setString(3, mEmail);
			pstmt.setString(4, mPhoto);
			pstmt.setDate(5, mBirth);
			pstmt.setString(6, mAddress);
			pstmt.setString(7, mId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		return result;
	}

	// 글 수정
	public int modifyMember(Member_dto member) {
		String mPw = member.getmPw();
		String mName = member.getmName();
		String mEmail = member.getmEmail();
		String mPhoto = member.getmPhoto();
		Date mBirth = member.getmBirth();
		String mAddress = member.getmAddress();
		String mId = member.getmId();
		return modifyMember(mPw, mName, mEmail, mPhoto, mBirth, mAddress, mId);
	}

	// !!!!!전체 회원 수
	public int getTotalMemberCount() {
		int result = 0;
		String sql = "SELECT COUNT(*) FROM MVC_MEMBER";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 로그인 위한 체크
	public int loginMemberIdPwCheck(String mId, String mPw) {
		int result = LOGIN_FAIL;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID=? AND MPW=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, mPw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = LOGIN_SUCCESS;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// session를 위한 로그인멤버
	public Member_dto getMember(String mId) {
		Member_dto member = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member_dto();
				member.setmId(rs.getString("mId"));
				member.setmPw(rs.getString("mPw"));
				member.setmName(rs.getString("mName"));
				member.setmEmail(rs.getString("mEmail"));
				member.setmPhoto(rs.getString("mPhoto"));
				member.setmBirth(rs.getDate("mBirth"));
				member.setmAddress(rs.getString("mAddress"));
				member.setmRdate(rs.getDate("mRdate"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return member;
	}

	// mId 중복체크
	public int mIdConfirm(String mId) {
		int result = EXISTENT;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = EXISTENT;
			} else {
				result = NOTEXISTENT;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	public int joinMember(String mId, String mPw, String mName, String mEmail, String mPhoto, Date mBirth,
			String mAddress) {
		int result = FAIL;
		String sql = "INSERT INTO mvc_member (MID,MPW,MNAME,MEMAIL,MPHOTO,MBIRTH,MADDRESS) VALUES"
				+ "    (?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, mPw);
			pstmt.setString(3, mName);
			pstmt.setString(4, mEmail);
			pstmt.setString(5, mPhoto);
			pstmt.setDate(6, mBirth);
			pstmt.setString(7, mAddress);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		return result;

	}

}
