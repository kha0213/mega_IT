package com.tj.dao;
//회원들 리스트(select * from member결과), 회원가입

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.dto.MemberDto;

public class MemberDao2 {
	private DataSource dataSource;
	private static MemberDao2 instance = new MemberDao2(); // MemberDao 객체를 가르키는 변수

	public static MemberDao2 getInstance() {
		return instance;
	}

	private MemberDao2() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<MemberDto> selectAll() {
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER";
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPw(rs.getString("pw"));
				dto.setPhone1(rs.getString("phone1"));
				dto.setPhone2(rs.getString("phone2"));
				dto.setPhone3(rs.getString("phone3"));
				dto.setGender(rs.getString("gender"));
				dtos.add(dto);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}

		}
		return dtos;
	}

	public int insertMember(MemberDto dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO MEMBER VALUES (?,?,?,?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getPhone1());
			pstmt.setString(5, dto.getPhone2());
			pstmt.setString(6, dto.getPhone3());
			pstmt.setString(7, dto.getGender());
			result = pstmt.executeUpdate();
			System.out.println(result > 0 ? "회원가입성공" : dto.toString() + "회원가입실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(result > 0 ? "회원가입성공" : dto.toString() + "회원가입실패");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}

		}
		return result;
	}
}
