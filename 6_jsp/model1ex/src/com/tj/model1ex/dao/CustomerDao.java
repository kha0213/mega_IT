package com.tj.model1ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.model1ex.dto.CustomerDto;

public class CustomerDao {
	public static final int SUCCESS = 1; // 회원가입, 정보수정 할 때
	public static final int FAIL = 0; // 회원가입, 정보수정 할 때
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공
	public static final int LOGIN_FAIL = 0; // 로그인 오류(ID오류)
	public static final int CUSTOMER_EXISTENT = 0; // 있는(중복된) ID
	public static final int CUSTOMER_NONEXISTENT = 1; // 없는(사용가능한) ID

	private static CustomerDao instance = new CustomerDao();

	public static CustomerDao getInstance() {
		return instance;
	}

	private CustomerDao() {

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

	// 1. 회원가입시 id 중복체크 (매개변수 :cid)
	public int confirmId(String cid) {
		int result = CUSTOMER_EXISTENT;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				result = CUSTOMER_NONEXISTENT;
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

	// 2. 회원가입 (매개변수 :dto)
	public int insertCustomer(CustomerDto dto) {
		int result = FAIL;
		String sql = "INSERT INTO CUSTOMER (CID,CPW,CNAME,CTEL,CEMAIL,CADDRESS,CBIRTH,CGENDER) VALUES "
				+ "(?,?,?,?,?,?,TO_CHAR(?,'YYYY-MM-DD'),?)";
		// 1.id 2.pw 3.name 4.tel 5.email 6.address 7.birth 8.gender
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCpw());
			pstmt.setString(3, dto.getCname());
			pstmt.setString(4, dto.getCtel());
			pstmt.setString(5, dto.getCemail());
			pstmt.setString(6, dto.getCaddress());
			pstmt.setDate(7, dto.getCbirth());
			pstmt.setString(8, dto.getCgender());
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

	// 3. 로그인 처리 (매개변수 : id, pw)
	public int loginCheck(String cid, String cpw) {
		int result = LOGIN_FAIL;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=? AND CPW=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			pstmt.setString(2, cpw);
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
	// 4. id로 DTO가져오기 (매개변수 : id)
	public CustomerDto getCustomer(String cid) {
		CustomerDto dto = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new CustomerDto();
				dto.setCid(rs.getString("cid"));
				dto.setCpw(rs.getString("cpw"));
				dto.setCname(rs.getString("cname"));
				dto.setCtel(rs.getString("ctel"));
				dto.setCemail(rs.getString("cemail"));
				dto.setCaddress(rs.getString("caddress"));
				dto.setCbirth(rs.getDate("cbirth"));
				dto.setCgender(rs.getString("cgender"));
				dto.setCrdate(rs.getDate("crdate"));
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

	// 5. 회원정보 수정 (매개변수 : dto)
	public int updateCustomer(CustomerDto dto) {
		int result = FAIL;
		String sql = "UPDATE CUSTOMER SET CPW=?,CNAME=?,CTEL=?,CEMAIL=?,"
				+ "CADDRESS=?,CBIRTH=?,CGENDER=? WHERE CID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCpw());
			pstmt.setString(2, dto.getCname());
			pstmt.setString(3, dto.getCtel());
			pstmt.setString(4, dto.getCemail());
			pstmt.setString(5, dto.getCaddress());
			pstmt.setDate(6, dto.getCbirth());
			pstmt.setString(7, dto.getCgender());
			pstmt.setString(8, dto.getCid());
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
