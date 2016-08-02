package com.evan.copy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.evan.domain.BIDR;

public class clientcopy {

	public static void copy(Map<String, BIDR> map) throws IOException {
		List<BIDR> values = new ArrayList();
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			values.add(map.get(key));
		}

		File file = new File("G:\\boss\\client\\beifen\\data.txt");

		FileWriter r = new FileWriter(file);
		BufferedWriter rt = new BufferedWriter(r);
	String str = null;
		for (BIDR b : values) {	
			str += b.getAaaLoginName() + "|";
			str += b.getNasIp() + "|";
			str += b.getLoginDate() + "|";
			str += b.getLogoutDate() + "|";
			str += b.getTimeDuration() + "";
			str+="\n";
			
		}
		rt.write(str);
	//	rt.write("\n");
		rt.flush();
		rt.close();

	}
}
