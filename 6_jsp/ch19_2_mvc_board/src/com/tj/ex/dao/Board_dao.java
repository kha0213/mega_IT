package com.tj.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.ex.dto.Board_dto;

public class Board_dao {
	private DataSource ds;

	public Board_dao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}

	// 글목록 (start_row, end_row)
	public ArrayList<Board_dto> getBoardsList(int start_row, int end_row) {
		ArrayList<Board_dto> boards = new ArrayList<Board_dto>();
		String sql = "SELECT * FROM (SELECT ROWNUM RN,A.* FROM (SELECT * FROM mvc_board ORDER BY BGROUP DESC, BSTEP) A)"
				+ "    WHERE RN BETWEEN ? AND ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start_row);
			pstmt.setInt(2, end_row);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				boards.add(new Board_dto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip));
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
		return boards;
	}

	// 글갯수
	public int getBoardsTotalCount() {
		int result = 0;
		String sql = "SELECT COUNT(*) FROM mvc_board";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
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

	// 글쓰기
	public int insertBoard(Board_dto board) {
		String bname = board.getBname();
		String btitle = board.getBtitle();
		String bcontent = board.getBcontent();
		String bip = board.getBip();
		return insertBoard(bname, btitle, bcontent, bip);
	}

	public int insertBoard(String bname, String btitle, String bcontent, String bip) {
		int result = 0;
		String sql = "INSERT INTO mvc_board (BID, BNAME, BTITLE, BCONTENT, BGROUP,BSTEP,BINDENT, BIP) VALUES "
				+ "    (MVC_BOARD_SEQ.NEXTVAL,?,?,?,MVC_BOARD_SEQ.CURRVAL,0,0,?)";
		// 1.bname 2.btitle 3.bcontent 4.bip
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bip);
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

	// (hit올리기)
	private void boardHitUp(int bid) {
		String sql = "UPDATE mvc_board SET BHIT=BHIT+1 WHERE BID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			pstmt.executeUpdate();
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
	}

	// 글상세보기(hit올리기)
	public Board_dto boardContentView(int bid, boolean hitUp) {
		if (hitUp == true) {
			boardHitUp(bid);
		}
		Board_dto board = null;
		String sql = "SELECT * FROM mvc_board WHERE BID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				board = new Board_dto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip);
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
		return board;
	}

	// 답글쓰기 위해 원글 정보 가져오기 boolean hitUp ->false

	// stepA
//	private void preReplyBoardStepA(int bid) { // 원글 bid
//		Board_dto board = boardContentView(bid, false);
//
//		String sql = "UPDATE mvc_board SET BSTEP=BSTEP+1 WHERE BGROUP=? AND BSTEP>?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			conn = ds.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, board.getBgroup());
//			pstmt.setInt(2, board.getBstep());
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//			}
//		}
//	}
	private void preReplyBoardStepA(int bgroup, int bstep) { // 원글 bgroup bstep
		String sql = "UPDATE mvc_board SET BSTEP=BSTEP+1 WHERE BGROUP=? AND BSTEP>?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			pstmt.executeUpdate();
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
	}

	// 답글쓰기
	public int replyBoard(Board_dto board) {
		String bname = board.getBname(); 
		String btitle = board.getBtitle(); 
		String bcontent = board.getBcontent(); 
		int bgroup = board.getBgroup(); 
		int bstep = board.getBstep(); 
		int bindent = board.getBindent(); 
		String bip = board.getBip();
		return replyBoard(bname, btitle, bcontent, bgroup, bstep, bindent, bip);
	}
	public int replyBoard(String bname, String btitle, String bcontent, int bgroup, int bstep, int bindent, String bip) {
		int result = 0;
		preReplyBoardStepA(bgroup, bstep);
		String sql = "INSERT INTO mvc_board (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)"
				+ "    VALUES (MVC_BOARD_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
		// 1.bname 2.btitle 3.bcontent 원글(4.bgroup 5.bstep 6.bindent) 7.bip
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, bgroup);
			pstmt.setInt(5, bstep+1);
			pstmt.setInt(6, bindent+1);
			pstmt.setString(7, bip);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 글 수정하기
	public int modifyBoard(Board_dto board) {
		String bname = board.getBname();
		String btitle = board.getBtitle();
		String bcontent = board.getBcontent();
		String bip = board.getBip();
		int bid = board.getBid();
		return modifyBoard(bname, btitle, bcontent, bip, bid);
	}
	public int modifyBoard(String bname,String btitle,String bcontent,String bip,int bid) {
		int result = 0;
		String sql = "UPDATE mvc_board SET BNAME=?,BTITLE=?,BCONTENT=?,BDATE=SYSDATE,BIP=? WHERE BID=?";
		// 1.bname 2.btitle 3.bcontent 4.bip 5.bid
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bip);
			pstmt.setInt(5, bid);
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

	
	// 글 삭제하기
	public int deleteBoard(int bid) {
		int result = 0;
		String sql = "DELETE FROM mvc_board WHERE BID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
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
