package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class test3 {

	public static void copy(String start, String end) throws IOException {
		try {
			FileInputStream in = new FileInputStream(start);
			BufferedInputStream rd = new BufferedInputStream(in);
			File file = new File(end);
			FileOutputStream out = new FileOutputStream(file);
			BufferedOutputStream rt = new BufferedOutputStream(out);
			int i;
			while ((i = rd.read()) != -1) {
				rt.write(i);
			}
			rd.close();
			rt.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		for (int i = 0; i < 200; i++)
			copy("G:\\照片\\大学\\ej.png", "D:\\haha" + i + ".png");
	}

}
