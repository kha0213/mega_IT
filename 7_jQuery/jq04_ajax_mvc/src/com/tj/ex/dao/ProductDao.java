package com.tj.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.ex.dto.ProductDto;

public class ProductDao {
	private static ProductDao instance;
	private ProductDao() {
		
	}
	
	public static ProductDao getInstance() {
		if(instance==null) instance = new ProductDao();
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
	
	
	
	public ProductDto getProduct(String pname) {
		ProductDto product = null;
		Connection conn = null;
		String sql = "SELECT * FROM PRODUCT WHERE PNAME=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				int pno = rs.getInt("pno");
				int pstock = rs.getInt("pstock");
				product = new ProductDto(pno, pname, pstock);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn !=null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return product;
	}
	
	
}
