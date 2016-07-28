package day15;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test6 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileOutputStream out = new FileOutputStream("G:\\m.txt");
		DataOutputStream d = new DataOutputStream(out);
		d.writeInt(12);
		d.wr
		d.flush();
		d.close();
	}

}
