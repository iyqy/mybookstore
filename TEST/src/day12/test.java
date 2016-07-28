package day12;

interface Person {
	String name = "1";

	public void fun();
}

class ZS {
	String name;
	public void say(){
		System.out.println("he ");
	}
}

class wo {

	ZS z = new ZS() {
		String name;
		public void say(){
			System.out.println("hello");
		}
	};
	

}

public class test {
	public static void main(String[] args) {
new wo().ll();
new wo().z.say();
	}
}
