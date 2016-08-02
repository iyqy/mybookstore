package com.evan.IO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class getdata {

	public static BufferedReader getData() throws IOException {
		FileInputStream in;
		in = new FileInputStream("G:\\boss\\client\\radwtmp.txt");
		InputStreamReader isr = new InputStreamReader(in, "utf-8");
		BufferedReader rd = new BufferedReader(isr);
		return rd;

	}

}
