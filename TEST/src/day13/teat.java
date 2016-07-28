package day13;

public class teat {

	public static void main(String[] args) {
		try {
			int i = 1 / 0;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
