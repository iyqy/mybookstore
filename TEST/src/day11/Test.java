package day11;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class Person {
	private String name;
	private int age;

	public String getName() {
		return name;
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
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.age;
	}

	@Override
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		if (this.name.equals(p.getName()) && this.age == p.getAge())
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "姓名:" + name + " 年龄:" + age;
	}

}

class comparatorClass implements Comparator {

	public int compare(Object p1, Object p2) {
		Person p11 = (Person) p1;
		Person p22 = (Person) p2;
		if (p11.getName().compareTo((p22).getName()) > 0)
			return -1;
		if (p11.getName().compareTo(p22.getName()) < 0)
			return 1;
		if (p11.getName().compareTo(p22.getName()) == 0)
			return 0;
		return 0;
	}

}

public class Test {

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();
		Person p5 = new Person();
		Person p6 = new Person();
		p1.setAge(30);
		p1.setName("ZS");
		p2.setAge(20);
		p2.setName("LS");
		p3.setAge(50);
		p3.setName("WW");
		p4.setAge(30);
		p4.setName("ZS");
		p5.setAge(60);
		p5.setName("TQ");
		p6.setAge(10);
		p6.setName("AC");

		Set set = new TreeSet(new comparatorClass());
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		set.add(p5);
		set.add(p6);

		Iterator it = set.iterator();

		System.out.println("插入6个人，因为同名同年龄，最终插入" + set.size() + "个人");

		while (it.hasNext()) {
			Person p = (Person) it.next();
			System.out.println(p);
		}
		System.out.println("按照名字首字母降序排列");
	}

}
