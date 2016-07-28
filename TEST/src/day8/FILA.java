package day8;

class Node1 {
	Node1 pre;
	int data;
}

class Stack1 {
	Node1 top;
	Node1 head = new Node1();

	public void init() {
		top = head;
	}

	public boolean isEmpty() {
		return top == head;

	}

	public void setNext(Node1 node) {
		if (top == head) {
			node.pre = head;
			top = node;
		} else {
			node.pre = top;
			top = node;
		}
	}

	public void out() {
		System.out.println(top.data);
		top = top.pre;

	}
}

public class FILA {

	public static void main(String[] args) {
		Stack1 n = new Stack1();
		n.init();
		for (int i = 9; i < 99; i++) {
			Node1 node = new Node1();
			node.data = i;
			n.setNext(node);
		}
		while (!n.isEmpty())
			n.out();
	}

}
