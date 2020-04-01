package com.tj.ch14.dao;

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

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.tj.ch14.constant.Constant;
import com.tj.ch14.dto.BoardDto;

public class BoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;

	private JdbcTemplate template;

	private static BoardDao instance = new BoardDao();

	private BoardDao() {
		template = Constant.template;
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

	public ArrayList<BoardDto> list(final int startRow, final int endRow) {
		String sql = "SELECT * FROM (SELECT ROWNUM RN,A.* FROM (SELECT * FROM mvc_board ORDER BY BGROUP DESC, BSTEP) A)"
				+ "    WHERE RN BETWEEN ? AND ?";
		return (ArrayList<BoardDto>) template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, startRow);
				ps.setInt(2, endRow);
			}
		}, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));

	}

	public int getBoardTotCnt() {
		String sql = "SELECT COUNT(*) FROM mvc_board";
		return template.queryForInt(sql);
	}

	// 원글 쓰기
	public int write(final BoardDto board) {
		String sql = "INSERT INTO mvc_board (BID, BNAME, BTITLE, BCONTENT, BGROUP,BSTEP,BINDENT, BIP) VALUES"
				+ "    (MVC_BOARD_SEQ.NEXTVAL,?,?,?,MVC_BOARD_SEQ.CURRVAL,0,0,?)";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, board.getBname());
				ps.setString(2, board.getBtitle());
				ps.setString(3, board.getBcontent());
				ps.setString(4, board.getBip());
			}
		});
	}

	// 조회 수 올리기
	private void hitUp(final int bid) {
		String sql = "UPDATE mvc_board SET BHIT=BHIT+1 WHERE BID=?";
		template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, bid);
			}
		});
	}

	// 상세 글 보기
	public BoardDto contentView(int bid) {
		hitUp(bid);
		String sql = "SELECT * FROM mvc_board WHERE BID=" + bid;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}

	public BoardDto modifyView_replyView(int bid) {
		String sql = "SELECT * FROM mvc_board WHERE BID=" + bid;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}

	// 글 수정하기
	public int modify(final BoardDto board) {
		return template.update(new PreparedStatementCreator() {
			String sql = "UPDATE mvc_board SET BNAME=?,BTITLE=?,BCONTENT=?,BDATE=SYSDATE,BIP=? WHERE BID=?";

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, board.getBname());
				pstmt.setString(2, board.getBtitle());
				pstmt.setString(3, board.getBcontent());
				pstmt.setString(4, board.getBip());
				pstmt.setInt(5, board.getBid());
				return pstmt;
			}
		});
	}

	// 글 삭제
	public int delete(final int bid) {
		String sql = "DELETE FROM mvc_board WHERE BID=?";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, bid);
			}
		});
	}

	// 답글쓰기 step A
	private void preReplyStepA(final int bgroup, final int bstep) {
		String sql = "UPDATE mvc_board SET BSTEP=BSTEP+1 WHERE BGROUP=? AND BSTEP>?";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, bgroup);
				pstmt.setInt(2, bstep);
			}
		});
	}

	// 답글쓰기
	public int reply(final BoardDto board) {
		preReplyStepA(board.getBgroup(), board.getBstep());
		String sql = "INSERT INTO mvc_board (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)"
				+ "    VALUES (MVC_BOARD_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
		return template.update(sql,		new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setString(1, board.getBname());
						pstmt.setString(2, board.getBtitle());
						pstmt.setString(3, board.getBcontent());
						pstmt.setInt(4, board.getBgroup());
						pstmt.setInt(5, board.getBstep() + 1);
						pstmt.setInt(6, board.getBindent() + 1);
						pstmt.setString(7, board.getBip());
					}
				});

	}
}
