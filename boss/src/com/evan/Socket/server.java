package com.evan.Socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;

import com.evan.enter.Enter;

public class server {

	public static void runServer() throws UnknownHostException, IOException,
			ClassNotFoundException {
		// 创建服务器端serversocket，端口为此服务器上的10086
		ServerSocket serversocket = new ServerSocket(10086);
		// 通过accep()方法监听客户端，等待客户端连接
		Socket socket = serversocket.accept();
		// 得到输入流，以下为流操作代码
		ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
		try {
			Map map = (Map) is.readObject();
			Enter.join(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 关闭输入流
		socket.shutdownInput();
		// 获取输出流，响应客户端程序
		// OutputStream os = socket.getOutputStream();
		// PrintWriter pw = new PrintWriter(os);
		// pw.write("连接成功欢迎你！");
		// pw.flush();
		//
		// pw.close();
		// os.close();
		// br.close();
		// isr.close();
		// is.close();
		// socket.close();// 关闭此监听
		// serversocket.close();// 关闭服务器端程序

	}
}
