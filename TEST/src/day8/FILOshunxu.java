package day8;

class Stack4 {
	int a[] = new int[11];// 能存10个数
	int top = 0;
	int botton = 0;

	public void init() {
		top = botton = 0;
	}

	public boolean isEmpty() {
		return top == botton;
	}

	public boolean isFull() {
		return top == a.length - 1;
	}

	public void setData(int s) {
		if (top != a.length - 1) {
			System.out.println(s + "入栈");
			a[++top] = s;
		} else {
			System.out.println("栈已满了别塞了。。。");
		}
	}

	public void getData() {
		if (top != botton) {
			System.out.println(a[top] + "出栈");
			a[top] = 0;
			top--;
		} else {
			System.out.println("栈已空了别取了。。。");
		}
	}
}

public class FILOshunxu {

	public static void main(String[] args) {
		Stack4 s = new Stack4();
		s.init();
		for (int i = 1; i <= 15; i++) {
			s.setData(i);
		}
		for (int i = 1; i <= 15; i++) {
			s.getData();
		}
	}
}
