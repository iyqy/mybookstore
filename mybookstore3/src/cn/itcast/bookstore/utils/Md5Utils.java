package cn.itcast.bookstore.utils;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class Md5Utils {

	private Md5Utils(){}
	
	public static String encript(String message) {
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("md5");
			byte[] md5 = messageDigest.digest(message.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			String result = encoder.encode(md5);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
