package com.evan.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnDB {
	public Connection conn = null;
	public Statement stmt = null;
	public ResultSet rs = null;

	private static String dbClassName = "com.mysql.jdbc.Driver";

	private static String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";

	public ConnDB() {
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(dbClassName).newInstance();
			 conn = DriverManager.getConnection(dbUrl, "evan", "evan");    
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		if (conn == null) {
			System.out.println(dbClassName + "连接失败");
		}
		return conn;
	}

	public ResultSet executeQuery(String sql) {
		conn = getConnection();
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return rs;
	}

	public int executeUpdate(String sql) {
		int result = 0;
		conn = getConnection();
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			return 0;
		}
		return result;
	}

	public void close() {
		try {
			if (rs == null) {
				rs.close();
			}
			if (stmt == null) {
				stmt.close();
			}
			if (conn == null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

}
