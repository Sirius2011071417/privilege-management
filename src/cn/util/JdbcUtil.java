package cn.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	
	private static ComboPooledDataSource cpds = null;
	static {
		cpds =  new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource() {
		return cpds;
	}
}
