package com.evan.enter;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;

import com.evan.domain.BIDR;
import com.evan.utils.JdbcUtils;

public class Enter {

	public static void join(Map map) throws SQLException {
		int count = 0;
		List keys = new ArrayList();
		List values = new ArrayList();
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			keys.add(key);
			values.add(map.get(key));
		}

		for (int i = 0; i < values.size(); i++) {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			BIDR b = (BIDR) values.get(i);
			int m = b.getLoginDate().getDay();
			String sql = "INSERT INTO t_detail_"
					+ m
					+ "(login_name,login_ip,login_date,logout_date,lab_ip,time_duration) VALUES (?,?,?,?,?,?)";

			System.out.println(b.getAaaLoginName());
			System.out.println(b.getNasIp());
			System.out.println(b.getLoginDate());
			if (b.getLogoutDate() != null && b.getLoginDate() != null) {
				Date date1 = new Date(b.getLoginDate().getTime());
				Date date2 = new Date(b.getLogoutDate().getTime());
				// SimpleDateFormat format = new SimpleDateFormat(
				// "yyyy-MM-dd HH:mm:ss");
				// String date1 = format.format(b.getLoginDate());// 格式化数据
				// String date2 = format.format(b.getLogoutDate());

				count = runner.update(
						sql,
						new Object[] { b.getAaaLoginName(), b.getNasIp(),
								date1, date2, b.getLoginIp(),
								b.getTimeDuration() });

			}
		}
		System.out.println(count);

	}
}
