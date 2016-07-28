package Sort;

public class insertSort {

	public static void insertSort(int[] a) {
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

	// public static void insertSort(int[] a) {
	// int temp = a[1];
	// for (int i = 1; i < a.length; i++) {
	// int j = i - 1;
	// while (j >= 0 && temp < a[j]) {
	// a[j + 1] = a[j];
	// j--;
	//
	// }
	// a[j + 1] = temp;
	// }
	// }

	public static void main(String[] args) {
		int[] a = { 9, 5, 8, 1, 7, 4, 2, 6, 7 };
		insertSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);

		}
	}

}
