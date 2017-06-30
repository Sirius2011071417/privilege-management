package cn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButil {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnect() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/privilege?characterEncoding=utf8&useSSL=false", "root", "zhongbiao");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void release(Connection conn, Statement s, ResultSet r) {
		if(conn!=null) {
			try{
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(s!=null) {
			try{
				s.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(r!=null) {
			try{
				r.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
