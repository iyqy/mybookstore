package Sort;

public class selectSort {
	public static void main(String[] args) {
		int[] a = { 5, 3, 1};
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i; j++) {
				int temp = 0;
				if (a[i] >= a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;

				}
			}

			for (int s : a) {
				System.out.print(s);
			}
		}

	}

}
