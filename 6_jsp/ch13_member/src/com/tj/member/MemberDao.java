package com.tj.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	public static final int SUCCESS = 1; // 회원가입, 정보수정 할 때
	public static final int FAIL = 0; // 회원가입, 정보수정 실패
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공
	public static final int LOGIN_FAIL_ID = -1; // 로그인오류(ID)
	public static final int LOGIN_FAIL_PW = 0; // 로그인오류(PW)
	public static final int MEMBER_EXISTENT = 0; // 있는(중복된) ID
	public static final int MEMBER_NONEXISTENT = 1; // 없는 ID (사용가능)

	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	private MemberDao() {

	}
	// conn객체 가져오는 함수

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
	// 1.회원가입시 id중복체크 (매개변수 id)

	public int confirmId(String id) {
		int result = MEMBER_EXISTENT; // 초기화
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {// 중복된 ID(있는 ID)
				result = MEMBER_EXISTENT;
			} else {// 사용가능한 ID(없는 ID)
				result = MEMBER_NONEXISTENT;
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

	// 2.회원가입 (매개변수 : dto)
	public int insertMember(MemberDto dto) {
		int result = FAIL; // 초기화
		String sql = "INSERT INTO MEMBER (ID,PW,NAME,EMAIL,BIRTH,RDATE,ADDRESS) " + "VALUES (?,?,?,?,?,SYSDATE,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setTimestamp(5, dto.getBirth());
			pstmt.setString(6, dto.getAddress());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "회원가입 성공" : "회원가입 실패" + dto.toString());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(dto.toString());
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

	// 3.로그인 처리(매개변수 : id,pw)
	public int loginCheck(String id, String pw) {
		int result = LOGIN_FAIL_ID;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) { // id를 제대로 입력함
				String dbPw = rs.getString("PW");
				if (dbPw.equals(pw)) {
					result = LOGIN_SUCCESS;
				} else {
					result = LOGIN_FAIL_PW;
				}
			} else {// id오류
				result = LOGIN_FAIL_ID;
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}
	// 4.id로 DTO가져오기 (매개변수 : id)
	public MemberDto getMember(String id) {
		MemberDto dto = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {// 중복된 ID(있는 ID)
				dto = new MemberDto();
				dto.setId(id);
				dto.setName(rs.getString("NAME"));
				dto.setPw(rs.getString("PW"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setBirth(rs.getTimestamp("BIRTH"));
				dto.setRdate(rs.getDate("RDATE"));
				dto.setAddress(rs.getString("ADDRESS"));
			} else {// 사용가능한 ID(없는 ID)
				
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
		return dto;
	}
	
	
	// 5.회원정보 수정 (매개변수 : dto)
	
	public int updateMember(MemberDto dto) {
		int result = FAIL; // 초기화
		String sql = "UPDATE MEMBER SET PW=?, NAME=?, EMAIL=?, BIRTH=?, ADDRESS=? WHERE ID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setTimestamp(4, dto.getBirth());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getId());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "정보수정 성공" : "정보수정 실패" + dto.toString());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(dto.toString());
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
