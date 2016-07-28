package day11;

class Person1 {
	private String name = "zz";
	private int age = 6;

	class Person2 {

		public void ss() {
			System.out.println(age);
		}

	}

	public static final void getName() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "姓名:" + name + " 年龄:" + age;
	}

}

class son1 extends Person1 {

}

public class test2 {

	public static void main(String[] args) {
		Person1 p = new Person1();

	}

}
