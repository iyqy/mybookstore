package Sort;

public class quickSort2 {

	public static void main(String[] args) {
		int[] a = { 9, 5, 8, 1, 7, 4, 2, 6, 7 };
		quickSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);

		}

	}

	public static void quickSort(int[] a, int first, int last) {
		if (first < last) {
			int middle = getMiddle(a, first, last);
			quickSort(a, first, middle - 1);
			quickSort(a, middle + 1, last);
		}

	}

	public static int getMiddle(int[] a, int first, int last) {
		int tmp = a[first];
		while (first < last) {
			while (first < last && tmp <= a[last])
				last--;
			if (first < last)
				a[first++] = a[last];

			while (first < last && tmp >= a[first])
				first++;
			if (first < last)
				a[last--] = a[first];

		}
		a[first] = tmp;
		return first;
	}
}
