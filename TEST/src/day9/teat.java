package day9;

//接口可以继承接口
//实现接口必须要实现复写接口中所有的方法
//
//
//抽象类实现接口可以不用重写接口中的方法
//抽象方法必须定义在抽象类中，而且不需要写方法体
//抽象类可以继承抽象类，不需要复写其中的方法。
//
//普通类继承抽象类必须要复写其中的抽象方法



interface pet1 {
	void say();

	abstract int agy();

}

abstract class Animal {
	void eat() {
	};

	interface pet extends Animal {
		void say();

		abstract int agy();

	}

	abstract void bet();

	void set(int a) {
		System.out.println("a a a a");
	}

}

class dog extends Animal implements pet {
	public void wang() {

		System.out.println("wang");
	}

	@Override
	void bet() {
		// TODO Auto-generated method stub

	}

	@Override
	public void say() {
		// TODO Auto-generated method stub

	}

	@Override
	public int agy() {
		// TODO Auto-generated method stub
		return 0;
	}

}

public class teat {

	public static void main(String[] args) {
		dog d = new dog();
		d.wang();
		d.set(0);

	}

}
