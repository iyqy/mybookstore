package com.evan.gather;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.evan.IO.getdata;
import com.evan.domain.BIDR;

public class gatherInfo {

	public static Map<String, BIDR> getMap() throws IOException {
		System.out.println("---------------------------------------");
		Map<String, BIDR> map = new HashMap();
		String str = null;
		BufferedReader rd = getdata.getData();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while ((str = rd.readLine()) != null) {
			String strnew[] = str.split("\\|", 5);
			if ("7".equals(strnew[2])) {
				System.out.println("-------------------------");
				BIDR b = new BIDR();
				b.setAaaLoginName(strnew[0]);
				b.setNasIp(strnew[1]);
				// 设置时间
				Date d = new Date(Long.parseLong(strnew[3]));
				String sd = format.format(new Date(Long.parseLong(strnew[3])));
				// System.out.println(sd);
				b.setLoginDate(d);
				// 设置IP
				b.setLoginIp(strnew[4]);
				// 时间差
				map.put(strnew[4], b);
				System.out.println(map.get(strnew[4]));
			} else {
				if (map.containsKey(strnew[4])) {
					BIDR c = map.get(strnew[4]);
					Date d = new Date(Long.parseLong(strnew[3]));
					c.setLogoutDate(d);
					c.setTimeDuration(c.getLogoutDate().getTime()
							- c.getLoginDate().getTime());
				}
				Date d = new Date(Long.parseLong(strnew[3]));

			}

		}

		return map;

	}
}
