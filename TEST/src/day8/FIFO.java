package day8;

//链队列
public class FIFO {
	public static void main(String[] args) {
		Stack s = new Stack();
		s.init();
		for (int i = 9; i < 18; i++) {
			Node node = new Node();
			node.data = i;
			s.setNext(node);
		}
		while (!s.isEmpty())
			s.out();

	}

}

class Node {
	int data;
	Node next;
}

class Stack {
	Node pre;
	Node head = new Node();

	public void init() {
		pre = null;
		head.next = null;

	}

	public boolean isEmpty() {
		if (head.next == null)
			return true;
		return false;
	}

	public void setNext(Node node) {
		if (head.next == null) {
			head.next = node;
			pre = node;
		} else {
			pre.next = node;
			pre = pre.next;
		}
	}

	public void out() {

		if (head.next == pre) {
			System.out.println(head.next.data);
			pre = null;
			head.next = null;
		} else {
			System.out.println(head.next.data);
			head.next = head.next.next;
		}
	}
}
