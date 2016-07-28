package cn.itcast.bookstore.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	// c3P0
	private static DataSource ds;
	static{
		ds = new ComboPooledDataSource();	// 使用默认配置
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
	
}
