package day13;

public class FuckException extends RuntimeException {

	public FuckException(Exception e) {
		throw new RuntimeException(e);
	}



}
