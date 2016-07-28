package Sort;

public class insertSort2 {

	public static void sort(int[] a) {
		int i, j;
		int tmp;
		for (i = 1; i < a.length; i++) {
			tmp = a[i];
			j = i - 1;
			while (j >= 0 && tmp < a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = tmp;
		}

	}

	public static void main(String[] args) {

	}

}
