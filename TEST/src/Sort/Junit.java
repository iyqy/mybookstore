package Sort;

import org.junit.Test;
class person{
	int age=9;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
public class Junit {
@Test
public void test(){
	person per = new person();
	System.out.println(per.getAge());
	
}
}
