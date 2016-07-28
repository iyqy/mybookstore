package day6;

public class ArrayMultipy {

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		for (int s : a) {
			System.out.print(s);
		}

	}
}