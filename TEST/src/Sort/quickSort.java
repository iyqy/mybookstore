package Sort;

public class quickSort {

	public static int getMiddle(int[] a, int low, int high) {
		int tmp = a[low];
		while (low < high) {
			while (low < high && tmp <= a[high])
				high--;
			if (low < high)
				a[low++] = a[high];
			while (low < high && tmp >= a[low])
				low++;
			if (low < high)
				a[high--] = a[low];
		}
		a[low] = tmp;
		return low;

	}

	public static void quickSort(int[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high);
			quickSort(list, low, middle - 1);
			quickSort(list, middle + 1, high);
		}

	}

	public static void main(String[] args) {
		int[] a = { 9, 5, 8, 1, 7, 4, 2, 6, 7 };
		quickSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);

		}

	}
}
