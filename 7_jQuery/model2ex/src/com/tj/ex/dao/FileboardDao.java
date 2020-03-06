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

import com.tj.ex.dto.BoardDto;

public class FileboardDao {
	
	private static FileboardDao instance = new FileboardDao();
	public static FileboardDao getInstance() {
		return instance;
	}
	private FileboardDao() {}
	
	
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
	
	// 글목록(startRow부터 endRow까지)
	
	public ArrayList<BoardDto> getBoardList(int startRow,int endRow){
		ArrayList<BoardDto> boards = new ArrayList<BoardDto>();
		String sql = "SELECT * FROM (SELECT ROWNUM RN,A.* FROM (SELECT F.*,MNAME FROM FILEBOARD F,MVC_MEMBER M WHERE F.MID=M.MID ORDER BY FGROUP DESC, FSTEP) A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fId = rs.getInt("fId");
				String mId = rs.getString("mId");
				String fTitle = rs.getString("fTitle");
				String fContent = rs.getString("fContent");
				String fFileName = rs.getString("fFileName");
				Date fRdate = rs.getDate("fRdate");
				int fHit = rs.getInt("fHit");
				int fGroup = rs.getInt("fGroup");
				int fStep = rs.getInt("fStep");
				int fIndent = rs.getInt("fIndent");
				String fIp = rs.getString("fIp");
				String mName = rs.getString("mName");
				boards.add(new BoardDto(fId, mId, mName, fTitle, fContent, fFileName, fRdate, fHit, fGroup, fStep, fIndent, fIp));
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
	
	// 글 갯수
	public int getBoardTotalCount(){
		int result = 0;
		String sql = "SELECT COUNT(*) FROM FILEBOARD";
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
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	//글 쓰기
	public int insertBoard(String mId,String fTitle, String fContent, String fFileName, String fIp) {
		int result = 0;
		String sql = "INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME," + 
				"        FGROUP, FSTEP, FINDENT, FIP)" + 
				"    VALUES (FILEBOARD_SEQ.NEXTVAL, ?,?,?,?," + 
				"        FILEBOARD_SEQ.CURRVAL, 0, 0, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, fTitle);
			pstmt.setString(3, fContent);
			pstmt.setString(4, fFileName);
			pstmt.setString(5, fIp);
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
	private void hitUp(int fId) {
		String sql = "UPDATE FILEBOARD SET FHIT=FHIT+1 WHERE FID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fId);
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
	
	// 상세 글 보기
	public BoardDto BoardDetail(int fId, boolean hitUp) {
		if(hitUp) hitUp(fId);
		
		BoardDto board = null;
		String sql = "SELECT F.*,MNAME FROM FILEBOARD F, MVC_MEMBER M WHERE F.MID = M.MID AND FID = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String mId = rs.getString("mId");
				String fTitle = rs.getString("fTitle");
				String fContent = rs.getString("fContent");
				String fFileName = rs.getString("fFileName");
				Date fRdate = rs.getDate("fRdate");
				int fHit = rs.getInt("fHit");
				int fGroup = rs.getInt("fGroup");
				int fStep = rs.getInt("fStep");
				int fIndent = rs.getInt("fIndent");
				String fIp = rs.getString("fIp");
				String mName = rs.getString("mName");
				board = new BoardDto(fId, mId, mName, fTitle, fContent, fFileName, fRdate, fHit, fGroup, fStep, fIndent, fIp);
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
	
	public int modifyBoard(int fId, String fTitle, String fContent, String fFileName, String fIp, Date frdate) {
		int result = 0;
		String sql = "UPDATE FILEBOARD SET FTITLE=?,FCONTENT=?,FFILENAME=?,FIP=?,FRDATE=SYSDATE WHERE FID=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fTitle);
			pstmt.setString(2, fContent);
			pstmt.setString(3, fFileName);
			pstmt.setString(4, fIp);
			pstmt.setInt(5, fId);
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
	
	public int deleteBoard(int fId) {
		int result = 0;
		String sql = "DELETE FROM FILEBOARD WHERE FID=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fId);
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
	
	private void preReplyStepA(int fGroup,int fStep) {
		String sql = "UPDATE FILEBOARD SET FSTEP=FSTEP+1 WHERE FGROUP=2 AND FSTEP>?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fStep);
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
	
	public int replyBoard(String mId,String fTitle, String fContent, String fFileName,int fGroup, int fStep, int fIndent, String fIp) {
		preReplyStepA(fGroup,fStep);
		int result = 0;
		String sql = "INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME," + 
				"        FGROUP, FSTEP, FINDENT, FIP)" + 
				"    VALUES (FILEBOARD_SEQ.NEXTVAL, ?,?,?,?," + 
				"        ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, fTitle);
			pstmt.setString(3, fContent);
			pstmt.setString(4, fFileName);
			pstmt.setInt(5, fGroup);
			pstmt.setInt(6, fStep+1);
			pstmt.setInt(7, fIndent+1);
			pstmt.setString(8, fIp);
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
