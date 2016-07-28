package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class test2 {

	public static void main(String[] args) {
		try {
			FileReader f = new FileReader("D:\\wksps1\\TEST\\src\\helloIO.txt");
			BufferedReader rd = new BufferedReader(f);
			File file = new File("D:\\wksps1\\TEST\\src\\n.txt");
			try {
				FileWriter r = new FileWriter(file);
				BufferedWriter rt = new BufferedWriter(r);
				String str = null;
				while ((str = rd.readLine()) != null) {
					rt.write(str);
					rt.write("\n");
				}
				rt.flush();
				rt.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
