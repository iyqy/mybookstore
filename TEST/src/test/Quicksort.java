package test;

public class Quicksort {

	public static int getMiddle(int[] list, int low, int high) {
		int tmp = list[low];
		while (low < high) {
			while (low < high && tmp <= list[high]) {
				high--;
			}
			if (low < high)
				list[low++] = list[high];
			while (low < high && tmp >= list[low]) {
				low++;
			}
			if (low < high)
				list[high--] = list[low];
		}
		list[low] = tmp;// low==high
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
