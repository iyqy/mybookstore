package day15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class test1 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		try {
			// 读取a文件
			FileInputStream f = new FileInputStream(
					"C:\\Users\\EvanYeh\\Desktop\\day15\\homework\\exercise3\\a.txt");
			InputStreamReader isr = new InputStreamReader(f, "gbk");
			BufferedReader rd = new BufferedReader(isr);

			try {
				// 读取b文件
				FileInputStream f2 = new FileInputStream(
						"C:\\Users\\EvanYeh\\Desktop\\day15\\homework\\exercise3\\b.txt");
				InputStreamReader isr2 = new InputStreamReader(f2, "gbk");
				BufferedReader rd2 = new BufferedReader(isr2);

				// 定义临时存储容器将a,b的内容经过判断后存入容器
				String buf = "";
				String str = null;
				while ((str = rd.readLine()) != null) {
					if (str.equals("*****  ******")) {
						buf += rd2.readLine();//如果读到* 就把b文件中的那句话放入容器
						buf += "\n";
					} else {//将a文件的内容逐行读入
						buf += str;
						buf += "\n";
					}
				}
				System.out.println(buf);

				// 定义输出流，覆盖原来的a文件
				File file = new File(
						"C:\\Users\\EvanYeh\\Desktop\\day15\\homework\\exercise3\\a.txt");
				FileOutputStream out = new FileOutputStream(file);
				OutputStreamWriter w = new OutputStreamWriter(out, "gbk");
				BufferedWriter rt = new BufferedWriter(w);

				// 将临时容器中的内容写入a中
				rt.write(buf);

				// 关闭流
				rt.flush();
				rt.close();
				rd2.close();
				rd.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}

}
