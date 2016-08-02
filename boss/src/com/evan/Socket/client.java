package com.evan.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.evan.copy.clientcopy;
import com.evan.gather.gatherInfo;

public class client {

	public static void runClient() throws UnknownHostException, IOException {
		// 创建客户端socket， 第一个参数为要链接服务器的ip，第二个为服务器上套接字程序的端口号10086
		Socket socket = new Socket("localhost", 10086);
		// 得到输出流，在流中写要传输的内容，服务器端通过输入流来获取该内容，以下为流操作代码
		ObjectOutputStream ops = new ObjectOutputStream(
				socket.getOutputStream());
		ops.writeObject(gatherInfo.getMap());
		clientcopy.copy(gatherInfo.getMap());
		ops.flush();
		socket.shutdownOutput();
		// 获取输入流，接受服务器返回的数据
		// InputStream is = socket.getInputStream();
		// BufferedReader br = new BufferedReader(new InputStreamReader(is));
		// String info = null;
		// while ((info = br.readLine()) != null) {
		// System.out.println("我是客户端，服务器说：" + info);
		// }
		//
		// br.close();
		// is.close();
		// pw.close();
		// os.close();
		socket.close();// 关闭客户端socket程序

	}

}