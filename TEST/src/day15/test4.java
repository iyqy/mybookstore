package day15;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class test4 {

	public static void main(String[] args) throws IOException {

		InputStream in = System.in;
		OutputStream out = System.out;
		byte[] b = new byte[5];
		try {
			in.read(b);
			out.write(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			in.close();
			out.flush();
			out.close();
		}

	}

}
