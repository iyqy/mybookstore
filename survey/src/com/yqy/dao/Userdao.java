package com.yqy.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.yqy.domain.Survey;
import com.yqy.utils.JdbcUtils;

public class Userdao {

	public Userdao() {

	}
	public boolean insert(Survey s){
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into survey(A,B,C,D,E,F,G,H,I,J) values(?,?,?,?,?,?,?,?,?,?)";					
			int num = runner.update(sql, new Object[]{
												s.getA(),
												s.getB(),
												s.getC(),
												s.getD(),
												s.getE(),
												s.getF(),
												s.getG(),
												s.getH(),
												s.getI(),
												s.getJ()
											});
			if(num>0)
			  return true;
			 return false;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}					
		
	}
}
