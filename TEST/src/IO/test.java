package IO;

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

public class test {

	public static void main(String[] args) throws IOException {

		// byte[] a = { 1, 2, 3, 4, 5 };
		// byte[] b = new byte[10];
		// ByteArrayInputStream aa = new ByteArrayInputStream(a);
		// try {
		// aa.read(b);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// System.out.println(b[4]);

		FileInputStream in;
		try {
			in = new FileInputStream("D:\\wksps1\\TEST\\src\\helloIO.txt");
			try {
				InputStreamReader isr = new InputStreamReader(in, "utf-8");
				BufferedReader rd = new BufferedReader(isr);
				StringBuffer buf = new StringBuffer();
				String str = null;
				File file1 = new File("D:\\wksps1\\TEST\\src\\b.txt");
				FileOutputStream out = new FileOutputStream(file1);
				OutputStreamWriter w = new OutputStreamWriter(out, "utf-8");
				BufferedWriter br = new BufferedWriter(w);

				while ((str = rd.readLine()) != null) {
					buf.append(str);
					br.write(str);
					buf.append("\n");
					br.write("\n");

				}

				System.out.println(buf);
				br.flush();
				br.close();

			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
