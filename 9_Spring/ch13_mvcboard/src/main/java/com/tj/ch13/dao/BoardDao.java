package com.tj.ch13.dao;

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

import com.tj.ch13.dto.BoardDto;

public class BoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static BoardDao instance = new BoardDao(); 
	private BoardDao() {
		
	}
	public static BoardDao getInstance() {
		return instance;
	}
	
	private Connection getConncetion() throws SQLException {
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
	public ArrayList<BoardDto> list(int startRow, int endRow){
		ArrayList<BoardDto> boards = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN,A.* FROM (SELECT * FROM mvc_board ORDER BY BGROUP DESC, BSTEP) A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConncetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Date bdate = rs.getDate("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				boards.add(new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return boards;
	}
	
	public int getBoardTotCnt() {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM mvc_board";
		try {
			conn = getConncetion();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 원글  쓰기
	public int write(BoardDto board) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO mvc_board (BID, BNAME, BTITLE, BCONTENT, BGROUP,BSTEP,BINDENT, BIP) VALUES" + 
				"    (MVC_BOARD_SEQ.NEXTVAL,?,?,?,MVC_BOARD_SEQ.CURRVAL,0,0,?)";
		try {
			conn = getConncetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBname());
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontent());
			pstmt.setString(4, board.getBip());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//조회 수 올리기
	private void hitUp(int bid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE mvc_board SET BHIT=BHIT+1 WHERE BID=?";
		try {
			conn = getConncetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	//상세 글 보기
	public BoardDto contentView(int bid) {
		hitUp(bid);
		BoardDto board = null;
		String sql = "SELECT * FROM mvc_board WHERE BID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConncetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Date bdate = rs.getDate("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				board = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return board;
	}
	
	public BoardDto modifyView_replyView(int bid) {
		BoardDto board = null;
		String sql = "SELECT * FROM mvc_board WHERE BID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConncetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Date bdate = rs.getDate("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				board = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return board;
	}
	
	// 글 수정하기
	public int modify(BoardDto board) {
		int result= FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE mvc_board SET BNAME=?,BTITLE=?,BCONTENT=?,BDATE=SYSDATE,BIP=? WHERE BID=?";
		try {
			conn = getConncetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBname());
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontent());
			pstmt.setString(4, board.getBip());
			pstmt.setInt(5, board.getBid());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	//글 삭제
	public int delete(int bid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM mvc_board WHERE BID=?";
		try {
			conn = getConncetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	
	//답글쓰기 step A
	private void preReplyStepA(int bgroup,int bstep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE mvc_board SET BSTEP=BSTEP+1 WHERE BGROUP=? AND BSTEP>?";
		try {
			conn = getConncetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	// 답글쓰기
	public int reply(BoardDto board) {
		preReplyStepA(board.getBgroup(), board.getBstep());
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO mvc_board (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)" + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
		try {
			conn = getConncetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBname());
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontent());
			pstmt.setInt(4, board.getBgroup());
			pstmt.setInt(5, board.getBstep()+1);
			pstmt.setInt(6, board.getBindent()+1);
			pstmt.setString(7, board.getBip());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}
