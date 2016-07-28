package test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Md5Utils {

	private Md5Utils() {
	};

	public static String encrypt(String data) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("md5");
			byte[] md5 = messageDigest.digest(data.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			String result = encoder.encode(md5);
			return result;
		} catch (NoSuchAlgorithmException e) {
			throw new MD5Exception();
		}
	}

}
