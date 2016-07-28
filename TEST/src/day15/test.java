package day15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test {

	public static void main(String[] args) throws IOException {
		// FileInputStream in = new
		// FileInputStream("C:\\Users\\EvanYeh\\Desktop\\day15\\homework\\exercise1\\Student.txt");
		FileReader f = new FileReader(
				"C:\\Users\\EvanYeh\\Desktop\\day15\\homework\\exercise1\\Student.txt");
		BufferedReader rd = new BufferedReader(f);
		List list = new ArrayList();
		String str = null;
		while ((str = rd.readLine()) != null) {
			list.add(str);
		}
		rd.close();
		Iterator it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());

	}

}
