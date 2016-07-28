package cn.itcast.bookstore.utils;

import java.io.RandomAccessFile;

public class NumberUtils {
	
	private NumberUtils(){}
	
	public static String makeNumber() {
		// 自增的编号
		
		try {
			// 针对文件读写的随机流
			String path = NumberUtils.class.getClassLoader()
					.getResource("number.txt").getPath();
			RandomAccessFile raf = new RandomAccessFile(path, "rw");
			
			String line = raf.readLine();
			
			int num = Integer.parseInt(line);
			
			
			num++;
			
			// 回到索引 0 的位置
			raf.seek(0);
			raf.write((num+"").getBytes());
			
			raf.close();
			
			// 返回编号
			StringBuffer sb = new StringBuffer("A");
			String numValue = num+"";
			for(int i=0; i<8-numValue.length(); i++) {
				sb.append("0");
			}
			sb.append(numValue);
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
