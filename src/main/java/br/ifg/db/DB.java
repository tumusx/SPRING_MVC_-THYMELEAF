package br.ifg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	private static Connection conn = null;
	
	public static Connection getConnection() {
		if (conn == null) {
			try {					
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/convidados", "root", "");
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}	
	
	public static void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		closeConnection(conn, stmt, pstmt, rs);
	}
	
	private static void closeConnection(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		try {
			
			if (conn != null) conn.close(); 
			if (stmt != null) stmt.close();
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
			
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void close(Statement stmt, ResultSet rs) {
		closeConnection(null, stmt, null, rs);
	}
	
	public static void close(Connection conn, Statement stmt) {
		closeConnection(conn, stmt, null, null);
	}
	
	public static void close(Statement stmt) {
		closeConnection(null, stmt, null, null);
	}	
	
	
	
}